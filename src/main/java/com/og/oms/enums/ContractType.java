package com.og.oms.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum ContractType implements IEnum{
    NORMAL(0, "其他");

    /**
     * 标识
     */
    private Integer code;
    /**
     * 文字描述
     */
    private String text;

    ContractType(Integer code, String text) {
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
