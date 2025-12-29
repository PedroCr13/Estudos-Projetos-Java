-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           11.5.2-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando estrutura para tabela empresa4.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `qtd_dependentes` int(11) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `cod_departamento` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKeufq1nefhvno14jjwi5skqkrk` (`cod_departamento`),
  CONSTRAINT `FKeufq1nefhvno14jjwi5skqkrk` FOREIGN KEY (`cod_departamento`) REFERENCES `departamento` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Copiando dados para a tabela empresa4.funcionario: ~24 rows (aproximadamente)
INSERT INTO `funcionario` (`codigo`, `nome`, `qtd_dependentes`, `salario`, `cargo`, `cod_departamento`) VALUES
	(1, 'Joao Luiz', 3, 7067.511360000001, 'Gerente', 1),
	(2, 'Maria Silva', 1, 7067.511360000001, 'Gerente', 5),
	(3, 'Marcos Oliveira', 2, 1667.6150400000001, 'Analista JR', 2),
	(4, 'Julia Prado', 0, 3573.4608000000007, 'Analista PL', 2),
	(5, 'Roberto Lopes', 2, 5955.768000000001, 'Analista SR', 2),
	(6, 'Roberta Clara', 0, 3573.4608000000007, 'Analista PL', 2),
	(7, 'Anderson Silva', 4, 1429.3843200000003, 'Tecnico Suporte JR', 4),
	(8, 'Paulo Jose', 1, 1747.02528, 'Tecnico Suporte PL', 4),
	(9, 'Rui Silveira', 3, 2779.3584, 'Tecnico Suporte SR', 4),
	(10, 'Tais Alves', 2, 1508.79456, 'Agente Cobranca JR', 5),
	(11, 'Carlos Santos', 4, 1508.79456, 'Agente Cobranca JR', 5),
	(12, 'Mariana da Silva', 2, 1985.256, 'Agente Cobranca PL', 5),
	(13, 'Augusta Maria', 3, 2858.7686400000007, 'Vendedor PL', 1),
	(14, 'Alicia Pedroso', 0, 7067.511360000001, 'Gerente', 1),
	(15, 'Paulo Silveira', 0, 2858.7686400000007, 'Vendedor PL', 1),
	(16, 'Consoelo do Prado', 2, 5399.896320000001, 'Vendedor SR', 1),
	(17, 'Airton Franca', 2, 1508.79456, 'Tecnico Adm JR', 7),
	(18, 'Lucia Colina', 0, 1747.02528, 'Tecnico Adm PL', 7),
	(19, 'Alfredo Luiz', 2, 1747.02528, 'Tecnico Adm PL', 7),
	(20, 'Pamela Bravo', 5, 1548.4996800000001, 'Tecnico Marketing JR', 6),
	(21, 'Thiago Ruiz', 2, 7067.511360000001, 'Gerente', 6),
	(22, 'Caio Roberto', 0, 1508.79456, 'Tec Eletronica JR', 8),
	(23, 'Ana Maria', 0, 1747.02528, 'Tec Eletronica PL', 8),
	(24, 'Carlos Eduardo', 3, 1508.79456, 'Tec Eletronica JR', 8);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
