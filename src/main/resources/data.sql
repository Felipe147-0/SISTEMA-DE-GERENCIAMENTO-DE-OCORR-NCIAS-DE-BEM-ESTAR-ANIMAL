INSERT INTO `bem_estar_animal`.`endereco` 
  (`logradouro`, `bairro`, `ponto_de_referencia`) 
VALUES 
  ('rua ffffffffffffffffffffffffffff', 'bairooooooooooooo', 'aaaaaaaa');

INSERT INTO `bem_estar_animal`.`denunciante` 
  (`nome`, `cpf`, `telefone`, `endereco_id`, `id_lista_exclusao`) 
VALUES 
  ('noememememe', NULL, '32132121', '1', NULL);
  
insert into setor values (1, "administracao");
insert into funcionario values (1, "pietro", 2222, "Usuário", 1);

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
