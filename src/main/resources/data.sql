CREATE TABLE STUDENTS (
    id serial primary key not null,
    firstName varchar(120) not null,
    lastName varchar(120) not null,
    patronymic varchar(120) not null,
    groupNumber varchar(120),
    isActive boolean default false
);

CREATE TABLE COURSES (
    name varchar(120) primary key unique not null,
    startDate date not null default current_date,
    endDate date not null default current_date,
    isActive boolean default false
);

CREATE TABLE LESSONS (
    id serial primary key not null,
    course varchar(120) references COURSES(name),
    name varchar(120) not null,
    date date default current_date,
    grade int default 0
);