package com.wp.filehandler.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.wp.filehandler.model.ExcelDataModel;
import com.wp.filehandler.model.ExcelDataModelListener;
import com.wp.filehandler.model.HutoolReadData;
import com.wp.filehandler.service.ExcelDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    /**
     * EasyExcel读取Excel方法
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/easyExcelReadExcel")
    public String easyExcelReadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        //通过@ExcelProperty(index = 2)制定读取哪几列数据，目前只需要第3,5,9列数据
        EasyExcel.read(file.getInputStream(), ExcelDataModel.class, new ExcelDataModelListener(excelDataService)).sheet().doRead();
        return "读取成功";
    }

    @PostMapping("/hutoolReadExcel")
    public String hutoolReadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        ExcelReader excelReader = ExcelUtil.getReader(file.getInputStream(), "临时定级");
        //属性名为字段名，属性值为字段值
        List<HutoolReadData> list = excelReader.readAll(HutoolReadData.class);
        log.info("读取的数据为：{}", list);
        return "读取成功";
    }
}
