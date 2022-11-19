package com.bookofficial.domain.readDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

@Alias(value = "ReadDTO")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ReadDTO {

/*
*
*   read_id         INTEGER,
    read_author     VARCHAR2(100),
    read_tittle     VARCHAR2(100),
    read_isbn       VARCHAR2(1000),
    read_publish    VARCHAR2(1000),
    read_imgUrl     VARCHAR(1000),
*
* */


    private int read_id;

    private String read_author;

    private String read_title;

    private String read_isbn;

    private String read_publish;

    private String read_imgUrl;





}
