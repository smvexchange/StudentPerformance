CREATE TABLE STUDENTS (
    id identity  primary key not null,
    first_name varchar,
    group_number varchar,
    is_active boolean,
    last_name varchar,
    patronymic varchar
);

CREATE TABLE COURSE (
    id identity primary key not null,
    name varchar UNIQUE,
    end_date date,
    is_active boolean,
    start_date date
);

CREATE TABLE COURSE_RATING (
    course_name varchar references COURSE(name),
    student_id bigint references STUDENTS(id),
    PRIMARY KEY (course_name, student_id),
    is_passed boolean,
    rating double precision
);

CREATE TABLE LESSONS (
    id identity primary key not null,
    name varchar,
    date date,
    max_grade integer,
    course_name varchar references COURSE(name)
);

CREATE TABLE COURSES_LESSONS (
    course_name varchar references COURSE(name),
    lesson_id bigint references LESSONS(id),
    PRIMARY KEY (course_name, lesson_id)
);

CREATE TABLE LESSONS_GRADE (
   student_id bigint references STUDENTS(id),
   lesson_id bigint references LESSONS(id),
   PRIMARY KEY (student_id, lesson_id),
   grade double precision
);

INSERT INTO STUDENTS VALUES (1, 'Ivan', 'java_2022', true, 'Ivanov', 'Ivanovich');
INSERT INTO STUDENTS VALUES (2, 'Dmitriy', 'java_2022', true, 'Somov', 'Fedorovich');
INSERT INTO STUDENTS VALUES (3, 'Michail', 'ptn_2022', true, 'Komov', 'Petrovich');
INSERT INTO STUDENTS VALUES (4, 'Vladimir', 'ptn_2022', true, 'Virov', 'Vladimirovich');
INSERT INTO STUDENTS VALUES (5, 'Maksim', 'cpp_2022', true, 'Remov', 'Dmitrievich');
INSERT INTO STUDENTS VALUES (6, 'Sergey', 'cpp_2022', true, 'Durov', 'Kuzmich');

INSERT INTO COURSE VALUES (1, 'JAVA', '2022-02-01', true, '2022-12-01');
INSERT INTO COURSE VALUES (2, 'Python', '2022-03-01', true, '2023-01-01');
INSERT INTO COURSE VALUES (3, 'C++', '2022-04-01', true, '2023-02-01');

INSERT INTO LESSONS VALUES (1, 'Core', '2022-01-01', 5, 'JAVA');
INSERT INTO LESSONS VALUES (2, 'OOP', '2022-01-01', 5, 'JAVA');
INSERT INTO LESSONS VALUES (3, 'SQL', '2022-01-01', 5, 'JAVA');
INSERT INTO LESSONS VALUES (4, 'Core', '2022-01-01', 6, 'Python');
INSERT INTO LESSONS VALUES (5, 'OOP', '2022-01-01', 6, 'Python');
INSERT INTO LESSONS VALUES (6, 'SQL', '2022-01-01', 6, 'Python');
INSERT INTO LESSONS VALUES (7, 'Core', '2022-01-01', 7, 'C++');
INSERT INTO LESSONS VALUES (8, 'OOP', '2022-01-01', 7, 'C++');
INSERT INTO LESSONS VALUES (9, 'SQL', '2022-01-01', 7, 'C++');

INSERT INTO COURSES_LESSONS VALUES ('JAVA', 1);
INSERT INTO COURSES_LESSONS VALUES ('JAVA', 2);
INSERT INTO COURSES_LESSONS VALUES ('JAVA', 3);
INSERT INTO COURSES_LESSONS VALUES ('Python', 4);
INSERT INTO COURSES_LESSONS VALUES ('Python', 5);
INSERT INTO COURSES_LESSONS VALUES ('Python', 6);
INSERT INTO COURSES_LESSONS VALUES ('C++', 7);
INSERT INTO COURSES_LESSONS VALUES ('C++', 8);
INSERT INTO COURSES_LESSONS VALUES ('C++', 9);

INSERT INTO COURSE_RATING VALUES ('JAVA', 1, false, 0.60);
INSERT INTO COURSE_RATING VALUES ('JAVA', 2, false, 0.80);
INSERT INTO COURSE_RATING VALUES ('Python', 3, false, 0.33);
INSERT INTO COURSE_RATING VALUES ('Python', 4, false, 0.16);
INSERT INTO COURSE_RATING VALUES ('C++', 5, false, 0.71);
INSERT INTO COURSE_RATING VALUES ('C++', 6, false, 0.57);

INSERT INTO LESSONS_GRADE VALUES (1, 1, 3);
INSERT INTO LESSONS_GRADE VALUES (1, 2, 3);
INSERT INTO LESSONS_GRADE VALUES (1, 3, 3);
INSERT INTO LESSONS_GRADE VALUES (2, 1, 4);
INSERT INTO LESSONS_GRADE VALUES (2, 2, 4);
INSERT INTO LESSONS_GRADE VALUES (2, 3, 4);
INSERT INTO LESSONS_GRADE VALUES (3, 4, 2);
INSERT INTO LESSONS_GRADE VALUES (3, 5, 2);
INSERT INTO LESSONS_GRADE VALUES (3, 6, 2);
INSERT INTO LESSONS_GRADE VALUES (4, 4, 1);
INSERT INTO LESSONS_GRADE VALUES (4, 5, 1);
INSERT INTO LESSONS_GRADE VALUES (4, 6, 1);
INSERT INTO LESSONS_GRADE VALUES (5, 7, 5);
INSERT INTO LESSONS_GRADE VALUES (5, 8, 5);
INSERT INTO LESSONS_GRADE VALUES (5, 9, 5);
INSERT INTO LESSONS_GRADE VALUES (6, 7, 3);
INSERT INTO LESSONS_GRADE VALUES (6, 8, 4);
INSERT INTO LESSONS_GRADE VALUES (6, 9, 5);