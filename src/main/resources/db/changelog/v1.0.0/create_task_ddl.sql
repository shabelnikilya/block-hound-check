--liquibase formatted sql
--changeset ilya.sh:1
CREATE TABLE IF NOT EXISTS task (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--rollback DROP TABLE user;
