package ru.hollow.blockhound.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.hollow.blockhound.task.tables.pojos.Task;
import ru.hollow.blockhound.task.tables.records.TaskRecord;

import static ru.hollow.blockhound.task.tables.Task.TASK;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final DSLContext context;

    @Autowired
    public TaskRepositoryImpl(DSLContext context) {
        this.context = context;
    }

    @Override
    public Mono<Task> save(Task task) {
        return Mono.just(task)
                .flatMap(t -> {
                    var taskRec = new TaskRecord(t);
                    return Mono.fromCallable(() -> context.insertInto(TASK)
                            .columns(taskRec.fields())
                            .valuesOfRecords(taskRec)
                            .returning(TASK.ID)
                            .fetchOneInto(Task.class));
                    /**
                     * Если перевести в отдельный пул bounded elastic блокирующий
                     * вызов к БД, то blockhount ругаться не будет
                     */
                            //.subscribeOn(Schedulers.boundedElastic());
                });
    }
}
