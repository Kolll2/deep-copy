package com.kosh.domain;

import com.kosh.service.CustomCloneableInterface;

import java.util.List;

@CustomCloneableInterface
public class Woman {
    private String name;
    private int age;
    private List<String> favoriteBooks;
    private List<Book> reading;

    public Woman(String name, int age, List<String> favoriteBooks, List<Book> reading) {
        this.name = name;
        this.age = age;
        this.favoriteBooks = favoriteBooks;
        this.reading = reading;
    }

    public Woman() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(List<String> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public List<Book> getReading() {
        return reading;
    }

    public void setReading(List<Book> reading) {
        this.reading = reading;
    }
}
