package com.kosh;

import com.kosh.domain.Book;
import com.kosh.domain.Man;
import com.kosh.domain.Woman;
import com.kosh.service.Cloner;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("AAAAA");

        Man man = new Man("Max", 50, array);

        Cloner cloner = new Cloner();

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("caption", 100, array));

        Woman woman = new Woman("Joan", 20, array, books);


        Object clone = null;
        Object clone2 = null;
        try {
            clone = cloner.clone(man);
            clone2 = cloner.clone(woman);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(clone);
    }


}
