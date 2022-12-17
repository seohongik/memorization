package com.fastcampus.jpa.bookmanager.domain.listener;

import com.fastcampus.jpa.bookmanager.domain.Member;
import com.fastcampus.jpa.bookmanager.domain.MemberHistory;
import com.fastcampus.jpa.bookmanager.repository.MemberHistoryRepository;
import com.fastcampus.jpa.bookmanager.repository.MemberRepository;
import com.fastcampus.jpa.bookmanager.support.BeanUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityListeners;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

//@Component
public class MemberEntityListener  {

    /*
    //리스너틑 DI 안됨
    @Autowired
    private MemberHistoryRepository memberHistoryRepository;
*/
    /*@PrePersist
    public void prePersist(Object obj){

        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        if(obj instanceof Member) {
            Member member = (Member) obj;

            MemberHistory memberHistory = new MemberHistory();
            memberHistory.setMemberId(member.getId());
            memberHistory.setEmail(member.getName());
            memberHistory.setName(member.getName());

            memberHistoryRepository.save(memberHistory);
        }

    }*/

    @PrePersist
    @PreUpdate
    public void preMemberInsertAndUpdate(Object obj) {

        MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);

        if(obj instanceof Member) {
            Member member = (Member) obj;

            MemberHistory memberHistory = new MemberHistory();
            memberHistory.setMemberId(member.getId());
            memberHistory.setEmail(member.getName());
            memberHistory.setName(member.getName());

            memberHistoryRepository.save(memberHistory);
        }

    }

}
