package com.lc.autoDao;

import com.lc.autoEntity.UserInfoPO;
import com.lc.autoEntity.UserInfoPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    long countByExample(UserInfoPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int deleteByExample(UserInfoPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int insert(UserInfoPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int insertSelective(UserInfoPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    List<UserInfoPO> selectByExample(UserInfoPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    UserInfoPO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserInfoPO record, @Param("example") UserInfoPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int updateByExample(@Param("record") UserInfoPO record, @Param("example") UserInfoPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int updateByPrimaryKeySelective(UserInfoPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    int updateByPrimaryKey(UserInfoPO record);
}