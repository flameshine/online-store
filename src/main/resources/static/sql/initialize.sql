INSERT INTO user (user_id, activity, email, first_name, last_name, password, username) VALUES (1, 1, 'admin@gmail.com', 'admin', 'admin', '$2a$10$8rpziPWIPnZYGeky0c52v.mNYW7qhcEavXZBMdP60AknWbkGczgZ2', 'admin');

INSERT INTO role (role_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (role_id, role_name) VALUES (2, 'ROLE_USER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);

INSERT INTO product (description, name, price, quantity) VALUES ('modern smartphone', 'phone', 350.00, 3);
INSERT INTO product (description, name, price, quantity) VALUES ('old japan clock', 'clock', 175.00, 2);
INSERT INTO product (description, name, price, quantity) VALUES ('leather cap from Germany', 'cap', 55.00, 5);
INSERT INTO product (description, name, price, quantity) VALUES ('interesting book', 'book', 25.50, 15);
INSERT INTO product (description, name, price, quantity) VALUES ('ancient jade mask', 'jade mask', 750.00, 1);
INSERT INTO product (description, name, price, quantity) VALUES ('beautiful postcard', 'postcard', 2.75, 100);
INSERT INTO product (description, name, price, quantity) VALUES ('modern headphones', 'headphones', 100.00, 2);