package com.lc.test;

import com.lc.model.Cars1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author
 */
public class CarsTest1to1 {
    public static void main(String[]args){
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //设置了true，则不用调用commit
        SqlSession session = sessionFactory.openSession(true);
        List<Cars1> carsList = session.selectList("selectCarsTest");
        for (Cars1 car:carsList){
            System.out.println(car.toString());
        }

        session.close();
    }
}
