package com.gcl.serviceedu.client;

import com.gcl.commonutils.R;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: gcl
 * @create: 2020/8/8 20:27
 */

@FeignClient(name = "service-vod")
@Component
public interface VodClient {
    @DeleteMapping("/eduvod/video/deleteAlyiVideo/{id}")
    public R removeVideo(@ApiParam(name = "id", value = "云端视频id", required = true)
                         @PathVariable("id") String id);

    @DeleteMapping("/eduvod/video/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);
}