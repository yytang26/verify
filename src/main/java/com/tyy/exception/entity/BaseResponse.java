package com.tyy.exception.entity;

import com.tyy.exception.e.ResultEnum;
import lombok.*;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class BaseResponse<T> {

    @Getter @Setter @NonNull
    private int code;

    @Getter @Setter @NonNull
    private String message;

    @Getter @Setter
    private T data;

    public BaseResponse(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public static <E> BaseResponse<E> success() {
        return BaseResponse.<E>builder().code(ResultEnum.SUCCESS.getCode()).message(ResultEnum.SUCCESS.getMessage()).build();
    }

    public static <E> BaseResponse<E> success(E data) {
        return BaseResponse.<E>builder().code(ResultEnum.SUCCESS.getCode()).message(ResultEnum.SUCCESS.getMessage()).data(data).build();
    }

    public static <E> BaseResponse<E> failure() {
         return BaseResponse.<E>builder().code(ResultEnum.FAIL.getCode()).message(ResultEnum.FAIL.getMessage()).build();
    }

    public static <E> BaseResponse<E> failure(String msg) {
        return BaseResponse.<E>builder().code(ResultEnum.FAIL.getCode()).message(msg).build();
    }

    public static <E> BaseResponse<E> failure(int code ,String msg) {
        return BaseResponse.<E>builder().code(code).message(msg).build();
    }
}
