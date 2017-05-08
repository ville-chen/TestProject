package com.selenium;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2017/5/8.
 */
public enum DataType {
    STRING(String.class),
    INTEGER(Integer.class),
    DOUBLE(Double.class),
    BIG_DECIMAL(BigDecimal.class),
    DATE(Date.class);

    private Class<?> clazz;

    private DataType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> clazz() {
        return this.clazz;
    }
}