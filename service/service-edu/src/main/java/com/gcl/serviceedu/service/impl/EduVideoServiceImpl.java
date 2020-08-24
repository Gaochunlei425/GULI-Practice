package com.gcl.serviceedu.service.impl;

import com.alibaba.nacos.client.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gcl.serviceedu.client.VodClient;
import com.gcl.serviceedu.entity.EduVideo;
import com.gcl.serviceedu.mapper.EduVideoMapper;
import com.gcl.serviceedu.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author gcl
 * @since 2020-08-02
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Resource
    private VodClient vodClient;

    @Override
    public void removeVideoByCourseId(String courseId) {

        QueryWrapper<EduVideo> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("chapter_id", courseId);

        List<EduVideo> eduVideoList = baseMapper.selectList(wrapper1);

        //List<EduVideo>变成List<String>
        List<String> videoIds = new ArrayList<>();
        for (int i =0; i < eduVideoList.size(); i++) {
            EduVideo eduVideo = eduVideoList.get(i);
            String videoSourceId = eduVideo.getVideoSourceId();

            if(!StringUtils.isEmpty(videoSourceId)) {
                videoIds.add(videoSourceId);
            }
        }

        if(videoIds.size() > 0) {
            vodClient.deleteBatch(videoIds);
        }


        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
