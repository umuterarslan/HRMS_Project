DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

/*
 *   TABLES
*/

CREATE TABLE public.users
(
    id       INTEGER                NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email    CHARACTER VARYING(320) NOT NULL,
    password CHARACTER VARYING(25)  NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uc_users_email UNIQUE (email)
);

CREATE TABLE public.jobseekers
(
    user_id         INTEGER               NOT NULL,
    first_name      CHARACTER VARYING(35) NOT NULL,
    last_name       CHARACTER VARYING(35) NOT NULL,
    identity_number CHARACTER VARYING(11) NOT NULL,
    birth_date      DATE                  NOT NULL,
    CONSTRAINT pk_jobseekers PRIMARY KEY (user_id),
    CONSTRAINT fk_jobseekers_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_jobseekers_identity_number UNIQUE (identity_number)
);

CREATE TABLE public.employers
(
    user_id      INTEGER                NOT NULL,
    picture_url  CHARACTER VARYING(200),
    company_name CHARACTER VARYING(255) NOT NULL,
    website      CHARACTER VARYING(255) NOT NULL,
    phone_number CHARACTER VARYING(12)  NOT NULL,
    CONSTRAINT pk_employers PRIMARY KEY (user_id),
    CONSTRAINT fk_employers_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_employers_company_name UNIQUE (company_name)

);

CREATE TABLE public.system_personels
(
    user_id  INTEGER               NOT NULL,
    username CHARACTER VARYING(35) NOT NULL,
    CONSTRAINT pk_system_personels PRIMARY KEY (user_id),
    CONSTRAINT fk_system_personels_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE
);

CREATE TABLE public.job_positions
(
    id        integer               NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    job_title character varying(50) NOT NULL,
    CONSTRAINT pk_job_positions PRIMARY KEY (id),
    CONSTRAINT uc_job_positions_job_title UNIQUE (job_title)
);

CREATE TABLE public.employers_activations
(
    id                    integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    employer_id           INTEGER NOT NULL,
    is_email_confirmed    boolean NOT NULL,
    is_employer_activated boolean NOT NULL,
    CONSTRAINT pk_employers_activations PRIMARY KEY (id),
    CONSTRAINT fk_employers_activations_employers FOREIGN KEY (employer_id) REFERENCES public.employers (user_id) ON DELETE CASCADE
);

CREATE TABLE public.jobseekers_activations
(
    id                 INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    jobseeker_id       INTEGER NOT NULL,
    is_email_confirmed boolean NOT NULL,
    is_mernis_valid    boolean NOT NULL,
    CONSTRAINT pk_jobseekers_activations PRIMARY KEY (id),
    CONSTRAINT fk_jobseekers_activations_jobseekers FOREIGN KEY (jobseeker_id) REFERENCES public.jobseekers (user_id) ON DELETE CASCADE
);

CREATE TABLE public.cities
(
    id        INTEGER               NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    city_name CHARACTER VARYING(25) NOT NULL UNIQUE,
    CONSTRAINT pk_cities PRIMARY KEY (id)
);

CREATE TABLE public.job_adverts
(
    id                       INTEGER                  NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    employer_id              INTEGER                  NOT NULL,
    city_id                  INTEGER                  NOT NULL,
    job_position_id          INTEGER                  NOT NULL,
    description              CHARACTER VARYING(25000) NOT NULL,
    salary                   INTEGER                  NOT NULL,
    position_count           INTEGER                  NOT NULL,
    release_date             timestamp with time zone NOT NULL,
    expire_date              DATE                     NOT NULL,
    is_active                boolean                  NOT NULL,
    is_confirmed             boolean                  NOT NULL,
    part_or_full_time        CHARACTER VARYING(20)    NOT NULL,
    remote_or_standart_typed CHARACTER VARYING(20),
    CONSTRAINT pk_job_adverts PRIMARY KEY (id),
    CONSTRAINT fk_job_adverts_job_positions FOREIGN KEY (job_position_id) REFERENCES public.job_positions (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_cities FOREIGN KEY (city_id) REFERENCES public.cities (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_employers FOREIGN KEY (employer_id) REFERENCES public.employers (user_id) ON DELETE CASCADE
);

CREATE TABLE public.curricula_vitaes
(
    id              INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    jobseeker_id    INTEGER NOT NULL,
    social_media_id INTEGER NOT NULL,
    cover_letter    CHARACTER VARYING(200),
    picture_url     CHARACTER VARYING(200),
    CONSTRAINT pk_curricula_vitaes PRIMARY KEY (id),
    CONSTRAINT uc_curricula_vitaes_jobseeker_id UNIQUE (jobseeker_id),
    CONSTRAINT uc_curricula_vitaes_social_media_id UNIQUE (social_media_id)
);

CREATE TABLE public.educations
(
    id                   INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    curricula_vitae_id   INTEGER NOT NULL,
    school_id            INTEGER NOT NULL,
    department_id        INTEGER NOT NULL,
    education_start_date DATE    NOT NULL,
    end_date             DATE,
    CONSTRAINT pk_educations PRIMARY KEY (id)
);

CREATE TABLE public.schools
(
    id          INTEGER                NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    school_name CHARACTER VARYING(100) NOT NULL UNIQUE,
    CONSTRAINT pk_schools PRIMARY KEY (id),
    CONSTRAINT uc_schools_school_name UNIQUE (school_name)
);

CREATE TABLE public.departments
(
    id              INTEGER                NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    department_name CHARACTER VARYING(100) NOT NULL,
    CONSTRAINT pk_departmants PRIMARY KEY (id)
);

CREATE TABLE public.business_lifes
(
    id                 INTEGER                NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    curricula_vitae_id INTEGER                NOT NULL,
    company_name       CHARACTER VARYING(100) NOT NULL,
    position_name      CHARACTER VARYING(100) NOT NULL,
    bl_start_date      DATE                   NOT NULL,
    end_date           DATE,
    CONSTRAINT pk_business_lifes PRIMARY KEY (id)
);

CREATE TABLE public.languages
(
    id            INTEGER                NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    language_name CHARACTER VARYING(100) NOT NULL,
    CONSTRAINT pk_languages PRIMARY KEY (id)
);

CREATE TABLE public.jobseeker_languages
(
    id                 INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    curricula_vitae_id INTEGER NOT NULL,
    language_id        INTEGER NOT NULL,
    language_degree    INTEGER NOT NULL,
    CONSTRAINT pk_jobseeker_languages PRIMARY KEY (id)
);

CREATE TABLE public.social_medias
(
    id                INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    github_username   CHARACTER VARYING(100),
    linkedin_username CHARACTER VARYING(100),
    CONSTRAINT pk_social_medias PRIMARY KEY (id),
    CONSTRAINT uc_social_medias_github_username UNIQUE (github_username),
    CONSTRAINT uc_social_medias_linkedin_username UNIQUE (linkedin_username)
);

CREATE TABLE public.technologies
(
    id                 INTEGER                NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    curricula_vitae_id INTEGER                NOT NULL,
    technologies       CHARACTER VARYING(200) NOT NULL,
    CONSTRAINT pk_technologies PRIMARY KEY (id)
);

ALTER TABLE public.curricula_vitaes
    ADD FOREIGN KEY (social_media_id) REFERENCES public.social_medias (id),
    ADD FOREIGN KEY (jobseeker_id) REFERENCES public.jobseekers (user_id);

ALTER TABLE public.educations
    ADD FOREIGN KEY (curricula_vitae_id) REFERENCES public.curricula_vitaes (id),
    ADD FOREIGN KEY (school_id) REFERENCES public.schools (id),
    ADD FOREIGN KEY (department_id) REFERENCES public.departments (id);

ALTER TABLE public.business_lifes
    ADD FOREIGN KEY (curricula_vitae_id) REFERENCES public.curricula_vitaes (id);

ALTER TABLE public.jobseeker_languages
    ADD FOREIGN KEY (curricula_vitae_id) REFERENCES public.curricula_vitaes (id),
    ADD FOREIGN KEY (language_id) REFERENCES public.languages (id);

ALTER TABLE public.technologies
    ADD FOREIGN KEY (curricula_vitae_id) REFERENCES public.curricula_vitaes (id);


INSERT INTO cities (city_name)
VALUES ('ADANA'),
       ('ADIYAMAN'),
       ('AFYONKARAHİSAR'),
       ('AĞRI'),
       ('AMASYA'),
       ('ANKARA'),
       ('ANTALYA'),
       ('ARTVİN'),
       ('AYDIN'),
       ('BALIKESİR'),
       ('BİLECİK'),
       ('BİNGÖL'),
       ('BİTLİS'),
       ('BOLU'),
       ('BURDUR'),
       ('BURSA'),
       ('ÇANAKKALE'),
       ('ÇANKIRI'),
       ('ÇORUM'),
       ('DENİZLİ'),
       ('DİYARBAKIR'),
       ('EDİRNE'),
       ('ELAZIĞ'),
       ('ERZİNCAN'),
       ('ERZURUM'),
       ('ESKİŞEHİR'),
       ('GAZİANTEP'),
       ('GİRESUN'),
       ('GÜMÜŞHANE'),
       ('HAKKARİ'),
       ('HATAY'),
       ('ISPARTA'),
       ('MERSİN'),
       ('İSTANBUL'),
       ('İZMİR'),
       ('KARS'),
       ('KASTAMONU'),
       ('KAYSERİ'),
       ('KIRKLARELİ'),
       ('KIRŞEHİR'),
       ('KOCAELİ'),
       ('KONYA'),
       ('KÜTAHYA'),
       ('MALATYA'),
       ('MANİSA'),
       ('KAHRAMANMARAŞ'),
       ('MARDİN'),
       ('MUĞLA'),
       ('MUŞ'),
       ('NEVŞEHİR'),
       ('NİĞDE'),
       ('ORDU'),
       ('RİZE'),
       ('SAKARYA'),
       ('SAMSUN'),
       ('SİİRT'),
       ('SİNOP'),
       ('SİVAS'),
       ('TEKİRDAĞ'),
       ('TOKAT'),
       ('TRABZON'),
       ('TUNCELİ'),
       ('ŞANLIURFA'),
       ('UŞAK'),
       ('VAN'),
       ('YOZGAT'),
       ('ZONGULDAK'),
       ('AKSARAY'),
       ('BAYBURT'),
       ('KARAMAN'),
       ('KIRIKKALE'),
       ('BATMAN'),
       ('ŞIRNAK'),
       ('BARTIN'),
       ('ARDAHAN'),
       ('IĞDIR'),
       ('YALOVA'),
       ('KARABÜK'),
       ('KİLİS'),
       ('OSMANİYE'),
       ('DÜZCE');

