
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


-- drop table if exists products cascade;
-- create table products (id bigserial, title varchar(255), category_id bigint, description varchar(5000), price numeric(8, 2), primary key(id), constraint fk_cat_id foreign key (category_id) references categories (id));
-- insert into products
-- (title, category_id, description, price) values
-- ('Milk', 1, 'Fresh Milk', 80.0),
-- ('Bread', 1, 'Fresh Bread', 30.0),
-- ('Meat', 1, 'Fresh Meat', 200.0),
-- ('Chocolate', 1, 'FChocolate', 70.0),
-- ('Juice', 1, 'Fresh Juice', 50.0),
-- ('NoteBook ASUS X1000', 2, 'Model: ASUS X1000, CPU: Xeon N700, RAM: 128 Gb, SSD: 1Tb', 25000.0);
--

--

--
-- INSERT INTO users (phone, password, first_name, last_name, email)
-- VALUES
-- ('anonymous','1','Anonymous','Anonymous','shop@shop.com'),
-- ('11111111','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i','Admin','Admin','admin@gmail.com');
--
-- INSERT INTO users_roles (user_id, role_id)
-- VALUES
-- (1, 1),
-- (1, 2),
-- (1, 3);
--
-- drop table if exists orders cascade;
-- create table orders (id bigserial, user_id bigint, price numeric(8, 2) not null, address varchar (255) not null, phone_number varchar(30) not null, confirm_order int, primary key(id), constraint fk_user_id foreign key (user_id) references users (id));
--
-- drop table if exists orders_items cascade;
-- create table orders_items (id bigserial, order_id bigint, product_id bigint, quantity int, price numeric(8, 2), primary key(id), constraint fk_prod_id foreign key (product_id) references products (id), constraint fk_order_id foreign key (order_id) references orders (id));
--
-- drop table if exists reviews cascade;
-- create table reviews (id bigserial, user_id bigint, product_id bigint, content varchar(5000), value int, primary key(id), foreign key (product_id) references products (id), foreign key (user_id) references users (id));