package com.gcl.serviceedu.service;

import com.gcl.serviceedu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gcl.serviceedu.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author gcl
 * @since 2020-08-01
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    List<OneSubject> getAllOneTwoSubject();
}
