package com.fastcampus.jpa.bookmanager.domain;


import com.fastcampus.jpa.bookmanager.domain.listener.MemberEntityListener;
import com.fastcampus.jpa.bookmanager.domain.listener.MyEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {MemberEntityListener.class,MyEntityListener.class})
public class MemberHistory extends BaseEntity/*implements Auditable */{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//아이디 자동으로 증가
    private Long id;

    @Column(name = "member_id", updatable = false, insertable = false)
    private Long memberId;

    private String name;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @ToString.Exclude
    private Member member;

}
