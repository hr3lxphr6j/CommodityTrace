INSERT INTO user (name, pwd) VALUES ('chigusa', '$2a$10$hsdeE3jev53JiV3FpYEo1.B0hwfIMB3Jr3L0LdKs764aGKgIXUWnm'),
  ('hr3lxphr6j', '$2a$10$hsdeE3jev53JiV3FpYEo1.B0hwfIMB3Jr3L0LdKs764aGKgIXUWnm');
INSERT INTO role (name) VALUES ('ROLE_PRODUCER'), ('ROLE_ADMIN');
INSERT INTO user_roles (user_id, roles_id) VALUES (1, 1), (1, 2), (2, 2);