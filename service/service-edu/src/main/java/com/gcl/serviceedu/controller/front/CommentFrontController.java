package com.gcl.serviceedu.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gcl.commonutils.JwtUtils;
import com.gcl.commonutils.R;
import com.gcl.commonutils.UcenterMember;
import com.gcl.serviceedu.client.UcenterClient;
import com.gcl.serviceedu.entity.EduComment;
import com.gcl.serviceedu.service.EduCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gcl
 * @create: 2020/8/15 10:20
 */

@RestController
@RequestMapping("/eduservice/comment")
@CrossOrigin
@Api(description="评论操作管理")
@Slf4j
public class CommentFrontController {

    @Autowired
    private EduCommentService eduCommentService;
    @Autowired
    private UcenterClient ucenterClient;

    //根据课程id查询评论列表
    @ApiOperation(value = "评论分页列表")
    @PostMapping("{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

                    @RequestBody(required = false) String courseId1) {
        Page<EduComment> pageParam = new Page<>(page, limit);

        QueryWrapper<EduComment> wrapper = new QueryWrapper<>();
        String courseId = courseId1.replaceAll("=", "");
        wrapper.eq("course_id",courseId);
        log.info("courseID = " + courseId);

//        wrapper.orderByDesc("gmtCreate");
//        List<EduComment> list = eduCommentService.list(wrapper);
//        log.info("list + "  + list);
//        EduComment byId = eduCommentService.getById("1195252819177570306");
        eduCommentService.page(pageParam, wrapper);
        List<EduComment> EduCommentList = pageParam.getRecords();
//        log.info(String.valueOf(EduCommentList));
//        log.info("byid + "+ byId);
        Map<String, Object> map = new HashMap<>();
        map.put("items", EduCommentList);
        map.put("current", pageParam.getCurrent());
        map.put("pages", pageParam.getPages());
        map.put("size", pageParam.getSize());
        map.put("total", pageParam.getTotal());
        map.put("hasNext", pageParam.hasNext());
        map.put("hasPrevious", pageParam.hasPrevious());
        return R.ok().data(map);
    }

    @ApiOperation(value = "添加评论")
    @PostMapping("auth/save")
    public R save(@RequestBody EduComment eduComment, HttpServletRequest request) {
        //
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if(StringUtils.isEmpty(memberId)) {
            return R.error().code(28004).message("请登录");
        }
        eduComment.setMemberId(memberId);
        log.info("得到數據" + eduComment);
        com.gcl.commonutils.UcenterMember ucenterPay = ucenterClient.getUcenterPay(memberId);
        System.out.println(ucenterPay);
        eduComment.setNickname(ucenterPay.getNickname());
        eduComment.setAvatar(ucenterPay.getAvatar());

        eduCommentService.save(eduComment);
        return R.ok();
    }
}
