package com.cst2335.finalproject;

public class Comic {
    private String title;
    private String imageUrl;
    private String thumbnail;

    public Comic(String title, String imageUrl){
        this.title = title;
        this.imageUrl = imageUrl;
    }
    public String getTitle() {
        return title;
    }

    public String getImageUrl() {return imageUrl;}

    public String getThumbnail(){return thumbnail;}
}
