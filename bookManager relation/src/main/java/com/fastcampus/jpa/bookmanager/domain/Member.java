package com.fastcampus.jpa.bookmanager.domain;


import com.fastcampus.jpa.bookmanager.domain.listener.MemberEntityListener;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "Member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Table(name = "member")
@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode
//@EntityListeners(value = {MyEntityListener.class,MemberEntityListener.class})
@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
public class Member extends BaseEntity/* implements Auditable*/{

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//아이디 자동으로 증가
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    //@Column(name = "crtdat") //말그대로 컬럼매핑 가독성을 위해 컬럼은 어노테이션으로 매핑하고 필드 변수는 따로 설정하는 경우가 있음
    //@Column(nullable = false)
    //@Column(unique = true)
    //@Column(updatable = false)
    /*private LocalDateTime createdAt;
    //@Column(insertable = false)
    private LocalDateTime updatedAt;*/

   /* @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate //==>@EnableJpaAuditing @EntityListeners(value = {AuditingEntityListener.class})
    private LocalDateTime updatedAt;*/

    @Transient // 디비에 반연하지 않고  셀렉트 업데이트 인서트 반영하지 안됨 //*객체에서 따로 쓰겠다 하는 것에 반영
    private String testData;

    @Enumerated(value = EnumType.STRING)     /***=> @Enumerated 의 default value 는 ordinary 즉 zero base 0 부터 시작 , 코드를 수정해야한다면 순서성 때문에 value = String **/
    private Gender gender;

    //@OneToMany(fetch = FetchType.EAGER)
    //private List<Address> addresses;

    //리스너 이벤트 관찰하다가 이벤트가 발생하면 동작

  /*@PrePersist
    @PreUpdate
    @PreRemove
    @PostPersist
    @PostUpdate
    @PostRemove
    @PostLoad*/

    /*@PrePersist
    public  void prePersist(){

        this.createdAt = LocalDateTime.now();
        log.error(">>>>> @PrePersist ");
    }*/

/*    @PostPersist
    public  void PostPersist(){

        log.error(">>>>> @PostPersist ");
    }*/

   /* @PreUpdate
    public  void PreUpdate(){
        this.updatedAt = LocalDateTime.now();
        log.error(">>>>> @PreUpdate ");
    }*/

    /*@PostUpdate
    public  void PostUpdate(){

        log.error(">>>>> @PostUpdate ");
    }*/

  /*  @PreRemove
    public  void PreRemove(){

        log.error(">>>>> @PreRemove ");
    }*/

    /*@PostRemove
    public  void PostRemove(){

        log.error(">>>>> @PostRemove ");
    }*/

   /* @PostLoad
    public  void PostLoad(){

        log.error(">>>>> @PostLoad ");
    }*/

}
