package sweter2_web_jdbs_boot2.service;

import sweter2_web_jdbs_boot2.domain.Message;

import java.util.List;

public interface IArticleService {
    List<Message> getAllArticles();
    void addArticle(Message article);



}
