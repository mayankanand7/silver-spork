package com.task.service;

import com.task.bean.*;
import com.task.dto.*;


public interface TaskService {

    int create(TaskBean bean);

    void update(int id, TaskBean bean);

    void purge(int id);

    TaskDTO read(int id);

}
