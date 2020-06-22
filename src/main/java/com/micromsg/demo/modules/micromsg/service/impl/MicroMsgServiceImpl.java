package com.micromsg.demo.modules.micromsg.service.impl;

import com.micromsg.demo.modules.micromsg.dao.MicroMsgMapper;
import com.micromsg.demo.modules.micromsg.entity.MicroMsg;
import com.micromsg.demo.modules.micromsg.service.MicroMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MicroMsgServiceImpl implements MicroMsgService {
    private Logger logger = LoggerFactory.getLogger(MicroMsgServiceImpl.class);

    @Autowired
    private MicroMsgMapper microMsgMapper;

    @Override
    public List<MicroMsg> getMsgList() {
        return microMsgMapper.getMsgList();
    }

    @Override
    public void addRecord(Map<String, String> data) {
        // 若id为空，插入；否则查找id更新对应行
        if (data.get("id").equals("")) {
            logger.info("id为空");
            microMsgMapper.addRecord(data.get("command"), data.get("result"));
        }
        else {
            logger.info("id不空");
            int id = Integer.parseInt(data.get("id"));
            microMsgMapper.updateRecord(id, data.get("command"), data.get("result"));
        }
    }

    @Override
    public void delRecord(Map<String, String> data) {
        int id = Integer.parseInt(data.get("id"));
        microMsgMapper.delRecord(id);
    }

    @Override
    public void multiDel(Map<String, String> data) {
        List<Integer> id = new ArrayList<>();
        for (String item: data.get("id").split(",")) {
            id.add(Integer.parseInt(item));
        }
        microMsgMapper.multiDel(id);
    }

    @Override
    public List<String> getResult(Map<String, String> data) {
        return microMsgMapper.getResult(data.get("command"));
    }

    @Override
    public List<MicroMsg> search(Map<String, String> data) {
        return microMsgMapper.search(data.get("command"), data.get("result"));
    }
}
