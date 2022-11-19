package com.bookofficial.controller;


import com.bookofficial.domain.DAO.*;
import com.bookofficial.domain.readDTO.ReadDTO;
import com.bookofficial.domain.recomAuthorDTO.ReComAuthorDTO;
import com.bookofficial.domain.recomPublisherDTO.ReComPublisherDTO;
import com.bookofficial.domain.reportDTO.ReportDTO;
import com.bookofficial.pasing.Root;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/result")
public class TestController {


    @Autowired
    private ReportDAO reportDAO;


    @Autowired
    private ReadDAO readDAO;


    @Autowired
    private ReComAuthorDAO reComAuthorDAO;


    @Autowired
    private ReComPublisherDAO reComPublisherDAO;




    @ResponseBody
    @GetMapping( "/GetCentralLibraryData" )
    public Map<String,Object> GetCentralLibraryData(@RequestParam(defaultValue = "") String title,
                                                    @RequestParam(defaultValue = "") String author,
                                                    @RequestParam(defaultValue = "") String publisher) throws Exception {

        String key="";

        RestTemplate template=new RestTemplate();

        Map<String,Object> map=new HashMap<>();

        JAXBContext jaxbContext = JAXBContext.newInstance(com.bookofficial.pasing.Root.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();


        JSONParser jsonParser = new JSONParser();

        ReComAuthorDTO authorDTO=new ReComAuthorDTO();

        ReComPublisherDTO publisherDTO=new ReComPublisherDTO();


        //author
        String authorStr = template.getForObject("https://www.nl.go.kr/NL/search/openApi/search.do?key="+key+"&detailSearch=true"+"&f1=author"+"&v1="+author, String.class);

        StringReader authorReader= new StringReader(authorStr);

        Root authorRoot= (Root) unmarshaller.unmarshal(authorReader);


        System.out.println(authorStr);

        int i=(int)(Math.random()*authorRoot.getResult().getItemList().size());

        String authorIsbn=authorRoot.getResult().getItemList().get(i).getIsbn();

        String authorJsonInfo=template.getForObject("http://seoji.nl.go.kr/landingPage/SearchApi.do?cert_key="+key+"&result_style=json&page_no=1&page_size=10&author=" + author, String.class);

        JSONObject authorJsonObject = (JSONObject) jsonParser.parse(new StringReader(authorJsonInfo));

        JSONArray authorjsonArray = (JSONArray) authorJsonObject.get("docs");

        String author_url="";



        JSONObject authorInArray = (JSONObject) authorjsonArray.get(i);



        author_url=authorInArray.get("TITLE_URL").toString();


        String authorTitle=authorRoot.getResult().getItemList().get(i).getTitle_info();

        String authorAuthor=authorRoot.getResult().getItemList().get(i).getAuthor_info();

        String authorPublish= authorRoot.getResult().getItemList().get(i).getPub_info();

        authorDTO.setRecom_author_title(authorTitle).setRecom_author_author(authorAuthor).setRecom_author_isbn(authorIsbn).setRecom_author_publish(authorPublish).setRecom_author_imgUrl(author_url);

        reComAuthorDAO.reComAuthorInsert(authorDTO);




        //publisher
        String publisherStr = template.getForObject("https://www.nl.go.kr/NL/search/openApi/search.do?key="+key+"&detailSearch=true"+"&f1=publisher"+"&v1="+publisher, String.class);

        StringReader publisherReader= new StringReader(publisherStr);

        Root publisherRoot= (Root) unmarshaller.unmarshal(publisherReader);


        String publisherIsbn=publisherRoot.getResult().getItemList().get(i).getIsbn();

        String publisherJsonInfo=template.getForObject("http://seoji.nl.go.kr/landingPage/SearchApi.do?cert_key="+key+"&result_style=json&page_no=1&page_size=10&publisher=" + publisher, String.class);

        JSONObject publisherJsonObject = (JSONObject) jsonParser.parse(new StringReader(publisherJsonInfo));

        JSONArray publisherjsonArray = (JSONArray) publisherJsonObject .get("docs");

        String publisher_url="";



        JSONObject publisherInArray = (JSONObject) publisherjsonArray.get(i);


        publisher_url=publisherInArray.get("TITLE_URL").toString();



        String publisherTitle=publisherRoot.getResult().getItemList().get(i).getTitle_info();

        String publisherAuthor=publisherRoot.getResult().getItemList().get(i).getAuthor_info();

        String publisherPublish= publisherRoot.getResult().getItemList().get(i).getPub_info();

        publisherDTO.setRecom_publisher_title(publisherTitle).setRecom_publisher_author(publisherAuthor).setRecom_publisher_isbn(publisherIsbn).setRecom_publisher_publish(publisherPublish).setRecom_publisher_imgUrl(publisher_url);

        reComPublisherDAO.reComPublisherInsert(publisherDTO);


        map.put("authorDTO",authorDTO);

        map.put("publisherDTO",publisherDTO);

        return map;
    }

    @ResponseBody
    @GetMapping( "/MyLibraryData")
    public Map<String,Object> MyLibraryData(@RequestParam(defaultValue = "") String subject,
                                            @RequestParam(defaultValue = "") String content,
                                            @RequestParam(defaultValue = "") String comment,
                                            @RequestParam(defaultValue = "") String hashKey,
                                            @RequestParam(defaultValue = "") String title,
                                            @RequestParam(defaultValue = "") String author,
                                            @RequestParam(defaultValue = "") String isbn,
                                            @RequestParam(defaultValue = "") String publisher) throws  Exception {

        String key="";

        Map<String,Object> map=new HashMap<>();

        ReportDTO reportDTO=new ReportDTO();

        reportDTO.setReport_subject(subject).setReport_content(content).setReport_comment(comment).setHashTage(hashKey);

        reportDAO.reportInsert(reportDTO);

        RestTemplate template=new RestTemplate();

        String jsonInfo=template.getForObject("http://seoji.nl.go.kr/landingPage/SearchApi.do?cert_key="+key+"&result_style=json&page_no=1&page_size=10&title="+title+"&author"+author, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new StringReader(jsonInfo));

        JSONArray jsonArray = (JSONArray) jsonObject.get("docs");

        String url="";

        JSONObject objectInArray = (JSONObject) jsonArray.get(0);

        url=objectInArray.get("TITLE_URL").toString();





        System.out.println("url:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+url);

        ReadDTO readDTO =new ReadDTO();

        readDTO.setRead_author(author).setRead_title(title).setRead_isbn(isbn).setRead_publish(publisher).setRead_imgUrl(url);

        readDAO.readList(readDTO);

        map.put("data",url);

        return map;
    }

}
