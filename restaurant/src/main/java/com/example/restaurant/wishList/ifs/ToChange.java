package com.example.restaurant.wishList.ifs;

import com.example.restaurant.wishList.dto.WishListDTO;
import com.example.restaurant.wishList.entity.WishListEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface ToChange<D, E>  {

     E toEntity (D d);

     D toDTO (E e);

     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
     void updateFromDto(D dto, @MappingTarget E entity);
}
