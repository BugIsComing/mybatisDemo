package com.lc.model;

/**
 * @author ifly_lc
 * 组合对象的所有属性存放在一张表格中，因此是SingleTable
 */
public class CarSingleTable extends AbstractCar{

    public CarSingleTable() {
        super();
    }

    public CarSingleTable(int id, String type, Engine engine, Brake brake) {
        super(id,type,engine,brake);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + this.getId() +
                ", type='" + this.getType() + '\'' +
                ", engine=" + this.getEngine() +
                ", brake=" + this.getBrake() +
                '}';
    }
}