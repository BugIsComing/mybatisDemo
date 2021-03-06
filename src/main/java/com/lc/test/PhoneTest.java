package com.lc.test;

import com.lc.model.PhoneUser;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 测试一对多关联查询
 */
public class PhoneTest {
    public static void main(String[] args) {
        SqlSession session = MybatisInit.getSqlSessionFactory().openSession(true);
        List<PhoneUser> carsList = session.selectList("selectPhoneUser");
        for (PhoneUser car : carsList) {
            System.out.println(car.toString());
        }
        //查询一次数据库
        carsList = session.selectList("selectPhoneUserOnce");
        for (PhoneUser car : carsList) {
            System.out.println(car.toString());
        }
        session.close();
    }
}
