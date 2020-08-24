package com.gcl.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gcl.serviceedu.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gcl.serviceedu.entity.frontvo.CourseFrontVo;
import com.gcl.serviceedu.entity.frontvo.CourseWebVo;
import com.gcl.serviceedu.entity.vo.CourseInfoVo;
import com.gcl.serviceedu.entity.vo.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author gcl
 * @since 2020-08-02
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfoFormById(String id);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);
}
