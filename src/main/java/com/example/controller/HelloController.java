package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chenjie on 2017/6/12.
 */
@RestController
@RequestMapping("home")
public class HelloController {
    @RequestMapping("hello")
    String home() {
        return "Hello World!";
    }
}
