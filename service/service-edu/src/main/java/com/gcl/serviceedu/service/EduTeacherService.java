package com.gcl.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gcl.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author gcl
 * @since 2020-07-24
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
