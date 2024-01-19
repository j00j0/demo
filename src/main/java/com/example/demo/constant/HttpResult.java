package com.example.demo.constant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(title = "返回数据通用格式", description = "0为成功，其他失败，data数据格式请查看接口定义")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult<T> {
    private int code = -1;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return code == 0;
    }

    public static final int CODE_SUCCESS = 0;            // 成功状态码
    public static final int CODE_ERROR = 500;            // 错误状态码
    public static final int CODE_WARNING = 501;            // 警告状态码
    public static final int CODE_NOT_FOUND = 404;        // 未找到
    public static final int CODE_NOT_JUR = 403;            // 无权限状态码
    public static final int CODE_NOT_LOGIN = 401;        // 未登录状态码
    public static final int CODE_INVALID_REQUEST = 400;    // 无效请求状态码

    public static <T> HttpResult<T> getResult(Integer code, String msg, T body) {
        return new HttpResult<>(code, msg, body);
    }

    // 返回成功
    public static HttpResult<String> getSuccess(String msg) {
        return new HttpResult<>(CODE_SUCCESS, msg, null);
    }

    public static <T> HttpResult<T> getSuccess(String msg, T body) {
        return new HttpResult<>(CODE_SUCCESS, msg, body);
    }

    // 返回失败
    public static HttpResult<String> getError() {
        return new HttpResult<>(CODE_ERROR, "error", null);
    }

    public static HttpResult<String> getError(String msg) {
        return new HttpResult<>(CODE_ERROR, msg, null);
    }

    public static HttpResult<String> getError(Integer code, String msg) {
        return new HttpResult<>(code, msg, null);
    }

    public static HttpResult<String> getError(IErrorCode errorCode) {
        return new HttpResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    // 返回警告
    public static HttpResult<String> getWarning() {
        return new HttpResult<>(CODE_ERROR, "warning", null);
    }

    public static HttpResult<String> getWarning(String msg) {
        return new HttpResult<>(CODE_WARNING, msg, null);
    }

    // 返回未登录
    public static HttpResult<String> getNotLogin() {
        return new HttpResult<>(CODE_NOT_LOGIN, "未登录，请先登录", null);
    }

    // 返回没有权限的
    public static HttpResult<String> getNotJur(String msg) {
        return new HttpResult<>(CODE_NOT_JUR, msg, null);
    }
}