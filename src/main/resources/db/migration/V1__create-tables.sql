use taskmanager;
create table Tarefas(
                tarefa_Id int not null auto_increment,
                nome varchar(100) not null ,
                status varchar(50) not null,
                prioridade varchar(50) not null,
                ETA date not null,
                descricao varchar(450),

                primary key (tarefa_Id)
);

create table Usuarios(
            usuario_Id int not null auto_increment,
            nome varchar(100) not null,
            email varchar(50) not null,
            senha varchar(20) not null,

            primary key (usuario_Id)
);

create table tarefas_usuario(
        id int not null auto_increment,
        tarefa_Id int not null,
        usuario_Id int not null,

        primary key (id),

        foreign key (tarefa_Id) references Tarefas(tarefa_Id),
        foreign key (usuario_Id) references Usuarios(usuario_Id)
);