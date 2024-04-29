INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
    role_id, email, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin'),
       (4, 'psychologist@gmail.com', 'Adamovic', 'Nikola', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'dzoni'),
(5, 'katarina.medic01@gmail.com', 'Medic', 'Katarina', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'kaca');

INSERT INTO faculty(
    name, is_Free)
VALUES ('Fakultet psihologije', TRUE),
       ('Fakultet drustvenih nauka', TRUE),
       ('Edukons psihologija', TRUE);

INSERT INTO fair(
    name, description, date, start_time, end_time, faculty_id)
VALUES ('Fair 1', 'super sajam', '2023-12-30T08:45:00', '09:00:00', '17:30:00', 1),
       ('Fair 2', 'dobar sajam', '2023-12-30T08:45:00', '09:00:00', '17:30:00', 2),
       ('Fair 3', 'odlican sajam', '2023-12-30T08:45:00', '09:00:00', '17:30:00', 3);