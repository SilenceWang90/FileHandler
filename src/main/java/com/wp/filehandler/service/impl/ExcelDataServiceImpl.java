package com.wp.filehandler.service.impl;

import com.wp.filehandler.model.ExcelDataModel;
import com.wp.filehandler.service.ExcelDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Classname ExcelDataServiceImpl
 * @Description ExcelDataServiceImpl
 * @Date 2020/1/12 9:12
 * @Created by wangpeng116
 */
@Service
@Slf4j
public class ExcelDataServiceImpl implements ExcelDataService {
    @Override
    public String handleData(ExcelDataModel data) {
        log.info("数据处理");
        return "service处理数据";
    }
}
