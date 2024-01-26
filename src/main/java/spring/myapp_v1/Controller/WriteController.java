package spring.myapp_v1.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.myapp_v1.Domain.Board;
import spring.myapp_v1.Service.BoardService;

@Slf4j
@Controller
public class WriteController {
    BoardService boardService;
    @Autowired
    public WriteController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Board board){
        log.info(board.toString());
        boardService.save(board);
        return "read";
    }
}
