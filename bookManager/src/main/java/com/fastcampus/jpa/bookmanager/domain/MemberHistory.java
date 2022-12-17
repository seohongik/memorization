package com.fastcampus.jpa.bookmanager.domain;


import com.fastcampus.jpa.bookmanager.domain.listener.MemberEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
//@EntityListeners(value = {MyEntityListener.class,MemberEntityListener.class})
@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
public class MemberHistory extends BaseEntity/*implements Auditable */{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//아이디 자동으로 증가
    private long id;

    private long memberId;

    private String name;

    private String email;

  /*  @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;*/

}
