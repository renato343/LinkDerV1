-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tindercompany
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tindercompany` ;

-- -----------------------------------------------------
-- Schema tindercompany
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tindercompany` DEFAULT CHARACTER SET utf8 ;
USE `tindercompany` ;

-- -----------------------------------------------------
-- Table `tindercompany`.`candidates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`candidates` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`candidates` (
  `candidate_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `github` VARCHAR(255) NULL DEFAULT NULL,
  `linkedin` VARCHAR(255) NULL DEFAULT NULL,
  `motto` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`candidate_id`))
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`companys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`companys` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`companys` (
  `company_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `motto` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`languages` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`languages` (
  `language_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`language_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`frameworks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`frameworks` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`frameworks` (
  `framework_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `languages_language_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`framework_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_frameworks_languages1_idx` (`languages_language_id` ASC),
  CONSTRAINT `fk_frameworks_languages1`
  FOREIGN KEY (`languages_language_id`)
  REFERENCES `tindercompany`.`languages` (`language_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`match_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`match_table` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`match_table` (
  `match_id` INT(11) NOT NULL AUTO_INCREMENT,
  `candidate_bol` BIT(1) NULL DEFAULT b'0',
  `candidate_id` INT(11) NULL DEFAULT NULL,
  `company_bol` BIT(1) NULL DEFAULT b'0',
  `company_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`match_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`Projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`Projects` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`Projects` (
  `project_id` BIGINT(20) NOT NULL,
  `Name` VARCHAR(45) NULL,
  `companys_company_id` INT(11) NOT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `fk_Projects_companys1_idx` (`companys_company_id` ASC),
  CONSTRAINT `fk_Projects_companys1`
  FOREIGN KEY (`companys_company_id`)
  REFERENCES `tindercompany`.`companys` (`company_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tindercompany`.`candidate_languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`candidate_languages` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`candidate_languages` (
  `candidates_candidate_id` BIGINT(20) NOT NULL,
  `languages_language_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`candidates_candidate_id`, `languages_language_id`),
  INDEX `fk_candidates_has_languages_languages1_idx` (`languages_language_id` ASC),
  INDEX `fk_candidates_has_languages_candidates1_idx` (`candidates_candidate_id` ASC),
  CONSTRAINT `fk_candidates_has_languages_candidates1`
  FOREIGN KEY (`candidates_candidate_id`)
  REFERENCES `tindercompany`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidates_has_languages_languages1`
  FOREIGN KEY (`languages_language_id`)
  REFERENCES `tindercompany`.`languages` (`language_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`candidate_frameworks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`candidate_frameworks` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`candidate_frameworks` (
  `candidates_candidate_id` BIGINT(20) NOT NULL,
  `frameworks_framework_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`candidates_candidate_id`, `frameworks_framework_id`),
  INDEX `fk_candidates_has_frameworks_frameworks1_idx` (`frameworks_framework_id` ASC),
  INDEX `fk_candidates_has_frameworks_candidates1_idx` (`candidates_candidate_id` ASC),
  CONSTRAINT `fk_candidates_has_frameworks_candidates1`
  FOREIGN KEY (`candidates_candidate_id`)
  REFERENCES `tindercompany`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidates_has_frameworks_frameworks1`
  FOREIGN KEY (`frameworks_framework_id`)
  REFERENCES `tindercompany`.`frameworks` (`framework_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tindercompany`.`Projects_languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`Projects_languages` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`Projects_languages` (
  `Projects_project_id` BIGINT(20) NOT NULL,
  `languages_language_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`Projects_project_id`, `languages_language_id`),
  INDEX `fk_Projects_has_languages_languages1_idx` (`languages_language_id` ASC),
  INDEX `fk_Projects_has_languages_Projects1_idx` (`Projects_project_id` ASC),
  CONSTRAINT `fk_Projects_has_languages_Projects1`
  FOREIGN KEY (`Projects_project_id`)
  REFERENCES `tindercompany`.`Projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projects_has_languages_languages1`
  FOREIGN KEY (`languages_language_id`)
  REFERENCES `tindercompany`.`languages` (`language_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tindercompany`.`Projects_frameworks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tindercompany`.`Projects_frameworks` ;

CREATE TABLE IF NOT EXISTS `tindercompany`.`Projects_frameworks` (
  `Projects_project_id` BIGINT(20) NOT NULL,
  `frameworks_framework_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`Projects_project_id`, `frameworks_framework_id`),
  INDEX `fk_Projects_has_frameworks_frameworks1_idx` (`frameworks_framework_id` ASC),
  INDEX `fk_Projects_has_frameworks_Projects1_idx` (`Projects_project_id` ASC),
  CONSTRAINT `fk_Projects_has_frameworks_Projects1`
  FOREIGN KEY (`Projects_project_id`)
  REFERENCES `tindercompany`.`Projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projects_has_frameworks_frameworks1`
  FOREIGN KEY (`frameworks_framework_id`)
  REFERENCES `tindercompany`.`frameworks` (`framework_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tindercompany`.`candidates`
-- -----------------------------------------------------
START TRANSACTION;
USE `tindercompany`;
INSERT INTO `tindercompany`.`candidates` (`candidate_id`, `email`, `github`, `linkedin`, `motto`, `name`, `password`) VALUES (1, 'renato@gmail.com', 'github', 'linkdin', 'Hello World', 'Renato', '123');
INSERT INTO `tindercompany`.`candidates` (`candidate_id`, `email`, `github`, `linkedin`, `motto`, `name`, `password`) VALUES (2, 'marisa', 'github', 'linkdin', 'Hello People', 'Marisa', '123');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tindercompany`.`languages`
-- -----------------------------------------------------
START TRANSACTION;
USE `tindercompany`;
INSERT INTO `tindercompany`.`languages` (`language_id`, `name`) VALUES (1, 'JAVA');
INSERT INTO `tindercompany`.`languages` (`language_id`, `name`) VALUES (2, 'C#');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tindercompany`.`frameworks`
-- -----------------------------------------------------
START TRANSACTION;
USE `tindercompany`;
INSERT INTO `tindercompany`.`frameworks` (`framework_id`, `name`, `languages_language_id`) VALUES (1, 'Spring', 1);
INSERT INTO `tindercompany`.`frameworks` (`framework_id`, `name`, `languages_language_id`) VALUES (2, '.Net', 2);
INSERT INTO `tindercompany`.`frameworks` (`framework_id`, `name`, `languages_language_id`) VALUES (3, 'Maven', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tindercompany`.`candidate_languages`
-- -----------------------------------------------------
START TRANSACTION;
USE `tindercompany`;
INSERT INTO `tindercompany`.`candidate_languages` (`candidates_candidate_id`, `languages_language_id`) VALUES (1, 1);
INSERT INTO `tindercompany`.`candidate_languages` (`candidates_candidate_id`, `languages_language_id`) VALUES (2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tindercompany`.`candidate_frameworks`
-- -----------------------------------------------------
START TRANSACTION;
USE `tindercompany`;
INSERT INTO `tindercompany`.`candidate_frameworks` (`candidates_candidate_id`, `frameworks_framework_id`) VALUES (1, 1);
INSERT INTO `tindercompany`.`candidate_frameworks` (`candidates_candidate_id`, `frameworks_framework_id`) VALUES (2, 2);

COMMIT;

