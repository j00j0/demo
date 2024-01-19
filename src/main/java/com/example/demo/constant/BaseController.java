package com.example.demo.constant;

public class BaseController {
    public static <T> HttpResult<T> httpOk(T data) {
        return new HttpResult<>(HttpResult.CODE_SUCCESS, "执行成功", data);
    }

    public static <T> HttpResult<T> httpFail(int code, String msg) {
        return new HttpResult<>(code, msg, null);
    }

    public static <T> HttpResult<T> httpFail(IErrorCode errorCode) {
        return new HttpResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> HttpResult<T> httpFail(T data, int code, String msg) {
        return new HttpResult<>(code, msg, data);
    }

    public static <T> HttpResult<T> httpFail(T data, IErrorCode errorCode) {
        return new HttpResult<>(errorCode.getCode(), errorCode.getMessage(), data);
    }
}
