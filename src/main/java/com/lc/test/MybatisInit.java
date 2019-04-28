package com.lc.test;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Mybatis 初始化
 *
 * @author lc
 * @date 2019年4月28日17:01:21
 */
public class MybatisInit {
    private static SqlSessionFactory sqlSessionFactory;

    static {

        //将运行时生成的代理类（.class文件）输出到本地路径下；在通过Mapper方式时才会动态生成class文件

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String resource = "Configuration.xml";
        InputStream is = MybatisInit.class.getClassLoader().getResourceAsStream(resource);
        /*
          此处build没有传递environment，则使用配置文件中environment的Default
          如果要选择不同的数据源，可以使用build(InputStream inputStream, String environment)
         */
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
