package spring.myapp_v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.myapp_v1.Repository.BoardRepository;
import spring.myapp_v1.Repository.BoardRepositoryImpl;
import spring.myapp_v1.Service.BoardService;

import javax.sql.DataSource;

@Configuration
public class BoardConfig {
    private final DataSource dataSource;

    public BoardConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    BoardRepository boardRepository(){
        return new BoardRepositoryImpl(dataSource);
    }

    @Bean
    BoardService boardService(){
        return new BoardService(boardRepository());
    }
}
