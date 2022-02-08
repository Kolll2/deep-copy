package com.kosh.domain;

import com.kosh.service.CustomCloneableInterface;

import java.util.List;

@CustomCloneableInterface
public class Book {
    private String name;
    private Integer totalPages;
    private List<String> sponsors;

    public Book(String name, Integer totalPages, List<String> sponsors) {
        this.name = name;
        this.totalPages = totalPages;
        this.sponsors = sponsors;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<String> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<String> sponsors) {
        this.sponsors = sponsors;
    }
}
