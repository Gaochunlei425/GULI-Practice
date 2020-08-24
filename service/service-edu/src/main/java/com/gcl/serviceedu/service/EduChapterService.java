package com.gcl.serviceedu.service;

import com.gcl.serviceedu.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gcl.serviceedu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author gcl
 * @since 2020-08-02
 */
public interface EduChapterService extends IService<EduChapter> {
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
