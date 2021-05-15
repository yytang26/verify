package com.tyy.exception.exception;

/**
 * @author:tyy
 * @date:2021/5/15
 */
public class BaseException extends RuntimeException{

    public BaseException() {
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message,Throwable cause){
        super(message,cause);
    }
}

