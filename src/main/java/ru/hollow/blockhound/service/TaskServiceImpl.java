package ru.hollow.blockhound.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.hollow.blockhound.repository.TaskRepository;
import ru.hollow.blockhound.task.tables.pojos.Task;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Task> save(Task task) {
        return repository.save(task);
    }
}
