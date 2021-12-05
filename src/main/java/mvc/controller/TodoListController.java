package mvc.controller;

import mvc.dao.TodoListDao;
import mvc.model.Task;
import mvc.model.TodoList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoListController {
    TodoListDao todoListDao;

    public TodoListController(TodoListDao todoListDao) {
        this.todoListDao = todoListDao;
    }

    @RequestMapping(value = "/add-list", method = RequestMethod.POST)
    public String addTodoList(@ModelAttribute("todoList")TodoList todoList) {
        todoListDao.addTodoList(todoList);
        return "redirect:/get-lists";
    }

    @RequestMapping(value = "/remove-list", method = RequestMethod.POST)
    public String removeTodoList(@RequestParam int id) {
        todoListDao.removeTodoList(id);
        return "redirect:/get-lists";
    }

    @RequestMapping(value = "/get-lists", method = RequestMethod.GET)
    public String getAllLists(ModelMap map) {
        map.addAttribute("lists", todoListDao.getAllLists());
        map.addAttribute("list", new TodoList());
        map.addAttribute("task", new Task());
        return "index";
    }
}
