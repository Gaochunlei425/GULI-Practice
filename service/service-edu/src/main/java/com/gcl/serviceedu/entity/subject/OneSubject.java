package com.gcl.serviceedu.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gcl
 * @create: 2020/8/1 21:58
 */

@Data
public class OneSubject {
    private String id;
    private String title;

    private List<TwoSubject> children = new ArrayList<>();

}
