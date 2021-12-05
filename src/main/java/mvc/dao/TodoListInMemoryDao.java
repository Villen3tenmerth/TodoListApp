package mvc.dao;

import mvc.model.Task;
import mvc.model.TodoList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoListInMemoryDao implements TodoListDao {
    private final AtomicInteger lastId = new AtomicInteger(0);
    private final List<TodoList> todoLists = new CopyOnWriteArrayList<>();

    @Override
    public int addTodoList(TodoList todoList) {
        int id = lastId.incrementAndGet();
        todoList.setId(id);
        todoLists.add(todoList);
        return id;
    }

    @Override
    public void removeTodoList(int id) {
        for (TodoList todoList : todoLists) {
            if (todoList.getId() == id) {
                todoLists.remove(todoList);
                return;
            }
        }
    }

    @Override
    public List<TodoList> getAllLists() {
        return List.copyOf(todoLists);
    }

    @Override
    public void addTaskToList(int listId, Task task) {
        for (TodoList todoList : todoLists) {
            if (todoList.getId() == listId) {
                todoList.addTask(task);
                return;
            }
        }
    }
}
