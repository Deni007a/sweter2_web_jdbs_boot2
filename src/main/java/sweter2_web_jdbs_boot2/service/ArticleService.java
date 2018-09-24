package sweter2_web_jdbs_boot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sweter2_web_jdbs_boot2.repos.MessageRepos;
import sweter2_web_jdbs_boot2.domain.Message;

import java.util.List;
@Service
public class ArticleService implements IArticleService {

    @Autowired
    private MessageRepos articleDAO;

    @Override
    public List<Message> getAllArticles() {
        return articleDAO.getAllМessage();
    }

    @Override
    public synchronized void addArticle(Message message) {
        articleDAO.addArticle(message);
    }
}
