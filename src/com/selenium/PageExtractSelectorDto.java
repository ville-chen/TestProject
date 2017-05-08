package com.selenium;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by tt on 2017/3/2.
 * 页面采集选择器
 */
@Data
public class PageExtractSelectorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据名称
     */
    private String name;

    /**
     * 数据KEY
     */
    private String key;

    /**
     * 选择器
     */
    private String selector;

    /**
     * 选择器类型
     */
    private String type;


    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 元素属性
     */
    private String elementAttr;


    /**
     * 结果是否集合
     */
    private Boolean isArray;

    /**
     * 结果替换
     */
    private String resultReplaces;

    /**
     * 种子Id
     */
    private String urlSeedId;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
