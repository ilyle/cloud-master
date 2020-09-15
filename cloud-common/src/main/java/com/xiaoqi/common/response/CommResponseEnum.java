package com.xiaoqi.common.response;

public enum  CommResponseEnum {

    SUCCESS(200, "成功"),
    ERROR(-1, "异常");

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    CommResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
