package com.lc.test;

import com.lc.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 测试验证mybatis提供的缓存功能，以App这个类中的测试接口
 * 主要测试mybatis提供的一级缓存功能
 */
public class CacheTest {
    public static void main(String[] args) {
        SqlSession session = MybatisInit.getSqlSessionFactory().openSession();
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
         * 每次试验完之后调用清理一级缓存
         */
        session.clearCache();
        /**
         * 试验二，同一个session中先查询一次，然后插入数据（此处插入一个会影响第一次查询结果的记录），最后在查询同一个SQL语句，判断缓存是否失效
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
        int temp = 2;
        params.clear();
        params.put("name", "LC222");
        params.put("age", temp);
        session.insert("saveUser", params);
        /**
         * 再次查询,结果增加了一条记录，说明insert、update等操作会影响缓存
         */
        params.clear();
        params.put("age", 2);
        userList = session.selectList("getUserByParam", params);
        session.clearCache();
        System.out.println("------------------------------试验三--------------------------------------------");
        /**
         * 不同session中，一个session1先查询，另一个session2再插入（此处插入一个会影响第一次查询结果的记录），session1再次查询同一个SQL
         * 试验结果表明，不同session的插入不会影响其他session的缓存结果，除非缓存失效再次查询数据库
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
        SqlSession session1 = MybatisInit.getSqlSessionFactory().openSession();
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
        session.clearCache();
        session1.clearCache();

        /**
         * 试验四，两次查询，两次查询的SQL处理where之后的条件不一样，其他都一样，where条件的顺序不一样
         * 试验四是试验一的变型
         * 试验结果表明查询条件的顺序会影响缓存,查询条件的顺序不同，也会被当做不同的缓存存放（虽然结果是相同的），
         * 引起缓存不同的原因是两个查询的statementId不一样导致的,实际开发中不应该出现这种查询情况，应该是要getUserByParam这种方式
         */
        System.out.println("------------------------------试验四--------------------------------------------");
        params.clear();
        params.put("age", 2);
        params.put("name", "LC");
        userList = session.selectList("getUserByAgeAndName", params);

        /**
         * 再次查询，交换查询条件顺序
         */
        userList = session.selectList("getUserByNameAndAge", params);
        session.clearCache();

        session.close();
        session1.close();
    }

}
