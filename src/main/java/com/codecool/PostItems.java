package com.codecool;

import java.time.LocalDate;

public abstract class PostItems {

    public String address;
    public LocalDate postDate;


    public PostItems(String address, LocalDate postDate) {
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

    public PostItems convertLetterToPostItem(Letter letter){
        return (PostItems) letter;
    }

}
