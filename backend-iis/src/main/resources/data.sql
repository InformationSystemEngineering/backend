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
-- INSERT INTO faculty(id, name, is_Free, photo, email)
-- VALUES (1, 'Harvard University - Department of Psychology', TRUE, 'https://imageio.forbes.com/specials-images/dam/imageserve/503064668/960x0.jpg?height=474&width=711&fit=bounds', 'katarina.medic01@gmail.com'),
--        (2, 'Stanford University - Department of Psychology', TRUE, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-hblL-wFX2-M2bws2XVSIZ2U8UUxrmqEvBA&s', 'katarina.medic01@gmail.com'),
--        (3, 'University of California, Berkeley - Department of Psychology', TRUE, 'https://psychology.berkeley.edu/sites/default/files/styles/1000x400sc/public/img_1945.jpg?itok=d_0ve2Io', 'katarina.medic01@gmail.com'),
--        (4, 'University of Oxford - Department of Experimental Psychology', TRUE, 'https://www.accessguide.ox.ac.uk/sites/default/files/styles/listing_tile_text_displayed_image/public/accessguide/images/media/new_radcliffe_house_1of1.jpg?itok=34G0tlwB', 'katarina.medic01@gmail.com'),
--        (5, 'University of Cambridge - Department of Psychology', TRUE, 'https://d3d00swyhr67nd.cloudfront.net/w800h800/PSY_location_image_1.jpg', 'katarina.medic01@gmail.com'),
--        (6, 'Yale University - Department of Psychology', TRUE, 'https://fastly.4sqi.net/img/general/600x600/84154773_raQYLNj4t4CPhQeDPDVeNkBRUcW22bek1CC8GRkI-lQ.jpg', 'katarina.medic01@gmail.com');

-- Insert psychologists
INSERT INTO psychologist(id, biography)
VALUES (1, 'super'),
       (2, 'ok');

-- Insert fairs
-- INSERT INTO fair(id, name, description, date, start_time, end_time, faculty_id, publish)
-- VALUES (1, 'Psychology Summit International', 'Join us at the Psychology Summit International where global experts gather to discuss the latest advancements and challenges in psychology.', '2024-07-10', '09:00:00', '17:30:00', 1, false),
--        (2, 'Global Psychology Forum', 'The Global Psychology Forum is a premier gathering of psychologists from around the world, focusing on collaborative research and innovative practices.', '2024-06-02', '09:00:00', '17:30:00', 2, true),
--        (3, 'International Psychologists Expo', 'Discover groundbreaking research and network with leading psychologists at the International Psychologists Expo, a hub of knowledge exchange.', '2024-07-05', '09:00:00', '17:30:00', 3, true),
--        (4, 'Worldwide Psychology Conference', 'Explore diverse perspectives on psychology at the Worldwide Psychology Conference, fostering dialogue on mental health and well-being globally.', '2024-07-06', '09:00:00', '17:30:00', 4, true),
--        (5, 'Global Minds Conference', 'Engage with thought leaders and influencers at the Global Minds Conference, addressing critical issues in psychology affecting communities worldwide.', '2024-06-29', '09:00:00', '17:30:00', 5, false),
--        (6, 'Cross-Cultural Psychology Symposium', 'Delve into the intersection of cultures and psychology at the Cross-Cultural Psychology Symposium, exploring how cultural contexts shape mental health practices.', '2024-07-01', '09:00:00', '17:30:00', 3, false),
--        (7, 'Global Perspectives in Psychology Fair', 'Gain insights into global trends in psychology at the Global Perspectives in Psychology Fair, featuring interactive sessions and expert panels.', '2024-07-07', '09:00:00', '17:30:00', 2, false),
--        (8, 'International Psychology Convention', 'Connect with peers and experts at the International Psychology Convention, focusing on advancements in clinical and experimental psychology.', '2024-07-03', '09:00:00', '17:30:00', 5, false),
--        (9, 'Psychology Innovations Summit', 'Join us at the Psychology Innovations Summit to explore cutting-edge technologies and innovative approaches transforming the field of psychology.', '2024-06-28', '09:00:00', '17:30:00', 1, false);


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
-- INSERT INTO student(id, faculty_name)
-- VALUES (1, 'Privatni psiholoski fakultet BG');
--
-- INSERT INTO users(role_id, email, last_name, name, password, username, image_url)
-- VALUES (3, 'student3@gmail.com', 'Jovic', 'Helena', '$2y$10$4i0YzRS1wnkHSR6KdHb.aeYD7/agdp4TLyMm0ZguS2/2MosBcrfee', 'student3', 'https://cdn-icons-png.flaticon.com/512/219/219983.png');
--
-- INSERT INTO student(id, faculty_name)
-- VALUES (4, 'Psiholoski fakultet EDUCONS');
--
