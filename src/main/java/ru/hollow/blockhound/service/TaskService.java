package ru.hollow.blockhound.service;


import reactor.core.publisher.Mono;
import ru.hollow.blockhound.task.tables.pojos.Task;

public interface TaskService {

    Mono<Task> save(Task task);
}
