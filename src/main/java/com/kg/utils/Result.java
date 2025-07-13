package com.kg.utils;

import lombok.Data;

/**
 * @author CCL
 * @since 2021年12月24日
 */
@Data
public class Result<T> {

    private int code;
    private String message;
    private T data;
    /**
     * 成功,只能是0
     */
    private static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "操作成功";
    /**
     * 失败
     */
    public static final int FAIL_CODE = 1;
    public static final String FAIL_MESSAGE = "操作失败";


    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(SUCCESS_CODE, message, data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(FAIL_CODE, message, null);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}

