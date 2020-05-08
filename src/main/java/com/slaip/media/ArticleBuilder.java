package com.slaip.media;

import com.slaip.ui.controller.TableViewController;

// TODO: 5/8/20 Make singleton
public class ArticleBuilder {

    private final Article article = new Article();

    private void fillArticleFromModel(TableViewController.ArticleModel articleModel) {
        article.setUrl(articleModel.getUrl());
        article.setAuthor(articleModel.getAuthor());
        article.setDescription(articleModel.getDescription());
        article.setPublishedAt(articleModel.getPublishedAt());
        article.setTitle(articleModel.getTitle());
        article.setUrlToImage(articleModel.getUrlToImage());
    }

    public Article build(TableViewController.ArticleModel articleModel) {
        fillArticleFromModel(articleModel);
        return article;
    }
}
