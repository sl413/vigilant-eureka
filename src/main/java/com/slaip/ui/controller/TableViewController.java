package com.slaip.ui.controller;

import com.slaip.ArticleDao;
import com.slaip.media.Article;
import com.slaip.media.ArticleBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

// TODO: 5/8/20 divide controller responsibility (table, button ...)
public class TableViewController {

    private static final ObservableList<ArticleModel> data = FXCollections.observableArrayList();
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
    private final ArticleDao articleDao = new ArticleDao();
    @FXML
    private Button delRowBut;
    @FXML
    private Button addRowBut;
    @FXML
    private Button pushDataBut;
    @FXML
    private Button fetchDataBut;

    public void initialize() {
        initTableView();
        initButton();
        articleDao.getArticles().forEach(this::addRow);
        tableView.setItems(data);
    }

    private void initButton() {
        ArticleBuilder articleBuilder = new ArticleBuilder();
        // TODO: 5/8/20 delete from DB
        delRowBut.setOnAction(e -> {
            ArticleModel selectedItem = tableView.getSelectionModel().getSelectedItem();
            tableView.getItems().remove(selectedItem);
        });
        addRowBut.setOnAction(e -> tableView.getItems().add(new ArticleModel()));
        // TODO: 5/8/20 dont get twice data. Need Data source?
        fetchDataBut.setOnAction(actionEvent -> articleDao.getArticles().forEach(this::addRow));
        pushDataBut.setOnAction(actionEvent -> data.forEach(articleModel -> articleDao
                .saveArticle(articleBuilder.build(articleModel))));
    }

    private void initTableView() {
        // TODO: 5/8/20 Move to .fxml and generify
//        tableView.setEditable(true);
        urlColumn.setCellValueFactory(new PropertyValueFactory<>("url"));
        urlColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        urlColumn.setOnEditCommit((TableColumn.CellEditEvent<ArticleModel, String> event) -> {
            TablePosition<ArticleModel, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            ArticleModel articleModel = event.getTableView().getItems().get(row);
            articleModel.setUrl(newValue);
        });

        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        authorColumn.setOnEditCommit((TableColumn.CellEditEvent<ArticleModel, String> event) -> {
            TablePosition<ArticleModel, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            ArticleModel articleModel = event.getTableView().getItems().get(row);
            articleModel.setAuthor(newValue);
        });

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        titleColumn.setOnEditCommit((TableColumn.CellEditEvent<ArticleModel, String> event) -> {
            TablePosition<ArticleModel, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            ArticleModel articleModel = event.getTableView().getItems().get(row);
            articleModel.setTitle(newValue);
        });

        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setOnEditCommit((TableColumn.CellEditEvent<ArticleModel, String> event) -> {
            TablePosition<ArticleModel, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            ArticleModel articleModel = event.getTableView().getItems().get(row);
            articleModel.setDescription(newValue);
        });

        publishedAtColumn.setCellValueFactory(new PropertyValueFactory<>("publishedAt"));
        publishedAtColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        publishedAtColumn.setOnEditCommit((TableColumn.CellEditEvent<ArticleModel, String> event) -> {
            TablePosition<ArticleModel, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            ArticleModel articleModel = event.getTableView().getItems().get(row);
            articleModel.setPublishedAt(newValue);
        });

        urlToImageColumn.setCellValueFactory(new PropertyValueFactory<>("urlToImage"));
        urlToImageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        urlToImageColumn.setOnEditCommit((TableColumn.CellEditEvent<ArticleModel, String> event) -> {
            TablePosition<ArticleModel, String> pos = event.getTablePosition();
            String newValue = event.getNewValue();
            int row = pos.getRow();
            ArticleModel articleModel = event.getTableView().getItems().get(row);
            articleModel.setUrlToImage(newValue);
        });
    }

    public void addRow(Article article) {
        data.add(new ArticleModel(article));
    }

    public static class ArticleModel {

        private final SimpleStringProperty url;
        private final SimpleStringProperty author;
        private final SimpleStringProperty title;
        private final SimpleStringProperty description;
        private final SimpleStringProperty publishedAt;
        private final SimpleStringProperty urlToImage;

        @Deprecated
        public ArticleModel(String url, String author, String title, String description, String publishedAt,
                            String urlToImage) {
            this.url = new SimpleStringProperty(url);
            this.author = new SimpleStringProperty(author);
            this.title = new SimpleStringProperty(title);
            this.description = new SimpleStringProperty(description);
            this.publishedAt = new SimpleStringProperty(publishedAt);
            this.urlToImage = new SimpleStringProperty(urlToImage);
        }

        public ArticleModel(Article article) {
            this.url = new SimpleStringProperty(article.getUrl());
            this.author = new SimpleStringProperty(article.getAuthor());
            this.title = new SimpleStringProperty(article.getTitle());
            this.description = new SimpleStringProperty(article.getDescription());
            this.publishedAt = new SimpleStringProperty(article.getPublishedAt());
            this.urlToImage = new SimpleStringProperty(article.getUrlToImage());
        }

        //for creating empty row
        public ArticleModel() {
            url = new SimpleStringProperty("null");
            author = new SimpleStringProperty("null");
            title = new SimpleStringProperty("null");
            description = new SimpleStringProperty("null");
            publishedAt = new SimpleStringProperty("null");
            urlToImage = new SimpleStringProperty("null");
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
