package sweter2_web_jdbs_boot2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sweter2_web_jdbs_boot2.repos.MessageRepos;
import sweter2_web_jdbs_boot2.domain.Message;


import java.util.Map;

//greeting?name=vvvv

@Controller
public class GreetingController {
    @Autowired
    private MessageRepos messageRepos;




    @RequestMapping(name = "", method = RequestMethod.GET)
    public String main(Map<String, Object> model) {

        Iterable<Message> messages = messageRepos.getAllМessage();
        model.put("messages", messages);
        return "main";
    }



    // контролер для формы

    @PostMapping
    public String add( Message mes,
            @RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        // создаем  по полученным данным обект  месадж


        Message message = new Message();
        message.setText(text);
        message.setTag(tag);
        // сохраняем  ево в бд

        messageRepos.addArticle(message);
        // тут  мы  берм  данный из репозитория
        Iterable<Message> messages = messageRepos.getAllМessage();
        // ложим их в  модель и отдаем  пользователю
        model.put("messages", messages);

        return "main";
    }


}


