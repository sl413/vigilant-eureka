package com.slaip;

import com.slaip.media.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// TODO: 5/8/20 need DI?
public class ArticleDao {

    // TODO: 5/8/20 research: it's the only way to save?
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
