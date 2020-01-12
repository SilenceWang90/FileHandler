package com.wp.filehandler.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname FileController
 * @Description FileController
 * @Date 2020/1/12 8:43
 * @Created by wangpeng116
 */
@RestController
@RequestMapping("file")
@Slf4j
public class FileController {
    @RequestMapping("readExcel")
    public String readExcel(){

        return "读取成功";
    }
}
