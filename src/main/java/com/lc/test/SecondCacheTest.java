package com.lc.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author ifly_lc
 * mybatis二级缓存测试例子
 */
public class SecondCacheTest {
    public static void main(String[] args) {
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session1 = sessionFactory.openSession();
        SqlSession session2 = sessionFactory.openSession();
    }
}
