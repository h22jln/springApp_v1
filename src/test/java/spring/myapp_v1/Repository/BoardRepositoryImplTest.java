package spring.myapp_v1.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import spring.myapp_v1.Domain.Board;
import spring.myapp_v1.Service.BoardService;

import javax.sql.DataSource;
@SpringBootTest
class BoardRepositoryImplTest {

    @Autowired
    BoardRepository boardRepository;
    @Autowired BoardService service;
    @TestConfiguration
    static class TestConfig {
        private final DataSource dataSource;
        public TestConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }
        @Bean
        BoardRepository repository() {
            return new BoardRepositoryImpl(dataSource);
        }
        @Bean
        BoardService service() {
            return new BoardService(repository());
        }
    }

    @Test
    void save(){
        service.save(new Board("히지누3", "content2", "23", false));
    }

    @Test
    @Transactional
    void save_fail(){
        service.save(new Board("a", "content2", "23", false));
        service.save(new Board(null, "content2", "23", false));
    }
}