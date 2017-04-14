INSERT INTO user (name, pwd) VALUES
  ('chigusa', '$2a$10$hsdeE3jev53JiV3FpYEo1.B0hwfIMB3Jr3L0LdKs764aGKgIXUWnm'),
  ('hr3lxphr6j', '$2a$10$hsdeE3jev53JiV3FpYEo1.B0hwfIMB3Jr3L0LdKs764aGKgIXUWnm');
INSERT INTO role (name) VALUES ('ROLE_PRODUCER'), ('ROLE_ADMIN');
INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1), (2, 2);
INSERT INTO product (isgm, name, producing_area, standard, user_id) VALUES
  (0, '香香鸡', '南昌', '+20', '1'),
  (0, '精英手柄', '数据删除', '黑（）剑', 1),
  (0, '蛇皮白菜', '农村', '666', 1),
  (0, '蛇皮地瓜', '农村', '666', 1),
  (0, '蛇皮土豆', '农村', '666', 1),
  (0, '蛇皮大豆', '农村', '666', 1),
  (0, '蛇皮酸菜', '农村', '666', 1),
  (0, '终极鱿鱼', '农村', '666', 1)