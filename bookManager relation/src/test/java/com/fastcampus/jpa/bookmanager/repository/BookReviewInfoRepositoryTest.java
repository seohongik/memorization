package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    void  crudTest(){

        BookReviewInfo bookReviewInfo = new BookReviewInfo();

        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(bookReviewInfoRepository.findAll());

    }

    /*
    @Test
    void  crudTest2(){

        Book book = new Book();
        book.setName("jpa 패키지");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);

        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);


      Book result=bookRepository.findById(
              bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new)
                      .getBookId()
      ).orElseThrow(RuntimeException::new);


        System.out.println("result :::::=>" +result);


    }*/


    @Test
    void oneToOneTest(){

        Book book = new Book();
        book.setId(1L);
        book.setName("jpa 패키지");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);

        BookReviewInfo bookReviewInfo = new BookReviewInfo();

        bookReviewInfo.setBook(bookRepository.findById(1L).orElseThrow(RuntimeException::new));

        bookReviewInfoRepository.save(bookReviewInfo);

        Book result=bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBook();

        System.out.println("result :::::=>" +result);

    }

}
