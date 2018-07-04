package com.lc.dao;
/**
 * Mybatis提供两种调用方式
 * 一种是传统API方式，通过传递StatementId和Arguments访问mapper中的sql，参考App中的测试代码
 * 一种是Mapper接口，也就是该类使用的方式
 */

import com.lc.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author:LC
 * @Date:Created in 23:00 2018/1/15
 * @Modifyed by:
 */
public interface UserMapper {
    /**
     * 通过参数查询
     * 此处的接口方法名要和userMapper.xml中定义的id一致，不然无法映射
     * 比如将getUserById改为getUser则不会生效
     * @param params
     * @return
     */
//    public List<User> getUserByParam(Map<String,Object> params);
//    public void saveUser(User user);
//    public void updateUser(Map<String,Object> params);
}
