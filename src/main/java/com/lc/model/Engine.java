package com.lc.model;

/**
 * @author ifly_lc
 */
public class Engine {
    private String type;
    private String cylinder;

    public Engine(String type, String cylinder) {
        this.type = type;
        this.cylinder = cylinder;
    }

    public Engine() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", cylinder='" + cylinder + '\'' +
                '}';
    }
}
