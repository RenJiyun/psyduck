package com.eggip.restTemplate;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonControl {
    @GetMapping("person/a")
    public void  getSystem(){
        System.out.println("person类=======");
    }
}
