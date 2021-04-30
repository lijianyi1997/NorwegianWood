package com.example.norwegianwood;

public class Actors {
    private String name;
    private String role;
    private int imgId;
    private String uriDir;
    private String jname;
    public Actors(String name, String role, int imgId, String uriDir){
        this.name = name;
        this.role = role;
        this.imgId = imgId;
        this.uriDir = uriDir;

    }

    public Actors(String name, String role, int imgId, String uriDir, String jname){
        this.name = name;
        this.role = role;
        this.imgId = imgId;
        this.uriDir = uriDir;
        this.jname = jname;

    }
    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }
    public int getImgId(){
        return imgId;
    }
    public String getUriDir(){
        return uriDir;
    }
    public String getJname(){
        return jname;
    }
}

