package com.example.restaurant.wishList.service;

import com.example.restaurant.service.WishListService;
import com.example.restaurant.wishList.dto.WishListDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){

        WishListDTO result = wishListService.search("갈비집");
        System.out.println(result);
        Assertions.assertNotNull(result);


    }
}
