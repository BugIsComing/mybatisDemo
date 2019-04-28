package com.lc.test;

import com.lc.dao.DepartmentMapper;
import com.lc.model.Department;
import org.apache.ibatis.session.SqlSession;

/**
 * 测试mybatis的递归查询
 *
 * @author lc
 */
public class DepartmentTest {
    public static void main(String[] args) {

        SqlSession session = MybatisInit.getSqlSessionFactory().openSession();

        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.selectAll("1");
        System.out.println(department.toString());
    }
}
