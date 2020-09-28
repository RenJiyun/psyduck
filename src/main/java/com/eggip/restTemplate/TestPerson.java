package com.eggip.restTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class TestPerson {
    public static RestTemplate restTemplate=new RestTemplate();

    public static  void  main(String[] args){
        String url= "http://192.168.43.221:/person/a";
        restTemplate.getForObject(url,Object.class);
    }
}
