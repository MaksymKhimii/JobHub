Create TABLE profile
(
    id            BIGINT              NOT NULL PRIMARY KEY,
    uid           varchar(100) UNIQUE NOT NULL,
    first_name    varchar(50)         NOT NULL,
    last_name     varchar(50)         NOT NULL,
    birth_day     date                         DEFAULT NULL,
    phone         varchar(20) UNIQUE           DEFAULT NULL,
    email         varchar(100) UNIQUE          DEFAULT NULL,
    country       varchar(60)                  DEFAULT NULL,
    city          varchar(100)                 DEFAULT NULL,
    objective     text                         DEFAULT NULL,
    summary       text                         DEFAULT NULL,
    large_photo   varchar(255)                 DEFAULT NULL,
    small_photo   varchar(255)                 DEFAULT NULL,
    info          text                         DEFAULT NULL,
    password      varchar(255)        NOT NULL,
    complete      boolean             NOT NULL,
    created       timestamp(0)        NOT NULL DEFAULT now(),
    skype         varchar(80)                  DEFAULT NULL,
    facebook      varchar(255)                 DEFAULT NULL,
    linkedin      varchar(255)                 DEFAULT NULL,
    github        varchar(255)                 DEFAULT NULL,
    stackoverflow varchar(255)                 DEFAULT NULL
);

CREATE TABLE certificate
(
    id         BIGINT       NOT NULL PRIMARY KEY,
    id_profile BIGINT       NOT NULL,
    name       varchar(50)  NOT NULL,
    large_url  varchar(255) NOT NULL,
    small_url  varchar(255) NOT NULL,
    CONSTRAINT certificate_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

CREATE INDEX certificate_idx ON certificate (id_profile);
CREATE INDEX certificate_pkey ON certificate (id);

create table course
(
    id          bigint      not null
        primary key,
    id_profile  bigint      not null
        constraint course_fk
            references profile,
    name        varchar(60) not null,
    school      varchar(60) not null,
    finish_date date
);

alter table course
    owner to postgres;

create index course_idx
    on course (finish_date);

create index course_idx1
    on course (id_profile);

CREATE TABLE education
(
    id          BIGINT       NOT NULL PRIMARY KEY,
    id_profile  BIGINT       NOT NULL,
    summary     varchar(100) NOT NULL,
    begin_year  integer      NOT NULL,
    finish_year integer DEFAULT NULL,
    university  text         NOT NULL,
    faculty     varchar(255) NOT NULL,
    CONSTRAINT education_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

CREATE INDEX education_idx ON education (id_profile);
CREATE INDEX education_idx1 ON education (finish_year);

CREATE TABLE hobby
(
    id         BIGINT      NOT NULL PRIMARY KEY,
    id_profile BIGINT      NOT NULL,
    name       varchar(30) NOT NULL,
    CONSTRAINT hobby_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

CREATE INDEX hobbi_idx ON hobby (id_profile);

CREATE TABLE language
(
    id         BIGINT      NOT NULL PRIMARY KEY,
    id_profile BIGINT      NOT NULL,
    name       varchar(30) NOT NULL,
    level      varchar(18) NOT NULL,
    type       varchar(7)  NOT NULL DEFAULT '0',
    CONSTRAINT language_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

CREATE INDEX language_idx ON language (id_profile);

CREATE TABLE practic
(
    id               BIGINT       NOT NULL PRIMARY KEY,
    id_profile       BIGINT       NOT NULL,
    position         varchar(100) NOT NULL,
    company          varchar(100) NOT NULL,
    begin_date       date         NOT NULL,
    finish_date      date         DEFAULT NULL,
    responsibilities text         NOT NULL,
    demo             varchar(255) DEFAULT NULL,
    src              varchar(255) DEFAULT NULL,
    CONSTRAINT practic_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

CREATE INDEX language_idx ON practic (id_profile);
CREATE INDEX language_idx1 ON practic (finish_date);

CREATE TABLE skill
(
    id         BIGINT      NOT NULL PRIMARY KEY,
    id_profile BIGINT      NOT NULL,
    category   varchar(50) NOT NULL,
    value      text        NOT NULL,

    CONSTRAINT skill_fk
        FOREIGN KEY (id_profile) REFERENCES profile (id)
);

CREATE INDEX skill_idx ON practic (id_profile);
CREATE INDEX skill_idx1 ON practic (id);

CREATE TABLE profile_restore
(
    id    BIGINT              NOT NULL PRIMARY KEY,
    token varchar(255) UNIQUE NOT NULL,
    CONSTRAINT profile_restore_fk
        FOREIGN KEY (id) REFERENCES profile (id)
);

CREATE INDEX profile_restore_pkey ON profile_restore (id);
CREATE INDEX profile_restore_uid_key ON profile_restore (token);

CREATE TABLE skill_category
(
    id       BIGINT              NOT NULL PRIMARY KEY,
    category varchar(255) UNIQUE NOT NULL
);

CREATE INDEX skill_category_category_key ON skill_category (category);
