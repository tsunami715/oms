package com.og.oms.enums;


import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * 状态枚举
 */
public enum StatusType implements IEnum {
    NORMAL(1, "正常"),
    DISABLE(2, "禁用");

    /**
     * 标识
     */
    private Integer code;
    /**
     * 文字描述
     */
    private String text;

    StatusType(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public Serializable getValue() {
        return this.code;
    }

    @JsonValue
    public String getDesc() {
        return this.text;
    }
}
