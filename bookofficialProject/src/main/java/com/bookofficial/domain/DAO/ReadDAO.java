package com.bookofficial.domain.DAO;

import com.bookofficial.domain.readDTO.ReadDTO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class ReadDAO  {

    @Autowired
    private  SqlSessionTemplate  sqlSession;


    public void readList(ReadDTO readDTO){


        sqlSession.insert("readListInsert",readDTO);


    }



}
