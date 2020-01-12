package com.wp.filehandler.model;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wp.filehandler.mapper.ExcelDataModelMapper;
import com.wp.filehandler.service.ExcelDataService;
import com.wp.filehandler.service.impl.ExcelDataServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ExcelDataModelListener
 * @Description ExcelDataModelListener
 * @Date 2020/1/12 9:19
 * @Created by wangpeng116
 */
@Slf4j
public class ExcelDataModelListener extends AnalysisEventListener<ExcelDataModel> {
    private static final int BATCH_COUNT = 51;
    private List<ExcelDataModel> list = new ArrayList<>();
    private ExcelDataService excelDataService;
    private ExcelDataModelMapper excelDataModelMapper;

    public ExcelDataModelListener() {
        excelDataService = new ExcelDataServiceImpl();
    }

    public ExcelDataModelListener(ExcelDataService excelDataService) {
        this.excelDataService = excelDataService;
        this.excelDataModelMapper = ((ExcelDataServiceImpl) excelDataService).getExcelDataModelMapper();
    }

    /**
     * 每一条数据解析都会来调用，用于即系数据
     *
     * @param data
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelDataModel data, AnalysisContext analysisContext) {
        excelDataService.handleData(data);
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            //防止OOM因此达到阈值就进行一次保存
            save(list);
        }
    }

    /**
     * 所有数据解析完了都回来调用
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("doAfterAllAnalysed被调用");
        //一般用于数据解析之后入库，调用save之类的方法
        save(list);
    }

    private void save(List<ExcelDataModel> list) {
        log.info("保存数据：{}", list);
        excelDataModelMapper.insertAll(list);
    }
}
