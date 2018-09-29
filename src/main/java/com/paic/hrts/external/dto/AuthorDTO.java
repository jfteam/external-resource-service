package com.paic.hrts.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-09-29
 * Time: 下午11:54
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO implements Serializable {

    private String avatar;
    @JsonProperty(value = "display_name")
    private String displayName;
    private Long id;
    private String uri;
    private String bio;
    @JsonProperty(value = "editor_choice_articles")
    private List<EditorChoiceArticleDTO> editorChoiceArticles;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<EditorChoiceArticleDTO> getEditorChoiceArticles() {
        return editorChoiceArticles;
    }

    public void setEditorChoiceArticles(List<EditorChoiceArticleDTO> editorChoiceArticles) {
        this.editorChoiceArticles = editorChoiceArticles;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
