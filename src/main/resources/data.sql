-- ENDERECO
INSERT INTO `bem_estar_animal`.`endereco`
  (`logradouro`, `bairro`, `ponto_de_referencia`)
VALUES
  ('Rua das Palmeiras, 120', 'Centro', 'Próximo à praça central');

-- DENUNCIANTES
INSERT INTO `bem_estar_animal`.`denunciante`
  (`nome`, `cpf`, `telefone`, `endereco_id`)
VALUES
  ('João Silva', '123.456.789-00', '(11) 98765-4321', 1),
  ('Maria Oliveira', '234.567.890-11', '(21) 99876-5432', 1),
  ('Carlos Pereira', '345.678.901-22', '(31) 95555-6677', 1),
  ('Ana Souza', '456.789.012-33', '(41) 92222-3344', 1),
  ('Lucas Lima', '567.890.123-44', '(51) 91111-2233', 1);

-- SETOR
INSERT INTO `setor` VALUES
(1, 'ADMINISTRACAO'),
(2, 'SECRETARIA'),
(3, 'OUVIDORIA'),
(4, 'FISCAL');

-- FUNCIONARIO
INSERT INTO `funcionario` (nome, cpf, telefone, endereco, registro, funcao, id_setor)
VALUES ('Pietro', '2222', '123456789', 'Rua Exemplo, 123', 'REG-001', 'Usuário', 1);


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
  1,
  'Notificação encaminhada para fiscalização.',
  '2025-11-05',
  '09:15',
  1,
  'Denúncia recebida e encaminhada à equipe de campo.',
  'PROC-SEC-2025-045',
  'Fiscal João da Silva',
  '2025-11-06',
  '14:00',
  'Maus-tratos a animal doméstico',
  0,
  'PROTO-2025-98765'
);

-- ANIMAL
INSERT INTO `bem_estar_animal`.`animal`
  (`registro`, `possui_chip`, `numero_chip`, `observacao`, `ficha_id`)
VALUES
  ('CACHORRO', 1, 'CHIP-12345', 'Animal com chip, resgatado em bom estado.', 1),
  ('GATO', 0, NULL, 'Animal encontrado em situação de risco.', 1),
  ('CAVALO', 1, 'CHIP-98765', 'Animal de grande porte, com identificação.', 1),
  ('AVE', 0, NULL, 'Ave ferida, sem identificação.', 1);
