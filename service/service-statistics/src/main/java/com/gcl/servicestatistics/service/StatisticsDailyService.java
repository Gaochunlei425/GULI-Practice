package com.gcl.servicestatistics.service;

import com.gcl.servicestatistics.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author gcl
 * @since 2020-08-22
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    void createStatisticsByDay(String day);

    Map<String, Object> getShowData(String type, String begin, String end);
}
