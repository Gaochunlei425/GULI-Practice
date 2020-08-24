package com.gcl.serviceedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gcl.commonutils.R;
import com.gcl.servicebase.entity.GuliException;
import com.gcl.serviceedu.entity.EduTeacher;
import com.gcl.serviceedu.entity.query.TeacherQuery;
import com.gcl.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author gcl
 * @since 2020-07-24
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@Slf4j
//@CrossOrigin
public class EduTeacherController {

    @Resource
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/list")
    public R list(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeBiId(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {

        teacherService.removeById(id);

        return R.ok();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        //！！！！！调用方法时候，底层封装，把分页所有数据封装到pageParam对象里面。
        teacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", records);

    }


    @ApiOperation(value = "分页讲师条件查询")
//    @GetMapping("pageTeacherCondition/{current}/{limit}")         对于下面的对象传递 更好是用post请求进行传递，在实体对象前开启@RequestBody注解来进行Json转对象的操作
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R oageTeacherCondition(@PathVariable Long current, @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam = new Page<>(current, limit);

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)){
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create", end);
        }

        wrapper.orderByDesc("gmt_create");

        //调用方法实现条件查询分页
        teacherService.page(pageParam, wrapper);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){

        teacherService.save(teacher);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("getById/{id}")
    public R getById(@ApiParam(name = "id", value = "讲师ID", required = true)
                                 @PathVariable String id) {
        EduTeacher teacher = teacherService.getById(id);

        return R.ok().data("item", teacher);
    }


    @ApiOperation(value = "根据Id修改讲师")
    @PutMapping("/updateById/{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
                        @ApiParam(name = "teacher", value = "讲师对象", required = true)
                        @RequestBody EduTeacher teacher){
        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }

    @ApiOperation(value = "根据Id修改讲师")
    @PostMapping("/updateTeacher")
    public R updateById(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){
        teacherService.updateById(teacher);
        return R.ok();
    }


    @ApiOperation(value = "÷零测试")
    @PostMapping("/test")
    public R test_save(){

        int i = 10/0;

        return R.ok();
    }

    @ApiOperation(value = "自定义异常测试")
    @PostMapping("/user_defined_test")
    public R user_defined(){

        try {

            int i = 10/0;

        }catch (Exception e) {
            log.error(e.getMessage());
            throw new GuliException(20001, "执行了自定义异常");
        }

        return R.ok();
    }
}

