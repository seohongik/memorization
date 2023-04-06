package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
//@EntityListeners(value = MyEntityListener.class)
@EntityListeners(value = {AuditingEntityListener.class})
public class Book extends BaseEntity /*implements Auditable*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//아이디 자동으로 증가
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    @Column(name = "publisher_id", updatable = false, insertable = false)
    private Long publisherId;

    private String author;

    @OneToOne( mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

}
