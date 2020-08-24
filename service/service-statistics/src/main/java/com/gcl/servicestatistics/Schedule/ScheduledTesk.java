package com.gcl.servicestatistics.Schedule;

import com.gcl.servicestatistics.service.StatisticsDailyService;
import com.gcl.servicestatistics.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: gcl
 * @create: 2020/8/22 10:04
 */

@Component
public class ScheduledTesk {

    @Autowired
    private StatisticsDailyService staService;

    // 0/5 * * * * ?表示每隔5秒执行一次这个方法
    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() {
        System.out.println("**************task1执行了..");
    }

    //在每天凌晨1点，把前一天数据进行数据查询添加
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        staService.createStatisticsByDay(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }
}
