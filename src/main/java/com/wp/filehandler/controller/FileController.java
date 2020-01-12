package com.wp.filehandler.controller;

import com.alibaba.excel.EasyExcel;
import com.wp.filehandler.model.ExcelDataModel;
import com.wp.filehandler.model.ExcelDataModelListener;
import com.wp.filehandler.service.ExcelDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Classname FileController
 * @Description FileController
 * @Date 2020/1/12 8:43
 * @Created by wangpeng116
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Autowired
    private ExcelDataService excelDataService;

    @PostMapping("/readExcel")
    public String readExcel(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelDataModel.class, new ExcelDataModelListener()).sheet().doRead();
        return "读取成功";
    }
}
