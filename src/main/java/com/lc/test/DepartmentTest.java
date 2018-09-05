package com.lc.test;

import com.lc.dao.DepartmentMapper;
import com.lc.dao.UserMapper;
import com.lc.model.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 测试mybatis的递归查询
 * @author lc
 */
public class DepartmentTest {
    public static void main(String[]args){
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();

        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.selectAll("1");
        System.out.println(department.toString());
    }
}
