package com.codecool.model;

import java.time.LocalDate;

public abstract class PostItem {

    public String address;
    public LocalDate postDate;


    public PostItem(String address, LocalDate postDate) {
        this.address = address;
        this.postDate = postDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public PostItem convertLetterToPostItem(Letter letter){
        return (PostItem) letter;
    }

}
