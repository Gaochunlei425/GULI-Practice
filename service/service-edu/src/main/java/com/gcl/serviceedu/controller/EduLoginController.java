package com.gcl.serviceedu.controller;

import com.gcl.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: gcl
 * @create: 2020/7/29 15:31
 */

@RestController
@RequestMapping("/eduservice/user")
////@CrossOrigin
public class EduLoginController {

    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596018250084&di=b21fbffd89a3983f2419685eec22292a&imgtype=0&src=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fphotos%2F33300000%2FIchigo-Rukia-bleach-anime-33326843-1024-576.jpg");
    }

}
