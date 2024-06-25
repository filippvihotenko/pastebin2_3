CREATE TABLE roles (
            uuid UUID PRIMARY KEY NOT NULL,
            name VARCHAR(255) UNIQUE NOT NULL,
            description VARCHAR(255) NOT NULL,
                       created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);