package com.codecool;

import com.codecool.enums.BoxSize;
import com.codecool.model.Box;
import com.codecool.model.Letter;
import com.codecool.model.PostItem;
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
        PostItem box1 = new Box(BoxSize.Big, "address1", givenDate, 70);
        PostItem box2 = new Box(BoxSize.Small, "address2", LocalDate.of(2022, 11,27), 50);
        PostItem letter1 = new Letter("address3", LocalDate.of(2022, 11,23));
        PostItem letter2 = new Letter("address4",givenDate);
        uot.addItem(box1);
        uot.addItem(box2);
        uot.addItem(letter1);
        uot.addItem(letter2);

        List<PostItem> observe = uot.allTheThingsPostedOnAGivenDate(givenDate);
        List<PostItem> result = new ArrayList<>();
        result.add(box1);
        result.add(letter2);
        assertEquals(result, observe);
    }

    @Test
    public void calculateTotalIncomeTest(){
        Box box1 = new Box(BoxSize.Big, "address1", LocalDate.of(2022, 11,22), 70);
        Box box3 = new Box(BoxSize.Big, "address3", LocalDate.of(2022, 11,22), 70);
        Box box2 = new Box(BoxSize.Small, "address2", LocalDate.of(2022, 11,27), 50);
        Box box4 = new Box(BoxSize.Small, "address4", LocalDate.of(2022, 11,27), 50);
        Letter letter1 = new Letter("address3", LocalDate.of(2022, 11,23));
        Letter letter2 = new Letter("address4", LocalDate.of(2022, 11,22));
        uot.addItem(box1);
        uot.addItem(box3);
        uot.addItem(box2);
        uot.addItem(box4);
        uot.addItem(letter1);
        uot.addItem(letter2);
//        assertEquals(30.59, box1.price, 0.000000000000004);
        double totalIncome = uot.calculateTotalIncome(BoxSize.Big);
        assertEquals(61.18, totalIncome, 0.0000001);
    }

   //todo: @BeforeEach
    //todo: @AfterEach

}
