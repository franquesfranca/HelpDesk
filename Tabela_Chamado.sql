CREATE TABLE Chamado(
idChamado INT(6) AUTO_INCREMENT PRIMARY KEY,
tituloChamado VARCHAR(120) NOT NULL,
descricaoChamado VARCHAR(360) NOT NULL,
chamadoAtendido BOOLEAN NOT NULL
)engine=InnoDB;