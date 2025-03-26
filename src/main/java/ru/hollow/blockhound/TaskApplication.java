package ru.hollow.blockhound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class TaskApplication {

    /**
     * Инициализация blockhount с исключением из проверок java.util.UUID.randomUUID().
     * Метод выше под капотом успользует блокирующий I/O, но пишется, что на самом деле блокировки не происходитб
     * поэтому он в исключениях и внимание сконцентрированно на блокирующем драйвере для postgresql.
     */
    static {
        BlockHound
                .builder()
                .loadIntegrations()
                .allowBlockingCallsInside("java.util.UUID", "randomUUID")
                .install();
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
