CREATE TABLE Usuario(
matricula VARCHAR(10) PRIMARY KEY,
nome VARCHAR(80) NOT NULL,
senha VARCHAR(10) NOT NULL,
admin BOOLEAN NOT NULL
)engine=InnoDB;
