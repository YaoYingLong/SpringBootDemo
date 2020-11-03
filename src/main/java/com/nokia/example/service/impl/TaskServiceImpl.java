package com.nokia.example.service.impl;

import com.nokia.example.annotation.InvokeListener;
import com.nokia.example.annotation.FieldListener;
import com.nokia.example.service.TaskService;

/**
 * @author by YingLong on 2020/10/26
 */
@InvokeListener(name = "taskService", weight = 50)
public class TaskServiceImpl implements TaskService {

    @FieldListener(value = "baseTask")
    private String taskName;

    @Override
    public String getTaskName() {
        return null;
    }
}
