package com.app.oscar.pruebafloatingbutton;

/**
 * Created by Oscar on 15/10/2016.
 */

public class Card {
    private long id;
    private String name;
    private int color_resource;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorResource() {
        return color_resource;
    }

    public void setColorResource(int color_resource) {
        this.color_resource = color_resource;
    }
}
