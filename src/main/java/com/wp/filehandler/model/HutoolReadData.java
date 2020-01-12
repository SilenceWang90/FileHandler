package com.wp.filehandler.model;

import lombok.Data;

/**
 * @Classname HutoolReadData
 * @Description HutoolReadData
 * @Date 2020/1/12 11:47
 * @Created by wangpeng116
 */
@Data
public class HutoolReadData {
    //对应标题为businessCode
    private String businessCode;
    //对应标题为categoryTypeName
    private String categoryTypeName;
    //对应标题为dueDate
    private String dueDate;
}
