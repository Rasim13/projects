package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Message;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MessagesRepositoryJdbcTemplateImpl implements MessagesRepository {

    //language=SQL
    private static final String SQL_INSERT_MESSAGE = "insert into message(text, date_time) VALUES (?, ?)";

    //language=SQL
    private static final String SQL_INSERT_TAG = "insert into tag_message (tag, message_id) values (?, ?);";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public Optional<Message> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Message message) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement statement = connection.prepareStatement(SQL_INSERT_MESSAGE, new String[]{"id"});

                    statement.setString(1, message.getText());
                    statement.setString(2, message.getDateTime().toString());
                    return statement;
                }, keyHolder);

        message.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());

        if (message.getTags() != null && !message.getTags().isEmpty()) {
            for (String tag : message.getTags()) {
                jdbcTemplate.update(SQL_INSERT_TAG, tag, message.getId());
            }
        }

    }

    @Override
    public void update(Message account) {

    }

    @Override
    public void delete(Message account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
