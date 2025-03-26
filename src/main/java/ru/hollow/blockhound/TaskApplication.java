package ru.hollow.blockhound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class TaskApplication {

    /**
     * Инициализация blockhount с исключением из проверок java.util.UUID.randomUUID().
     * Метод выше блокирующий, но в рамках опробывания либы, я решил его исключить и посмотреть как он отловит
     * блокирующие вызовы на уровне вызова jdbc драйвера блокирующего.
     */
    static {
        BlockHound.builder()
                .loadIntegrations()
                .allowBlockingCallsInside("java.util.UUID", "randomUUID")
                .install();


    }

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
