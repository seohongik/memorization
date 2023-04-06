package com.fastcampus.jpa.bookmanager.domain;


import com.fastcampus.jpa.bookmanager.domain.listener.MemberEntityListener;
import com.fastcampus.jpa.bookmanager.domain.listener.MyEntityListener;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.LazyLoader;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {MemberEntityListener.class,MyEntityListener.class})
public class Member extends BaseEntity/* implements Auditable*/{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<MemberHistory> memberHistories = new ArrayList<>();


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", updatable = false, insertable = false)
    @ToString.Exclude
    private List<Review> reviewList = new ArrayList<>();


}
