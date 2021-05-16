package com.tyy.aop.mapper;

import com.tyy.aop.pojo.UserOperation;
import com.tyy.aop.pojo.UserOperationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//@Mapper
public interface UserOperationMapper {
    long countByExample(UserOperationExample example);

    int deleteByExample(UserOperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserOperation record);

    int insertSelective(UserOperation record);

    List<UserOperation> selectByExample(UserOperationExample example);

    UserOperation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserOperation record, @Param("example") UserOperationExample example);

    int updateByExample(@Param("record") UserOperation record, @Param("example") UserOperationExample example);

    int updateByPrimaryKeySelective(UserOperation record);

    int updateByPrimaryKey(UserOperation record);
}