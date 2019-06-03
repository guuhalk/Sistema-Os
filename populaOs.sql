-- POPULA BANCO OS



/* TABELA DE PERFIL */
INSERT INTO `os_db`.`perfil` (`prf_id`, `prf_ativo`, `prf_descricao`) VALUES ('1', '1', 'admin');
INSERT INTO `os_db`.`perfil` (`prf_id`, `prf_ativo`, `prf_descricao`) VALUES ('2', '1', 'comum');
INSERT INTO `os_db`.`perfil` (`prf_id`, `prf_ativo`, `prf_descricao`) VALUES ('3', '1', 'analista');

/* TABELA DE USUARIO */
INSERT INTO `os_db`.`usuario` (`usu_id`, `usu_ativo`, `usu_cpf`, `usu_email`, `usu_login`, `usu_nome`, `usu_senha`, `prf_id`) VALUES ('1', '1', '1234567890', 'admin@os.com', 'admin', 'Administrador', '123', '1');
INSERT INTO `os_db`.`usuario` (`usu_id`, `usu_ativo`, `usu_cpf`, `usu_email`, `usu_login`, `usu_nome`, `usu_senha`, `prf_id`) VALUES ('2', '1', '0987654321', 'user@os.com', 'user', 'Usuario', '123', '2');
INSERT INTO `os_db`.`usuario` (`usu_id`, `usu_ativo`, `usu_cpf`, `usu_email`, `usu_login`, `usu_nome`, `usu_senha`, `prf_id`) VALUES ('3', '1', '5432167890', 'analista@os.com', 'analista', 'Analista', '123', '3');

/* TABELA DE STATUS */
INSERT INTO `os_db`.`os_status` (`sts_id`, `sts_descricao`) VALUES ('1', 'Desenvolvimento');
INSERT INTO `os_db`.`os_status` (`sts_id`, `sts_descricao`) VALUES ('2', 'Aguardando Usuario');
INSERT INTO `os_db`.`os_status` (`sts_id`, `sts_descricao`) VALUES ('3', 'Aguardando Terceiros');
INSERT INTO `os_db`.`os_status` (`sts_id`, `sts_descricao`) VALUES ('4', 'Teste');
INSERT INTO `os_db`.`os_status` (`sts_id`, `sts_descricao`) VALUES ('5', 'Fechado');
INSERT INTO `os_db`.`os_status` (`sts_id`, `sts_descricao`) VALUES ('6', 'Reprovado');