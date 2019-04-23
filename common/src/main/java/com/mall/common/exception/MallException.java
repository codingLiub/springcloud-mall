package com.mall.common.exception;

import com.mall.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 20:21
 * @ Description：自定义异常
 * @ Modified By：
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MallException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}
