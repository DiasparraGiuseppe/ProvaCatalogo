package com.example.provacatalogo.model;

public class Plate {
    public String img;
    public String nome;
    public String descrizione;

    public String getDescription() {
        return descrizione;
    }

    public void setDescription(String description) {
        this.descrizione = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
