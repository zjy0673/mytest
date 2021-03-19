package com.yaorange.ssm.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultVO<T> {
    private Integer code;
    private List<T> data;
    private String msg;
    private Long count;
}
