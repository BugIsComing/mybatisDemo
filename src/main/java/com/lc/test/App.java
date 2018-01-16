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

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //mybatis的配置文件
        String resource = "Configuration.xml";

        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();


        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User user = new User();
//        for(int i=1;i<=10;i++){
//            user.setName("LC");
//            user.setAge(i);
//            userMapper.saveUser(user);
//        }

        //执行查询返回一个唯一user对象的sql
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name","lc");
        List<User> userList = userMapper.getUserByParam(params);

        for (User ur : userList){
            System.out.println(ur.toString());
        }

        /**
         * session必须提交，否则无法写入到数据库
         */
        session.commit();
        session.close();
    }
}
