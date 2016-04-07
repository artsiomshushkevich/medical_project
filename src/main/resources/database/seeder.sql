USE `medical` ;

INSERT INTO  `medical`.`role` (`id`, `name`) VALUES (NULL,  'Admin');
INSERT INTO  `medical`.`role` (`id`, `name`) VALUES (NULL,  'Client');
INSERT INTO  `medical`.`role` (`id`, `name`) VALUES (NULL,  'Doctor');

INSERT INTO  `medical`.`department` (`id`, `name`, `address`) VALUES (NULL,  'Surgery', 'Naberezhnaya, 4');
INSERT INTO  `medical`.`department` (`id`, `name`, `address`) VALUES (NULL,  'Traumatology', 'Naberezhnaya, 5');
INSERT INTO  `medical`.`department` (`id`, `name`, `address`) VALUES (NULL,  'Dentistry', 'Naberezhnaya, 6');

INSERT INTO  `medical`.`cure` (`id`, `name`) VALUES (NULL,  'Aspirin');
INSERT INTO  `medical`.`cure` (`id`, `name`) VALUES (NULL,  'Analgin');
INSERT INTO  `medical`.`cure` (`id`, `name`) VALUES (NULL,  'Paracetamol');

INSERT INTO  `medical`.`user` (`id`, `login`, `password`, `role_id`)
VALUES (NULL ,  'admin',  'adminadmin',  '1');
INSERT INTO  `medical`.`user` (`id`, `login`, `password`, `role_id`)
VALUES (NULL ,  'vitaly',  'vitalyorlov',  '2');
INSERT INTO  `medical`.`user` (`id`, `login`, `password`, `role_id`)
VALUES (NULL ,  'dmitri',  'dmitrisoroko',  '2');
INSERT INTO  `medical`.`user` (`id`, `login`, `password`, `role_id`)
VALUES (NULL ,  'doctor',  'doctordoctor',  '3');
INSERT INTO  `medical`.`user` (`id`, `login`, `password`, `role_id`)
VALUES (NULL ,  'artem',  'artsiomsh',  '3');


INSERT INTO  `medical`.`client` (`id`, `firstname`, `secondname`, `lastname`, `phone_number`, `address`, `email`, `user_id`)
VALUES (NULL ,  'Vitaly',  'Olegovich',  'Orlov',  '+375293338950',  'Lenina, 44',  'vitali11@gmail.com',  '2');
INSERT INTO  `medical`.`client` (`id`, `firstname`, `secondname`, `lastname`, `phone_number`, `address`, `email`, `user_id`)
VALUES (NULL ,  'Dmitrii',  'Batkovich',  'Soroko',  '+375291138950',  'Kosmonavtov, 14',  'sorokod11@gmail.com',  '3');

INSERT INTO  `medical`.`doctor` (`id`, `firstname`, `secondname`, `lastname`, `qualification`,
`speciality`, `phone_number`, `email`, `user_id`, `department_id`)
VALUES (NULL,  'Artem',  'Batkovich',  'Shushkevich',  'doctor',
'surgeon',  '+375298899978',  'artsem@mail.ru',  '4',  '2');
INSERT INTO  `medical`.`doctor` (`id`, `firstname`, `secondname`, `lastname`, `qualification`,
`speciality`, `phone_number`, `email`, `user_id`, `department_id`)
VALUES (NULL,  'Doc',  'Batkovich',  'Doctorovich',  'doctor',
'surgeon',  '+375298119978',  'docdocc@mail.ru',  '5',  '1');

INSERT INTO  `medical`.`medical_history` (`id`, `client_id`)
VALUES (NULL ,  '1');
INSERT INTO  `medical`.`medical_history` (`id`, `client_id`)
VALUES (NULL ,  '2');

INSERT INTO  `medical`.`order` (`id`, `date`, `begin_time`, `doctor_id`, `client_id`)
VALUES (NULL,  '1482278400',  '1482318671',  '1',  '1');
INSERT INTO  `medical`.`order` (`id`, `date`, `begin_time`, `doctor_id`, `client_id`)
VALUES (NULL,  '1482278400',  '1482326400',  '1',  '2');
INSERT INTO  `medical`.`order` (`id`, `date`, `begin_time`, `doctor_id`, `client_id`)
VALUES (NULL,  '1482278400',  '1482318671',  '2',  '1');
INSERT INTO  `medical`.`order` (`id`, `date`, `begin_time`, `doctor_id`, `client_id`)
VALUES (NULL,  '1482278400',  '1482326400',  '2',  '2');

INSERT INTO  `medical`.`visit` (`id`, `complaints`, `diagnosys`, `medical_history_id`, `order_id`)
VALUES (NULL ,  'headache',  'headache',  '1',  '1');
INSERT INTO  `medical`.`visit` (`id`, `complaints`, `diagnosys`, `medical_history_id`, `order_id`)
VALUES (NULL ,  'headache',  'headache',  '1',  '2');
INSERT INTO  `medical`.`visit` (`id`, `complaints`, `diagnosys`, `medical_history_id`, `order_id`)
VALUES (NULL ,  'headache',  'headache',  '2',  '3');
INSERT INTO  `medical`.`visit` (`id`, `complaints`, `diagnosys`, `medical_history_id`, `order_id`)
VALUES (NULL ,  'headache',  'headache',  '2',  '4');

INSERT INTO  `medical`.`analyse` (`id`, `name`, `result`, `doctor_id`, `client_id`, `visit_id`)
VALUES (NULL ,  'blood analyse',  'you will life',  '2',  '1',  '3');
INSERT INTO  `medical`.`analyse` (`id`, `name`, `result`, `doctor_id`, `client_id`, `visit_id`)
VALUES (NULL ,  'MRI',  'you will life',  '1',  '1',  '1');

INSERT INTO  `medical`.`schedule` (`id`, `workday`, `beginworkday`, `endworkday`, `room`, `doctor_id`)
VALUES (NULL,  'monday',  '0',  '28800',  '213',  '1');
INSERT INTO  `medical`.`schedule` (`id`, `workday`, `beginworkday`, `endworkday`, `room`, `doctor_id`)
VALUES (NULL,  'thuesday',  '28800',  '57600',  '113',  '2');

INSERT INTO `medical`.`treatment` (`id`, `prescription`, `cure_count`, `method_of_using`, `cure_id`, `visit_id`)
VALUES (NULL, NULL, '1', '2 times a day', '1', '2');
INSERT INTO `medical`.`treatment` (`id`, `prescription`, `cure_count`, `method_of_using`, `cure_id`, `visit_id`)
VALUES (NULL, NULL, '1', '2 times a day', '2', '3');