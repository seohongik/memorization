package com.bookofficial.domain.reportDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Alias(value ="ReportDTO")
public class ReportDTO {

    /*
    report_id      INTEGER,
    report_subject VARCHAR2(100)   NOT NULL,
    report_content VARCHAR2(1000)  NOT NULL,
    report_comment VARCHAR2(200)   NOT NULL,

    */

    int report_id;

    String report_subject;

    String report_content;

    String report_comment;

    String hashTage;


}
