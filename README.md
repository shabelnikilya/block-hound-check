# BlockHound Check: Тестирование обнаружения блокирующих вызовов JDBC

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen)](https://spring.io/projects/spring-boot)
[![BlockHound](https://img.shields.io/badge/BlockHound-1.0.11.RELEASEE-orange)](https://github.com/reactor/BlockHound)

Проект предназначен для проверки работы библиотеки **BlockHound** - инструмента для обнаружения блокирующих вызовов в реактивных приложениях. В частности, проверяется детектирование блокирующих операций JDBC драйвера PostgreSQL.

## Основная цель

Проверить, что BlockHound:
1. Обнаруживает блокирующий вызов в `PgConnection` драйвера postgresql
2. При вызове эндпоинта `/v1/tasks` выбрасывается `BlockingOperationError`

## Технологии

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring webflux**
- **BlockHound 1.0.11.RELEASE**
- **PostgreSQL JDBC Driver**