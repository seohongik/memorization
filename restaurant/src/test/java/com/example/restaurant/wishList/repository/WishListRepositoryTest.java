package com.example.restaurant.wishList.repository;

import com.example.restaurant.wishList.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){

        WishListEntity wishList = new WishListEntity();
        wishList.setTitle("Title");
        wishList.setCategory("Category");
        wishList.setAddress("Address");
        wishList.setRoadAddress("RoadAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitData(null);

        return wishList;
    }


    @Test
    public void saveTest(){

        WishListEntity wishListEntity = create();
        WishListEntity result = wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1,result.getIndex());


    }


    @Test
    public void updateTest(){

        WishListEntity wishListEntity = create();
        WishListEntity result = wishListRepository.save(wishListEntity);

        result.setTitle("update test");

        WishListEntity saveEntity = wishListRepository.save(result);
        Assertions.assertEquals("update test", saveEntity.getTitle());
        Assertions.assertEquals(1,wishListRepository.listAll().size());

    }



    @Test
    public void findByIdTest(){

        WishListEntity wishListEntity = create();
        wishListRepository.save(wishListEntity);

        Optional<WishListEntity> result = wishListRepository.findById(1);

        Assertions.assertEquals(true,result.isPresent());
        Assertions.assertEquals(1,result.get().getIndex());


    }

    @Test
    public void deleteTest(){

        WishListEntity wishListEntity = create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);
        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(0,count);

    }

    @Test
    public void findAllTest(){

        WishListEntity wishListEntity1 = create();
        wishListRepository.save(wishListEntity1);

        WishListEntity wishListEntity2 = create();
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(2,count);

    }
}
