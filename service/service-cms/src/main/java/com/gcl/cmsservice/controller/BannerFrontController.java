package com.gcl.cmsservice.controller;

import com.gcl.cmsservice.entity.CrmBanner;
import com.gcl.cmsservice.service.CrmBannerService;
import com.gcl.commonutils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: gcl
 * @create: 2020/8/10 13:16
 */

@RestController
@RequestMapping("/educms/bannerfront")
@Api(description = "网站首页Banner列表")
//@CrossOrigin //跨域
public class BannerFrontController {

    @Resource
    private CrmBannerService bannerService;

    @GetMapping("getAllBanner")
    public R getAllBanner() {
        List<CrmBanner> list = bannerService.selectAllBanner();

        return R.ok().data("list", list);
    }
}
