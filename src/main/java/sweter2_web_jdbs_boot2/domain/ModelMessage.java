package sweter2_web_jdbs_boot2.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMessage implements RowMapper<Message> {

// ResultSet  с помощью этого класса  мапится модель
    @Override
    public Message mapRow(ResultSet resultSet, int i) throws SQLException {
        Message message = new Message();
        // сетим  месадж
        message.setId( //  получаем данные из бд ("имя колонки в бд")
                resultSet.getInt("id"));
        message.setText(resultSet.getString("text"));
        message.setTag(resultSet.getString("tag"));
        return message;
    }
}
