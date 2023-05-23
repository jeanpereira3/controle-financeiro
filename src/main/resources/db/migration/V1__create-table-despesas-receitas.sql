create table  despesas (
    id bigint not null auto_increment,
    descricao varchar(255) not null,
    valor DOUBLE not null,
    data DATE not null,

    primary key(id)
);

create table  receitas (
    id bigint not null auto_increment,
    descricao varchar(255) not null,
    valor DOUBLE not null,
    data DATE not null,

    primary key(id)
);