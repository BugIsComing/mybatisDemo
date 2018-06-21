package com.lc.model;

public class Cars1 {
    private int id;
    private String type;
    private int engineid;
    private int brakeid;
    private Engine engine;
    private Brake brake;

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
        return "CarsTest{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", engineid=" + engineid +
                ", brakeid=" + brakeid +
                ", engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
