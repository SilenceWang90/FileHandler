package com.wp.filehandler.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * @Classname ExcelDataModel
 * @Description ExcelDataModel
 * @Date 2020/1/12 8:59
 * @Created by wangpeng116
 */
@Data
public class ExcelDataModel {
    @ExcelProperty(index = 2)
    private String businessCode;
    @ExcelProperty(index = 4)
    private String categoryTypeName;
    @ExcelProperty(index = 8)
    private String dueDate;
}
