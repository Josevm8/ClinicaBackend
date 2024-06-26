

INSERT INTO menu(id_menu, name, icon, url) VALUES (1, 'Dashboard', 'home', '/pages/dashboard');
INSERT INTO menu(id_menu, name, icon, url) VALUES (2, 'Search', 'search', '/pages/search');
INSERT INTO menu(id_menu, name, icon, url) VALUES (3, 'Consult Wizard', 'view_carousel', '/pages/consult-wizard');
INSERT INTO menu(id_menu, name, icon, url) VALUES (4, 'Specialties', 'star_rate', '/pages/specialty');
INSERT INTO menu(id_menu, name, icon, url) VALUES (5, 'Medics', 'healing', '/pages/medic');
INSERT INTO menu(id_menu, name, icon, url) VALUES (6, 'Exams', 'assignment', '/pages/exam');
INSERT INTO menu(id_menu, name, icon, url) VALUES (7, 'Patients', 'accessibility', '/pages/patient');
INSERT INTO menu(id_menu, name, icon, url) VALUES (8, 'Reports', 'assessment', '/pages/report');

INSERT INTO Role (id_role, name, description) VALUES (1, 'ADMIN', 'Administrador');
INSERT INTO Role (id_role, name, description) VALUES (2, 'USER', 'Usuario');
INSERT INTO Role (id_role, name, description) VALUES (3, 'DBA', 'Admin de bd');


INSERT INTO menu_role (id_menu, id_role) VALUES (1, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (2, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (3, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (4, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (5, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (6, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (7, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (8, 1);
INSERT INTO menu_role (id_menu, id_role) VALUES (1, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (3, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (4, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (5, 2);
INSERT INTO menu_role (id_menu, id_role) VALUES (6, 2);

INSERT INTO user_data(id_user, username, password, enabled) values (1, 'velezmendoza8@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');
INSERT INTO user_data(id_user, username, password, enabled) values (2, 'josewvm@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');


INSERT INTO user_role (id_user, id_role) VALUES (1, 1);
INSERT INTO user_role (id_user, id_role) VALUES (1, 3);
INSERT INTO user_role (id_user, id_role) VALUES (2, 2);