package com.example.demo.constant;

import cn.hutool.core.util.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;

    public BaseException(IErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 如果flag==true，则抛出message异常
     *
     * @param flag    标记
     * @param message 异常信息
     */
    public static void throwIfFalse(boolean flag, Integer code, String message) {
        if (!flag) {
            throw new BaseException(code, message);
        }
    }

    public static void throwIfFalse(boolean flag, IErrorCode errorCode) {
        if (!flag) {
            throw new BaseException(errorCode);
        }
    }

    /**
     * 如果flag==true，则抛出message异常
     *
     * @param flag    标记
     * @param message 异常信息
     */
    public static void throwIfTrue(boolean flag, Integer code, String message) {
        if (flag) {
            throw new BaseException(code, message);
        }
    }

    public static void throwIfTrue(boolean flag, IErrorCode errorCode) {
        if (flag) {
            throw new BaseException(errorCode);
        }
    }

    /**
     * 如果value==null或者isEmpty，则抛出message异常
     *
     * @param value   值
     * @param message 异常信息
     */
    public static void throwIfEmpty(Object value, Integer code, String message) {
        if (ObjectUtil.isEmpty(value)) {
            throw new BaseException(code, message);
        }
    }

    public static void throwIfEmpty(Object value, IErrorCode errorCode) {
        if (ObjectUtil.isEmpty(value)) {
            throw new BaseException(errorCode);
        }
    }

    /**
     * 如果value==null或者isEmpty，则抛出message异常
     *
     * @param value   值
     * @param message 异常信息
     */
    public static void throwIfNotEmpty(Object value, Integer code, String message) {
        if (ObjectUtil.isNotEmpty(value)) {
            throw new BaseException(code, message);
        }
    }

    public static void throwIfNotEmpty(Object value, IErrorCode errorCode) {
        if (ObjectUtil.isNotEmpty(value)) {
            throw new BaseException(errorCode);
        }
    }
}
