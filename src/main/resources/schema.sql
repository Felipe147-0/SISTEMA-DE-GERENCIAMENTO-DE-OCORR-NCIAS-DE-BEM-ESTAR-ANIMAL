drop database if exists bem_estar_animal;

create database if not exists bem_estar_animal;

use bem_estar_animal;

create table funcionario(
	id_funcionario bigint not null auto_increment,
    nome varchar(255),
    registro varchar(255),
    funcao varchar(255),
    primary key(id_funcionario)
);

create table endereco(
	id_endereco bigint not null auto_increment,
    logradouro varchar(255),
    bairro varchar(255),
    ponto_de_referencia varchar(255),
    primary key (id_endereco)
);

create table denunciante(
	id_denunciante bigint not null auto_increment,
    nome varchar(255),
    telefone varchar(255),
    endereco_id bigint,
    primary key (id_denunciante),
    foreign key (endereco_id) references endereco (id_endereco)
);

create table ficha(
    id_ficha bigint not null auto_increment,
    processo VARCHAR(255),
    recebido_por VARCHAR(255),
    data DATETIME,
    hora DATETIME,
    denunciante_id bigint,
    assunto VARCHAR(255),
    desfecho_da_notificacao VARCHAR(255), 
    data_tramite DATETIME,
    hora_tramite datetime,
    funcionario_id bigint,
    historico VARCHAR(255),
    animal VARCHAR(255),
    primary key (id_ficha),
    foreign key (denunciante_id) references denunciante (id_denunciante),
    foreign key (funcionario_id) references funcionario (id_funcionario)
);


create table login(
	id_login bigint not null auto_increment,
    username varchar(255),
    password varchar(255),
    funcionario_id bigint,
    primary key (id_login),
    foreign key (funcionario_id) references funcionario (id_funcionario)
);

create table role(
	id_role bigint not null auto_increment,
    login_id bigint,
    primary key (id_role),
    foreign key (login_id) references login (id_login)
);
