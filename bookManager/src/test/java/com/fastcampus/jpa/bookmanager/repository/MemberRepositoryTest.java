package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Member;
import org.assertj.core.util.Lists;
import org.hibernate.annotations.Loader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.*;

import javax.persistence.PostLoad;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void crud(){

        //memberRepository.save(new Member());
        //memberRepository.findAll().stream().forEach(System.out::println);

        //List<Member> members =memberRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        //members.forEach(System.out::println);

        /*List<Long> ids = new ArrayList<>(Arrays.asList(1l,2l,3l,4l,5l));
        List<Member> members =memberRepository.findAllById(ids);
        members.forEach(System.out::println);*/

        /*List<Member> members =memberRepository.findAllById(Lists.newArrayList(1l,3l,5l));
        members.forEach(System.out::println);
        */

       /* Member member1 = new Member("jack","jack@fastcampus.com");
        Member member2 = new Member("steve","steve@fastcampus.com");

        memberRepository.saveAll(Lists.newArrayList(member1,member2));
        List<Member> members =memberRepository.findAll();
        members.forEach(System.out::println);*/

    }

    @Test
    @Transactional
    public void getOne(){

        //getone은 lazy패치 이며 	@Deprecated 되었다. @Transactional을 붙여야 동작
        Member member = memberRepository.getOne(1l);
        System.out.println(member);
    }

    @Test
    public void getById(){

        Member member = memberRepository.findById(1l).orElse(null);
        System.out.println(member);
    }

    @Test
    public void flush(){
        //flush는 쿼리에 반영이 아니라 DB반영시점과 관련이 있다
       memberRepository.save(new Member("newMartin", "newMartin@fastcampus.com"));
       memberRepository.flush();
       memberRepository.findAll().forEach(System.out::println);

    }

    @Test
    public void count(){
        //count도 existsById도 카운트 쿼리를 사용한다.
        long count=memberRepository.count();
        System.out.println(count);

        boolean exists = memberRepository.existsById(1l);
        System.out.println(exists);
    }

    @Test
    public void delete(){

        memberRepository.delete(memberRepository.findById(1l).orElseThrow(RuntimeException::new));

        memberRepository.deleteById(2l);

        memberRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void deleteAll(){

       //memberRepository.deleteAll(); //전체 삭제 //포루프 돌면서 하나씩 삭제
        memberRepository.deleteAll(memberRepository.findAllById(Lists.newArrayList(1L,3L))); // 아이디 찾아서 삭제
        memberRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void deleteInBatch(){

        memberRepository.deleteAllInBatch(); //전체 삭제 // where 조건 없음
        //memberRepository.deleteInBatch(memberRepository.findAllById(Lists.newArrayList(1L,3L))); // 아이디 찾아서 삭제
        memberRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void paging(){

        Page<Member> memberPage = memberRepository.findAll(PageRequest.of(0,3)); //page는 zerobase = 0이 실질상 1페이지

        System.out.println("page::"+memberPage);
        System.out.println("totalElements::"+memberPage.getTotalElements());
        System.out.println("totalPages::"+memberPage.getTotalPages());
        System.out.println("numberOfElements::"+memberPage.getNumberOfElements());
        System.out.println("sort::"+memberPage.getSort());
        System.out.println("size ::"+memberPage.getSize());

        memberPage.getContent().forEach(System.out::println);
    }

    @Test
    public void queryByExample(){

        Member member = new Member();
        member.setEmail("slowcampus");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("email",contains());
        Example<Member> exampleMatcher = Example.of(member, matcher);

        memberRepository.findAll(exampleMatcher).forEach(System.out::println);

    }
}