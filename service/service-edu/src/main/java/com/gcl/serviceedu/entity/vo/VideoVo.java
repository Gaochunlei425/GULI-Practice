package com.gcl.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: gcl
 * @create: 2020/8/4 10:20
 */

@ApiModel(value = "课时信息")
@Data
public class VideoVo {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String videoSourceId;   //视频ID
}
