package com.bookofficial.domain.DAO;

import com.bookofficial.domain.reportDTO.ReportDTO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class ReportDAO  {


    @Autowired
    private  SqlSessionTemplate  sqlSession;


    public void reportInsert(ReportDTO reportDTO) {


        sqlSession.insert("reportInsert",reportDTO);
    }



}
