package com.example.shoes;

public class ItemModel {
    Integer id;
    String image;
    String category;
    String name;
    String price;
    String text;

    public ItemModel(Integer id, String image, String category, String name, String price, String text) {
        this.id = id;
        this.image = image;
        this.category = category;
        this.name = name;
        this.price = price;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
