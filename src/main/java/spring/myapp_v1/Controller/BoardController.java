package spring.myapp_v1.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.myapp_v1.Domain.Board;
import spring.myapp_v1.Service.BoardService;

import java.util.List;

@Slf4j
@Controller
public class BoardController {
    BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Board board, Model model){
        // DB에 저장하고
        boardService.save(board);

        // 저장된 모든 값을 가져온다
        List<Board> boards = boardService.selectBoards();
        model.addAttribute("boards", boards);

        return "read";
    }
}
