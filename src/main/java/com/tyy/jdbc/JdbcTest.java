package com.tyy.jdbc;

import com.tyy.mybatis.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:tyy
 * @date:2021/7/24
 */
public class JdbcTest {

    Logger logger = LoggerFactory.getLogger(JdbcTest.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void batchInsert(List<Student> studentList) {

        List<List<Student>> batchStudents = getBatchStudent(studentList);

        String sql = "insert into student (createTime,updateTime,creatorId,operatorId,creator,operator,isDelete,name,age,address,sex)"
                + "values (sysdate(),sysdate(),?,?,?,?,?,?,?,?,?)";

        Long startTime = System.currentTimeMillis();
        logger.info("批量插入开始");
        for (List<Student> students : batchStudents) {
            final List<Student> curList = students;
            this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1,"123");
                    ps.setString(2,"123");
                    ps.setString(3,"test");
                    ps.setString(4,"test");
                    ps.setInt(5,0);
                    ps.setString(6,curList.get(i).getName());
                    ps.setInt(7,curList.get(i).getAge());
                    ps.setString(8,curList.get(i).getAddress());
                    ps.setInt(9,curList.get(i).getSex());
                }

                @Override
                public int getBatchSize() {
                    return curList.size();
                }
            });
        }
        Long endTime = System.currentTimeMillis();
        logger.info("批量插入结束，用时:[{}] 毫秒",endTime-startTime);

    }

    private List<List<Student>> getBatchStudent(List<Student> studentList) {

        List<List<Student>> lists = new ArrayList<>();

        if (CollectionUtils.isEmpty(studentList)) {
            return lists;
        }

        int count = 50000;
        int index = 0;
        while (true) {
            List<Student> list = studentList.subList(index * count, Math.min((index + count) * count, studentList.size()));
            lists.add(list);
            if (list.size() < count) {
                break;
            }
            index++;
        }
        return lists;
    }

    public void testJdbc() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("tyy");
        student.setAge(12);
        student.setAddress("诸暨");
        student.setSex(0);
        students.add(student);
        student = new Student();
        student.setName("lhb");
        student.setAge(24);
        student.setAddress("信丰");
        student.setSex(1);
        students.add(student);

        batchInsert(students);
    }
}
