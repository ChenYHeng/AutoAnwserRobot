package com.micromsg.demo.modules.micromsg.controller;

import com.micromsg.demo.core.json.JsonResult;
import com.micromsg.demo.modules.micromsg.service.MicroMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@CrossOrigin
public class MicroMsgController {
    private Logger logger = LoggerFactory.getLogger(MicroMsgController.class);

    @Autowired
    private MicroMsgService microMsgService;

    @PostMapping("/test")
    @ResponseBody
    public String test() {
        return "test success";
    }

    @PostMapping("/loadlist")
    @ResponseBody
    public JsonResult getMsgList() {
        return JsonResult.ok(microMsgService.getMsgList());
    }

    /**
     * 添加或修改记录
     * @param data
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public JsonResult addRecord(@RequestParam Map<String, String> data) {
        logger.info(data.toString());
        microMsgService.addRecord(data);
        return JsonResult.ok("成功修改");
    }

    /**
     * 删除单个记录
     * @param data
     * @return
     */
    @PostMapping("/del")
    @ResponseBody
    public JsonResult delRecord(@RequestParam Map<String, String> data) {
        microMsgService.delRecord(data);
        return JsonResult.ok("删除成功");
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/multiDel")
    @ResponseBody
    public JsonResult multiDel(@RequestParam Map<String, String> data) {
        microMsgService.multiDel(data);
        return JsonResult.ok("批量删除成功");
    }

    /**
     * 用指令查找结果
     * @param data
     * @return
     */
    @PostMapping("/command")
    @ResponseBody
    public JsonResult getResult(@RequestParam Map<String, String> data) {
        return JsonResult.ok("指令提交成功", microMsgService.getResult(data));
    }

    @PostMapping("/search")
    @ResponseBody
    public JsonResult search(@RequestParam Map<String, String> data) {
        return JsonResult.ok(microMsgService.search(data));
    }
}
