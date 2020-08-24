package com.gcl.servicebase.config;


import com.gcl.commonutils.R;
import com.gcl.servicebase.entity.GuliException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: gcl
 * @create: 2020/7/26 9:23
 */

/**
 * @ControllerAdvice作用
 * 全局异常处理
 * 全局数据绑定
 * 全局数据预处理
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //@ExceptionHandler 注解用来指明异常的处理类型，即如果这里指定为 NullpointerException，则数组越界异常就不会进到这个方法中来。
    @ExceptionHandler(Exception.class)
    @ResponseBody   //为了返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException自定义异常");
    }


    /**
     * 自定义异常方法，需要手动的抛出异常
     * @param e
     * @return
     */
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }

}
