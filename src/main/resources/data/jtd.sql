/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.7.13-log : Database - jtd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jtd` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jtd`;

/*Table structure for table `tb_fjbf` */

DROP TABLE IF EXISTS `tb_fjbf`;

CREATE TABLE `tb_fjbf` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(30) DEFAULT NULL,
  `POSITIVE_WORDS` varchar(256) DEFAULT NULL,
  `NOTHING_THE_MATTER` varchar(256) DEFAULT NULL,
  `ABOUT_FUTURE` varchar(256) DEFAULT NULL,
  `IMPORTANT_THINGS` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(256) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(256) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_fjbf` */

insert  into `tb_fjbf`(`ID`,`USER_ID`,`POSITIVE_WORDS`,`NOTHING_THE_MATTER`,`ABOUT_FUTURE`,`IMPORTANT_THINGS`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,1,'3','e','e','ee','admin','2018-04-10','admin','2018-04-10'),(2,1,'e','d','d','d','admin','2018-04-07','admin','2018-04-09'),(3,1,'好的开始是成功的一半','画笑脸','完善“鸡汤店”','把资产维护测试完','zhouyan','2018-04-09','admin','2018-04-09'),(4,1,'我爱你','对自己说，你已经很好了','我要做好爱你的准备，不管是心灵上的还是肉体上的','I like you','admin','2018-04-08','admin','2018-04-08');

/*Table structure for table `tb_ly` */

DROP TABLE IF EXISTS `tb_ly`;

CREATE TABLE `tb_ly` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL,
  `REBACK` varchar(256) DEFAULT NULL,
  `CREATE_BY` varchar(30) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_ly` */

insert  into `tb_ly`(`ID`,`USER_ID`,`REMARK`,`REBACK`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,1,'你好！','你好,我也很好。','admin','2018-03-18','admin','2018-03-18'),(2,1,'尴尬','是的','admin','2018-03-27','admin','2018-03-27'),(3,1,'I know that running out of time,you make the best of this test.','fighting!','admin','2018-03-27','admin','2018-03-27'),(4,1,'hi','hello','admin','2018-03-28','admin','2018-03-28'),(5,1,'南方有乔木','北方有佳人','admin','2018-03-28','admin','2018-03-28'),(6,1,'回家',NULL,'admin','2018-03-28','admin','2018-03-28'),(7,1,'Today is not a nice day,but i also waona build \"jtd\"',NULL,'admin','2018-04-09','admin','2018-04-09'),(8,3,'How are you today?',NULL,'yangrui','2018-04-09','yangrui','2018-04-09');

/*Table structure for table `tb_menu` */

DROP TABLE IF EXISTS `tb_menu`;

CREATE TABLE `tb_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(50) DEFAULT NULL,
  `MENU_CODE` varchar(256) DEFAULT NULL,
  `MENU_DESC` varchar(256) DEFAULT NULL,
  `MENU_SEQ` varchar(50) DEFAULT NULL,
  `IS_LEAF` char(1) DEFAULT NULL,
  `MENU_LEVEL` bigint(2) DEFAULT NULL,
  `PARENT_MENU_ID` bigint(20) DEFAULT NULL,
  `SORT_NO` bigint(4) DEFAULT NULL,
  `URL` varchar(256) DEFAULT NULL,
  `MENU_ICON` varchar(20) DEFAULT NULL,
  `CAN_DELETE` char(1) DEFAULT NULL,
  `CREATE_BY` varchar(30) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_menu` */

insert  into `tb_menu`(`ID`,`MENU_NAME`,`MENU_CODE`,`MENU_DESC`,`MENU_SEQ`,`IS_LEAF`,`MENU_LEVEL`,`PARENT_MENU_ID`,`SORT_NO`,`URL`,`MENU_ICON`,`CAN_DELETE`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,'文章','WZ','所有人可以读的文章','.1.','0',1,NULL,1,'/wz/todo.shtml','icon_1','N',NULL,NULL,NULL,NULL),(2,'留言','LY','登录后可以留言','.2.','0',1,NULL,2,'/ly/todo.shtml','icon_2','N',NULL,NULL,NULL,NULL),(3,'与我对话','YWDH','与我对话','.3.','0',1,NULL,3,'/ywdh/todo.shtml','icon_3','N',NULL,NULL,NULL,NULL),(4,'附加部分','FJBF','附加部分','.4.','0',1,NULL,4,'/fjbf/todo.shtml','icon_4','N',NULL,NULL,NULL,NULL),(5,'豁然开朗的话','HRKLDH','豁然开朗的话','.1.5.','0',2,1,1,'/wz/hrkldh.shtml',NULL,NULL,NULL,NULL,NULL,NULL),(6,'美文','MW','美文','.1.6.','0',2,1,2,'/wz/mw.shtml',NULL,NULL,NULL,NULL,NULL,NULL),(7,'积极的话','JJDH','积极的话','.1.7.','0',2,1,3,'/wz/jjdh.shtml',NULL,NULL,NULL,NULL,NULL,NULL),(8,'历史','LS','留言历史','.2.8.','0',2,2,1,'/ly/history.shtml',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(50) DEFAULT NULL,
  `ROLE_CODE` varchar(50) DEFAULT NULL,
  `ROLE_DESC` varchar(256) DEFAULT NULL,
  `ROLE_TYPE` char(1) DEFAULT NULL,
  `CAN_DELETE` char(1) DEFAULT NULL,
  `CREATE_BY` varchar(30) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`ID`,`ROLE_NAME`,`ROLE_CODE`,`ROLE_DESC`,`ROLE_TYPE`,`CAN_DELETE`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,'超级管理员','G0','超级管理员','1','N',NULL,NULL,NULL,NULL),(2,'注册用户','A1','注册用户','1','N',NULL,NULL,NULL,NULL),(3,'VIP','B1','VIP','1','N',NULL,NULL,NULL,NULL);

/*Table structure for table `tb_role_menu` */

DROP TABLE IF EXISTS `tb_role_menu`;

CREATE TABLE `tb_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `MENU_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role_menu` */

insert  into `tb_role_menu`(`id`,`ROLE_ID`,`MENU_ID`) values (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,2,1),(6,3,1),(7,3,2),(8,3,4),(9,1,5),(10,1,6),(11,1,7),(12,1,8);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(30) DEFAULT NULL,
  `PASSWORD` varchar(256) DEFAULT NULL,
  `ACCOUNT` varchar(64) DEFAULT NULL,
  `DISABLED` tinyint(1) DEFAULT NULL,
  `CREATE_BY` varchar(30) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2018040413172300465 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`ID`,`USERNAME`,`PASSWORD`,`ACCOUNT`,`DISABLED`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,'admin','00000000',NULL,NULL,NULL,NULL,NULL,NULL),(2,'zhouyan','00000000',NULL,NULL,NULL,NULL,NULL,NULL),(3,'yangrui','00000000',NULL,NULL,NULL,NULL,NULL,NULL),(4,'caowen','6354a3c9bd626dab6a63020f329d9a0c','caowen',1,NULL,NULL,NULL,NULL),(5,'jiyuansheng','40b693a342f0c5ed12fdbaefc3338bf5','jiyuansheng',1,NULL,NULL,NULL,NULL),(6,'caoxuejiao','032de06b090fd8394b66a20de68595ed','caoxuejiao',1,NULL,NULL,NULL,NULL),(7,'Bellah','00000000','Bellah',1,NULL,NULL,NULL,NULL),(8,'wangkang','49528fd5b42b1ccf7b34bb91ce712281','wangkang',1,NULL,NULL,NULL,NULL),(9,'master','8df2f60f093e373fadebded9215e40fa','master',1,NULL,NULL,NULL,NULL),(2018040413172300458,'ada','89a958cf9126936069c1357a99520c62','ada',1,NULL,NULL,NULL,NULL),(2018040413172300459,'stephone','00000000','stephone',NULL,NULL,NULL,NULL,NULL),(2018040413172300460,'Eason','00000000','Eason',NULL,NULL,NULL,NULL,NULL),(2018040413172300461,'Garden','00000000','Garden',NULL,'Garden','2018-04-08','Garden','2018-04-08'),(2018040413172300462,'Standly','00000000','Standly',NULL,'Standly','2018-04-09','Standly','2018-04-09'),(2018040413172300463,'Lotus','00000000','Lotus',NULL,'Lotus','2018-04-09','Lotus','2018-04-09'),(2018040413172300464,'','','',NULL,'','2018-04-09','','2018-04-09');

/*Table structure for table `tb_user_attends` */

DROP TABLE IF EXISTS `tb_user_attends`;

CREATE TABLE `tb_user_attends` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `USER_NAME` varchar(30) DEFAULT NULL,
  `ATTENDS` bigint(50) DEFAULT NULL,
  `CREATE_BY` varchar(30) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_attends` */

insert  into `tb_user_attends`(`ID`,`USER_ID`,`USER_NAME`,`ATTENDS`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,1,'admin',11,'admin','2018-04-11','admin','2018-04-11'),(2,7,'Bellah',14,'admin','2018-04-11','admin','2018-04-11');

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `CREATE_BY` varchar(30) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `UPDATE_BY` varchar(30) DEFAULT NULL,
  `UPDATE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`ID`,`USER_ID`,`ROLE_ID`,`CREATE_BY`,`CREATE_DATE`,`UPDATE_BY`,`UPDATE_DATE`) values (1,1,1,NULL,NULL,NULL,NULL),(2,2,2,NULL,NULL,NULL,NULL),(3,9,1,NULL,NULL,NULL,NULL),(4,2018040413172300462,2,'admin','2018-04-09','admin','2018-04-09'),(5,2018040413172300463,2,'admin','2018-04-09','admin','2018-04-09'),(6,3,3,'admin','2018-04-09','admin','2018-04-09'),(7,2018040413172300464,2,'admin','2018-04-09','admin','2018-04-09'),(9,7,3,'admin','2018-04-11','admin','2018-04-11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
