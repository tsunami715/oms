package com.og.oms.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.og.oms.utils.EnumUtil;

import java.io.Serializable;

public enum ProducerEnum implements IEnum {
    NORMAL(0, "其他");

    /**
     * 标识
     */
    private Integer code;
    /**
     * 文字描述
     */
    private String name;

    ProducerEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 增加一个枚举实例
     *
     * @param code
     * @param name
     */
    public static void addEnum(Integer code, String name) {
        Class[] additionalTypes = new Class[]{Integer.class, String.class};
        Object[] additionalValues = new Object[]{code, name};
        EnumUtil.addEnum(ProducerEnum.class, String.valueOf(code), additionalTypes, additionalValues);
    }

    @Override
    public Serializable getValue() {
        return this.code;
    }

    @JsonValue
    public String getDesc() {
        return this.name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String text) {
        this.name = text;
    }
}
