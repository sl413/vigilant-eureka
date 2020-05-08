package com.slaip.ui.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController {

    private final ObservableList<ArticleModel> data = FXCollections.observableArrayList();
    @FXML
    private TableView<ArticleModel> tableView;
    @FXML
    private TableColumn<ArticleModel, String> urlColumn;
    @FXML
    private TableColumn<ArticleModel, String> authorColumn;
    @FXML
    private TableColumn<ArticleModel, String> titleColumn;
    @FXML
    private TableColumn<ArticleModel, String> descriptionColumn;
    @FXML
    private TableColumn<ArticleModel, String> publishedAtColumn;
    @FXML
    private TableColumn<ArticleModel, String> urlToImageColumn;

    public void initialize() {
        urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        publishedAtColumn.setCellValueFactory(new PropertyValueFactory<>("publishedAt"));
        urlToImageColumn.setCellValueFactory(new PropertyValueFactory<>("urlToImage"));
        tableView.setItems(data);
//        data.add(new ArticleModel("wqee", "author", "title", "description", "publishedAt", "urlToImage"));
    }

    public static class ArticleModel {

        private final SimpleStringProperty url;
        private final SimpleStringProperty author;
        private final SimpleStringProperty title;
        private final SimpleStringProperty description;
        private final SimpleStringProperty publishedAt;
        private final SimpleStringProperty urlToImage;

        public ArticleModel(String url, String author, String title, String description, String publishedAt,
                            String urlToImage) {
            this.url = new SimpleStringProperty(url);
            this.author = new SimpleStringProperty(author);
            this.title = new SimpleStringProperty(title);
            this.description = new SimpleStringProperty(description);
            this.publishedAt = new SimpleStringProperty(publishedAt);
            this.urlToImage = new SimpleStringProperty(urlToImage);
        }

        public String getUrl() {
            return url.get();
        }

        public void setUrl(String url) {
            this.url.set(url);
        }

        public String getAuthor() {
            return author.get();
        }

        public void setAuthor(String author) {
            this.author.set(author);
        }

        public String getTitle() {
            return title.get();
        }

        public void setTitle(String title) {
            this.title.set(title);
        }

        public String getDescription() {
            return description.get();
        }

        public void setDescription(String description) {
            this.description.set(description);
        }

        public String getPublishedAt() {
            return publishedAt.get();
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt.set(publishedAt);
        }

        public String getUrlToImage() {
            return urlToImage.get();
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage.set(urlToImage);
        }
    }
}
