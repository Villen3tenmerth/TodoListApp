package mvc.controller;

import mvc.dao.TaskDao;
import mvc.dao.TodoListDao;
import mvc.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    private final TaskDao taskDao;
    private final TodoListDao todoListDao;

    public TaskController(TaskDao taskDao, TodoListDao todoListDao) {
        this.taskDao = taskDao;
        this.todoListDao = todoListDao;
    }

    @RequestMapping(value = "/add-task", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task, @RequestParam int listId) {
        taskDao.addTask(task);
        todoListDao.addTaskToList(listId, task);
        return "redirect:/get-lists";
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.POST)
    public String updateTask(@RequestParam int id, @RequestParam boolean completed) {
        taskDao.updateStatus(id, completed);
        return "redirect:/get-lists";
    }
}
