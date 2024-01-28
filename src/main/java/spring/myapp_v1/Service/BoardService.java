package spring.myapp_v1.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.myapp_v1.Domain.Board;
import spring.myapp_v1.Repository.BoardRepository;

import java.util.List;

@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public int save(Board board){
        return boardRepository.save(board);
    }

    public List<Board> selectBoards(){
        return boardRepository.selectBoards();
    }
}
