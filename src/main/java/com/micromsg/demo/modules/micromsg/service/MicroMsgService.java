package com.micromsg.demo.modules.micromsg.service;

import com.micromsg.demo.modules.micromsg.entity.MicroMsg;

import java.util.List;
import java.util.Map;

public interface MicroMsgService {
    List<MicroMsg> getMsgList();

    void addRecord(Map<String, String> data);

    void delRecord(Map<String, String> data);

    void multiDel(Map<String, String> data);

    List<String> getResult(Map<String, String> data);

    List<MicroMsg> search(Map<String, String> data);
}
