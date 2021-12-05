package mvc.config;

import mvc.dao.TaskDao;
import mvc.dao.TaskInMemoryDao;
import mvc.dao.TodoListDao;
import mvc.dao.TodoListInMemoryDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryDaoContextConfiguration {
    @Bean
    public TaskDao taskDao() {
        return new TaskInMemoryDao();
    }

    @Bean
    public TodoListDao todoListDao() {
        return new TodoListInMemoryDao();
    }
}
