package com.lc.autoEntity;

import java.io.Serializable;

public class UserInfoPO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_copy.id
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_copy.name
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_copy.age
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_copy
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_copy.id
     *
     * @return the value of user_copy.id
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_copy.id
     *
     * @param id the value for user_copy.id
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_copy.name
     *
     * @return the value of user_copy.name
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_copy.name
     *
     * @param name the value for user_copy.name
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_copy.age
     *
     * @return the value of user_copy.age
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_copy.age
     *
     * @param age the value for user_copy.age
     *
     * @mbg.generated Tue Apr 23 15:31:14 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}