DROP SCHEMA IF EXISTS `bem_estar_animal`;
CREATE SCHEMA IF NOT EXISTS `bem_estar_animal` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `bem_estar_animal`;

-- TABELA ENDERECO
CREATE TABLE IF NOT EXISTS `endereco` (
  `id_endereco` BIGINT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(255) NULL DEFAULT NULL,
  `bairro` VARCHAR(255) NULL DEFAULT NULL,
  `ponto_de_referencia` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABELA SETOR
CREATE TABLE IF NOT EXISTS `setor` (
  `id_setor` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_setor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABELA DENUNCIANTE
CREATE TABLE IF NOT EXISTS `denunciante` (
  `id_denunciante` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `cpf` VARCHAR(45) NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  `endereco_id` BIGINT NULL DEFAULT NULL,
  `em_lista` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id_denunciante`),
  INDEX `endereco_id` (`endereco_id` ASC),
  CONSTRAINT `denunciante_ibfk_1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABELA FUNCIONARIO
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id_funcionario` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `registro` VARCHAR(255) NULL DEFAULT NULL,
  `funcao` VARCHAR(255) NULL DEFAULT NULL,
  `id_setor` BIGINT NULL,
  PRIMARY KEY (`id_funcionario`),
  INDEX `fk_funcionario_setor1_idx` (`id_setor` ASC),
  CONSTRAINT `fk_funcionario_setor1`
    FOREIGN KEY (`id_setor`)
    REFERENCES `setor` (`id_setor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABELA LISTA_EXCLUSAO
CREATE TABLE IF NOT EXISTS `lista_exclusao` (
  `id_lista_exclusao` BIGINT NOT NULL AUTO_INCREMENT,
  `observacao` VARCHAR(500) NULL,
  `id_denunciante` BIGINT NULL,
  PRIMARY KEY (`id_lista_exclusao`),
  UNIQUE INDEX `denunciante_unico_idx` (`id_denunciante` ASC),
  CONSTRAINT `fk_listaExclusao_denunciante1`
    FOREIGN KEY (`id_denunciante`)
    REFERENCES `denunciante` (`id_denunciante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABELA FICHA
CREATE TABLE IF NOT EXISTS `ficha` (
  `id_ficha` BIGINT NOT NULL AUTO_INCREMENT,
  `processo_ouvidoria` VARCHAR(50) NULL DEFAULT NULL,
  `recebido_por_secretaria` VARCHAR(40) NULL DEFAULT NULL,
  `recebido_por_ouvidoria` VARCHAR(40) NULL DEFAULT NULL,
  `data_ouvidoria` VARCHAR(40) NULL DEFAULT NULL,
  `hora_ouvidoria` VARCHAR(40) NULL DEFAULT NULL,
  `denunciante_id` BIGINT NULL DEFAULT NULL,
  `desfecho_da_notificacao` VARCHAR(500) NULL DEFAULT NULL,
  `data_secretaria` VARCHAR(40) NULL DEFAULT NULL,
  `hora_secretaria` VARCHAR(40) NULL DEFAULT NULL,
  `funcionario_id` BIGINT NULL DEFAULT NULL,
  `historico` VARCHAR(255) NULL DEFAULT NULL,
  `processo_secretaria` VARCHAR(50) NULL DEFAULT NULL,
  `fiscal` VARCHAR(50) NULL DEFAULT NULL,
  `data_tramite` VARCHAR(40) NULL DEFAULT NULL,
  `hora_tramite` VARCHAR(40) NULL DEFAULT NULL,
  `assunto` VARCHAR(500) NULL,
  `interno` INT NULL,
  `protocolo` VARCHAR(100) NULL,
  PRIMARY KEY (`id_ficha`),
  INDEX `denunciante_id` (`denunciante_id` ASC),
  INDEX `funcionario_id` (`funcionario_id` ASC),
  CONSTRAINT `ficha_ibfk_1`
    FOREIGN KEY (`denunciante_id`)
    REFERENCES `denunciante` (`id_denunciante`),
  CONSTRAINT `ficha_ibfk_2`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABELA ANIMAL
CREATE TABLE IF NOT EXISTS `animal` (
  `id_animal` BIGINT NOT NULL AUTO_INCREMENT,
  `registro` VARCHAR(255) NULL,
  `possui_chip` TINYINT(1) NULL DEFAULT 0,
  `numero_chip` VARCHAR(255) NULL,
  `observacao` VARCHAR(500) NULL,
  `ficha_id` BIGINT NULL,
  PRIMARY KEY (`id_animal`),
  INDEX `ficha_id_idx` (`ficha_id` ASC),
  CONSTRAINT `fk_animal_ficha`
    FOREIGN KEY (`ficha_id`)
    REFERENCES `ficha` (`id_ficha`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
