package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Member;
import com.fastcampus.jpa.bookmanager.domain.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory,Long> {

    //List<MemberHistory> findByMemberId(long id);


}
