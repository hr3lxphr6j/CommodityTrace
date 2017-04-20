INSERT INTO user (name, pwd, email, phone) VALUES
  ('chigusa', '$2a$10$hsdeE3jev53JiV3FpYEo1.B0hwfIMB3Jr3L0LdKs764aGKgIXUWnm','123@123.com','1008611'),
  ('hr3lxphr6j', '$2a$10$hsdeE3jev53JiV3FpYEo1.B0hwfIMB3Jr3L0LdKs764aGKgIXUWnm','456@456.com','10010');
INSERT INTO role (name) VALUES ('ROLE_PRODUCER'), ('ROLE_ADMIN');
INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1), (2, 2);
INSERT INTO product (isgm, name, producing_area, standard, user_id) VALUES
  (0, '香香鸡', '南昌', '+20', '1'),
  (1, '精英手柄', '数据删除', '黑（）剑', 1),
  (0, '蛇皮白菜', '农村', '666', 1),
  (1, '蛇皮地瓜', '农村', '666', 2),
  (0, '蛇皮土豆', '农村', '666', 2),
  (1, '蛇皮大豆', '农村', '666', 2),
  (0, '蛇皮酸菜', '农村', '666', 1),
  (1, '终极鱿鱼', '农村', '666', 1);
INSERT INTO complaint (content, phone, product_id) VALUES
  ('什么蛇皮玩意', '1008611', 1),
  ('不存在的', '100811', 1);