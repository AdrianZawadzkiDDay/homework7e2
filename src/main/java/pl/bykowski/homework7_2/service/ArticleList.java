package pl.bykowski.homework7_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.homework7_2.model.Example;
import pl.bykowski.homework7_2.repository.ArticleDAOList;

@Service
public class ArticleList {

    RestTemplate restTemplate;   // create HTTP client
    Example example;
    ArticleDAOList articleDaoList;

    @Autowired
    public ArticleList(ArticleDAOList articleDaoList) {
        this.articleDaoList = articleDaoList;
        restTemplate = new RestTemplate();
        get();
    }


    public void get(){
        String url =  "http://newsapi.org/v2/everything?q=diving&sortBy=publishedAt&apiKey=d6a95994c8494860b37eb49f1921e372";
        Example forObject = restTemplate.getForObject(url, Example.class);
            for (int i = 0; i <1 ; i++) {
                articleDaoList.saveArticle(forObject.getArticles().get(i).getAuthor(), forObject.getArticles().get(i).getTitle(),
                            forObject.getArticles().get(i).getContent());
            }
    }


}
