package com.task.service;

import com.task.bean.*;
import com.task.dto.*;

public interface OrgService {

    int create(OrgBean bean);

    void update(int id, OrgBean bean);

    void purge(int id);

    OrgDTO read(int id);

}
