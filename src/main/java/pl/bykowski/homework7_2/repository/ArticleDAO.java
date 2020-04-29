package pl.bykowski.homework7_2.repository;

import pl.bykowski.homework7_2.service.ArticleDB;
import java.util.List;

public interface ArticleDAO {

    void saveArticle(String author, String title, String content);

    List<ArticleDB> findAll();

    void updateArticle(ArticleDB newArticle);

    void deleteArticle(long id);

    ArticleDB getOne(long id);




}
