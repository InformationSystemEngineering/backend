-- Insert roles
INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

-- Insert users
INSERT INTO users(role_id, email, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin'),
       (4, 'psychologist@gmail.com', 'Adamovic', 'Nikola', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'dzoni'),
       (5, 'katarina.medic01@gmail.com', 'Medic', 'Katarina', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'kaca'),
       (3, 'student@gmail.com', 'Simic', 'Sima', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'simi');

-- Insert faculties
INSERT INTO faculty(id, name, is_Free, photo)
VALUES (1, 'Harvard University - Department of Psychology', TRUE, 'https://imageio.forbes.com/specials-images/dam/imageserve/503064668/960x0.jpg?height=474&width=711&fit=bounds'),
       (2, 'Stanford University - Department of Psychology', TRUE, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-hblL-wFX2-M2bws2XVSIZ2U8UUxrmqEvBA&s'),
       (3, 'University of California, Berkeley - Department of Psychology', FALSE, 'https://psychology.berkeley.edu/sites/default/files/styles/1000x400sc/public/img_1945.jpg?itok=d_0ve2Io'),
       (4, 'University of Oxford - Department of Experimental Psychology', FALSE, 'https://www.accessguide.ox.ac.uk/sites/default/files/styles/listing_tile_text_displayed_image/public/accessguide/images/media/new_radcliffe_house_1of1.jpg?itok=34G0tlwB'),
       (5, 'University of Cambridge - Department of Psychology', TRUE, 'https://d3d00swyhr67nd.cloudfront.net/w800h800/PSY_location_image_1.jpg'),
       (6, 'Yale University - Department of Psychology', TRUE, 'https://fastly.4sqi.net/img/general/600x600/84154773_raQYLNj4t4CPhQeDPDVeNkBRUcW22bek1CC8GRkI-lQ.jpg');

-- Insert psychologists
INSERT INTO psychologist(id, biography)
VALUES (1, 'super'),
       (2, 'ok');

-- Insert fairs
INSERT INTO fair(id, name, description, date, start_time, end_time, faculty_id, publish)
VALUES (1, 'Psychology Summit International', 'Join us at the Psychology Summit International where global experts gather to discuss the latest advancements and challenges in psychology.', '2024-07-05', '09:00:00', '17:30:00', 1, false),
       (2, 'Global Psychology Forum', 'The Global Psychology Forum is a premier gathering of psychologists from around the world, focusing on collaborative research and innovative practices.', '2024-06-02', '09:00:00', '17:30:00', 2, true),
       (3, 'International Psychologists Expo', 'Discover groundbreaking research and network with leading psychologists at the International Psychologists Expo, a hub of knowledge exchange.', '2024-07-05', '09:00:00', '17:30:00', 3, true),
       (4, 'Worldwide Psychology Conference', 'Explore diverse perspectives on psychology at the Worldwide Psychology Conference, fostering dialogue on mental health and well-being globally.', '2024-07-06', '09:00:00', '17:30:00', 4, true),
       (5, 'Global Minds Conference', 'Engage with thought leaders and influencers at the Global Minds Conference, addressing critical issues in psychology affecting communities worldwide.', '2024-06-29', '09:00:00', '17:30:00', 5, false),
       (6, 'Cross-Cultural Psychology Symposium', 'Delve into the intersection of cultures and psychology at the Cross-Cultural Psychology Symposium, exploring how cultural contexts shape mental health practices.', '2024-07-01', '09:00:00', '17:30:00', 3, false),
       (7, 'Global Perspectives in Psychology Fair', 'Gain insights into global trends in psychology at the Global Perspectives in Psychology Fair, featuring interactive sessions and expert panels.', '2024-07-07', '09:00:00', '17:30:00', 2, false),
       (8, 'International Psychology Convention', 'Connect with peers and experts at the International Psychology Convention, focusing on advancements in clinical and experimental psychology.', '2024-07-03', '09:00:00', '17:30:00', 5, false),
       (9, 'Psychology Innovations Summit', 'Join us at the Psychology Innovations Summit to explore cutting-edge technologies and innovative approaches transforming the field of psychology.', '2024-06-28', '09:00:00', '17:30:00', 1, false);

-- Insert fair_psychology
INSERT INTO fair_psychology(id, fair_id, psychologist_id)
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 3, 2),
       (4, 4, 2);

-- Insert extra_activity
INSERT INTO extra_activity(id, name, activity_type, date, start_time, end_time, classroom, capacity, fair_psychology_id)
VALUES (1, 'Workshop on Mindfulness', 'WORKSHOP', '2024-07-03', '10:00:00', '12:00:00', 'Room 101', 30, 1);

INSERT INTO extra_activity(id, name, activity_type, date, start_time, end_time, classroom, capacity, fair_psychology_id)
VALUES (2,'Lecture on Cognitive Behavioral Therapy', 'LECTURE', '2024-07-02', '13:00:00', '15:00:00', 'Room 202', 50, 2);

INSERT INTO extra_activity(id, name, activity_type, date, start_time, end_time, classroom, capacity, fair_psychology_id)
VALUES (3, 'Seminar on Child Psychology', 'COMPETITION', '2024-07-05', '09:00:00', '11:00:00', 'Room 303', 40, 3);

INSERT INTO extra_activity(id, name, activity_type, date, start_time, end_time, classroom, capacity, fair_psychology_id)
VALUES (4, 'Seminar Worldwide Conference', 'LECTURE', '2024-07-05', '09:00:00', '11:00:00', 'Room 304', 40, 4);

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
