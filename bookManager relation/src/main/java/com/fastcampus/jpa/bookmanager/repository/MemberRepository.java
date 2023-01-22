package com.fastcampus.jpa.bookmanager.repository;
import com.fastcampus.jpa.bookmanager.domain.Address;
import com.fastcampus.jpa.bookmanager.domain.Member;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface MemberRepository extends JpaRepository<Member,Long> {

    Set<Member> findByName(String name);

    Set<Member> findUserByNameIs(String name);
    Set<Member> findByNameIs(String name);
    Set<Member> findUserByNameEquals(String name);


    Member findByEmail(String email);
    Member getByEmail(String email);
    Member readByEmail(String email);
    Member searchByEmail(String email);
    Member streamByEmail(String email);
    Member findMemberByEmail(String email);
    Member queryByEmail(String email);

    List<Member> findFirst1ByName(String name);
    List<Member> findTop1ByName(String name);
    List<Member> findLast1ByName(String name);

    List<Member> findByEmailAndName(String email, String name);
    List<Member> findByEmailOrName(String email, String name);
    List<Member> findByCreatedAtAfter(LocalDateTime yesterday);
    List<Member> findByIdAfter(Long id); // 숫자도 사용가능하지만 가독성을 위해 날짜 데이터만 사용하는게 좋음


    List<Member> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<Member> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<Member> findByCreatedAtBetween(LocalDateTime yesterday,LocalDateTime tomorrow );
    List<Member> findByIdBetween(Long id1,Long id2 );

    List<Member> findByIdIsNotNull( );

    //List<Member> findByAddressesIsNotEmpty( );  /**문자열의 not empty 가아니라 컬렉션의 not empty를 말함 문자열 아님에 주의*/

    List<Member> findByNameIn(List<String> names);

    //문자열에서 동작 like 검색어

    List<Member> findByNameStartingWith(String name);
    List<Member> findByNameEndingWith(String name);
    List<Member> findByNameContaining(String name);
    List<Member> findByNameLike(String name);


    List<Member> findTop1ByNameOrderByIdDesc(String name);

    List<Member> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<Member> findFirstByName(String name, Sort sort);

    Page<Member> findByName(String name, Pageable pageable);

    @Query(value = "select * from member limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();


}
