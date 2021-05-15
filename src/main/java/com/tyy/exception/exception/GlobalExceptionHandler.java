package com.tyy.exception.exception;

import com.tyy.exception.entity.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public BaseResponse handleBusinessException(BusinessException exception){
        logger.error("业务逻辑错误："+exception.getMessage());
        return BaseResponse.failure(exception.getMessage());
    }


    @ExceptionHandler(BaseException.class)
    public BaseResponse handleBaseException(BaseException exception){
        logger.error("业务逻辑错误："+exception.getMessage());
        return BaseResponse.failure(exception.getMessage());
    }

    @ExceptionHandler(UnKnownException.class)
    public BaseResponse handleUnKonwnException(UnKnownException exception){
        logger.error("业务逻辑错误："+exception.getMessage());
        return BaseResponse.failure(exception.getMessage());
    }
}
