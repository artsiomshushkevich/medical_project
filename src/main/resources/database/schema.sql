SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `medical`;
CREATE SCHEMA IF NOT EXISTS `medical` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `medical` ;

-- -----------------------------------------------------
-- Table `medical`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_role_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `medical`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`doctor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `secondname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `qualification` VARCHAR(45) NOT NULL,
  `speciality` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_user1_idx` (`user_id` ASC),
  INDEX `fk_doctor_department1_idx` (`department_id` ASC),
  CONSTRAINT `fk_doctor_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `medical`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_doctor_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `medical`.`department` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `secondname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_client_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `medical`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `workday` VARCHAR(45) NOT NULL,
  `beginworkday` MEDIUMTEXT NOT NULL,
  `endworkday` MEDIUMTEXT NOT NULL,
  `room` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_schedule_doctor1_idx` (`doctor_id` ASC),
  CONSTRAINT `fk_schedule_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medical`.`doctor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`medical_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`medical_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medical_history_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_medical_history_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `medical`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` MEDIUMTEXT NOT NULL,
  `begin_time` MEDIUMTEXT NOT NULL,
  `doctor_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_doctor1_idx` (`doctor_id` ASC),
  INDEX `fk_order_client1_idx` (`client_id` ASC),
  CONSTRAINT `fk_order_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medical`.`doctor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `medical`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`visit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`visit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `complaints` VARCHAR(200) NOT NULL,
  `diagnosys` VARCHAR(100) NOT NULL,
  `medical_history_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_visit_medical_history1_idx` (`medical_history_id` ASC),
  INDEX `fk_visit_order1_idx` (`order_id` ASC),
  CONSTRAINT `fk_visit_medical_history1`
    FOREIGN KEY (`medical_history_id`)
    REFERENCES `medical`.`medical_history` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_visit_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `medical`.`order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`cure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`cure` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`treatment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`treatment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `prescription` VARCHAR(45) NULL,
  `cure_count` INT NOT NULL,
  `method_of_using` VARCHAR(45) NOT NULL,
  `cure_id` INT NOT NULL,
  `visit_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_treatment_cure1_idx` (`cure_id` ASC),
  INDEX `fk_treatment_visit1_idx` (`visit_id` ASC),
  CONSTRAINT `fk_treatment_cure1`
    FOREIGN KEY (`cure_id`)
    REFERENCES `medical`.`cure` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_treatment_visit1`
    FOREIGN KEY (`visit_id`)
    REFERENCES `medical`.`visit` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medical`.`analyse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medical`.`analyse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `result` VARCHAR(200) NOT NULL,
  `doctor_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  `visit_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_analyse_doctor1_idx` (`doctor_id` ASC),
  INDEX `fk_analyse_client1_idx` (`client_id` ASC),
  INDEX `fk_analyse_visit1_idx` (`visit_id` ASC),
  CONSTRAINT `fk_analyse_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `medical`.`doctor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_analyse_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `medical`.`client` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_analyse_visit1`
    FOREIGN KEY (`visit_id`)
    REFERENCES `medical`.`visit` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
