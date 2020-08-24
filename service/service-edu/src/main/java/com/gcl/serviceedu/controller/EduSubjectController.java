package com.gcl.serviceedu.controller;


import com.gcl.commonutils.R;
import com.gcl.serviceedu.entity.EduSubject;
import com.gcl.serviceedu.entity.subject.OneSubject;
import com.gcl.serviceedu.service.EduSubjectService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author gcl
 * @since 2020-08-01
 */
@Api(description="课程分类管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/eduservice/subject")
public class EduSubjectController {

    @Resource
    private EduSubjectService subjectService;

    //添加课程分类
    //获取上传过来的文件，把文件内容读取出来
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){

        //上传过来的excel文件
        subjectService.saveSubject(file, subjectService);
        return R.ok();
    }

    @GetMapping("getAllSubject")
    public R getAllSubject() {
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return R.ok().data("list", list);
    }



}

