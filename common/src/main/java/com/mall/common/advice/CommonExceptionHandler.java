package com.mall.common.advice;

import com.mall.common.exception.MallException;
import com.mall.common.vo.ExceptionResult;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/23 20:20
 * @ Description：拦截异常
 * @ Modified By：
 */
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(MallException.class)
    public ResponseEntity<ExceptionResult> handleException(MallException e) {
        val em = e.getExceptionEnum();
        return ResponseEntity.status(em.getCode()).body(new ExceptionResult(em));
    }
}
