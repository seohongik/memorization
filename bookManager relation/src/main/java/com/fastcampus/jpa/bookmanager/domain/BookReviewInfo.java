package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class BookReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long bookId;

    @OneToOne( optional = false)//
    // optional  반드시 존재한다(book) , mappedBy 해당키를 존재시키지 않는다.
    private Book book;

    private float averageReviewScore;

    private int reviewCount;

}
