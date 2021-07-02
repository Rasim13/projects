package ru.itis.site.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.site.model.Movie;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepositoryJdbcTemplateImpl implements MovieRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private static final String SQL_SEARCH = "select * from movie where movie_title ilike = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from movie";

    public MovieRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // строка из БД мапиться (сопоставляется) в модель Movie
    private RowMapper<Movie> movieRowMapper = (row, rowNUmber) ->
            Movie.builder()
                    .id(row.getLong("id"))
                    .movieTitle(row.getString("movie_title"))
                    .build();

    @Override
    public List findAll() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL, movieRowMapper);
    }

    @Override
    public List<Movie> findByMovieContains(String title) {
        Map<String, Object> params = Collections.singletonMap("query","%" + title + "%");
        return namedParameterJdbcTemplate.query(SQL_SEARCH, params, movieRowMapper);
    }
}
