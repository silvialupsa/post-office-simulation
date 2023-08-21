package com.codecool;

import com.codecool.enums.BoxSize;
import com.codecool.model.Box;
import com.codecool.model.Letter;
import com.codecool.model.PostItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostOffice {

    List<PostItem> postItemsList = new ArrayList<>();

    public void addItem(PostItem postItem) {
        postItemsList.add(postItem);
    }

    public List<PostItem> getPostItemsList() {
        return postItemsList;
    }

    public List<PostItem> allTheThingsPostedOnAGivenDate(LocalDate givenDate){
        return postItemsList.stream()
                .filter(el -> el.postDate.equals(givenDate))
                .toList();
    }

    public double calculateTotalIncome(BoxSize boxSize){
        if(boxSize != null){
            return postItemsList.stream()
                    .filter(el -> el instanceof Box && ((Box) el).boxSize.equals(boxSize))
                    .mapToDouble(i -> ((Box) i).price)
                    .sum();
        }
        return postItemsList.stream()
                .filter(el->el instanceof Letter)
                .mapToDouble(i -> ((Letter) i)
                        .price)
                .sum();
    }

}
