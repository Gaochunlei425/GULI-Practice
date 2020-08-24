package com.gcl.serviceoss.controller;

import com.gcl.commonutils.R;
import com.gcl.serviceoss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * @Author: gcl
 * @create: 2020/7/30 18:02
 */


@Api(description="阿里云文件管理")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class FileUploadController {


    @Resource
    private OssService ossService;

    //上传头像的方法
    @PostMapping
    public R uploadOssFile(MultipartFile file) {
        //获取上传文件  MultipartFile
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }

}
