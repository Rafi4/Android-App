package com.example.swipe2;

public class Book {
    private String title;
    private String author;
    private int image;


    public Book(String title, String author, int image) {
        this.title = title;
        this.author = author;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getImage() {
        return image;
    }

}
