package com.paic.hrts.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-09-30
 * Time: 上午12:55
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditorChoiceArticleDTO implements Serializable {

    private Long id;
    private String title;
    private String uri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
