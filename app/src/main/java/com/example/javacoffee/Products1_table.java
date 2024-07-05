package com.example.javacoffee;

public class Products1_table {

    private int Id;
    private  String Name;
    private String price;
    private String description;
    private byte[] Image;

    public Products1_table(int id, String name, String price, String description, byte[] image) {
        Id = id;
        Name = name;
        this.price = price;
        this.description = description;
        Image = image;
    }

    public Products1_table(String name, String price, String description, byte[] image) {
        Name = name;
        this.price = price;
        this.description = description;
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
