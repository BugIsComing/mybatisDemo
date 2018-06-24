package com.lc.test;

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
 * @author
 * 测试验证mybatis提供的缓存功能，以App这个类中的测试接口
 */
public class CacheTest {
    public static void main(String[] args){
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();
        /**
         * 如果要测试mybatis的缓存，需要在配置文件中增加setting
         */

        /**
         * 试验一：同一个session中执行两次相同的查询，判断是否调用两次调用数据库
         */
        Map<String, Object> params = new HashMap<String, Object>();
        List<User> userList;
        System.out.println("------------------------------试验一--------------------------------------------");
        params.clear();
        params.put("age", 2);
        userList = session.selectList("getUserByParam", params);
        /**
         * 相同语句执行两次，试验缓存，试验结果在输出窗口debug查看第二次查询是否打印查询的SQL
         */
        userList = session.selectList("getUserByParam", params);

        /**
         * 试验二，同一个session中先查询一次，然后插入数据，最后在查询同一个SQL语句，判断缓存是否失效
         */
        System.out.println("------------------------------试验二--------------------------------------------");
        /**
         *
         * 第一次查询
         */
        params.clear();
        params.put("age", 2);
        userList = session.selectList("getUserByParam", params);
        /**
         * 插入语句
         */
        int temp = new Random().nextInt(10);
        params.clear();
        params.put("name", "LC");
        params.put("age", temp);
        session.insert("saveUser", params);
        /**
         * 再次查询
         */
        params.clear();
        params.put("age", 2);
        userList = session.selectList("getUserByParam", params);
        System.out.println("------------------------------试验三--------------------------------------------");
        /**
         * 不同session中，一个session1先查询，另一个session2再插入（此处插入一个会影响第一次查询结果的记录），session1再次
         * 查询同一个SQL
         */
        /**
         *
         * 第一次查询
         */
        params.clear();
        params.put("age", 2);
        userList = session.selectList("getUserByParam", params);
        for (User ur : userList) {
            System.out.println(ur.toString());
        }
        /**
         * 插入语句
         */
        SqlSession session1 = sessionFactory.openSession();
        temp = 2;
        params.clear();
        params.put("name", "LC88");
        params.put("age", temp);
        session1.insert("saveUser", params);
        /**
         * 再次查询
         */
        params.clear();
        params.put("age", 2);
        userList = session.selectList("getUserByParam", params);

        for (User ur : userList) {
            System.out.println(ur.toString());
        }
        /**
         * 两个不同session的查询对比
         */
        params.clear();
        params.put("age", 2);
        userList = session1.selectList("getUserByParam", params);

        for (User ur : userList) {
            System.out.println(ur.toString());
        }
    }

}
