package com.bookofficial.domain.recomAuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias(value ="ReComAuthorDTO")
@Accessors(chain = true)
public class ReComAuthorDTO {

    /*
    *   recom_author_id         INTEGER,
        recom_author_author     VARCHAR2(100),
        recom_author_title     VARCHAR2(100),
        recom_author_isbn       VARCHAR2(1000),
        recom_author_publish    VARCHAR2(1000),
        recom_author_imgUrl     VARCHAR(1000),
    *
    *
    * */

    private int recom_author_id;

    private String recom_author_author;

    private String recom_author_title;

    private String recom_author_isbn;

    private String recom_author_publish;

    private String recom_author_imgUrl;

}
