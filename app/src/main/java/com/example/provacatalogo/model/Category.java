package com.example.provacatalogo.model;

import java.util.Map;

public class Category {
    public String img;
    public Map<String,Plate> plates;

    public Category(String nome,Map<String,Plate> plates) {
        this.img = img;
        this.plates=plates;
    }

    public Category() {
    }
}
