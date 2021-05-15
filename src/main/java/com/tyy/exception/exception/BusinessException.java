package com.tyy.exception.exception;

import com.tyy.exception.e.ResultEnum;
import com.tyy.exception.service.ExceptionService;

/**
 * @author:tyy
 * @date:2021/5/15
 */
public class BusinessException extends RuntimeException {

    private Integer errorCode;

    public BusinessException() {

    }

    public BusinessException(String message){
        super(message);
        errorCode = ResultEnum.FAIL.getCode();
    }

    public BusinessException(Integer errorCode , String msg){
        super(msg);
        this.errorCode = errorCode;
    }

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.errorCode = resultEnum.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
    public BusinessException(String message,Throwable cause){
        super(message,cause);
    }


}
