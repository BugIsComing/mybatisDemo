package com.lc.model;

/**
 * @author ifly_lc
 * 抽象类，由于要测试不同的情况，需要定义不同的子类，因此将子类公共属性提取出来
 */
public abstract class AbstractCar {
    private int id;
    private String type;
    private Engine engine;
    private Brake brake;

    public AbstractCar() {
    }

    public AbstractCar(int id, String type, Engine engine, Brake brake) {
        this.id = id;
        this.type = type;
        this.engine = engine;
        this.brake = brake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Brake getBrake() {
        return brake;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    @Override
    public String toString() {
        return "AbstractCar{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
