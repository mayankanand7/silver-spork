package com.task.service;

import com.task.bean.*;
import com.task.dto.*;


public interface UserService {

    int create(UserBean bean);

    void update(int id, UserBean bean);

    void purge(int id);

    UserDTO read(int id);

}
