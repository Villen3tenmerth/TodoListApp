package mvc.dao;

import mvc.model.Task;

public interface TaskDao {
    int addTask(Task task);

    void updateStatus(int id, boolean completed);
}
