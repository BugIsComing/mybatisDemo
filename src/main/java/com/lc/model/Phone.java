package com.lc.model;

/**
 * @author 手机号的抽象，一个手机号只能归属于一个user，但是一个 user可以拥有多个phone
 */
public class Phone {
    private int phoneId;
    private String phoneNum;
    private int userId;

    public Phone() {
    }

    public Phone(int phoneId, String phoneNum) {
        this.phoneId = phoneId;
        this.phoneNum = phoneNum;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", phoneNum='" + phoneNum + '\'' +
                ", userId=" + userId +
                '}';
    }
}
