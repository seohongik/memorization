package com.example.restaurant.controller;

import com.example.restaurant.service.WishListService;
import com.example.restaurant.wishList.dto.WishListDTO;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
@Slf4j
public class ApiController {

    private final WishListService wishListService;


    @GetMapping("/search")
    public WishListDTO search(@RequestParam String query){

        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDTO add(@RequestBody WishListDTO wishListDTO){

      log.info("{}",wishListDTO);

      return  wishListService.add(wishListDTO);

    }

    @GetMapping("/all")
    public List<WishListDTO> findAll(){

        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){

        wishListService.delete(index);
    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){

        wishListService.addVisit(index);
    }
}
