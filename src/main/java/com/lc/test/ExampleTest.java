package com.lc.test;

import com.lc.autoDao.UserInfoPOMapper;
import com.lc.autoEntity.UserInfoPO;
import com.lc.autoEntity.UserInfoPOExample;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * mybatis-generator生成的example类使用demo
 *
 * @author lc
 * @date 2019年4月28日17:06:35
 */
public class ExampleTest {
    public static void main(String[] args) {

        SqlSession session = MybatisInit.getSqlSessionFactory().openSession();
        UserInfoPOMapper userMapper = session.getMapper(UserInfoPOMapper.class);
        UserInfoPOExample userInfoPOExample = new UserInfoPOExample();
        userInfoPOExample.createCriteria().andAgeEqualTo(2);
        List<UserInfoPO> userInfos = userMapper.selectByExample(userInfoPOExample);
        System.out.println(userInfos);
    }

}
