-- ENDERECO
INSERT INTO `bem_estar_animal`.`endereco` 
  (`logradouro`, `bairro`, `ponto_de_referencia`) 
VALUES 
  ('rua ffffffffffffffffffffffffffff', 'bairooooooooooooo', 'aaaaaaaa');

-- DENUNCIANTE
INSERT INTO `bem_estar_animal`.`denunciante` 
  (`nome`, `cpf`, `telefone`, `endereco_id`) 
VALUES 
  ('noememememe', NULL, '32132121', '1');

  -- Insert 1
INSERT INTO `bem_estar_animal`.`denunciante` 
(`nome`, `cpf`, `telefone`, `endereco_id` ) 
VALUES 
('João Silva', '123.456.789-00', '(11) 98765-4321', null);

-- Insert 2
INSERT INTO `bem_estar_animal`.`denunciante` 
(`nome`, `cpf`, `telefone`, `endereco_id` ) 
VALUES 
('Maria Oliveira', '234.567.890-11', '(21) 99876-5432', null);

-- Insert 3
INSERT INTO `bem_estar_animal`.`denunciante` 
(`nome`, `cpf`, `telefone`, `endereco_id` ) 
VALUES 
('Carlos Pereira', '345.678.901-22', '(31) 95555-6677', null);

-- Insert 4
INSERT INTO `bem_estar_animal`.`denunciante` 
(`nome`, `cpf`, `telefone`, `endereco_id` ) 
VALUES 
('Ana Souza', '456.789.012-33', '(41) 92222-3344', null);

-- Insert 5
INSERT INTO `bem_estar_animal`.`denunciante` 
(`nome`, `cpf`, `telefone`, `endereco_id`) 
VALUES 
('Lucas Lima', '567.890.123-44', '(51) 91111-2233', null);

  
-- SETOR
insert into setor values (1, "ADMINISTRACAO");
insert into setor values (2, "SECRETARIA");
insert into setor values (3, "OUVIDORIA");
insert into setor values (4, "FISCAL");

-- FUNCIONARIO
insert into funcionario values (1, "pietro", 2222, "Usuário", 1);

-- FICHA
INSERT INTO `bem_estar_animal`.`ficha` (
  `processo_ouvidoria`,
  `recebido_por_secretaria`,
  `recebido_por_ouvidoria`,
  `data_ouvidoria`,
  `hora_ouvidoria`,
  `denunciante_id`,
  `desfecho_da_notificacao`,
  `data_secretaria`,
  `hora_secretaria`,
  `funcionario_id`,
  `historico`,
  `animal`,
  `processo_secretaria`,
  `fiscal`,
  `data_tramite`,
  `hora_tramite`,
  `assunto`,
  `interno`,
  `protocolo`
) VALUES
(
  'PROC-OUV-2025-0001',
  'Secretaria de Meio Ambiente',
  'Ouvidoria Municipal',
  '2025-11-04',
  '10:35',
  1,  -- denunciante_id (ok)
  'Notificação encaminhada para fiscalização.',
  '2025-11-05',
  '09:15',
  1,  -- funcionario_id corrigido para 1
  'Denúncia recebida e encaminhada à equipe de campo.',
  'Cachorro',
  'PROC-SEC-2025-045',
  'Fiscal João da Silva',
  '2025-11-06',
  '14:00',
  'Maus-tratos a animal doméstico',
  0,
  'PROTO-2025-98765'
);
