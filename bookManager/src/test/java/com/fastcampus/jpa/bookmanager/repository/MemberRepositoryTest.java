package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.Member;
import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void crud() {

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
    public void getOne() {

        //getone은 lazy패치 이며 	@Deprecated 되었다. @Transactional을 붙여야 동작
        Member member = memberRepository.getOne(1l);
        System.out.println(member);
    }

    @Test
    public void getById() {

        Member member = memberRepository.findById(1l).orElse(null);
        System.out.println(member);
    }

    @Test
    public void flush() {
        //flush는 쿼리에 반영이 아니라 DB반영시점과 관련이 있다
        memberRepository.save(new Member("newMartin", "newMartin@fastcampus.com"));
        memberRepository.flush();
        memberRepository.findAll().forEach(System.out::println);

    }

    @Test
    public void count() {
        //count도 existsById도 카운트 쿼리를 사용한다.
        long count = memberRepository.count();
        System.out.println(count);

        boolean exists = memberRepository.existsById(1l);
        System.out.println(exists);
    }

    @Test
    public void delete() {

        memberRepository.delete(memberRepository.findById(1l).orElseThrow(RuntimeException::new));

        memberRepository.deleteById(2l);

        memberRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void deleteAll() {

        //memberRepository.deleteAll(); //전체 삭제 //포루프 돌면서 하나씩 삭제
        memberRepository.deleteAll(memberRepository.findAllById(Lists.newArrayList(1L, 3L))); // 아이디 찾아서 삭제
        memberRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void deleteInBatch() {

        memberRepository.deleteAllInBatch(); //전체 삭제 // where 조건 없음
        //memberRepository.deleteInBatch(memberRepository.findAllById(Lists.newArrayList(1L,3L))); // 아이디 찾아서 삭제
        memberRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void paging() {

        Page<Member> memberPage = memberRepository.findAll(PageRequest.of(0, 3)); //page는 zerobase = 0이 실질상 1페이지

        System.out.println("page::" + memberPage);
        System.out.println("totalElements::" + memberPage.getTotalElements());
        System.out.println("totalPages::" + memberPage.getTotalPages());
        System.out.println("numberOfElements::" + memberPage.getNumberOfElements());
        System.out.println("sort::" + memberPage.getSort());
        System.out.println("size ::" + memberPage.getSize());

        memberPage.getContent().forEach(System.out::println);
    }

    @Test
    public void queryByExample() {

        Member member = new Member();
        member.setEmail("slowcampus");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("email", contains());
        Example<Member> exampleMatcher = Example.of(member, matcher);

        memberRepository.findAll(exampleMatcher).forEach(System.out::println);

    }

    @Test
    public void select() {

        //System.out.println("findByName::::::"+memberRepository.findByName("martine"));

        /*System.out.println("findByEmail::::::"+memberRepository.findByEmail("martine@fastcampus.com"));
        System.out.println("getByEmail::::::"+memberRepository.getByEmail("martine@fastcampus.com"));
        System.out.println("getByEmail::::::"+memberRepository.searchByEmail("martine@fastcampus.com"));
        System.out.println("readByEmail::::::"+memberRepository.readByEmail("martine@fastcampus.com"));
        System.out.println("streamByEmail::::::"+memberRepository.streamByEmail("martine@fastcampus.com"));
        System.out.println("queryByEmail::::::"+memberRepository.queryByEmail("martine@fastcampus.com"));
        System.out.println("findMemberByEmail::::::"+memberRepository.findMemberByEmail("martine@fastcampus.com"));
        */

        /*System.out.println("findFirst1ByName::::::"+memberRepository.findFirst1ByName("martine"));
        System.out.println("findTop1ByName::::::"+memberRepository.findTop1ByName("martine"));

        //2개 리턴 리미트 조건 빠짐 인식하지 않는 메소드는 무시하게 된다.
        System.out.println("findLast1ByName::::::"+memberRepository.findLast1ByName("martine"));*/

        /*System.out.println("findByEmailAndName::::::"+memberRepository.findByEmailAndName("martine@fastcampus.com", "martine"));
        System.out.println("findByEmailOrName::::::"+memberRepository.findByEmailOrName("martine@fastcampus.com", "martine"));
        */

        //System.out.println("findByCreatedAtAfter::::::"+memberRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        //System.out.println("findByIdAfter::::::"+memberRepository.findByIdAfter(4L));
        /*System.out.println("findByCreatedAtGreaterThan::::::"+memberRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual::::::"+memberRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        */

        /*System.out.println("findByCreatedAtBetween::::::"+
                memberRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L),LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween::::::"+memberRepository.findByIdBetween(2L,5L));
      */

        //System.out.println("findByIdIsNotNull::::::"+memberRepository.findByIdIsNotNull());

        /**문자열의 not empty 가아니라 컬렉션의 not empty를 말함 문자열 아님에 주의*/
        //System.out.println("findByAddressesIsNotEmpty::::::"+memberRepository.findByAddressesIsNotEmpty());


        //System.out.println("findByNameIn::::::"+memberRepository.findByNameIn(Lists.newArrayList("martine", "sophia")));


       /* System.out.println("findByNameStartingWith::::::"+memberRepository.findByNameStartingWith("ma"));
        System.out.println("findByNameEndingWith::::::"+memberRepository.findByNameEndingWith("pia"));
        System.out.println("findByNameContaining::::::"+memberRepository.findByNameContaining("ma"));
        System.out.println("findByNameLike::::::"+memberRepository.findByNameLike("%"+"ma"+"%"));*/

    }

    @Test
    void pagingAndSorting() {

       /* System.out.println("findTop1ByName::::::" + memberRepository.findTop1ByName("martine"));
        System.out.println("findLast1ByName::::::" + memberRepository.findLast1ByName("martine"));
        System.out.println("findTop1ByNameOrderByIdDesc::::::" + memberRepository.findTop1ByNameOrderByIdDesc("martine"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc::::::" + memberRepository.findFirstByNameOrderByIdDescEmailAsc("martine"));
        System.out.println("findFirstByNameWithSortParam::::::" + memberRepository.findFirstByName("martine", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        */

        //page 디폴트 0 => 첫번째 인자 시작은 0
       /* System.out.println("findByNameWithPage::::::" + memberRepository.findByName("martine", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
        System.out.println("findByNameWithPage::::::" + memberRepository.findByName("martine", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getContent());
       */
    }

    @Test
    void insertAndUpdate(){

        /*Member member = new Member();

        member.setName("martine");
        member.setEmail("martine2@fastcampus.com");

        memberRepository.save(member);
        Member member2 =memberRepository.findById(1L).orElseThrow(RuntimeException::new);

        member2.setName("marrrrrrrrrrrtine");
        memberRepository.save(member2);*/
    }

    @Test
    void enumTest(){

        /*Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setGender(Gender.FEMALE);
        memberRepository.save(member);
        memberRepository.findAll().forEach(System.out::println);
        System.out.println(memberRepository.findRowRecord().get("gender")); // 결과 0*/


        /*Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setGender(Gender.FEMALE);
        memberRepository.save(member);
        memberRepository.findAll().forEach(System.out::println);
        System.out.println(memberRepository.findRowRecord().get("gender")); // 결과 1*/

        /***=> @Enumerated 의 default value 는 ordinary 즉 zero base 0 부터 시작 , 코드를 수정해야한다면 순서성 때문에 value = String **/

        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setGender(Gender.FEMALE);
        memberRepository.save(member);
        memberRepository.findAll().forEach(System.out::println);
        System.out.println(memberRepository.findRowRecord().get("gender"));


    }
}