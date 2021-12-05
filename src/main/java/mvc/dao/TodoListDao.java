package mvc.dao;

import mvc.model.Task;
import mvc.model.TodoList;

import java.util.List;

public interface TodoListDao {
    int addTodoList(TodoList todoList);

    void removeTodoList(int id);

    List<TodoList> getAllLists();

    void addTaskToList(int listId, Task task);
}
