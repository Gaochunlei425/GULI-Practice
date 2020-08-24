package com.gcl.serviceedu.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: gcl
 * @create: 2020/8/6 14:48
 */
@ApiModel(value = "Course查询对象", description = "课程查询对象封装")
@Data
public class CourseQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程名称，模糊查询")
    private String title;

    @ApiModelProperty(value = "Normal为激活，Draft为未激活")
    private String status;

}
