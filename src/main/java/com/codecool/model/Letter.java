package com.codecool.model;

import java.time.LocalDate;

public class Letter extends PostItems{
    public String address;
    public LocalDate postDate;
    public Double price;

    public Letter(String address, LocalDate postDate) {
        super(address, postDate);
        this.price = 1.99;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public LocalDate getPostDate() {
        return postDate;
    }

    @Override
    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Double getPrice() {
        return price;
    }


}
