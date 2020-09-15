package com.xiaoqi.common.response;

public class CommHttpResponseUtil {

    private static <T> CommHttpResponse<T> create(int code, String msg, T data) {
        CommHttpResponse<T> response = new CommHttpResponse<T>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static <T> CommHttpResponse<T> success(T data) {
        return create(CommResponseEnum.SUCCESS.getCode(), CommResponseEnum.SUCCESS.getMsg(), data);
    }

    public static <T> CommHttpResponse<T> error(String errMsg) {
        return create(CommResponseEnum.SUCCESS.getCode(), errMsg != null ? errMsg : CommResponseEnum.ERROR.getMsg(), null);
    }
}
