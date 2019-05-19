package com.imooc.weatherssss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: HelloController
 * @date 2019/5/15 22:38
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
