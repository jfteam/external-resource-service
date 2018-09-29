package com.paic.hrts.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-09-30
 * Time: 上午12:56
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO implements Serializable {
    private String key;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
