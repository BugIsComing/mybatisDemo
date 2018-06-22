package com.lc.model;

/**
 * @author ifly_lc
 * 组合对象分别存放在不同的数据表格，因此是MutipleTable
 */
public class CarMultipleTable extends AbstractCar{
    private int engineid;
    private int brakeid;

    public int getEngineid() {
        return engineid;
    }

    public void setEngineid(int engineid) {
        this.engineid = engineid;
    }

    public int getBrakeid() {
        return brakeid;
    }

    public void setBrakeid(int brakeid) {
        this.brakeid = brakeid;
    }

    @Override
    public String toString() {
        return "CarMultipleTable{" +
                "id=" + this.getId() +
                ", type='" + this.getType() + '\'' +
                ", engineid=" + engineid +
                ", brakeid=" + brakeid +
                ", engine=" + this.getEngine() +
                ", brake=" + this.getBrake() +
                '}';
    }
}
