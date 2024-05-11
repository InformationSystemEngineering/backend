INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

INSERT INTO users(
    role_id, email, last_name, name, password, username, image_url)
VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');


INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'zarkokn@gmail.com', 'Knezevic', 'Nina', '$2y$10$HgilFq.14RicLfcPGKBOYeuplIU.wTz1NbYeSuY5fblX4TWkUj8UW', 'student1', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');

INSERT INTO student(id, faculty_name)
VALUES (2, 'Psiholoski fakultet NS');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student2@gmail.com', 'Boskovic', 'Ana', '$2y$10$XeHBUEM6tbR2LFj8VaBuz.yv1QSdn8X0vVidt/3Yais4mA8oBLyT2', 'student2', 'https://cdn-icons-png.freepik.com/256/3135/3135715.png?semt=ais_hybrid');

INSERT INTO student(id, faculty_name)
VALUES (3, 'Privatni psiholoski fakultet BG');

INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
VALUES (3, 'student3@gmail.com', 'Jovic', 'Helena', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student3', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');

INSERT INTO student(id, faculty_name)
VALUES (4, 'Psiholoski fakultet EDUCONS');

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
VALUES (2, 1, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (3, 1, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (4, 1, 75, true);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (2, 2, 0, false);

INSERT INTO student_test (student_id, internship_test_id, points, is_reviewed)
VALUES (3, 2, 0, false);

INSERT INTO users(
    role_id, email, last_name, name, password, username, image_url)
VALUES (5, 'menadzer@gmail.com', 'Lazic', 'Ana', '$2y$10$tQTm6Mf6G93ftNmf.NuFb.37OwqSRAII9bqgvIOaU3P45SxxgOrFO', 'menadzer', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');
