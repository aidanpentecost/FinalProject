package com.cst2335.finalproject;

public class ComicItem {

    private String id;
    private String name;
    private String description;
    private String thumbnailPath;
    private String thumbnailExtension;

    /**
     * @param id
     * @param name
     * @param description
     * @param thumbnailPath
     * @param thumbnailExtension
     */
    public ComicItem(String id, String name, String description, String thumbnailPath, String thumbnailExtension) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.thumbnailExtension = thumbnailExtension;
    }

    /**
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return String thumbnailPath
     */
    public String getThumbnailPath() {
        return thumbnailPath;
    }

    /**
     * @return String thumbnailExtention
     */
    public String getThumbnailExtension() {
        return thumbnailExtension;
    }
}

