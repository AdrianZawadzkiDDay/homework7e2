package pl.bykowski.homework7_2.service;

import org.springframework.stereotype.Service;

@Service
public class ArticleDB {

    private long articleId;
    private String author;
    private String title;
    private String content;

    public ArticleDB() {
    }
    public ArticleDB(long article_id, String author, String title, String content) {
        this.articleId=  article_id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public ArticleDB(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "ArticleDB{" +
                "articleId=" + articleId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
