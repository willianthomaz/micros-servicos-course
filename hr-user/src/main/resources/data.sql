INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2y$10$/QiSqw9ZBIuXIe/c9FSc0eNtIVOEReEWti82Hr7a2wrwxPqYgOdSa');//password: 123456
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2y$10$SEPzT4ijCEz/85dnIcv95OA30ol8XAd0zs2Bw/CnH.ZE7r2GD7tce');//password: 12345

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);