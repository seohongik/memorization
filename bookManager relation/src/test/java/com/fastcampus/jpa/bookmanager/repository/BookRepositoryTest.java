package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.Member;
import com.fastcampus.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private  ReviewRepository reviewRepository;

    @Autowired
    private  MemberRepository memberRepository;

    @Test
    void bookTest(){

        Book book = new Book();
        book.setName("jpa 초격차 패키지");
        book.setAuthor("패스트캠퍼스");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

    @Test
    void bookRelationTest(){

        System.err.println("Review :::::::"+ givenBookAndReview().getReviewList());
        System.err.println("Book :::::::"+ givenBookAndReview().getReviewList().get(0).getBook());
        System.err.println("Publisher :::::::" +givenBookAndReview().getReviewList().get(0).getBook().getPublisher());


    }

    private Member givenBookAndReview(){

        givenReview(givenMember(), givenBook());


        return givenMember();
    }

    private Member givenMember(){

        return memberRepository.findByEmail("martine@fastcampus.com");
    }

    private Book givenBook(){

        Book book = new Book();

        book.setName("jpa");

        Publisher publisher = new Publisher();
        publisher.setName("패캠");
        book.setPublisher(publisherRepository.save(publisher));

        return bookRepository.save(book);
    }

    private  Review givenReview(Member member , Book book){
        Review review = new Review();

        review.setTitle("내 인생을 바꾼 책");
        review.setContent("아구국 i good");
        review.setScore(5.0f);
        review.setMember(member);
        review.setBook(book);

        return reviewRepository.save(review);
    }
}
