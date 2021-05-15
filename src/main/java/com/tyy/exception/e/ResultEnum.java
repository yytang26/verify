package com.tyy.exception.e;

/**
 * @author:tyy
 * @date:2021/5/15
 * 结果枚举类
 */
public enum  ResultEnum {

    SUCCESS(0,"success"),
    FAIL(1,"fail"),

    SYSTEM_FAIL(2,"系统异常，请求失败");

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultEnum(int code,String message){
        this.code = code;
        this.message = message;
    }
}
