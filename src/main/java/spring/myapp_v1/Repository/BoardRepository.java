package spring.myapp_v1.Repository;

import spring.myapp_v1.Domain.Board;


public interface BoardRepository {
    int save(Board board);
}
