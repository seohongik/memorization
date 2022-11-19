package test;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;


@Log4j
public class MybatisTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void name() {

        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection();) {

            log.info(session);
            log.info(con);

        } catch (Exception e) {
            e.getMessage();
        }
    }


}