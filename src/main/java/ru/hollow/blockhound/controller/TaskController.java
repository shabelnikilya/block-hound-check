package ru.hollow.blockhound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.hollow.blockhound.dto.TaskDto;
import ru.hollow.blockhound.service.TaskService;
import ru.hollow.blockhound.task.tables.pojos.Task;

import java.time.LocalDateTime;
import java.util.UUID;

@RequestMapping("/v1/tasks")
@RestController()
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping()
    public Mono<ResponseEntity<String>> save(@RequestBody TaskDto request) {
        return service.save(toPojo(request))
                .map(
                        id -> new ResponseEntity<>(id.toString(), HttpStatus.OK)
                )
                .switchIfEmpty(
                        Mono.just(
                                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                        )
                );
    }


    private Task toPojo(TaskDto dto) {
        return new Task(
                UUID.randomUUID(),
                dto.name(),
                dto.createdBy(),
                dto.description(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
