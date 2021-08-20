package com.example.volocustomer.HelperClasses;

public class BrowseHelperClass {

    int image;
    String category;

    public BrowseHelperClass(int image, String category) {
        this.category = category;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

}
