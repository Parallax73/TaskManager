create table Auth(
    id int not null auto_increment,
    login varchar(100) not null,
    senha varchar(100) not null,

    primary key (id)
);