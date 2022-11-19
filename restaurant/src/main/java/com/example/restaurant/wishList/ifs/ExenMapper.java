package com.example.restaurant.wishList.ifs;

import com.example.restaurant.wishList.dto.WishListDTO;
import com.example.restaurant.wishList.entity.WishListEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExenMapper extends ToChange<WishListDTO, WishListEntity> {

}
