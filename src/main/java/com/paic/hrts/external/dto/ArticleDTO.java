package com.paic.hrts.external.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author: fengwenping
 * Description:
 * Date: 2018-09-29
 * Time: 下午11:56
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDTO implements Serializable {

    @JsonProperty(value = "content_short")
    private String contentShort;
    @JsonProperty(value = "display_time")
    private Long displayTime;
    private Long id;
    @JsonProperty(value = "image_uri")
    private String imageUri;
    @JsonProperty(value = "source_name")
    private String sourceName;
    @JsonProperty(value = "source_uri")
    private String sourceUri;
    private String title;
    private String uri;
    private AudioDTO audio;
    private AuthorDTO author;
    private List<CategoryDTO> categories;
    @JsonProperty(value = "related_articles")
    private List<ArticleDTO> relatedArticles;
    private List<CategoryDTO> symbols;
    private List<CategoryDTO> tags;
    @JsonProperty(value = "updated_at")
    private String updatedAt;
    @JsonProperty(value = "content_args")
    private List<ContentArgDTO> contentArgs;
    private String content;

    public String getContentShort() {
        return contentShort;
    }

    public void setContentShort(String contentShort) {
        this.contentShort = contentShort;
    }

    public Long getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(Long displayTime) {
        this.displayTime = displayTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceUri() {
        return sourceUri;
    }

    public void setSourceUri(String sourceUri) {
        this.sourceUri = sourceUri;
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public AudioDTO getAudio() {
        return audio;
    }

    public void setAudio(AudioDTO audio) {
        this.audio = audio;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public List<ArticleDTO> getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(List<ArticleDTO> relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    public List<CategoryDTO> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<CategoryDTO> symbols) {
        this.symbols = symbols;
    }

    public List<CategoryDTO> getTags() {
        return tags;
    }

    public void setTags(List<CategoryDTO> tags) {
        this.tags = tags;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<ContentArgDTO> getContentArgs() {
        return contentArgs;
    }

    public void setContentArgs(List<ContentArgDTO> contentArgs) {
        this.contentArgs = contentArgs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
