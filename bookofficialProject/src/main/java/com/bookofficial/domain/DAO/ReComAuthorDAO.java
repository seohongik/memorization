package com.bookofficial.domain.DAO;

import com.bookofficial.domain.recomAuthorDTO.ReComAuthorDTO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ReComAuthorDAO {

    @Autowired
    private  SqlSessionTemplate  sqlSession;


    public  void reComAuthorInsert(ReComAuthorDTO reComAuthorDTO){



        sqlSession.insert("reComAuthorInsert",reComAuthorDTO);
    }


}
