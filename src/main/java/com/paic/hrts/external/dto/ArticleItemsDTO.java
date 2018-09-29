package com.paic.hrts.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-09-29
 * Time: 下午11:59
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleItemsDTO implements Serializable {

    private List<ArticleDTO> items;
    @JsonProperty(value = "next_cursor")
    private String nextCursor;

    public List<ArticleDTO> getItems() {
        return items;
    }

    public void setItems(List<ArticleDTO> items) {
        this.items = items;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }

    @Override
    public String toString() {
        return this.nextCursor;
    }
}
