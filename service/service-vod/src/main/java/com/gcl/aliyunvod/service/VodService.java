package com.gcl.aliyunvod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    void removeVideo(String id);


    void removeMoreAlyVideo(List<String> videoIdList);
}
