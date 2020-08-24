package com.gcl.servicestatistics.controller;


import com.gcl.commonutils.R;
import com.gcl.servicestatistics.entity.StatisticsDaily;
import com.gcl.servicestatistics.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author gcl
 * @since 2020-08-22
 */
@RestController
@RequestMapping("/staservice/sta")
@CrossOrigin
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService dailyService;

    //統計某一天注冊人數，生成統計數據
    @PostMapping("registerCount/{day}")
    public R createStatisticsByDate(@PathVariable String day) {
        dailyService.createStatisticsByDay(day);
        return R.ok();
    }

    //圖表顯示，返回兩部分數據，日期json數組，數量json數組
    @GetMapping("showData/{type}/{begin}/{end}")
    public R showData(@PathVariable String type, @PathVariable String begin, @PathVariable String end) {
        Map<String, Object> map = dailyService.getShowData(type, begin, end);
        return R.ok().data(map);
    }

}

