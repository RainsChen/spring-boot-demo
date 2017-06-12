package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chenjie on 2017/6/12.
 */
@Controller
@RequestMapping("log")
public class LogController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("writelog")
    @ResponseBody
    public String writeLog()
    {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "OK";
    }
}
