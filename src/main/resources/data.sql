INSERT INTO `bem_estar_animal`.`endereco` 
  (`logradouro`, `bairro`, `ponto_de_referencia`) 
VALUES 
  ('rua ffffffffffffffffffffffffffff', 'bairooooooooooooo', 'aaaaaaaa');

INSERT INTO `bem_estar_animal`.`denunciante` 
  (`nome`, `cpf`, `telefone`, `endereco_id`, `id_lista_exclusao`) 
VALUES 
  ('noememememe', NULL, '32132121', '1', NULL);
  
insert into setor values (1);
insert into funcionario values (1, "pietro", 2222, "Usuário", 1);

INSERT INTO `bem_estar_animal`.`ficha` 
  (`id_ficha`, `processo_ouvidoria`, `recebido_por_secretaria`, `recebido_por_ouvidoria`, `data_ouvidoria`, `hora_ouvidoria`, 
   `denunciante_id`, `desfecho_da_notificacao`, `data_secretaria`, `hora_secretaria`, `funcionario_id`, `historico`, `animal`, 
   `processo_secretaria`, `fiscal`, `data_tramite`, `hora_tramite`, `assunto`, `interno`, `protocolo`) 
VALUES 
  (NULL, NULL, NULL, NULL, '27/10/2025', '19:14', '1', 'aaaaaaaaaaaaaa', NULL, NULL, '1', NULL, NULL, NULL, NULL, '12/10/2222', 
   '2222', 'aaaaaaaa', '0', NULL);