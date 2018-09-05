package com.lc.test;

import com.lc.dao.UserMapper;
import com.lc.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author ifly_lc
 * 配置方式参考官网http://www.mybatis.org/mybatis-3/zh/getting-started.html
 */
public class App {
    public static void main(String[] args) {
        /**
         * 将运行时生成的代理类（.class文件）输出到本地路径下；在通过Mapper方式时才会动态生成class文件
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();


        UserMapper userMapper = session.getMapper(UserMapper.class);

        //执行查询返回一个唯一user对象的sql
        Map<String, Object> params = new HashMap<String, Object>();

        /*************通过API方式访问mybatis，进行CRUD操作************/
        /**
         * C操作
         */
        int temp = new Random().nextInt(10);
        params.put("name", "LC");
        params.put("age", temp);
        session.insert("saveUser", params);

        /**
         * U操作
         */
        params.clear();
        params.put("id", 45);
        params.put("age", 2);
        params.put("name", String.valueOf(new Random().nextInt(10)));
        session.update("updateUser", params);
        /**
         * R操作
         */
        params.clear();
        params.put("age", 2);
        List<User> userList;
        userList = session.selectList("getUserByParam", params);
        /**
         * 相同语句执行两次，试验缓存，试验结果debug查看第二次查询是否打印查询的SQL
         */
        userList = session.selectList("getUserByParam", params);

        for (User ur : userList) {
            System.out.println(ur.toString());
        }

        /**
         * D操作
         */
        params.clear();
        params.put("age",temp);
        session.delete("deleteUser",params);
        /**
         * session必须提交，否则无法写入到数据库
         * 如果在Configuration.xml中设置了defaultAutoCommit，则不需要这一行
         */
        //session.commit();

        /**
         * 测试Mapper代理如何生成
         */
        userMapper.getUserByParam(params);
        session.close();
    }
}
