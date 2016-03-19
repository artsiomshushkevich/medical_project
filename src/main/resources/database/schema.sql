DROP DATABASE IF EXISTS medical;
 
CREATE DATABASE medical DEFAULT CHARACTER SET 'utf8';
 
USE medical;

CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`login` varchar(100) NOT NULL,
	`password` varchar(100) NOT NULL,
	`role_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `clients` (
	`id_medical_history` INT NOT NULL,
	`user_id` INT NOT NULL,
	`id` INT NOT NULL AUTO_INCREMENT,
	`first_name` varchar(100) NOT NULL,
	`second_name` varchar(100) NOT NULL,
	`last_name` varchar(100) NOT NULL,
	`phone_number` varchar(100) NOT NULL,
	`address` varchar(100) NOT NULL,
	`email` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `doctors` (
	`user_id` INT NOT NULL,
	`id` INT NOT NULL AUTO_INCREMENT,
	`first_name` varchar(100) NOT NULL,
	`second_name` varchar(100) NOT NULL,
	`last_name` varchar(100) NOT NULL,
	`qualification` varchar(100) NOT NULL,
	`position` varchar(100) NOT NULL,
	`email` varchar(100) NOT NULL,
	`phone_number` varchar(100) NOT NULL,
	`id_specialisation` INT NOT NULL,
	`id_departments` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `departments` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`address` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `specialisations` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `medical_histories` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`info` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `visits` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_treatment` INT NOT NULL,
	`id_medical_history` INT NOT NULL,
	`id_order` INT NOT NULL,
	`diagnosis` varchar(100) NOT NULL,
	`complaints` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `schedules` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_doctor` INT NOT NULL,
	`week_day` varchar(100) NOT NULL,
	`begin_workday` varchar(100) NOT NULL,
	`end_workday` varchar(100) NOT NULL,
	`duration` TIME NOT NULL,
	`cabinet` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `analyses` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_doctor` INT NOT NULL,
	`id_client` INT NOT NULL,
	`name` varchar(100) NOT NULL,
	`result` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `treatments` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`type_treatment` varchar(100) NOT NULL,
	`method` varchar(100) NOT NULL,
	`treatment` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `orders` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_client` INT NOT NULL,
	`date` DATE NOT NULL,
	`id_doctor` INT NOT NULL,
	`begin_time` TIME NOT NULL,
	`end_time` TIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `prescriptions` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_client` INT NOT NULL,
	`id_doctor` INT NOT NULL,
	`name` varchar(100) NOT NULL,
	`method_of_using` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `roles` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `users` ADD CONSTRAINT `users_fk0` FOREIGN KEY (`role_id`) REFERENCES `roles`(`id`);

ALTER TABLE `clients` ADD CONSTRAINT `clients_fk0` FOREIGN KEY (`id_medical_history`) REFERENCES `medical_histories`(`id`);

ALTER TABLE `clients` ADD CONSTRAINT `clients_fk1` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `doctors` ADD CONSTRAINT `doctors_fk0` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `doctors` ADD CONSTRAINT `doctors_fk1` FOREIGN KEY (`id_specialisation`) REFERENCES `specialisations`(`id`);

ALTER TABLE `doctors` ADD CONSTRAINT `doctors_fk2` FOREIGN KEY (`id_departments`) REFERENCES `departments`(`id`);

ALTER TABLE `visits` ADD CONSTRAINT `visits_fk0` FOREIGN KEY (`id_treatment`) REFERENCES `treatments`(`id`);

ALTER TABLE `visits` ADD CONSTRAINT `visits_fk1` FOREIGN KEY (`id_medical_history`) REFERENCES `medical_histories`(`id`);

ALTER TABLE `visits` ADD CONSTRAINT `visits_fk2` FOREIGN KEY (`id_order`) REFERENCES `orders`(`id`);

ALTER TABLE `schedules` ADD CONSTRAINT `schedules_fk0` FOREIGN KEY (`id_doctor`) REFERENCES `doctors`(`id`);

ALTER TABLE `analyses` ADD CONSTRAINT `analyses_fk0` FOREIGN KEY (`id_doctor`) REFERENCES `doctors`(`id`);

ALTER TABLE `analyses` ADD CONSTRAINT `analyses_fk1` FOREIGN KEY (`id_client`) REFERENCES `clients`(`id`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`id_client`) REFERENCES `clients`(`id`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk1` FOREIGN KEY (`id_doctor`) REFERENCES `doctors`(`id`);

ALTER TABLE `prescriptions` ADD CONSTRAINT `prescriptions_fk0` FOREIGN KEY (`id_client`) REFERENCES `clients`(`id`);

ALTER TABLE `prescriptions` ADD CONSTRAINT `prescriptions_fk1` FOREIGN KEY (`id_doctor`) REFERENCES `doctors`(`id`);

SET NAMES 'utf8';

insert into roles (name) 
values ('admin');

insert into roles (name) 
values ('client');

insert into roles (name) 
values ('doctor');

insert into users (login, password, role_id) 
values ('admin', 'admin', '1');

insert into users (login, password, role_id) 
values ('client', 'client', '2');

insert into users (login, password, role_id) 
values ('doctor', 'doctor', '3');



