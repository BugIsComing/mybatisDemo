package com.lc.test;

import com.lc.dao.UserMapper;
import com.lc.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.*;

/**
 * @author ifly_lc
 *  配置方式参考官网http://www.mybatis.org/mybatis-3/zh/getting-started.html
 */
public class App
{
    public static void main( String[] args )
    {
        /**
         * 将运行时生成的代理类（.class文件）输出到本地路径下；
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();


        //执行查询返回一个唯一user对象的sql
        Map<String,Object> params = new HashMap<String,Object>();


        params.put("id",45);
        params.put("age",2);
        params.put("name", String.valueOf(new Random().nextInt(10)));
        session.update("updateUser",params);
        //params.put("name","lc");
        params.clear();
        params.put("age",2);
        List<User> userList = null;
        //userList = userMapper.getUserByParam(params);

        /**
         * 通过传统的API方式访问mybatis
         */
        userList =  session.selectList("getUserByParam",params);

        for (User ur : userList){
            System.out.println(ur.toString());
        }

        /**
         * session必须提交，否则无法写入到数据库
         * 如果在Configuration.xml中设置了defaultAutoCommit，则不需要这一行
         */
        //session.commit();

        /**
         * 通过Mapper接口访问mybatis
         * 这一句执行完之后会在com.sun.proxy路径下生成一个代理类，前提是将sun.misc.ProxyGenerator.saveGeneratedFiles设置为true
         */
        //UserMapper userMapper = session.getMapper(UserMapper.class);
//        User user = new User();
//        for(int i=1;i<=10;i++){
//            user.setName("LC");
//            user.setAge(i);
//            userMapper.saveUser(user);
//        }
        session.close();
    }
}
