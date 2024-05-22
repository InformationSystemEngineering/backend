INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(role_id, email, last_name, name, password, username)
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

--     role_id, email, last_name, name, password, username, image_url)
-- VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');
--
--
-- INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
-- VALUES (3, 'zarkokn@gmail.com', 'Knezevic', 'Nina', '$2y$10$HgilFq.14RicLfcPGKBOYeuplIU.wTz1NbYeSuY5fblX4TWkUj8UW', 'student1', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');
--
-- INSERT INTO student(id, faculty_name)
-- VALUES (2, 'Psiholoski fakultet NS');
--
-- INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
-- VALUES (3, 'student2@gmail.com', 'Boskovic', 'Ana', '$2y$10$XeHBUEM6tbR2LFj8VaBuz.yv1QSdn8X0vVidt/3Yais4mA8oBLyT2', 'student2', 'https://cdn-icons-png.freepik.com/256/3135/3135715.png?semt=ais_hybrid');
--
INSERT INTO student(id, faculty_name)
VALUES (1, 'Privatni psiholoski fakultet BG');
--
-- INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
-- VALUES (3, 'student3@gmail.com', 'Jovic', 'Helena', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student3', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');
--
-- INSERT INTO student(id, faculty_name)
-- VALUES (4, 'Psiholoski fakultet EDUCONS');
--
INSERT INTO hall (name, capacity)
VALUES ('Hall A', 100);

INSERT INTO hall (name, capacity)
VALUES ('Hall B', 150);

INSERT INTO internship (title, date, category, image_url)
VALUES ('Extra Psychology Internship', '2024-09-15', 1, 'https://www.myconsultingoffer.org/wp-content/uploads/Consulting-Internship.png');

INSERT INTO internship (title, date, category, image_url)
VALUES ('Modern Psychology Internship', '2024-10-20', 2, 'https://www.usatoday.com/gcdn/-mm-/db4d91ab7b5a4bd4f81da93a6d7056902c8c6aa1/c=0-473-7904-4939/local/-/media/2018/06/20/USATODAY/USATODAY/636651170533306247-intern-1.jpg');

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (false, 100, '2024-09-20', null, 1);

INSERT INTO internship_test (test_reviewed, max_points, date, time, internship_id)
VALUES (true, 100, '2023-10-25', '10:00:00', 2);

INSERT INTO hall_reservation (date, duration, time, hall_id, internship_test_id)
VALUES  ('2024-09-20', 3, '11:00:00', 1, 2);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (1, 1, 0, false);

-- INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
-- VALUES (3, 1, 0, false);
--
-- INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
-- VALUES (4, 1, 75, true);
--
-- INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
-- VALUES (2, 2, 0, false);
--
-- INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
-- VALUES (3, 2, 0, false);
--
-- INSERT INTO users(
--     role_id, email, last_name, name, password, username, image_url)
-- VALUES (5, 'menadzer@gmail.com', 'Lazic', 'Ana', '$2y$10$tQTm6Mf6G93ftNmf.NuFb.37OwqSRAII9bqgvIOaU3P45SxxgOrFO', 'menadzer', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');
--
-- INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
-- VALUES (4, 'psiholog@gmail.com', 'Knezevic', 'Zarko', '$2a$12$gjNONuZTM43S47DRK21c1ugkw1sUQS1OiXMFsOkiOHaZ/HsmGe6fu', 'psiholog', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');
--
-- INSERT INTO psychologist(id, biography)
-- VALUES (1, 'skolovani psiholog spreman na sve');
--
-- INSERT INTO student_internship(internship_id, psychologist_id, student_id)
-- VALUES (2, 1, 2);
--
-- INSERT INTO task(student_internship_id, title, description, status, priority)
-- VALUES (1, 'Adolescent Assessment Assistance', 'Assist in administering psychological assessments to adolescents, including scoring and report compilation.', 3, 1);
--
-- INSERT INTO task(student_internship_id, title, description, status, priority)
-- VALUES (1, 'Child Development Observation', 'Conduct observational research on child development, including participant recruitment and data analysis.', 2, 2);
--
-- INSERT INTO task(student_internship_id, title, description, status, priority)
-- VALUES (1, 'Mental Health Awareness Workshops', 'Assist in providing psychoeducation workshops on mental health, including content development and facilitation.', 0, 2);
--
-- INSERT INTO task(student_internship_id, title, description, status, priority)
-- VALUES (1, 'Parenting Skills Workshop Development', ' Develop workshops on parenting skills, covering topics such as communication and discipline techniques.', 0, 1);
