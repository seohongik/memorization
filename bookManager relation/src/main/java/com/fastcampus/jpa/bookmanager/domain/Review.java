package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Review extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", updatable = false, insertable = false)
    private Long memberId;

    private String title;

    private String content;

    private float score;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;

}
