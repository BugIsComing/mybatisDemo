package com.lc.test;

import org.apache.ibatis.session.SqlSession;

/**
 * @author ifly_lc
 * mybatis二级缓存测试例子
 */
public class SecondCacheTest {
    public static void main(String[] args) {


        SqlSession session1 = MybatisInit.getSqlSessionFactory().openSession();
        SqlSession session2 = MybatisInit.getSqlSessionFactory().openSession();
        session1.selectList("testSecondCache");
        session2.selectList("testSecondCache");
        System.out.println("test");
    }
}
