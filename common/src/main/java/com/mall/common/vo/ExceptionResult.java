package com.mall.common.vo;

import com.mall.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 20:27
 * @ Description：异常结果处理对象
 * @ Modified By：
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum) {
        this.status = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
