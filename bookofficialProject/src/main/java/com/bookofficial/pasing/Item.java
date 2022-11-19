package com.bookofficial.pasing;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Getter
@Setter
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {


    @XmlElement(name = "title_info")
    private String title_info;


    @XmlElement(name = "type_name")
    private String type_name;

    @XmlElement(name = "author_info")
    private String author_info;


    @XmlElement(name = "pub_info")
    private String pub_info;


    @XmlElement(name = "pub_year_info")
    private String pub_year_info;


    @XmlElement(name = "isbn")
    private String isbn;






}
