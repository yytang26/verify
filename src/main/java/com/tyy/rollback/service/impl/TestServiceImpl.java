package com.tyy.rollback.service.impl;

import com.tyy.exception.exception.BusinessException;
import com.tyy.mybatis.mapper.StudentMapper;
import com.tyy.mybatis.pojo.Student;
import com.tyy.rollback.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author:tyy
 * @date:2021/6/27
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        Student student = new Student();
        student.setAddress("hj");
        student.setAge(18);
        student.setCreatorId("tyy");
        student.setCreator("tyy");
        student.setIsDelete(0);
        student.setName("tyy");
        student.setSex(1);
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        student.setId(1L);
        studentMapper.insertSelective(student);
        throw new BusinessException("异常");

    }
}
