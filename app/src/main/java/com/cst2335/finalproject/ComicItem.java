package com.cst2335.finalproject;

public class ComicItem {

    private String id;
    private String name;
    private String description;
    private String thumbnailPath;
    private String thumbnailExtension;
    public ComicItem(String id, String name, String description, String thumbnailPath, String thumbnailExtension) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.thumbnailExtension = thumbnailExtension;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getThumbnailPath() {
        return thumbnailPath;
    }
    public String getThumbnailExtension() {
        return thumbnailExtension;
    }
}

