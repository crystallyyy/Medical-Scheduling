BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, patient, doctor, office, office_hours, doctor_availability, appointment, reviews, doctor_office;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

  
CREATE TABLE patient (
	patient_id serial,
	user_id int,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	date_of_birth DATE NOT NULL,
	address varchar(200) NOT NULL,
	phone_number varchar(20) NOT NULL,
	CONSTRAINT PK_patient PRIMARY KEY (patient_id)
);

CREATE TABLE doctor (
	doctor_id serial PRIMARY KEY,
	user_id int,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	time_slot_default int NOT NULL,
	email varchar(50) NOT NULL
);

CREATE TABLE doctor_availability (
	doctor_id int NOT NULL,
	day_of_week varchar(20) NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	CONSTRAINT PK_availability PRIMARY KEY (doctor_id, day_of_week),
	CONSTRAINT FK_doctor_availability FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);

CREATE TABLE office (
	office_id serial,
	office_name varchar(50) NOT NULL,
	address varchar(200) NOT NULL,
	phone_number varchar(12) NOT NULL,
	CONSTRAINT PK_office PRIMARY KEY (office_id),
	CONSTRAINT UQ_office UNIQUE (office_name)
);

CREATE TABLE office_hours (
	office_hours_id serial,
	office_id int NOT NULL,
	day_of_week varchar(20) NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	CONSTRAINT PK_office_hours PRIMARY KEY (office_hours_id),
	CONSTRAINT FK_office_hours FOREIGN KEY (office_id) REFERENCES office(office_id)
);

CREATE TABLE doctor_office (
	doctor_id int NOT NULL,
	office_id int NOT NULL,
	CONSTRAINT PK_doctor_office PRIMARY KEY (doctor_id, office_id),
	CONSTRAINT FK_doctor_office_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
	CONSTRAINT FK_doctor_office_office FOREIGN KEY (office_id) REFERENCES office(office_id)
);

CREATE TABLE reviews (
	review_id serial,
	office_id int NOT NULL,
	description varchar(1000),
	rating int NOT NULL,
	CONSTRAINT PK_review PRIMARY KEY (review_id),
	CONSTRAINT FK_reviews_office FOREIGN KEY (office_id) REFERENCES office(office_id)
);

CREATE TABLE appointment (
	appointment_id serial,
	doctor_id int NOT NULL,
	appt_date date NOT NULL,
	start_time time NOT NULL,
	duration int NOT NULL,
	patient_id int,
	office_id int NOT NULL,
	CONSTRAINT PK_appointment PRIMARY KEY (appointment_id),
	CONSTRAINT FK_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
	CONSTRAINT UQ_appointment UNIQUE (doctor_id, appt_date, start_time)
);

COMMIT TRANSACTION;
