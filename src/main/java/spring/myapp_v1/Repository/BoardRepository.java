package spring.myapp_v1.Repository;

import spring.myapp_v1.Domain.Board;

import java.util.List;


public interface BoardRepository {
    int save(Board board);

    List<Board> selectBoards();
}
