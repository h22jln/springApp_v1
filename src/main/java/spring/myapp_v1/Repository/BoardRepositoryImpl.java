package spring.myapp_v1.Repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring.myapp_v1.Domain.Board;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
public class BoardRepositoryImpl implements BoardRepository {
    private final JdbcTemplate template;

    public BoardRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Board board) {
        String sql = "insert into board(name,content,password,ckPrivate) values(?,?,?,?)";
        int update = template.update(sql, board.getName(), board.getContent(), board.getPassword(), board.isCkPrivate());
        return update;
    }

    @Override
    public List<Board> selectBoards() {
        String sql = "SELECT * FROM board";
        return template.query(sql, boardRowMapper());
    }

    private RowMapper<Board> boardRowMapper() {
        return (rs, rowNum) -> {
            Board board = new Board(
                    rs.getString("name"),
                    rs.getString("content"),
                    rs.getString("password")
            );
            board.setCreated_at(rs.getString("created_at"));
            board.setCkPrivate(rs.getBoolean("ckPrivate"));
            return board;
        };
    }
}
