-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DBIFS
-- -----------------------------------------------------
-- Schema utilizado para disciplina Web 1.

-- -----------------------------------------------------
-- Schema DBIFS
--
-- Schema utilizado para disciplina Web 1.
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBIFS` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `DBIFS` ;

-- -----------------------------------------------------
-- Table `DBIFS`.`coordenada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBIFS`.`coordenada` (
  `id_coordenada` INT NOT NULL AUTO_INCREMENT,
  `latitude` FLOAT NOT NULL,
  `longitude` FLOAT NOT NULL,
  `velocidade` FLOAT NOT NULL,
  `altitude` FLOAT NOT NULL,
  `horario` DATE NOT NULL,
  PRIMARY KEY (`id_coordenada`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBIFS`.`equipamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBIFS`.`equipamento` (
  `id_equipamento` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  `id_coordenada` INT NOT NULL,
  `identificador` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_equipamento`),
  CONSTRAINT `fk_AEJEQUIPAMENTO_AEJCOORDENADA1`
    FOREIGN KEY (`id_coordenada`)
    REFERENCES `DBIFS`.`coordenada` (`id_coordenada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBIFS`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBIFS`.`empresa` (
  `id_empresa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_empresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBIFS`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBIFS`.`pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `dt_cadastro` DATE NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `id_empresa` INT NULL,
  `numero_casa` INT NULL,
  `bairro` VARCHAR(45) NULL,
  `sigla_estado` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(100) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `id_responsavel` INT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pessoa`),
  CONSTRAINT `fk_AEJPESSOA_AEJEMPRESA1`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `DBIFS`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AEJPESSOA_AEJPESSOA1`
    FOREIGN KEY (`id_responsavel`)
    REFERENCES `DBIFS`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBIFS`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBIFS`.`veiculo` (
  `id_veiculo` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(45) NOT NULL,
  `chassi` VARCHAR(45) NOT NULL,
  `ano` DATE NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_veiculo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBIFS`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBIFS`.`servico` (
  `id_servico` INT NOT NULL AUTO_INCREMENT,
  `id_pessoa` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  `id_veiculo` INT NOT NULL,
  `descricao` TEXT NULL,
  `id_equipamento` INT NOT NULL,
  PRIMARY KEY (`id_servico`),
  CONSTRAINT `fk_AEJSERVICO_AEJPESSOA1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `DBIFS`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AEJSERVICO_AEJVEICULO1`
    FOREIGN KEY (`id_veiculo`)
    REFERENCES `DBIFS`.`veiculo` (`id_veiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AEJSERVICO_AEJEQUIPAMENTO1`
    FOREIGN KEY (`id_equipamento`)
    REFERENCES `DBIFS`.`equipamento` (`id_equipamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
