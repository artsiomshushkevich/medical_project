SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `medical` DEFAULT CHARACTER SET utf8 ;
USE `medical` ;

-- -----------------------------------------------------
-- Table `medical`.`analyses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`analyses` ;

CREATE TABLE IF NOT EXISTS `medical`.`analyses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_doctor` INT(11) NOT NULL,
  `id_client` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `result` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`clients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`clients` ;

CREATE TABLE IF NOT EXISTS `medical`.`clients` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `second_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`departments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`departments` ;

CREATE TABLE IF NOT EXISTS `medical`.`departments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`doctors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`doctors` ;

CREATE TABLE IF NOT EXISTS `medical`.`doctors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `second_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `qualification` VARCHAR(100) NOT NULL,
  `position` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(100) NOT NULL,
  `id_specialization` INT(11) NOT NULL,
  `id_departments` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`medical_histories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`medical_histories` ;

CREATE TABLE IF NOT EXISTS `medical`.`medical_histories` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `info` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`orders` ;

CREATE TABLE IF NOT EXISTS `medical`.`orders` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_client` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  `id_doctor` INT(11) NOT NULL,
  `begin_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`prescriptions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`prescriptions` ;

CREATE TABLE IF NOT EXISTS `medical`.`prescriptions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_client` INT(11) NOT NULL,
  `id_doctor` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `method_of_using` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`roles` ;

CREATE TABLE IF NOT EXISTS `medical`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`schedules`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`schedules` ;

CREATE TABLE IF NOT EXISTS `medical`.`schedules` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_doctor` INT(11) NOT NULL,
  `week_day` VARCHAR(100) NOT NULL,
  `begin_workday` VARCHAR(100) NOT NULL,
  `end_workday` VARCHAR(100) NOT NULL,
  `duration` TIME NOT NULL,
  `cabinet` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`specializations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`specializations` ;

CREATE TABLE IF NOT EXISTS `medical`.`specializations` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`treatments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`treatments` ;

CREATE TABLE IF NOT EXISTS `medical`.`treatments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type_treatment` VARCHAR(100) NOT NULL,
  `method` VARCHAR(100) NOT NULL,
  `treatment` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`users` ;

CREATE TABLE IF NOT EXISTS `medical`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`visits`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`visits` ;

CREATE TABLE IF NOT EXISTS `medical`.`visits` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_treatment` INT(11) NOT NULL,
  `id_medical_history` INT(11) NOT NULL,
  `id_order` INT(11) NOT NULL,
  `diagnosis` VARCHAR(100) NOT NULL,
  `complaints` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `medical`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`role` ;

CREATE TABLE IF NOT EXISTS `medical`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`user` ;

CREATE TABLE IF NOT EXISTS `medical`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_role1_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `medical`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`department` ;

CREATE TABLE IF NOT EXISTS `medical`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`client` ;

CREATE TABLE IF NOT EXISTS `medical`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_client_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `medical`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`medical_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`medical_history` ;

CREATE TABLE IF NOT EXISTS `medical`.`medical_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medical_history_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_medical_history_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `medical`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`doctor` ;

CREATE TABLE IF NOT EXISTS `medical`.`doctor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `department_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `qualification` VARCHAR(45) NOT NULL,
  `specialty` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_department1_idx` (`department_id` ASC),
  INDEX `fk_doctor_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_doctor_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `medical`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doctor_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `medical`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`order` ;

CREATE TABLE IF NOT EXISTS `medical`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `begin_time` TIME NOT NULL,
  `client_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_client1_idx` (`client_id` ASC, `doctor_id` ASC),
  INDEX `fk_order_doctor1_idx` (`doctor_id` ASC),
  CONSTRAINT `fk_order_client1`
    FOREIGN KEY (`client_id` , `doctor_id`)
    REFERENCES `medical`.`client` (`id` , `id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medical`.`doctor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`visit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`visit` ;

CREATE TABLE IF NOT EXISTS `medical`.`visit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `medical_history_id` INT NOT NULL,
  `medical_history_client_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `complaints` VARCHAR(200) NOT NULL,
  `diagnosis` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_visit_medical_history1_idx` (`medical_history_id` ASC, `order_id` ASC, `medical_history_client_id` ASC),
  INDEX `fk_visit_order1_idx` (`order_id` ASC),
  CONSTRAINT `fk_visit_medical_history1`
    FOREIGN KEY (`medical_history_id` , `order_id` , `medical_history_client_id`)
    REFERENCES `medical`.`medical_history` (`id` , `id` , `id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_visit_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `medical`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`analyse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`analyse` ;

CREATE TABLE IF NOT EXISTS `medical`.`analyse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `result` VARCHAR(100) NOT NULL,
  `doctor_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  `visit_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_analyse_doctor1_idx` (`doctor_id` ASC, `client_id` ASC, `visit_id` ASC),
  INDEX `fk_analyse_client1_idx` (`client_id` ASC),
  INDEX `fk_analyse_visit1_idx` (`visit_id` ASC),
  CONSTRAINT `fk_analyse_doctor1`
    FOREIGN KEY (`doctor_id` , `client_id` , `visit_id`)
    REFERENCES `medical`.`doctor` (`id` , `id` , `id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_analyse_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `medical`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_analyse_visit1`
    FOREIGN KEY (`visit_id`)
    REFERENCES `medical`.`visit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`cure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`cure` ;

CREATE TABLE IF NOT EXISTS `medical`.`cure` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`treatment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`treatment` ;

CREATE TABLE IF NOT EXISTS `medical`.`treatment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prescribtioncol` VARCHAR(45) NULL,
  `visit_id` INT NOT NULL,
  `treatmentcol` VARCHAR(45) NULL,
  `cure_id` INT NOT NULL,
  `cure_count` INT NOT NULL,
  `using_method` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_treatment_visit1_idx` (`visit_id` ASC),
  INDEX `fk_treatment_cure1_idx` (`cure_id` ASC),
  CONSTRAINT `fk_treatment_visit1`
    FOREIGN KEY (`visit_id`)
    REFERENCES `medical`.`visit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_treatment_cure1`
    FOREIGN KEY (`cure_id`)
    REFERENCES `medical`.`cure` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical`.`schedule` ;

CREATE TABLE IF NOT EXISTS `medical`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `work_day` VARCHAR(45) NOT NULL,
  `begin_workday` TIME NOT NULL,
  `end_workday` TIME NOT NULL,
  `room` VARCHAR(45) NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_schedule_doctor1_idx` (`doctor_id` ASC),
  CONSTRAINT `fk_schedule_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medical`.`doctor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
