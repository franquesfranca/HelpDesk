CREATE TABLE Caso(
idCaso INT(6) AUTO_INCREMENT PRIMARY KEY,
idDescricao INT(6) NOT NULL,
FOREIGN KEY (idDescricao) references DescricaoCaso(idDescricaoCaso),
idSolucao INT(6) NOT NULL,
FOREIGN KEY (idSolucao) references SolucaoCaso(idSolucaoCaso)
)engine=InnoDB;
