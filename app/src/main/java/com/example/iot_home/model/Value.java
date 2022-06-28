package com.example.iot_home.model;

public class Value {

    private String type;
    private int icon;


    public Value(String type, int icon) {
        this.type = type;
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public int getIcon() {
        return icon;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
