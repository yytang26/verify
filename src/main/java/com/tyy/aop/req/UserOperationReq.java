package com.tyy.aop.req;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author:tyy
 * @date:2021/5/16
 */

@Data
@Builder
public class UserOperationReq {

    private Long id;

    private String remark;

    private String action;

    private String params;

    private String result;

    private String method;

    private String ip;

    private Date createTime;

    private Date updateTime;

    private String creatorId;

    private String creator;

    private String operatorId;

    private String operator;
}
