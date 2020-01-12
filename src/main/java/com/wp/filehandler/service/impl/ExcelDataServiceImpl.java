package com.wp.filehandler.service.impl;

import com.wp.filehandler.mapper.ExcelDataModelMapper;
import com.wp.filehandler.model.ExcelDataModel;
import com.wp.filehandler.service.ExcelDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ExcelDataModelMapper excelDataModelMapper;

    @Override
    public void handleData(ExcelDataModel data) {
        log.info("service处理数据");
        excelDataModelMapper.insertOne(data);
    }
}
