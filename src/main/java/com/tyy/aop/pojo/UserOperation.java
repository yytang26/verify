package com.tyy.aop.pojo;

import java.util.Date;

public class UserOperation {
    private Long id;

    private String action;

    private String method;

    private String params;

    private String remark;

    private String ip;

    private Date createTime;

    private Date updateTime;

    private String creatorId;

    private String operatorId;

    private String creator;

    private String operator;

    private Integer isDelete;

    public UserOperation(Long id, String action, String method, String params, String remark, String ip, Date createTime, Date updateTime, String creatorId, String operatorId, String creator, String operator, Integer isDelete) {
        this.id = id;
        this.action = action;
        this.method = method;
        this.params = params;
        this.remark = remark;
        this.ip = ip;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.creatorId = creatorId;
        this.operatorId = operatorId;
        this.creator = creator;
        this.operator = operator;
        this.isDelete = isDelete;
    }

    public UserOperation() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}