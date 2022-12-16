package com.fastcampus.jpa.bookmanager.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "Member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Table(name = "member")
public class Member {

    /**
     *
     * drop table if exists member CASCADE;
     * create table member
     * (
     *     id bigint generated by default as identity,
     *     name varchar2(255),
     *     email varchar2(255),
     *     created_at date default now(),
     *     updated_at date default now(),
     *     primary key (id)
     * );
     *
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//아이디 자동으로 증가
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    //@Column(name = "crtdat") //말그대로 컬럼매핑 가독성을 위해 컬럼은 어노테이션으로 매핑하고 필드 변수는 따로 설정하는 경우가 있음
    //@Column(nullable = false)
    //@Column(unique = true)
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Transient // 디비에 반연하지 않고  셀렉트 업데이트 인서트 반영하지 안됨 //*객체에서 따로 쓰겠다 하는 것에 반영
    private String testData;

    @Enumerated(value = EnumType.STRING)     /***=> @Enumerated 의 default value 는 ordinary 즉 zero base 0 부터 시작 , 코드를 수정해야한다면 순서성 때문에 value = String **/
    private Gender gender;

    //@OneToMany(fetch = FetchType.EAGER)
    //private List<Address> addresses;



}
