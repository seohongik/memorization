package com.example.restaurant.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import com.example.restaurant.wishList.dto.WishListDTO;
import com.example.restaurant.wishList.entity.WishListEntity;
import com.example.restaurant.wishList.ifs.ExenMapper;
import com.example.restaurant.wishList.ifs.ToChange;
import com.example.restaurant.wishList.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class WishListService  {

    private final NaverClient naverClient;

    private final ExenMapper exenMapper;

    private final WishListRepository wishListRepository;

    public WishListDTO search(String query){

        SearchLocalReq searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);
        SearchLocalRes searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if(searchLocalRes.getTotal()>0){

            SearchLocalRes.SearchLocalItem localItem = searchLocalRes.getItems().stream().findFirst().get();
            String imageQuery = localItem.getTitle().replaceAll("<[^>]*>","");
            SearchImageReq searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);
            SearchImageRes searchimageRes = naverClient.searchImage(searchImageReq);

            if(searchimageRes.getTotal()>0){

                SearchImageRes.SearchImageItem imageItem = searchimageRes.getItems().stream().findFirst().get();
                WishListDTO resultDTO = new WishListDTO();

                resultDTO.setTitle(localItem.getTitle());
                resultDTO.setCategory(localItem.getCategory());
                resultDTO.setAddress(localItem.getAddress());
                resultDTO.setRoadAddress(localItem.getRoadAddress());
                resultDTO.setHomePageLink(localItem.getLink());
                resultDTO.setImageLink(imageItem.getLink());

                return resultDTO;
            }
        }

        return new WishListDTO();

    }


    public WishListDTO add(WishListDTO wishListDTO){

        WishListEntity wishListEntity = exenMapper.toEntity(wishListDTO);

        log.info("entity::{}", exenMapper.toDTO(wishListRepository.save(wishListEntity)));

       return  exenMapper.toDTO(wishListRepository.save(wishListEntity));

    }

    public List<WishListDTO> findAll(){

        return wishListRepository.listAll().stream().map(it->exenMapper.toDTO(it)).collect(Collectors.toList());
    }


    public void delete(int index) {

        wishListRepository.deleteById(index);
    }
    
    public  void addVisit(int index){

        Optional<WishListEntity> wishItem = wishListRepository.findById(index);

        if(wishItem.isPresent()){

            WishListEntity item = wishItem.get();
            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
            
        }
    }
}
