package ru.hollow.blockhound.repository;

import reactor.core.publisher.Mono;
import ru.hollow.blockhound.task.tables.pojos.Task;

public interface TaskRepository {

   Mono<Task> save(Task task);
}
