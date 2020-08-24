package com.gcl.serviceedu.client;

import com.gcl.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: gcl
 * @create: 2020/8/9 10:19
 */

@Component
public class VodFileDegradeFeignClient implements VodClient {

    @Override
    public R removeVideo(String id) {
        return R.error().message("time out");

    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return R.error().message("time out");
    }
}
