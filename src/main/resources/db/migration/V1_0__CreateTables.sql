CREATE TABLE `tb_cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(14) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tb_produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `valor_produto` decimal(14,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tb_pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_do_pedido` datetime NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `valor_total_do_pedido` decimal(14,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjqm65wiaj65gia070a45vt9w` (`id_cliente`),
  CONSTRAINT `FKmjqm65wiaj65gia070a45vt9w` FOREIGN KEY (`id_cliente`) REFERENCES `tb_cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tb_pedido_item` (
  `id_pedido` bigint(20) NOT NULL,
  `id_produto` bigint(20) NOT NULL,
  `quantidade` double NOT NULL,
  `valor_total_itens_do_pedido` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`,`id_produto`),
  UNIQUE KEY `UK_7nvicfyvigrglxjmiv1j6frdt` (`id_produto`),
  CONSTRAINT `FK92m1orgkgf2dutd43jwuk27oc` FOREIGN KEY (`id_pedido`) REFERENCES `tb_pedido` (`id`),
  CONSTRAINT `FKirm93hpn8g3nsmq08ej9p61y2` FOREIGN KEY (`id_produto`) REFERENCES `tb_produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto A',10.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto B',20.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto C',30.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto D',40.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto E',50.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto F',60.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto G',70.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto H',80.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto I',90.01);
INSERT INTO `db-eicon`.`tb_produto` (`descricao`,`valor_produto`) VALUES ('Produto J',100.01);

INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('650.420.260-53','cli1@gmail.com','Customer 1');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('833.137.300-60','cli2@gmail.com','Customer 2');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('815.928.960-06','cli3@gmail.com','Customer 3');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('566.784.920-80','cli4@gmail.com','Customer 4');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('277.709.470-57','cli5@gmail.com','Customer 5');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('052.139.510-07','cli6@gmail.com','Customer 6');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('721.386.930-23','cli7@gmail.com','Customer 7');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('387.031.670-54','cli8@gmail.com','Customer 8');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('045.003.470-46','cli9@gmail.com','Customer 9');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('004.428.980-45','cli10@gmail.com','Customer 10');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('896.625.650-35','cli11@gmail.com','Customer 11');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('052.062.130-12','cli12@gmail.com','Customer 12');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('021.484.800-06','cli13@gmail.com','Customer 13');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('572.456.070-44','cli14@gmail.com','Customer 14');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('363.835.550-06','cli15@gmail.com','Customer 15');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('672.625.720-16','cli16@gmail.com','Customer 16');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('157.098.080-24','cli17@gmail.com','Customer 17');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('902.744.420-00','cli18@gmail.com','Customer 18');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('399.508.750-72','cli19@gmail.com','Customer 19');
INSERT INTO `db-eicon`.`tb_cliente` (`cpf`,`email`,`nome_cliente`) VALUES ('634.362.050-87','cli20@gmail.com','Customer 20');

INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',1,20.02);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/02',2,140.05);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/03',3,50.01);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/04',4,40.04);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/05',5,50.05);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/06',6,60.06);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/07',7,70.07);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/08',8,80.08);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/09',9,90.09);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/1',10,100.10);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/10',11,110.02);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',12,120.03);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',13,130.04);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',14,140.05);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',15,150.06);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',16,160.07);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',17,170.08);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',18,180.09);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',19,190.10);
INSERT INTO `db-eicon`.`tb_pedido` (`data_do_pedido`,`id_cliente`,`valor_total_do_pedido`) VALUES ('2019/12/01',20,200.02);

INSERT INTO `db-eicon`.`tb_pedido_item` (`id_pedido`,`id_produto`,`quantidade`,`valor_total_itens_do_pedido`) VALUES (1,1,2,20.02);
INSERT INTO `db-eicon`.`tb_pedido_item` (`id_pedido`,`id_produto`,`quantidade`,`valor_total_itens_do_pedido`) VALUES (2,2,1,20.01);
INSERT INTO `db-eicon`.`tb_pedido_item` (`id_pedido`,`id_produto`,`quantidade`,`valor_total_itens_do_pedido`) VALUES (2,3,4,120.04);
INSERT INTO `db-eicon`.`tb_pedido_item` (`id_pedido`,`id_produto`,`quantidade`,`valor_total_itens_do_pedido`) VALUES (3,5,1,50.01);
