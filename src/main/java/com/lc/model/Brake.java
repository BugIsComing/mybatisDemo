package com.lc.model;

/**
 * @author ifly_lc
 */
public class Brake {
    private String type;
    public Brake() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Brake{" +
                "type='" + type + '\'' +
                '}';
    }

}
