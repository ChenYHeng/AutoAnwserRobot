package com.micromsg.demo.core.json;

public class JsonResult {
    private int statusCode;
    private String errMsg;
    private Object data;

    private JsonResult(int statusCode, String errMsg, Object data) {
        this.statusCode = statusCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public static JsonResult result(int statusCode, String errMsg, Object data) {
        return new JsonResult(statusCode, errMsg, data);
    }

    public static JsonResult ok () {
        return JsonResult.ok("request:ok", "");
    }
    public static JsonResult ok (String errMsg) {
        return JsonResult.ok(errMsg, "");
    }
    public static JsonResult ok (Object data) {
        return JsonResult.ok("request:ok", data);
    }
    public static JsonResult ok (String errMsg, Object data) {
        return result(200, errMsg, data);
    }
    public static JsonResult error () {
        return JsonResult.error("request:fail", "");
    }
    public static JsonResult error (String errMsg) {
        return JsonResult.error(errMsg, "");
    }
    public static JsonResult error (Object data) {
        return JsonResult.error("request:fail", data);
    }
    public static JsonResult error (String errMsg, Object data) {
        return result(-1, errMsg, data);
    }
    public static JsonResult error (int statusCode, String errMsg) {
        return result(statusCode, errMsg, "");
    }
    public static JsonResult error (int statusCode, String errMsg, Object data) {
        return result(statusCode, errMsg, data);
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return data;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public String getErrMsg() {
        return errMsg;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }
}
