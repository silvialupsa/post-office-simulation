package com.codecool;

import com.codecool.enums.BoxSizes;
import com.codecool.model.Box;
import com.codecool.model.Letter;
import com.codecool.model.PostItems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostOffice {

    List<PostItems> postItemsList = new ArrayList<>();

    public void addItem(PostItems postItem) {
        postItemsList.add(postItem);
    }

    public List<PostItems> getPostItemsList() {
        return postItemsList;
    }

    public List<PostItems> allTheThingsPostedOnAGivenDate(LocalDate givenDate){
        return postItemsList.stream().filter(el -> el.postDate.equals(givenDate)).toList();
    }

    public double calculateTotalIncome(PostItems postItem){
        if(postItem instanceof Box){
            if(((Box) postItem).boxSize.equals(BoxSizes.Small)){
                System.out.println("this is a small box"+postItem);
                return postItemsList.stream().filter(el->el instanceof Box && ((Box) el).boxSize.equals(BoxSizes.Small)).mapToDouble(i -> ((Box) i).price).sum();
            }else if(((Box) postItem).boxSize.equals(BoxSizes.Big)){
                System.out.println("this is a big box"+postItem);
                return postItemsList.stream().filter(el->el instanceof Box && ((Box) el).boxSize.equals(BoxSizes.Big)).mapToDouble(i -> ((Box) i).price).sum();
            }
        } else if(postItem instanceof Letter){
            System.out.println("this is a letter"+postItem);
            return postItemsList.stream().filter(el->el instanceof Letter).mapToDouble(i -> ((Letter) i).price).sum();
        }
        return 0.0;
    }

    //todo: de intrebat pe Tavi
    public double calculateTotalIncomeBoxes(BoxSizes boxSize){
        return postItemsList.stream().filter(el->el instanceof Box && ((Box) el).boxSize.equals(boxSize)).mapToDouble(i -> ((Box) i).price).sum();
    }

    public double calculateTotalIncomeLetters(){
        return postItemsList.stream().filter(el->el instanceof Letter).mapToDouble(i -> ((Letter) i).price).sum();
    }

}
