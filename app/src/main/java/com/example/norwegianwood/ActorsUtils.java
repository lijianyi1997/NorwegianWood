package com.example.norwegianwood;

public class ActorsUtils {
    private String txtLeft;
    private String txtRight;
    private int imageId;
    public ActorsUtils(String txtLeft, String txtRight, int imageId){
        this.imageId = imageId;
        this.txtLeft = txtLeft;
        this.txtRight = txtRight;
    }
    public String getTxtLeft(){
        return txtLeft;
    }
    public String getTxtRight(){
        return txtRight;
    }
    public int getImageId(){
        return imageId;
    }
}
