package com.example.javacoffee;

public class Card_table {

    private int Id;
    private  String Name;
    private String price;

    public Card_table(int id, String name, String price) {
        Id = id;
        Name = name;
        this.price = price;
    }

    public Card_table(String name, String price) {
        Name = name;
        this.price = price;
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
}
