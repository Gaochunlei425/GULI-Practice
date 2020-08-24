package com.gcl.serviceedu.client;

import com.gcl.commonutils.UcenterMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: gcl
 * @create: 2020/8/15 9:04
 */

@Component
@FeignClient(name="service-ucenter")
public interface UcenterClient {

    //根据用户id获取用户信息
    //根据token字符串获取用户信息
    @GetMapping("/educenter/member/getUcenterPay/{memberId}")
    public com.gcl.commonutils.UcenterMember getUcenterPay(@PathVariable("memberId") String memberId);

}
