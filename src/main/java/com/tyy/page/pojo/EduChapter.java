package com.tyy.page.pojo;

import java.util.Date;

public class EduChapter {
    private String id;

    private String courseId;

    private String title;

    private Integer sort;

    private Date gmtCreate;

    private Date gmtModified;

    public EduChapter(String id, String courseId, String title, Integer sort, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.sort = sort;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public EduChapter() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}