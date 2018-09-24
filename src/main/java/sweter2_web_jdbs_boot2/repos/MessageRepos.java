package sweter2_web_jdbs_boot2.repos;


import sweter2_web_jdbs_boot2.domain.Message;

import java.util.List;

//  это наш урезаный     CRUD
public interface MessageRepos {
    // создаем метот который ищет тег и  возвращает колекцию наденого
    List<Message> getAllМessage();
    void addArticle(Message message);
   // boolean articleExists(String text, String tag);


}

