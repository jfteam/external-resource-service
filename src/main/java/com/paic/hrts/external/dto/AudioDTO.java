package com.paic.hrts.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-09-30
 * Time: 上午12:54
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioDTO implements Serializable{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
