package sweter2_web_jdbs_boot2.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sweter2_web_jdbs_boot2.domain.Message;
import sweter2_web_jdbs_boot2.domain.ModelMessage;

import java.util.List;

@Transactional()
@Repository

public class MessageReposDAO implements MessageRepos {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Message> getAllМessage() {

        String sql = "SELECT id, text, tag FROM messages";

        //Интерфейс, используемый JdbcTemplate для сопоставления строк
        // ResultSet(из нашей ModelMessage)
        // для каждой строки. Реализации этого интерфейса выполняют фактическую работу
        // по отображению каждой строки в объект результата,
        // но не нужно беспокоиться об обработке исключений.
        RowMapper<Message> rowMapper = new ModelMessage();
        return this.jdbcTemplate.query(sql, rowMapper);

    }

    @Override
    public void addArticle(Message message) {

        String sql = "INSERT INTO messages (id, text, tag) values (?, ?, ?)";
        jdbcTemplate.update(sql, message.getId(), message.getText(), message.getTag());

//        //Fetch article id
//        sql = "SELECT id FROM messages WHERE text = ? and tag=?";
//        int articleId = jdbcTemplate.queryForObject(sql, Integer.class,
//                message.getText(), message.getTag());
//
//        //Set article id
//        message.setId(articleId);

    }


}
