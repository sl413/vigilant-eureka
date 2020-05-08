package com.slaip;

import com.slaip.media.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ArticleDao {
    public void saveArticle(Article article) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(article);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Article> getArticles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Article", Article.class).list();
        }
    }
}
