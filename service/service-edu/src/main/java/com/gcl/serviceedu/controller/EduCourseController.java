package com.gcl.serviceedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gcl.commonutils.R;
import com.gcl.serviceedu.entity.EduCourse;
import com.gcl.serviceedu.entity.query.CourseQuery;
import com.gcl.serviceedu.entity.query.TeacherQuery;
import com.gcl.serviceedu.entity.vo.CourseInfoVo;
import com.gcl.serviceedu.entity.vo.CoursePublishVo;
import com.gcl.serviceedu.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author gcl
 * @since 2020-08-02
 */
@Api(description="课程添加管理")
@RestController
@RequestMapping("/eduservice/course")
//@CrossOrigin
public class EduCourseController {

    @Resource
    private EduCourseService eduCourseService;

    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId", id);
    }

    //回调数据
    @GetMapping("courseinfo/{id}")
    public R returnCourseInfo(
            @ApiParam(name = "id", value = "课程ID", required = true)
            @PathVariable String id){
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfoFormById(id);
        return R.ok().data("item", courseInfoVo);
    }

    //修改课程基本信息
    @PostMapping("updateCourseInfo")
    public R updateCourseInifo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.updateCourseInfo(courseInfoVo);
        return  R.ok();
    }

    //根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = eduCourseService.publishCourseInfo(id);
        return R.ok().data("publishCourse",coursePublishVo);
    }

    //课程最终发布
    //修改课程状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");//设置课程发布状态
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }

    //删除课程
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable String courseId) {
        eduCourseService.removeCourse(courseId);
        return R.ok();
    }

    //完善条件查询带分页
    @PostMapping("/pageCourseCondition/{current}/{limit}")
    public R getCourseList(@PathVariable Long current, @PathVariable long limit,
                           @RequestBody(required = false) CourseQuery courseQuery) {
        Page<EduCourse> page = new Page<>(current, limit);

        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();

        String name = courseQuery.getTitle();
        String status = courseQuery.getStatus();

        if(!StringUtils.isEmpty(name)) {
            wrapper.like("title", name);
        }
        if(!StringUtils.isEmpty(status)) {
            wrapper.eq("status", status);
        }

        //调用方法实现条件查询分页
        eduCourseService.page(page, wrapper);
        List<EduCourse> records = page.getRecords();
        long total = page.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }

}

