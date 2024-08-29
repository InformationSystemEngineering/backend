-- Insert roles
INSERT INTO role (name) VALUES ('ROLE_REGISTERED_USER');
INSERT INTO role (name) VALUES ('ROLE_SYSTEM_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_STUDENT');
INSERT INTO role (name) VALUES ('ROLE_PSYCHOLOG');
INSERT INTO role (name) VALUES ('ROLE_MANAGER');

-- Insert users
INSERT INTO users(role_id, email, image_url, last_name, name, password, username)
VALUES (2, 'admin@gmail.com', 'https://cdn-icons-png.flaticon.com/512/219/219969.png', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin'),
       (4, 'psychologist@gmail.com', 'https://cdn.pixabay.com/photo/2014/03/25/16/54/user-297566_640.png', 'Adamovic', 'Nikola', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'dzoni'),
       (5, 'katarina.medic01@gmail.com', 'https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745', 'Medic', 'Katarina', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'kaca'),
       (3, 'student@gmail.com', 'https://freesvg.org/img/1459344336.png', 'Simic', 'Sima', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'simi'),
       (4, 'daca@gmail.com', 'https://cdn4.iconfinder.com/data/icons/mixed-set-1-1/128/28-512.png', 'Dacic', 'Daca', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'daca');
        --(4, 'admin@gmail.com', 'adminic', 'admin', '$2a$10$QZbtkoO3UqIW8ataNZzkJuRHQqsvD5vaAmVUNFxQPIZZ8X0D9iTSu', 'admin', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');
        --(5, 'zarkokn@gmail.com', 'Knezevic', 'Nina', '$2y$10$HgilFq.14RicLfcPGKBOYeuplIU.wTz1NbYeSuY5fblX4TWkUj8UW', 'student1', 'https://cdn-icons-png.flaticon.com/512/219/219969.png');

-- Insert students
INSERT INTO student(id, faculty_name)
VALUES (4, 'Psiholoski fakultet NS');

-- Insert psychologists
INSERT INTO psychologist(id, biography)
VALUES (2, 'super'),
       (5, 'ok');


-- Insert faculties
INSERT INTO faculty(id, name, active_contract, photo, email)
VALUES (1, 'Harvard University - Department of Psychology', TRUE, 'https://imageio.forbes.com/specials-images/dam/imageserve/503064668/960x0.jpg?height=474&width=711&fit=bounds', 'katarina.medic01@gmail.com'),
       (2, 'Stanford University - Department of Psychology', TRUE, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-hblL-wFX2-M2bws2XVSIZ2U8UUxrmqEvBA&s', 'katarina.medic01@gmail.com'),
       (3, 'University of California, Berkeley - Department of Psychology', TRUE, 'https://psychology.berkeley.edu/sites/default/files/styles/1000x400sc/public/img_1945.jpg?itok=d_0ve2Io', 'katarina.medic01@gmail.com'),
       (4, 'University of Oxford - Department of Experimental Psychology', TRUE, 'https://www.accessguide.ox.ac.uk/sites/default/files/styles/listing_tile_text_displayed_image/public/accessguide/images/media/new_radcliffe_house_1of1.jpg?itok=34G0tlwB', 'katarina.medic01@gmail.com'),
       (5, 'University of Cambridge - Department of Psychology', TRUE, 'https://d3d00swyhr67nd.cloudfront.net/w800h800/PSY_location_image_1.jpg', 'katarina.medic01@gmail.com'),
       (6, 'Yale University - Department of Psychology', TRUE, 'https://fastly.4sqi.net/img/general/600x600/84154773_raQYLNj4t4CPhQeDPDVeNkBRUcW22bek1CC8GRkI-lQ.jpg', 'katarina.medic01@gmail.com');

-- Insert request
INSERT INTO request(name, start_date, end_date, faculty_id, user_id, description, status)
VALUES ('Psychology Summit International', '2024-09-10', '2024-09-15', 1, 3, 'I am writing to request your approval for the proposed date for the upcoming fair. We would like to confirm this date to proceed with further planning.', 0),
       ('Global Psychology Forum',  '2024-09-14', '2024-09-30', 2, 3, 'I am writing to request your approval for the proposed date for the upcoming fair. We would like to confirm this date to proceed with further planning.', 0),
       ('International Psychologists Expo', '2024-09-23', '2024-09-27', 3, 3, 'I am writing to request your approval for the proposed date for the upcoming fair. We would like to confirm this date to proceed with further planning.', 0),
       ('International Psychologists Fair', '2024-08-30', '2024-08-31', 3, 3, 'I am writing to request your approval for the proposed date for the upcoming fair. We would like to confirm this date to proceed with further planning.', 0);

-- Insert classroom
INSERT INTO classroom(name, date, start_time, end_time, floor, capacity, request_id)
VALUES ('A1', '2024-09-11', '08:30:00', '10:00:00', 1, 60, 1),
       ('A2', '2024-09-11', '10:30:00', '11:00:00', 1, 45, 1),
       ('A3', '2024-09-11', '10:00:00', '13:00:00', 1, 13, 1),
       ('205', '2024-09-12', '08:30:00', '10:00:00', 2, 35, 1),
       ('206', '2024-09-12', '09:30:00', '11:00:00', 2, 20, 1),
       ('A3', '2024-09-13', '10:00:00', '13:00:00', 1, 13, 1),
       ('A2', '2024-09-12', '10:30:00', '11:00:00', 1, 45, 2),
       ('A2', '2024-08-30', '10:30:00', '11:00:00', 1, 45, 4),
       ('A2', '2024-08-31', '10:30:00', '11:00:00', 1, 45, 4);


-- Insert fairs
INSERT INTO fair(approved_start_date, approved_end_date, request_id, is_publish)
VALUES ('2024-09-11', '2024-09-13',  1, false),
       ('2024-09-15', '2024-09-20', 2, true),
       ('2024-09-23', '2024-09-27', 3, false),
       ('2024-08-30', '2024-08-31', 4, true);
--        (4, 'Worldwide Psychology Conference', 'Explore diverse perspectives on psychology at the Worldwide Psychology Conference, fostering dialogue on mental health and well-being globally.', '2024-07-06', '09:00:00', '17:30:00', 4, true),
--        (5, 'Global Minds Conference', 'Engage with thought leaders and influencers at the Global Minds Conference, addressing critical issues in psychology affecting communities worldwide.', '2024-06-29', '09:00:00', '17:30:00', 5, false),
--        (6, 'Cross-Cultural Psychology Symposium', 'Delve into the intersection of cultures and psychology at the Cross-Cultural Psychology Symposium, exploring how cultural contexts shape mental health practices.', '2024-07-01', '09:00:00', '17:30:00', 3, false),
--        (7, 'Global Perspectives in Psychology Fair', 'Gain insights into global trends in psychology at the Global Perspectives in Psychology Fair, featuring interactive sessions and expert panels.', '2024-07-07', '09:00:00', '17:30:00', 2, false),
--        (8, 'International Psychology Convention', 'Connect with peers and experts at the International Psychology Convention, focusing on advancements in clinical and experimental psychology.', '2024-07-03', '09:00:00', '17:30:00', 5, false),
--        (9, 'Psychology Innovations Summit', 'Join us at the Psychology Innovations Summit to explore cutting-edge technologies and innovative approaches transforming the field of psychology.', '2024-06-28', '09:00:00', '17:30:00', 1, false);


-- Insert reservation
INSERT INTO reservation(start_time, end_time, classroom_id)
VALUES ('08:30:00', '09:30:00', 1),
       ('10:30:00', '11:00:00', 2),
       ('10:30:00', '11:00:00', 8);


-- Insert topic
INSERT INTO topic(name, duration, available_spots, fair_id, psychologist_id, reservation_id)
VALUES ('The Impact of Social Media on Mental Health', 1, 40, 1, 2, 1),
       ('Mindfulness and Stress Reduction Techniques', 0.5, 15, 2, 2, 2),
       ('Mindfulness and Stress Reduction Techniques', 0.5, 15, 4, 2, 3);


-- Insert application
INSERT INTO application(name, surname, study_year, email, student_id, topic_id)
VALUES ('Sima', 'Simic', '4', 'sima@gmail.com', 4, 3);