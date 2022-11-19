package com.example.restaurant.wishList.entity;

import com.example.restaurant.db.MemoryDBEntity;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListEntity extends MemoryDBEntity {

    protected int index;
    private String title; //음식명 장소명
    private String category; //카테고리
    private String address; //주소
    private String roadAddress; //도로명
    private String homePageLink; //홈페이지 링크
    private String imageLink; //이미지 링크
    private boolean isVisit; //방문 여부
    private int visitCount; //방문 횟수
    private LocalDateTime lastVisitData; //마지막 방문일자

}
