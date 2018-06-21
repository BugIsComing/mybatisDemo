package com.lc.model;

/**
 * @author ifly_lc
 * Cars类用于试验一对一的关联查询
 */
public class Cars {
    private int id;
    private String type;
    private Engine engine;
    private Brake brake;

    public Cars() {
    }

    public Cars(int id, String type, Engine engine, Brake brake) {
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
        return "Cars{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
