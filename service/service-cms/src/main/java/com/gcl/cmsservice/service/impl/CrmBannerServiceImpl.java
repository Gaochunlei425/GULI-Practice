package com.gcl.cmsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gcl.cmsservice.entity.CrmBanner;
import com.gcl.cmsservice.mapper.CrmBannerMapper;
import com.gcl.cmsservice.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author gcl
 * @since 2020-08-10
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner() {
//        List<CrmBanner> banners = baseMapper.selectList(null);
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("id");

        wrapper.last("limit 2");

        List<CrmBanner> list = baseMapper.selectList(wrapper);


        return list;
    }
}
