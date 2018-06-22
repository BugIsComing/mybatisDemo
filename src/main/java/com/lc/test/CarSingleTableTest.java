package com.lc.test;

import com.lc.model.CarSingleTable;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ifly_lc
 * 单表一对一关联查询测试类
 */
public class CarSingleTableTest {
    public static void main(String[] args) {
        String resource = "Configuration.xml";
        InputStream is = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //设置了true，则不用调用commit
        SqlSession session = sessionFactory.openSession(true);
        List<CarSingleTable> carsList = session.selectList("selectCars");
        for (CarSingleTable car : carsList) {
            System.out.println(car.toString());
        }
        Map<String, Object> params = new HashMap<>(16);
        params.put("carid", 8);
        params.put("cartype", "BMW");
        params.put("enginetype", "Gas");
        params.put("enginecylinders", 8);
        params.put("brakestype", "disk");
        session.insert("insertCars", params);
        session.close();
    }
}
