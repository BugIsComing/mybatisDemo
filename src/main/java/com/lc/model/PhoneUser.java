package com.lc.model;

import java.util.List;

/**
 * @author 手机号用户
 * 用于测试一对多关联查询
 */
public class PhoneUser {
    private int userId;
    List<Phone> phoneList;

    public PhoneUser() {
    }

    public PhoneUser(int userId, List<Phone> phoneList) {
        this.userId = userId;
        this.phoneList = phoneList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "PhoneUser{" +
                "userId=" + userId +
                ", phoneList=" + phoneList +
                '}';
    }
}
