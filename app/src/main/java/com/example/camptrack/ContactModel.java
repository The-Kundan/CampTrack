package com.example.camptrack;

public class ContactModel {
    int img;
    String name,details;
    public ContactModel(int img, String name,String details){
        this.name=name;
        this.details = details;
        this.img = img;
    }
    public ContactModel( String name,String details){
        this.name=name;
        this.details = details;
    }
}
