package com.lc.test;

import com.lc.model.CarMultipleTable;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author ifly_lc
 * 多表格一对一关联查询测试类
 */
public class CarMultipleTableTest {
    public static void main(String[]args){
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //设置了true，则不用调用commit
        SqlSession session = sessionFactory.openSession(true);
        //调用一次mapper，多次查询数据库
        List<CarMultipleTable> carsList = session.selectList("selectCarsTest");
        for (CarMultipleTable car:carsList){
            System.out.println(car.toString());
        }

        //调用一次mapper，只做一次查询数据库
        List<CarMultipleTable> carsList1 = session.selectList("selectCarsTestQueryOnce");
        for (CarMultipleTable car:carsList1){
            System.out.println(car.toString());
        }

        session.close();
    }
}
