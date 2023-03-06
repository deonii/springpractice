package com.example.testproject.controller;


import com.example.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello world";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping("/name")
    public String getName() {
        return "Deonii";
    }

    // http://localhost:8080/api/v1/get-api/variable1/deonii
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/deonii
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=deonii&email=fishingman99@gmail.com
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email) {
        return name + " / " + email;
    }

    // http://localhost:8080/api/v1/get-api/request2?name=deonii&email=fishingman99@gmail.com
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        System.out.println(param);

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=deonii&email=fishingman99@gmail.com
    @GetMapping(value = "request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
