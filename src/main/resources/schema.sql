CREATE TABLE IF NOT EXISTS specialization (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS hospital (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    location VARCHAR(255),
    email VARCHAR(255),
    contact VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS doctor (
    id SERIAL PRIMARY KEY,
    imglink VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    contact VARCHAR(255),
    status varchar(10) default 'false',
    experience VARCHAR(255),
    specialization_id INTEGER NOT NULL,
    hospital_id INTEGER NOT NULL,
    CONSTRAINT fk_specialization FOREIGN KEY (specialization_id) REFERENCES specialization(id),
    CONSTRAINT fk_hospital FOREIGN KEY (hospital_id) REFERENCES hospital(id)
);


CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role Varchar(10) not null 
);

CREATE TABLE IF NOT EXISTS appointments (
    id SERIAL PRIMARY KEY,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    user_id INTEGER,
    doctor_id INTEGER,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctor (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS doctor_availability (
    id SERIAL PRIMARY KEY,
    date DATE,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    max_appointments INTEGER,
    booked_appointments INTEGER DEFAULT 0,
    doctor_id INTEGER,
    CONSTRAINT fk_doctor_availability_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctor (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ratings (
    id SERIAL PRIMARY KEY,
    rating_value INTEGER NOT NULL CHECK (rating_value BETWEEN 1 AND 5),
    doctor_id INTEGER,
    user_id INTEGER,
    CONSTRAINT fk_rating_doctor
        FOREIGN KEY (doctor_id)
        REFERENCES doctor (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_rating_user
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
