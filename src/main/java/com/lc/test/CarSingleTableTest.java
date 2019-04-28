package com.lc.test;

import com.lc.model.CarSingleTable;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ifly_lc
 * 单表一对一关联查询测试类
 */
public class CarSingleTableTest {
    public static void main(String[] args) {

        SqlSession session = MybatisInit.getSqlSessionFactory().openSession(true);
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
