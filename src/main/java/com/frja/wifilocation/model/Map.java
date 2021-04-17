package com.frja.wifilocation.model;

public class Map {

    private String name;

    private float sizeX;

    private float sizeY;

    private String url;

    public Map(){
        name = null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSizeX() {
        return sizeX;
    }

    public void setSizeX(float sizeX) {
        this.sizeX = sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }

    public void setSizeY(float sizeY) {
        this.sizeY = sizeY;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                ", url='" + url + '\'' +
                '}';
    }
}
