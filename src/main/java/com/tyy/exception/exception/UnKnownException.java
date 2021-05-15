package com.tyy.exception.exception;

/**
 * @author:tyy
 * @date:2021/5/15
 */
public class UnKnownException extends RuntimeException{

    public UnKnownException() {
    }

    public UnKnownException(String message){
        super(message);
    }

    public UnKnownException(Throwable cause) {
        super(cause);
    }

    public UnKnownException(String message,Throwable cause){
        super(message,cause);
    }
}
