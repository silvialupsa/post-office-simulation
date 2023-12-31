package com.codecool.model;

import com.codecool.enums.BoxSize;

import java.time.LocalDate;

public class Box extends PostItem {
    public BoxSize boxSize;
    public String address;
    public LocalDate postDate;
    public int weight;
    public Double price;

    public Box(BoxSize boxSize, String address, LocalDate postDate, int weight) {
        super(address, postDate);
        this.boxSize = boxSize;
        this.weight = weight;
        this.price = calculatePrice();
    }

    public BoxSize getBoxSizes() {
        return boxSize;
    }

    public void setBoxSizes(BoxSize boxSize) {
        this.boxSize = boxSize;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public double calculatePrice() {
        if(boxSize.equals(BoxSize.Small)){
            return 7.99;
        } else if(boxSize.equals(BoxSize.Big)){
            return 10.29+0.29*weight;
        }
        return 0.0;
    }


}
