package com.wp.filehandler.mapper;

import com.wp.filehandler.model.ExcelDataModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname ExcelDataModelMapper
 * @Description ExcelDataModelMapper
 * @Date 2020/1/12 10:15
 * @Created by wangpeng116
 */
@Repository
public interface ExcelDataModelMapper {
    @Insert("insert eva_supplier_temp (business_code,category_type_name,due_date) values " +
            "(#{data.businessCode},#{data.categoryTypeName},#{data.dueDate})")
    void insertOne(@Param("data") ExcelDataModel data);

    void insertAll(@Param("list") List<ExcelDataModel> list);
}
