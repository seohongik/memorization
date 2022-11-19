package com.example.restaurant.wishList.ifs;

import com.example.restaurant.wishList.dto.WishListDTO;
import com.example.restaurant.wishList.entity.WishListEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-19T14:38:33+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 1.8.0_292 (AdoptOpenJDK)"
)
@Component
public class ExenMapperImpl implements ExenMapper {

    @Override
    public WishListEntity toEntity(WishListDTO d) {
        if ( d == null ) {
            return null;
        }

        WishListEntity wishListEntity = new WishListEntity();

        wishListEntity.setIndex( d.getIndex() );
        wishListEntity.setTitle( d.getTitle() );
        wishListEntity.setCategory( d.getCategory() );
        wishListEntity.setAddress( d.getAddress() );
        wishListEntity.setRoadAddress( d.getRoadAddress() );
        wishListEntity.setHomePageLink( d.getHomePageLink() );
        wishListEntity.setImageLink( d.getImageLink() );
        wishListEntity.setVisit( d.isVisit() );
        wishListEntity.setVisitCount( d.getVisitCount() );
        wishListEntity.setLastVisitData( d.getLastVisitData() );

        return wishListEntity;
    }

    @Override
    public WishListDTO toDTO(WishListEntity e) {
        if ( e == null ) {
            return null;
        }

        WishListDTO wishListDTO = new WishListDTO();

        wishListDTO.setIndex( e.getIndex() );
        wishListDTO.setTitle( e.getTitle() );
        wishListDTO.setCategory( e.getCategory() );
        wishListDTO.setAddress( e.getAddress() );
        wishListDTO.setRoadAddress( e.getRoadAddress() );
        wishListDTO.setHomePageLink( e.getHomePageLink() );
        wishListDTO.setImageLink( e.getImageLink() );
        wishListDTO.setVisit( e.isVisit() );
        wishListDTO.setVisitCount( e.getVisitCount() );
        wishListDTO.setLastVisitData( e.getLastVisitData() );

        return wishListDTO;
    }

    @Override
    public void updateFromDto(WishListDTO dto, WishListEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setIndex( dto.getIndex() );
        if ( dto.getTitle() != null ) {
            entity.setTitle( dto.getTitle() );
        }
        if ( dto.getCategory() != null ) {
            entity.setCategory( dto.getCategory() );
        }
        if ( dto.getAddress() != null ) {
            entity.setAddress( dto.getAddress() );
        }
        if ( dto.getRoadAddress() != null ) {
            entity.setRoadAddress( dto.getRoadAddress() );
        }
        if ( dto.getHomePageLink() != null ) {
            entity.setHomePageLink( dto.getHomePageLink() );
        }
        if ( dto.getImageLink() != null ) {
            entity.setImageLink( dto.getImageLink() );
        }
        entity.setVisit( dto.isVisit() );
        entity.setVisitCount( dto.getVisitCount() );
        if ( dto.getLastVisitData() != null ) {
            entity.setLastVisitData( dto.getLastVisitData() );
        }
    }
}
