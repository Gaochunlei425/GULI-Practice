package com.gcl.servicestatistics.client;

import com.gcl.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: gcl
 * @create: 2020/8/22 9:24
 */

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    @GetMapping(value = "/educenter/member/countregister/{day}")
    public R registerCount(@PathVariable("day") String day);
}
