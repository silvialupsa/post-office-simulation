package com.codecool;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostOfficeTest {
    private PostOffice uot = new PostOffice();
    @Test
    public void allTheThingsPostedOnAGivenDateTest(){
        LocalDate givenDate = LocalDate.of(2022, 11,22);
        PostItems box1 = new Box(BoxSizes.Big, "address1", givenDate, 70);
        PostItems box2 = new Box(BoxSizes.Small, "address2", LocalDate.of(2022, 11,27), 50);
        PostItems letter1 = new Letter("address3", LocalDate.of(2022, 11,23));
        PostItems letter2 = new Letter("address4",givenDate);
        uot.addItem(box1);
        uot.addItem(box2);
        uot.addItem(letter1);
        uot.addItem(letter2);

        List<PostItems> observe = uot.allTheThingsPostedOnAGivenDate(givenDate);
        List<PostItems> result = new ArrayList<>();
        result.add(box1);
        result.add(letter2);
        assertEquals(result, observe);
    }

    @Test
    public void calculateTotalIncomeTest(){
        Box box1 = new Box(BoxSizes.Big, "address1", LocalDate.of(2022, 11,22), 70);
        Box box3 = new Box(BoxSizes.Big, "address3", LocalDate.of(2022, 11,22), 70);
        Box box2 = new Box(BoxSizes.Small, "address2", LocalDate.of(2022, 11,27), 50);
        Box box4 = new Box(BoxSizes.Small, "address4", LocalDate.of(2022, 11,27), 50);
        Letter letter1 = new Letter("address3", LocalDate.of(2022, 11,23));
        Letter letter2 = new Letter("address4", LocalDate.of(2022, 11,22));
        uot.addItem(box1);
        uot.addItem(box3);
        uot.addItem(box2);
        uot.addItem(box4);
        uot.addItem(letter1);
        uot.addItem(letter2);
//        assertEquals(30.59, box1.price, 0.1);
        Double totalIncome = uot.calculateTotalIncome(box1);
        System.out.println(totalIncome);
    }

}
