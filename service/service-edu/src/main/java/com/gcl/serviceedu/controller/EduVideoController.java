package com.gcl.serviceedu.controller;


import com.alibaba.excel.util.StringUtils;
import com.gcl.commonutils.R;
import com.gcl.servicebase.entity.GuliException;
import com.gcl.serviceedu.client.VodClient;
import com.gcl.serviceedu.entity.EduVideo;
import com.gcl.serviceedu.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author gcl
 * @since 2020-08-02
 */
@RestController
@RequestMapping("/eduservice/video")
//@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    @Resource
    private VodClient vodClient;

    //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }

    //删除小节
    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频删除
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {

        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        System.out.println(videoSourceId);
        //删除视频资源
        if(!StringUtils.isEmpty(videoSourceId)){
            System.out.println("-------------------");
            R r = vodClient.removeVideo(videoSourceId);
            System.out.println(r.getCode());
            if(r.getCode() == 20001) {
                throw new GuliException(20001,"删除视频失败，熔断器。。。");
            }
        }

        videoService.removeById(id);
        return R.ok();
    }

    //修改小节 TODO

}


