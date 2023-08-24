--criando a tabela de usuários
create table usuario(
	id		serial		primary key,
	nome		varchar(100)	not null,
	email		varchar(50)	not null,
	senha		varchar(40)	not null
);


--criando a tabela de conta
create table conta(
	id		serial		primary key,
	nome		varchar(100)	not null,
	descricao	varchar(500)	null,
	data		date			not null,
	valor		decimal(18,2)	not null,
	tipo		integer		not null,
	usuario_id	integer			not null,
	foreign key(usuario_id) references usuario(id)
);
