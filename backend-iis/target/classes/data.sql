INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin'),
       (4, 'psychologist@gmail.com', 'Adamovic', 'Nikola', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'dzoni'),
(5, 'katarina.medic01@gmail.com', 'Medic', 'Katarina', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'kaca'),
       (3, 'student@gmail.com', 'Simic', 'Sima', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'simi');

INSERT INTO faculty(
    name, is_Free)
VALUES ('Fakultet psihologije', TRUE),
       ('Fakultet drustvenih nauka', TRUE),
       ('Edukons psihologija', TRUE);

INSERT INTO psychologist(id, biography)
VALUES (1, 'super'),
       (2, 'ok');

-- INSERT INTO fair_psychology(fair_id, psychologist_id)
-- VALUES (1, 1),
--        (1, 2);
--
-- INSERT INTO extra_activity(end_time, start_time, date, fair_psychology_id, activity_type, classroom, name)
-- VALUES ('08:00:00', '09:00:00', '2023-12-30', 1, 'ok', 'A2', 'act1');

INSERT INTO fair(
    name, description, date, start_time, end_time, faculty_id, publish)
VALUES ('Fair 1', 'super sajam', '2023-12-30', '09:00:00', '17:30:00', 1, false),
       ('Fair 2', 'dobar sajam', '2023-12-30', '09:00:00', '17:30:00', 2, false),
       ('Fair 3', 'odlican sajam', '2023-12-30', '09:00:00', '17:30:00', 3, false);
