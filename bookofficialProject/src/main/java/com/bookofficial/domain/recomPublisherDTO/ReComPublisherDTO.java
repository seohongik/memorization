package com.bookofficial.domain.recomPublisherDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias(value ="ReComPublisherDTO")
@Accessors(chain = true)
public class ReComPublisherDTO {

    /*
    *   recom_publisher_id         INTEGER,
        recom_publisher_author     VARCHAR2(100),
        recom_publisher_title     VARCHAR2(100),
        recom_publisher_isbn       VARCHAR2(1000),
        recom_publisher_publish    VARCHAR2(1000),
        recom_publisher_imgUrl     VARCHAR(1000),
    *
    *
    * */

    private int recom_publisher_id;

    private String recom_publisher_author;

    private String recom_publisher_title;

    private String recom_publisher_isbn;

    private String recom_publisher_publish;

    private String recom_publisher_imgUrl;

}
