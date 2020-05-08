package com.slaip.media;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "article")
public class Article {

    private String url;
    private String author;
    private String title;
    private String description;
    private String urlToImage;
    private String publishedAt;

    @Id
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "url_to_image")
    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @Basic
    @Column(name = "published_at")
    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(url, article.url) &&
                Objects.equals(author, article.author) &&
                Objects.equals(title, article.title) &&
                Objects.equals(description, article.description) &&
                Objects.equals(urlToImage, article.urlToImage) &&
                Objects.equals(publishedAt, article.publishedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, author, title, description, urlToImage, publishedAt);
    }
}
