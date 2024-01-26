package spring.myapp_v1.Repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.myapp_v1.Domain.Board;

import javax.sql.DataSource;
@Slf4j
public class BoardRepositoryImpl implements BoardRepository {
    private final JdbcTemplate template;

    public BoardRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Board board) {
        String sql = "insert into board(name,content,password,ckPrivate) values(?, ?,?,?)";
        int update = template.update(sql, board.getName(), board.getContent(), board.getPassword(), board.isCkPrivate());
        return update;
    }
}
