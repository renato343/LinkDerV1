-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema linkder
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `linkder` ;

-- -----------------------------------------------------
-- Schema linkder
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `linkder` DEFAULT CHARACTER SET utf8 ;
USE `linkder` ;

-- -----------------------------------------------------
-- Table `linkder`.`candidates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`candidates` ;

CREATE TABLE IF NOT EXISTS `linkder`.`candidates` (
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
-- Table `linkder`.`companys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`companys` ;

CREATE TABLE IF NOT EXISTS `linkder`.`companys` (
  `company_id` BIGINT(20) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `motto` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`languages` ;

CREATE TABLE IF NOT EXISTS `linkder`.`languages` (
  `language_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`language_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`frameworks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`frameworks` ;

CREATE TABLE IF NOT EXISTS `linkder`.`frameworks` (
  `framework_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `language_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`framework_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_frameworks_languages1_idx` (`language_id` ASC),
  CONSTRAINT `fk_frameworks_languages1`
  FOREIGN KEY (`language_id`)
  REFERENCES `linkder`.`languages` (`language_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`projects` ;

CREATE TABLE IF NOT EXISTS `linkder`.`projects` (
  `project_id` BIGINT(20) NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`project_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkder`.`mitch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`mitch` ;

CREATE TABLE IF NOT EXISTS `linkder`.`mitch` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `candidate_id` BIGINT(20) NULL,
  `candidate_bol` BIT(1) NULL DEFAULT b'0',
  `project_id` BIGINT(20) NULL,
  `project_bol` BIT(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  INDEX `fk_match_table_candidates1_idx` (`candidate_id` ASC),
  INDEX `fk_match_table_projects1_idx` (`project_id` ASC),
  CONSTRAINT `fk_match_table_candidates1`
  FOREIGN KEY (`candidate_id`)
  REFERENCES `linkder`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_match_table_projects1`
  FOREIGN KEY (`project_id`)
  REFERENCES `linkder`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`candidate_languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`candidate_languages` ;

CREATE TABLE IF NOT EXISTS `linkder`.`candidate_languages` (
  `candidates_id` BIGINT(20) NOT NULL,
  `languages_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`candidates_id`, `languages_id`),
  INDEX `fk_candidates_has_languages_languages1_idx` (`languages_id` ASC),
  INDEX `fk_candidates_has_languages_candidates1_idx` (`candidates_id` ASC),
  CONSTRAINT `fk_candidates_has_languages_candidates1`
  FOREIGN KEY (`candidates_id`)
  REFERENCES `linkder`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidates_has_languages_languages1`
  FOREIGN KEY (`languages_id`)
  REFERENCES `linkder`.`languages` (`language_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`candidate_frameworks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`candidate_frameworks` ;

CREATE TABLE IF NOT EXISTS `linkder`.`candidate_frameworks` (
  `candidate_id` BIGINT(20) NOT NULL,
  `framework_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`candidate_id`, `framework_id`),
  INDEX `fk_candidates_has_frameworks_frameworks1_idx` (`framework_id` ASC),
  INDEX `fk_candidates_has_frameworks_candidates1_idx` (`candidate_id` ASC),
  CONSTRAINT `fk_candidates_has_frameworks_candidates1`
  FOREIGN KEY (`candidate_id`)
  REFERENCES `linkder`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidates_has_frameworks_frameworks1`
  FOREIGN KEY (`framework_id`)
  REFERENCES `linkder`.`frameworks` (`framework_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`projects_languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`projects_languages` ;

CREATE TABLE IF NOT EXISTS `linkder`.`projects_languages` (
  `project_id` BIGINT(20) NOT NULL,
  `language_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`project_id`, `language_id`),
  INDEX `fk_Projects_has_languages_languages1_idx` (`language_id` ASC),
  INDEX `fk_Projects_has_languages_Projects1_idx` (`project_id` ASC),
  CONSTRAINT `fk_Projects_has_languages_Projects1`
  FOREIGN KEY (`project_id`)
  REFERENCES `linkder`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projects_has_languages_languages1`
  FOREIGN KEY (`language_id`)
  REFERENCES `linkder`.`languages` (`language_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkder`.`projects_frameworks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`projects_frameworks` ;

CREATE TABLE IF NOT EXISTS `linkder`.`projects_frameworks` (
  `projects_id` BIGINT(20) NOT NULL,
  `framework_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`projects_id`, `framework_id`),
  INDEX `fk_Projects_has_frameworks_frameworks1_idx` (`framework_id` ASC),
  INDEX `fk_Projects_has_frameworks_Projects1_idx` (`projects_id` ASC),
  CONSTRAINT `fk_Projects_has_frameworks_Projects1`
  FOREIGN KEY (`projects_id`)
  REFERENCES `linkder`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projects_has_frameworks_frameworks1`
  FOREIGN KEY (`framework_id`)
  REFERENCES `linkder`.`frameworks` (`framework_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `linkder`.`companys_projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`companys_projects` ;

CREATE TABLE IF NOT EXISTS `linkder`.`companys_projects` (
  `companys_id` BIGINT(20) NOT NULL,
  `Projects_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`companys_id`, `Projects_id`),
  INDEX `fk_companys_has_Projects_Projects1_idx` (`Projects_id` ASC),
  INDEX `fk_companys_has_Projects_companys1_idx` (`companys_id` ASC),
  CONSTRAINT `fk_companys_has_Projects_companys1`
  FOREIGN KEY (`companys_id`)
  REFERENCES `linkder`.`companys` (`company_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_companys_has_Projects_Projects1`
  FOREIGN KEY (`Projects_id`)
  REFERENCES `linkder`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `linkder`.`candidates_projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `linkder`.`candidates_projects` ;

CREATE TABLE IF NOT EXISTS `linkder`.`candidates_projects` (
  `candidates_id` BIGINT(20) NOT NULL,
  `project_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`candidates_id`, `project_id`),
  INDEX `fk_candidates_has_Projects_Projects1_idx` (`project_id` ASC),
  INDEX `fk_candidates_has_Projects_candidates1_idx` (`candidates_id` ASC),
  CONSTRAINT `fk_candidates_has_Projects_candidates1`
  FOREIGN KEY (`candidates_id`)
  REFERENCES `linkder`.`candidates` (`candidate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidates_has_Projects_Projects1`
  FOREIGN KEY (`project_id`)
  REFERENCES `linkder`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `linkder`.`candidates`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`candidates` (`candidate_id`, `email`, `github`, `linkedin`, `motto`, `name`, `password`) VALUES (1, 'renato@gmail.com', 'github', 'linkdin', 'Hello World', 'Renato', '123');
INSERT INTO `linkder`.`candidates` (`candidate_id`, `email`, `github`, `linkedin`, `motto`, `name`, `password`) VALUES (2, 'marisa', 'github', 'linkdin', 'Hello People', 'Marisa', '123');

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`companys`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`companys` (`company_id`, `email`, `motto`, `name`, `password`) VALUES (1, 'altran@altran.com', 'We\'re french', 'Altran', '123');
INSERT INTO `linkder`.`companys` (`company_id`, `email`, `motto`, `name`, `password`) VALUES (2, 'logicalis', 'We\'re Fuition', 'Logicallis', '123');
INSERT INTO `linkder`.`companys` (`company_id`, `email`, `motto`, `name`, `password`) VALUES (3, 'academia@codigo.com', 'We\'re Crazy', 'Academia', '123');

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`languages`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`languages` (`language_id`, `name`) VALUES (1, 'JAVA');
INSERT INTO `linkder`.`languages` (`language_id`, `name`) VALUES (2, 'C#');
INSERT INTO `linkder`.`languages` (`language_id`, `name`) VALUES (3, 'JavaScript');

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`frameworks`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`frameworks` (`framework_id`, `name`, `language_id`) VALUES (1, 'Spring', 1);
INSERT INTO `linkder`.`frameworks` (`framework_id`, `name`, `language_id`) VALUES (2, '.Net', 2);
INSERT INTO `linkder`.`frameworks` (`framework_id`, `name`, `language_id`) VALUES (3, 'Maven', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`projects`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`projects` (`project_id`, `Name`) VALUES (1, 'Axa');
INSERT INTO `linkder`.`projects` (`project_id`, `Name`) VALUES (2, 'ClientNow');
INSERT INTO `linkder`.`projects` (`project_id`, `Name`) VALUES (3, 'bootcamp ');

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`candidate_languages`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`candidate_languages` (`candidates_id`, `languages_id`) VALUES (1, 1);
INSERT INTO `linkder`.`candidate_languages` (`candidates_id`, `languages_id`) VALUES (2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`candidate_frameworks`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`candidate_frameworks` (`candidate_id`, `framework_id`) VALUES (1, 1);
INSERT INTO `linkder`.`candidate_frameworks` (`candidate_id`, `framework_id`) VALUES (2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`projects_languages`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`projects_languages` (`project_id`, `language_id`) VALUES (1, 2);
INSERT INTO `linkder`.`projects_languages` (`project_id`, `language_id`) VALUES (2, 3);
INSERT INTO `linkder`.`projects_languages` (`project_id`, `language_id`) VALUES (3, 1);
INSERT INTO `linkder`.`projects_languages` (`project_id`, `language_id`) VALUES (3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`projects_frameworks`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`projects_frameworks` (`projects_id`, `framework_id`) VALUES (1, 2);
INSERT INTO `linkder`.`projects_frameworks` (`projects_id`, `framework_id`) VALUES (3, 1);
INSERT INTO `linkder`.`projects_frameworks` (`projects_id`, `framework_id`) VALUES (3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `linkder`.`companys_projects`
-- -----------------------------------------------------
START TRANSACTION;
USE `linkder`;
INSERT INTO `linkder`.`companys_projects` (`companys_id`, `Projects_id`) VALUES (1, 1);
INSERT INTO `linkder`.`companys_projects` (`companys_id`, `Projects_id`) VALUES (2, 2);
INSERT INTO `linkder`.`companys_projects` (`companys_id`, `Projects_id`) VALUES (3, 3);

COMMIT;

