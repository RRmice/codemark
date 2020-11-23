
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  login                 VARCHAR(50),
  name                  VARCHAR(50),
  password              VARCHAR(50),

  PRIMARY KEY (login)
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id                    bigserial,
  name                  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
  user_login            VARCHAR(50) NOT NULL,
  role_id               INT         NOT NULL,
  PRIMARY KEY (user_login, role_id),
  FOREIGN KEY (user_login) REFERENCES users (login),
  FOREIGN KEY (role_id) REFERENCES roles (id)
);


INSERT INTO users (login, name, password)
VALUES
('VASYA', 'Vasya', '123'),
('PETYA', 'Petya', '321');

INSERT INTO roles (name)
VALUES
('ROLE_ANALYST'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

INSERT INTO users_roles (user_login, role_id)
VALUES
('VASYA', 3),
('VASYA', 2),
('PETYA', 2),
('PETYA', 1);
