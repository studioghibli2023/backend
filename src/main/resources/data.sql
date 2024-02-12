
INSERT INTO course (id,name, description , image, price, duration) VALUES (0,'Course 1' , 'Course desc', 'some image', 200, 2);
INSERT INTO course (id,name, description , image, price, duration) VALUES (1,'Course 2' , 'Course desc', 'some image', 300, 3);
INSERT INTO course (id,name, description , image, price, duration) VALUES (2,'Course 2' , 'Course desc', 'some image', 400, 4);

INSERT INTO user_table (id,name, email , role, password) VALUES (0,'Test' , 'test@test.com', 1, 'thetest');
INSERT INTO user_table (id,name, email , role, password, course_id) VALUES (1,'John' , 'john@test.com', 2, 'theJohn', 1);