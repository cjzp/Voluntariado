/*DROP DATABASE IF EXISTS bd_sistema;*/
/*
CREATE USER 'dev'@'localhost' IDENTIFIED BY 'dev';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'dev'@'localhost';
*/
/*
create database bd_sistema;

use bd_sistema;*/

CREATE DATABASE IF NOT EXISTS `bd_sistema` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bd_sistema`;


CREATE TABLE `tb_usuario` (
  `cod_usu` varchar(11) NOT NULL,
  `nom_usu` varchar(50) NOT NULL,
  `ape_usu` varchar(50) NOT NULL,
  `fono_usu` varchar(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `login_usu` varchar(15) NOT NULL,
  `pass_usu` varchar(20) NOT NULL,
 `cod_estado` int(5) NOT NULL references tb_estado, 
  PRIMARY KEY (`cod_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

											
insert into tb_usuario values 
				('pmviscarra','juan','juan',99682448,'pmviscarra@cibertec','pmviscarra','123',10), 
			
                ('admperez','Administrador Juan','Juan',99878998,'i201577773@cibertec','admperez','123',10),
                
                /*docentes*/
                ('pmvelasco','Gissette','Velasco',974159626,'gsvelasco@cibertec','pmvelasco','pmvelasco',10),
				('pmjovita','Ada','Jovita',934789865,'pmjovita@cibertec','pmjovita','pmjovita',10),
                
                /*alumnos*/
                ('i201514763','Julio', 'Limache',959682445,'i201514763@cibertec','i201514763','i201514763',10),
				('i20157777','Elisban','Mamani ',934574899,'i20157777@cibertec','i20157777','i20157777',10),
				('i201774580','Fiorela','Vargas',979808054,'i201774580@cibertec','i201774580','i201774580',10),
				('i201555555','Pamela','Bellido',979808054,'i20155555@cibertec','i201555555','i201555555',10);
                

create TABLE `tb_alumno` (
  `cod_alu` varchar(10) NOT NULL,
  `cod_usu` varchar(11) NOT NULL references tb_usuario,
  `cod_carrera` int(3) NOT NULL references tb_carrera,
  `cod_seccion` int(3) NOT NULL references tb_seccion,  
  `cod_act` varchar(11) DEFAULT NULL references tb_actividad, 
  PRIMARY KEY (`cod_alu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_alumno values ('i201514763','i201514763',1,1,null), 
							('i20157777', 'i20157777',1,1,null),
							('i201774580','i201774580',3,4,null),
                            ('i201555555','i201555555',4,3,null);

CREATE TABLE `tb_docente` (
  `cod_doc` varchar(14) NOT NULL,
  `cod_usu` varchar(11) NOT NULL references tb_usuario,
  PRIMARY KEY (`cod_doc`)	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_docente values ('pmvelasco','pmvelasco'),
								('pmjovita','pmjovita');
				

create table`tb_estado` (
  `cod_estado` int(5) NOT NULL,
  `nom_estado` varchar(15) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_estado values (1,'Aprobado'),/*estados para actividad*/
							(2,'En Revisión'),
							(3,'Descartado'),
                            (10,'Activo'), /*estados para usuarios*/
                            (11,'Inactivo');

CREATE TABLE `tb_institucion` (
  `cod_ins` int(10) NOT NULL AUTO_INCREMENT,
  `nom_ins` varchar(80) NOT NULL,
  `carac_ins` varchar(100) NOT NULL, 
  `direc_ins` varchar(100) NOT NULL,
  `fono_ins` varchar(20) NOT NULL,
  PRIMARY KEY (`cod_ins`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8;

insert into tb_institucion values (1,'Caritas Arequipa','Institucion encargada del cuidado de niños con discapacidad','Av Benavidez #107 - Cercado','054-457884'),
								(2,'Liga contra el cáncer','Institucion encargada del cuidado de personas con cáncer','Av Venezuela, calle Bustamante #477 - Cercado','054-898887');

CREATE TABLE `tb_actividad` (
  `cod_act` int(11) NOT NULL AUTO_INCREMENT,
  `cod_ins` int(10) NOT NULL references tb_institucion,
  `nom_act` varchar(60) NOT NULL,/*s*/
  `des_act` varchar(100) NOT NULL,
  `fecha_act` date DEFAULT NULL,
  `horainicio_act` varchar(20) NOT NULL,
  `horafin_act` varchar(20) NOT NULL,
  `cod_doc` varchar(14) NOT NULL references tb_docente,
  `cod_estado` int(5) NOT NULL references tb_estado,
  `motivo_estado` varchar(100) NULL,
  `max_vacantes` int NULL,
  `min_vacantes` int NULL,
  
  PRIMARY KEY (`cod_act`)
) ENGINE=InnoDB AUTO_INCREMENT=2005 DEFAULT CHARSET=utf8;

insert into tb_actividad values (1,1,'visitar albergue','bañar perros','2020/05/05','8am','10am','pmvelasco',1,'',20,10);
insert into tb_actividad values (2,1,'visitar asilo','limpieza','2020/05/05','8am','10am','pmvelasco',2,'',20,10);
create table tb_voluntariado
(
	cod_vol int(10) not null primary key auto_increment,
    cod_alu varchar(10) references tb_alumno,
    cod_act int(11) references tb_actividad,
    asistencia varchar(12) null, 
    justificacion varchar(30) null,
    horas int null 
);

create table tb_carrera (
  cod_carrera int(3) NOT NULL primary key auto_increment,
  carrera varchar(30) NOT NULL
); 

insert into tb_carrera values ('1','Computacion e Informatica'),
								('2','Administracion y Sistemas'),
                                ('3','Administracion de Empresas'),
                                ('4','Contabilidad');
				

create table tb_seccion (
  cod_seccion int(3) NOT NULL primary key auto_increment,
  seccion varchar(30) NOT NULL,
  cod_carrera int(3) NOT NULL references tb_carrera
);
 

insert into tb_seccion values ('1','TA01',1),
								('2','ASA01',2),
                                ('3','AEA01',3),
                                ('4','CA01',4);

