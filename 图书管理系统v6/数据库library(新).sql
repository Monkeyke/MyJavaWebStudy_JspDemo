/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.49 : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`username`,`password`) values ('admin','e7ef63bc4c950228aa049fc02d2ec291'),('root','e7ef63bc4c950228aa049fc02d2ec291');

/*Table structure for table `announcement` */

DROP TABLE IF EXISTS `announcement`;

CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '告示标题',
  `detail` varchar(2000) DEFAULT NULL COMMENT '告示内容',
  `publish_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `announcement` */

insert  into `announcement`(`id`,`title`,`detail`,`publish_date`) values (1,'图书管理系统开始建设','图书系统开始建设~~~','2020-12-25 12:28:00'),(2,'图书管理系统正在建设','图书系统正在建设中......','2021-05-01 08:29:40'),(3,'图书管理系统基本建成','庆祝图书管理系统基本建成！！！','2021-08-10 16:45:00');

/*Table structure for table `book_sort` */

DROP TABLE IF EXISTS `book_sort`;

CREATE TABLE `book_sort` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '' COMMENT '书籍类型名',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `book_sort` */

insert  into `book_sort`(`id`,`name`,`description`) values (1,'武侠类',NULL),(2,'推理类',NULL),(3,'悬疑类',NULL),(4,'科幻类',NULL),(5,'言情类',NULL),(6,'玄幻类',NULL),(7,'文学类',NULL);

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `library_id` int(20) DEFAULT NULL,
  `sort_id` int(30) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`id`,`name`,`author`,`library_id`,`sort_id`,`position`,`status`,`description`) values (1,'雪中悍刀行','烽火戏诸侯',2,1,'一楼',1,NULL),(2,'偷偷藏不住','竹已',3,5,'五楼',1,NULL),(3,'沉默的羔羊','托马斯·哈里斯',1,2,'二楼',1,NULL),(4,'坏小孩','紫金陈',4,3,'三楼',1,NULL),(5,'射雕英雄传','金庸',1,1,'一楼',1,NULL),(6,'十宗罪','蜘蛛',2,2,'二楼',0,NULL),(7,'流浪地球','刘慈欣',4,4,'四楼',1,NULL),(8,'来不及说我爱你','匪我思存',5,5,'五楼',1,NULL),(9,'天龙八部','金庸',2,1,'一楼',1,NULL),(10,'风声','麦家',3,2,'二楼',0,NULL),(11,'三生三世十里桃花','唐七公子',1,5,'二楼',1,NULL),(12,'白夜行','东野圭吾',3,3,'三楼',1,NULL),(13,'剑来','烽火戏诸侯',4,1,'一楼',1,NULL),(14,'长夜难明','紫金陈',1,3,'三楼',0,NULL),(15,'倚天屠龙记','金庸',3,1,'一楼',1,NULL),(16,'心理罪','雷米',2,3,'三楼',1,NULL),(17,'秘密','东野圭吾',3,3,'三楼',1,NULL),(18,'三体','刘慈欣',2,4,'四楼',1,NULL),(19,'盗墓笔记','南派三叔',4,2,'二楼',0,NULL),(20,'嫌疑人X的献身','东野圭吾',3,3,'三楼',1,NULL),(21,'银河帝国','艾萨克·阿西莫夫',4,4,'四楼',0,NULL),(22,'微微一笑很倾城','顾漫',2,5,'二楼',1,NULL),(23,'鬼吹灯','天下霸唱',1,2,'二楼',1,NULL),(24,'斗罗大陆','唐家三少',3,6,'三楼',1,NULL),(25,'何以笙箫默','顾漫',4,5,'四楼',0,NULL),(26,'无人生还','阿加莎·克里斯蒂',2,2,'二楼',1,NULL),(27,'原来你还在这里','辛夷坞',3,5,'三楼',1,NULL),(28,'斗破苍穹','天蚕土豆',3,6,'五楼',0,NULL),(29,'笑傲江湖','金庸',4,1,'一楼',1,NULL),(30,'武动乾坤','天蚕土豆',1,6,'四楼',1,NULL),(31,'破云','淮上',3,5,'五楼',1,NULL),(32,'绝世唐门','唐家三少',2,6,'二楼',1,NULL),(33,'撒野','巫哲',4,5,'五楼',1,NULL),(34,'完美世界','辰东',1,6,'三楼',1,NULL),(35,'诛仙','萧鼎',1,6,'四楼',1,NULL),(36,'百年孤独','马尔克斯',2,7,'一楼',1,NULL),(37,'活着','余华',4,7,'五楼',0,NULL),(38,'悲惨世界','雨果',3,7,'二楼',1,NULL),(39,'平凡的世界','路遥',3,7,'四楼',1,NULL),(40,'挪威的森林','村上春树',4,7,'三楼',1,NULL),(41,'西游记','吴承恩',2,7,'三楼',1,NULL),(42,'红楼梦','曹雪芹',2,7,'五楼',1,NULL),(43,'水浒传','施耐庵',4,7,'一楼',0,NULL),(44,'边城','沈从文',4,7,'二楼',1,NULL),(45,'围城','钱钟书',3,7,'四楼',1,NULL);

/*Table structure for table `borrow_books` */

DROP TABLE IF EXISTS `borrow_books`;

CREATE TABLE `borrow_books` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `card_id` int(20) DEFAULT NULL,
  `book_id` int(20) DEFAULT NULL,
  `borrow_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  `illegal` varchar(200) DEFAULT NULL,
  `manager_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `borrow_books` */

insert  into `borrow_books`(`id`,`card_id`,`book_id`,`borrow_date`,`end_date`,`return_date`,`illegal`,`manager_id`) values (1,152004031,6,'2021-08-11 09:37:00','2021-10-11 09:37:00','2020-10-11 09:28:00','','1'),(2,152004032,10,'2021-10-08 17:45:00','2021-12-08 15:38:00','2020-12-11 15:38:07','已逾期3天','3'),(3,152004033,28,'2021-09-20 11:47:00','2021-12-10 11:47:00','2021-12-10 10:50:00','','2'),(4,152004034,43,'2021-08-20 09:55:00','2021-11-20 09:55:00','2021-11-30 10:02:00','已逾期10天','4'),(5,152004035,25,'2021-09-29 09:59:00','2021-11-19 09:59:00','2021-09-19 09:00:00','','3'),(6,152004036,19,'2021-08-15 14:01:00','2021-12-15 14:01:00','2021-12-15 10:07:00','','5'),(7,152004037,37,'2021-08-21 10:12:00','2021-11-21 10:12:00','2021-11-26 10:13:00','已逾期5天','2'),(8,152004038,14,'2021-09-19 15:22:00','2021-12-10 15:22:00','2021-12-10 11:32:00','','4'),(9,152004039,21,'2021-08-12 09:20:00','2021-12-12 09:20:00','2021-12-12 08:36:00','','5');

/*Table structure for table `borrow_card` */

DROP TABLE IF EXISTS `borrow_card`;

CREATE TABLE `borrow_card` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) DEFAULT NULL,
  `reader` varchar(20) DEFAULT NULL,
  `rule_id` int(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL COMMENT '0注销，1正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1805010220 DEFAULT CHARSET=utf8;

/*Data for the table `borrow_card` */

insert  into `borrow_card`(`id`,`password`,`reader`,`rule_id`,`status`) values (152004031,'1234','徐凤年',5,1),(152004032,'2345','姜泥',2,0),(152004033,'3456','徐渭熊',3,1),(152004034,'4567','青鸟',1,1),(152004035,'5678','南宫仆射',6,0),(152004036,'6789','徐骁',7,1),(152004037,'7890','陈芝豹',4,1),(152004038,'8901','徐龙象',2,1),(156096479,'9012','宁峨眉',6,1);

/*Table structure for table `library` */

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `library` */

insert  into `library`(`id`,`name`,`description`) values (1,'东馆','学校东面'),(2,'南馆','学校南面'),(3,'西馆','学校西面'),(4,'北馆','学校北面');

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`id`,`name`,`account`,`password`,`email`) values (1,'张三','zhang','123456','123456@qq.com'),(2,'李四','li','234567','234567@qq.com'),(3,'王五','wang','345678','345678@qq.com'),(4,'周星星','zhou','456789','456789@qq.com'),(5,'金浩森','jin','567890','567890@qq.com');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `card_id` int(20) DEFAULT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `public_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`id`,`card_id`,`detail`,`public_date`) values (1,152004031,'一起来看《雪中》！','2021-08-18 10:35:00'),(2,152004032,'我喜欢在图书馆学习！','2021-09-19 12:13:00'),(3,152004033,'图书馆很安静！','2021-10-20 20:22:00'),(4,152004034,'这里的书真的很丰富！','2021-11-21 08:50:00');

/*Table structure for table `rules` */

DROP TABLE IF EXISTS `rules`;

CREATE TABLE `rules` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `borrow_num` int(10) DEFAULT NULL COMMENT '限制本数',
  `limit_day` int(10) DEFAULT NULL COMMENT '限制天数',
  `borrow_library` varchar(20) DEFAULT NULL,
  `overtime_fee` float(10,3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `rules` */

insert  into `rules`(`id`,`borrow_num`,`limit_day`,`borrow_library`,`overtime_fee`) values (1,4,60,'1、2、3',0.100),(2,5,80,'2、3',0.200),(3,4,120,'2、3、4',0.100),(4,3,90,'3、4',0.300),(5,5,100,'1、4',0.200),(6,6,80,'1、2、4',0.300),(7,4,90,'1、3',0.100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
