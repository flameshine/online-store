INSERT INTO users (user_id, activity, email, first_name, last_name, password, username) VALUES (1, 1, 'excellenceissoon@gmail.com', 'Anton', 'Pokhyla', '$2a$10$8rpziPWIPnZYGeky0c52v.mNYW7qhcEavXZBMdP60AknWbkGczgZ2', 'admin');

INSERT INTO roles (role_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (role_id, role_name) VALUES (2, 'ROLE_USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);

INSERT INTO products (description, name, price, quantity) VALUES ('modern smartphone', 'phone', 350.00, 3);
INSERT INTO products (description, name, price, quantity) VALUES ('old japan clock', 'clock', 175.00, 1);