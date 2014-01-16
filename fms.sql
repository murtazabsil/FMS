/*
SQLyog Community v9.02 
MySQL - 5.5.12-log : Database - fms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `accommodation` */

DROP TABLE IF EXISTS `accommodation`;

CREATE TABLE `accommodation` (
  `LocationID` varchar(100) NOT NULL,
  `LocationName` varchar(200) DEFAULT NULL,
  `LocationImage` varchar(200) DEFAULT NULL,
  `LocationDesc` tinytext,
  PRIMARY KEY (`LocationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `accommodation` */

insert  into `accommodation`(`LocationID`,`LocationName`,`LocationImage`,`LocationDesc`) values ('L001','Goa','Goa1.jpg','Our resort is 5km from beach\r\n\n'),('L002','Coorg','Coorg.jpg','Our resort is 5Km from this location'),('L003','Manali','Manali.jpg','Our resort is 15kms from this location'),('L004','Kodaikanal','Kodaikanal.jpg','Our resort is 10kms from this location'),('L005','Munnar','Munnar.jpg','Our resort is 15kms from this location');

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(64) DEFAULT NULL,
  `account_lob` bigint(20) DEFAULT NULL,
  `account_client` varchar(64) DEFAULT NULL,
  `account_location` bigint(20) DEFAULT NULL,
  `account_head` varchar(20) DEFAULT NULL,
  `account_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `FK_account_lob` (`account_lob`),
  KEY `FK_account_location` (`account_location`),
  CONSTRAINT `FK_account_lob` FOREIGN KEY (`account_lob`) REFERENCES `lob` (`lob_id`),
  CONSTRAINT `FK_account_location` FOREIGN KEY (`account_location`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `account` */

insert  into `account`(`account_id`,`account_name`,`account_lob`,`account_client`,`account_location`,`account_head`,`account_desc`) values (1,'TRISEPT',1,'abc coRP',1,'1','sadsad'),(2,'BLUESTAR',1,'blueSTAR',1,'1','dfsdffsfs'),(3,'TRISEPT',1,'trisept',1,'WSDSDQQ','CSADCDCSC'),(4,'TRISEPT',1,'TRISEPT',1,'DILIP','xcdsdcsd'),(5,'TRISEPT',2,'TRISEPT',2,'DILIP','zx ccdsscsc');

/*Table structure for table `bookingsinfo` */

DROP TABLE IF EXISTS `bookingsinfo`;

CREATE TABLE `bookingsinfo` (
  `BookingID` varchar(100) NOT NULL,
  `ResortID` varchar(100) DEFAULT NULL,
  `RoomID` varchar(100) DEFAULT NULL,
  `LocationName` varchar(100) DEFAULT NULL,
  `UserID` varchar(100) DEFAULT NULL,
  `MemberType` varchar(100) DEFAULT NULL,
  `RoomCharges` float DEFAULT NULL,
  `From` date DEFAULT NULL,
  `To` date DEFAULT NULL,
  `BookingStatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bookingsinfo` */

insert  into `bookingsinfo`(`BookingID`,`ResortID`,`RoomID`,`LocationName`,`UserID`,`MemberType`,`RoomCharges`,`From`,`To`,`BookingStatus`) values ('B01','R001','R0011','Goa','kalyan','Platinum',375,'2008-02-26','2008-02-29','CheckedOut'),('B02','R002','R0024','Coorg','kalyan','Platinum',375,'2008-02-22','2008-02-25','CheckedOut'),('B03','R001','R0011','Goa','kalyan','Platinum',375,'2008-02-01','2008-02-06','CheckedOut'),('B04','R001','R0011','Goa','Subhas','Gold',400,'2008-02-22','2008-02-22','CheckedOut');

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_info` text,
  `city_code` varchar(5) DEFAULT NULL,
  `city_name` varchar(64) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country_id` bigint(20) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `city_image` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `fk_city_country1` (`country_id`),
  KEY `city_name` (`city_name`),
  KEY `city_code` (`city_code`),
  CONSTRAINT `fk_city_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `city` */

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `country_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(64) DEFAULT NULL,
  `country_code` varchar(5) DEFAULT NULL,
  `country_info` text,
  PRIMARY KEY (`country_id`),
  KEY `country_name` (`country_name`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

/*Data for the table `country` */

insert  into `country`(`country_id`,`country_name`,`country_code`,`country_info`) values (1,'India','IND','IN'),(3,'USA','USA','USA'),(4,'France','FRA','Fr'),(5,'Bhutan','BHU','BHU'),(6,'nepal','NP','NP'),(7,'Spain','SPA','SPA'),(8,'United Kingdom','UK','UK'),(9,'Japan','JPN','JPN'),(10,'Sweden','SWE','SWE'),(11,'Singapore','SIN','SIN'),(12,'Aruba','ABW',NULL),(13,'Albania','ALB',NULL),(15,'Argentina','ARG',NULL),(16,'Armenia','ARM',NULL),(17,'Antigua & Barbuda','ATG',NULL),(18,'Austria','AUS',NULL),(19,'Australia','AUT',NULL),(20,'Azerbaijan','AZE',NULL),(21,'Belgium','BEL',NULL),(22,'Bahrain','BHR',NULL),(23,'Bahamas','BHS',NULL),(24,'Belarus','BLR',NULL),(25,'Bosnia & Herzegovina','BOS',NULL),(26,'Brazil','BRA',NULL),(27,'Barbados','BRB',NULL),(28,'Bulgaria','BUL',NULL),(29,'Canada','CAN',NULL),(30,'China','CHN',NULL),(31,'Croatia','CRO',NULL),(32,'Cuba','CUB',NULL),(33,'Curacao','CUW',NULL),(34,'Cyprus','CYP',NULL),(35,'Czech Republic','CZE',NULL),(36,'Denmark','DEN',NULL),(37,'Egypt','EGY',NULL),(38,'Estonia','EST',NULL),(39,'Finland','FIN',NULL),(41,'Georgia','GEO',NULL),(42,'Germany','GER',NULL),(43,'Gibraltar','GIB',NULL),(44,'Grenada','GRD',NULL),(45,'Greece','GRE',NULL),(46,'Hong Kong','HKG',NULL),(47,'Hungary','HUN',NULL),(48,'Iceland','ICE',NULL),(49,'Indonesia','IDN',NULL),(51,'Ireland','IRE',NULL),(52,'Israel','ISR',NULL),(53,'Italy','ITA',NULL),(54,'Jamaica','JAM',NULL),(55,'Jordan','JOR',NULL),(57,'Kazakhstan','KAZ',NULL),(58,'Cambodia','KHM',NULL),(59,'South Korea','KOR',NULL),(60,'Latvia','LAT',NULL),(61,'Lebanon','LBN',NULL),(62,'St Lucia','LCA',NULL),(63,'Lithuania','LIT',NULL),(64,'Luxembourg','LUX',NULL),(65,'Macau','MAC',NULL),(66,'Morocco','MAR',NULL),(67,'Maldives','MDV',NULL),(68,'Mexico','MEX',NULL),(69,'Malta','MLA',NULL),(70,'Moldova','MOL',NULL),(71,'Monaco','MON',NULL),(72,'Montenegro','MTN',NULL),(73,'Mauritius','MUS',NULL),(74,'Malaysia','MYS',NULL),(75,'Netherlands','NET',NULL),(76,'New Zealand','NEZ',NULL),(77,'Norway','NOR',NULL),(78,'Oman','OMN',NULL),(79,'Poland','POL',NULL),(80,'Portugal','POR',NULL),(81,'Puerto Rico','PRI',NULL),(82,'Qatar','QAT',NULL),(83,'Romania','ROM',NULL),(84,'Russia','RUS',NULL),(85,'Saudi Arabia','SAU',NULL),(86,'Serbia','SER',NULL),(88,'Slovakia','SLO',NULL),(89,'Slovenia','SLV','Slovenia'),(92,'Switzerland','SWI','Honeymoon Place'),(93,'Thailand','THA','Thailand'),(94,'Turkey','TUR','Turkey info'),(95,'Taiwan','TWN','Taiwan info'),(97,'Ukraine','UKR','Ukraine info'),(98,'Uruguay','URY','Uruguay'),(100,'Uzbekistan','UZB','Uzbekistan'),(101,'Vietnam','VNM','Vietnam europe'),(102,'South Africa','ZAF','Aferica country '),(103,'Fiji','Fiji','Fiji'),(104,'Western Samoa','Samoa','Western Samoa'),(106,'Cook Island','Cook ','Cook Island'),(107,'American Samoa','Ameri','American Samoa'),(108,'Easter Island','Easte','Easter Island'),(109,'French Polynesia','Frenc','French Polynesia'),(110,'Hawaii','Hawai','Hawaiiiiiki'),(111,'Tonga','Tonga','Tongaaaaaa'),(112,'Norfolk Island','Norfo','Norfolk Islandddd'),(113,'Srilanka','Srila','Srilankaaaaa'),(114,'British Virgin Islands','Briti','British Virgin Islands'),(115,'Cayman Islands','Cayma','Cayman Islands'),(116,'Dominican Republic','Domin','Dominican Republic'),(118,'Guadeloupe','Guade','Guadeloupe'),(119,'Haiti','Haiti','Haiti'),(120,'Martinique','Marti','Martinique'),(123,'Trinidad AND Tobago','Trini','Trinidad AND Tobago'),(124,'Saint Kitts AND Nevis','Saint','Saint Kitts AND Nevis'),(125,'Bolivia','Boliv','Bolivia'),(126,'Chile','Chile','Chile'),(127,'Ecuador','Ecuad','Ecuador'),(128,'Colombia','Colom','Colombia'),(129,'French Guiana','Frenc','French Guiana'),(130,'Guyana','Guyan','Guyana'),(131,'Paraguay','Parag','Paraguay'),(132,'Peru','Peru','Peru'),(133,'Venezuela','Venez','Venezuela'),(134,'Andorra','Andor','Andorra'),(136,'Italy','Italy','Italy'),(137,'Liechtenstein','Liech','Liechtenstein'),(138,'Republic of Macedonia','Repub','Republic of Macedonia'),(139,'Vatican','Vatic','Vatican'),(142,'Kuwait','Kuwai','Kuwait'),(143,'Syria','Syria','Syria'),(144,'Yemen','Yemen','Yemen'),(145,'Algeria','Alger','Algeria'),(147,'Somalia','Somal','Somalia'),(149,'Zimbabwe','Zimba','Zimbabwe');

/*Table structure for table `currency` */

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `currency_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currency_code` char(3) NOT NULL,
  `currency_name` varchar(45) NOT NULL,
  `currency_symbol` char(3) NOT NULL,
  PRIMARY KEY (`currency_id`),
  KEY `currency_code` (`currency_code`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

/*Data for the table `currency` */

insert  into `currency`(`currency_id`,`currency_code`,`currency_name`,`currency_symbol`) values (1,'AFA','Afghanistan afghani','$'),(2,'ALL','Albanian lek',''),(3,'DZD','Algerian dinar',''),(4,'AOR','Angolan kwanza reajustado',''),(5,'ARS','Argentine peso',''),(6,'AMD','Armenian dram',''),(7,'AWG','Aruban guilder',''),(8,'AUD','Australian dollar',''),(9,'AZN','Azerbaijanian new manat',''),(10,'BSD','Bahamian dollar',''),(11,'BHD','Bahraini dinar',''),(12,'BDT','Bangladeshi taka',''),(13,'BBD','Barbados dollar',''),(14,'BYR','Belarusian ruble',''),(15,'BZD','Belize dollar',''),(16,'BMD','Bermudian dollar',''),(17,'BTN','Bhutan ngultrum',''),(18,'BOB','Bolivian boliviano',''),(19,'BWP','Botswana pula',''),(20,'BRL','Brazilian real',''),(21,'GBP','British pound',''),(22,'BND','Brunei dollar',''),(23,'BGN','Bulgarian lev',''),(24,'BIF','Burundi franc',''),(25,'KHR','Cambodian riel',''),(26,'CAD','Canadian dollar',''),(27,'CVE','Cape Verde escudo',''),(28,'KYD','Cayman Islands dollar',''),(29,'XOF','CFA franc BCEAO',''),(30,'XAF','CFA franc BEAC',''),(31,'XPF','CFP franc',''),(32,'CLP','Chilean peso',''),(33,'CNY','Chinese yuan renminbi',''),(34,'COP','Colombian peso',''),(35,'KMF','Comoros franc',''),(36,'CDF','Congolese franc',''),(37,'CRC','Costa Rican colon',''),(38,'HRK','Croatian kuna',''),(39,'CUP','Cuban peso',''),(40,'CZK','Czech koruna',''),(41,'DKK','Danish krone',''),(42,'DJF','Djibouti franc',''),(43,'DOP','Dominican peso',''),(44,'XCD','East Caribbean dollar',''),(45,'EGP','Egyptian pound',''),(46,'SVC','El Salvador colon',''),(47,'ERN','Eritrean nakfa',''),(48,'EEK','Estonian kroon',''),(49,'ETB','Ethiopian birr',''),(50,'EUR','EU euro',''),(51,'FKP','Falkland Islands pound',''),(52,'FJD','Fiji dollar',''),(53,'GMD','Gambian dalasi',''),(54,'GEL','Georgian lari',''),(55,'GHS','Ghanaian new cedi',''),(56,'GIP','Gibraltar pound',''),(57,'XAU','Gold (ounce)',''),(58,'XFO','Gold franc',''),(59,'GTQ','Guatemalan quetzal',''),(60,'GNF','Guinean franc',''),(61,'GYD','Guyana dollar',''),(62,'HTG','Haitian gourde',''),(63,'HNL','Honduran lempira',''),(64,'HKD','Hong Kong SAR dollar',''),(65,'HUF','Hungarian forint',''),(66,'ISK','Icelandic krona',''),(67,'XDR','IMF special drawing right',''),(68,'INR','Indian rupee','Rs.'),(69,'IDR','Indonesian rupiah',''),(70,'IRR','Iranian rial',''),(71,'IQD','Iraqi dinar',''),(72,'ILS','Israeli new shekel',''),(73,'JMD','Jamaican dollar',''),(74,'JPY','Japanese yen',''),(75,'JOD','Jordanian dinar',''),(76,'KZT','Kazakh tenge',''),(77,'KES','Kenyan shilling',''),(78,'KWD','Kuwaiti dinar',''),(79,'KGS','Kyrgyz som',''),(80,'LAK','Lao kip',''),(81,'LVL','Latvian lats',''),(82,'LBP','Lebanese pound',''),(83,'LSL','Lesotho loti',''),(84,'LRD','Liberian dollar',''),(85,'LYD','Libyan dinar',''),(86,'LTL','Lithuanian litas',''),(87,'MOP','Macao SAR pataca',''),(88,'MKD','Macedonian denar',''),(89,'MGA','Malagasy ariary',''),(90,'MWK','Malawi kwacha',''),(91,'MYR','Malaysian ringgit',''),(92,'MVR','Maldivian rufiyaa',''),(93,'MRO','Mauritanian ouguiya',''),(94,'MUR','Mauritius rupee',''),(95,'MXN','Mexican peso',''),(96,'MDL','Moldovan leu',''),(97,'MNT','Mongolian tugrik',''),(98,'MAD','Moroccan dirham',''),(99,'MZN','Mozambique new metical',''),(100,'MMK','Myanmar kyat',''),(101,'NAD','Namibian dollar',''),(102,'NPR','Nepalese rupee',''),(103,'ANG','Netherlands Antillian guilder',''),(104,'NZD','New Zealand dollar',''),(105,'NIO','Nicaraguan cordoba oro',''),(106,'NGN','Nigerian naira',''),(107,'KPW','North Korean won',''),(108,'NOK','Norwegian krone',''),(109,'OMR','Omani rial',''),(110,'PKR','Pakistani rupee',''),(111,'XPD','Palladium (ounce)',''),(112,'PAB','Panamanian balboa',''),(113,'PGK','Papua New Guinea kina',''),(114,'PYG','Paraguayan guarani',''),(115,'PEN','Peruvian nuevo sol',''),(116,'PHP','Philippine peso',''),(117,'XPT','Platinum (ounce)',''),(118,'PLN','Polish zloty',''),(119,'QAR','Qatari rial',''),(120,'RON','Romanian new leu',''),(121,'RUB','Russian ruble',''),(122,'RWF','Rwandan franc',''),(123,'SHP','Saint Helena pound',''),(124,'WST','Samoan tala',''),(125,'STD','Sao Tome and Principe dobra',''),(126,'SAR','Saudi riyal',''),(127,'RSD','Serbian dinar',''),(128,'SCR','Seychelles rupee',''),(129,'SLL','Sierra Leone leone',''),(130,'XAG','Silver (ounce)',''),(131,'SGD','Singapore dollar',''),(132,'SBD','Solomon Islands dollar',''),(133,'SOS','Somali shilling',''),(134,'ZAR','South African rand',''),(135,'KRW','South Korean won',''),(136,'LKR','Sri Lanka rupee',''),(137,'SDG','Sudanese pound',''),(138,'SRD','Suriname dollar',''),(139,'SZL','Swaziland lilangeni',''),(140,'SEK','Swedish krona',''),(141,'CHF','Swiss franc',''),(142,'SYP','Syrian pound',''),(143,'TWD','Taiwan New dollar',''),(144,'TJS','Tajik somoni',''),(145,'TZS','Tanzanian shilling',''),(146,'THB','Thai baht',''),(147,'USD','Dollar',''),(148,'PDS','Pounds','A');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  `description` varchar(2000) DEFAULT NULL,
  `default_department` int(1) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `comp_department_customer_id` (`department_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `FId` int(10) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(100) DEFAULT NULL,
  `Feedback` text,
  `DateSubmitted` date DEFAULT NULL,
  PRIMARY KEY (`FId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `feedback` */

insert  into `feedback`(`FId`,`UserID`,`Feedback`,`DateSubmitted`) values (1,'kalyan','We choose Goa .Their service is very nice','2008-02-18');

/*Table structure for table `forecast` */

DROP TABLE IF EXISTS `forecast`;

CREATE TABLE `forecast` (
  `forecast_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `forecast_name` varchar(50) NOT NULL,
  `forecast_type_id` bigint(20) NOT NULL,
  `forecast_year` int(5) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_on` datetime NOT NULL,
  PRIMARY KEY (`forecast_id`),
  KEY `FK_forecast_manager` (`created_by`),
  KEY `FK_forecast_type` (`forecast_type_id`),
  KEY `FK_forecast_project` (`project_id`,`created_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `forecast` */

/*Table structure for table `forecast_detail` */

DROP TABLE IF EXISTS `forecast_detail`;

CREATE TABLE `forecast_detail` (
  `forecast_detail_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `forecast_id` bigint(20) NOT NULL,
  `cost` double DEFAULT NULL,
  `month_id` int(5) NOT NULL,
  PRIMARY KEY (`forecast_detail_id`),
  KEY `FK_forecast_detail_forecast` (`forecast_id`),
  KEY `FK_forecast_detail_month` (`month_id`),
  CONSTRAINT `FK_forecast_detail_forecast` FOREIGN KEY (`forecast_id`) REFERENCES `forecast` (`forecast_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_forecast_detail_month` FOREIGN KEY (`month_id`) REFERENCES `month` (`month_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `forecast_detail` */

/*Table structure for table `forecast_type` */

DROP TABLE IF EXISTS `forecast_type`;

CREATE TABLE `forecast_type` (
  `forecast_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `forecast_type` varchar(30) NOT NULL,
  PRIMARY KEY (`forecast_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `forecast_type` */

insert  into `forecast_type`(`forecast_type_id`,`forecast_type`) values (1,'Monthly'),(2,'Quarterly'),(3,'Yearly');

/*Table structure for table `invites` */

DROP TABLE IF EXISTS `invites`;

CREATE TABLE `invites` (
  `Sno` int(10) NOT NULL AUTO_INCREMENT,
  `From` varchar(200) NOT NULL DEFAULT '',
  `To` varchar(200) DEFAULT NULL,
  `Status` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `invites` */

insert  into `invites`(`Sno`,`From`,`To`,`Status`) values (1,'kalyan','xyz@gmail.com,ghij@yahoo.com','Invited'),(2,'kalyan','Raj@gmail.com,James@yahoo.com','Invited'),(3,'kalyan','Raju@gmail.com,\r\nRamu@yahoo.com','Invite');

/*Table structure for table `lob` */

DROP TABLE IF EXISTS `lob`;

CREATE TABLE `lob` (
  `lob_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lob_name` varchar(64) DEFAULT NULL,
  `lob_location` bigint(20) DEFAULT NULL,
  `lob_head` varchar(64) DEFAULT NULL,
  `lob_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lob_id`),
  KEY `FK_lob_location` (`lob_location`),
  CONSTRAINT `FK_lob_location` FOREIGN KEY (`lob_location`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `lob` */

insert  into `lob`(`lob_id`,`lob_name`,`lob_location`,`lob_head`,`lob_desc`) values (1,'BAP',1,'1','1'),(2,'PES',2,'2','2'),(3,'abc',3,'3','3'),(4,'bap',1,'SDSDDSscsc','bap'),(5,'ABC',1,'sqqw','ABC'),(6,'SDSDFDFSF',1,'qwsass','SDSDFDFSF'),(7,'bap',1,'qwsass','bap'),(8,'bap',1,'qwsass','bap'),(9,'SDSDFDFSF',2,'qwsass','SDSDFDFSF');

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(64) DEFAULT NULL,
  `location_code` varchar(64) DEFAULT NULL,
  `location_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `location` */

insert  into `location`(`location_id`,`location_name`,`location_code`,`location_desc`) values (1,'INDIA','IND','india'),(2,'UK','UK','UK'),(3,'USA','USA','USA'),(4,'SINGAPORE','SINGAPORE','sing');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `UserID` varchar(200) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  `Auth` varchar(200) DEFAULT NULL,
  `user_type` bigint(29) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK_login` (`user_type`),
  CONSTRAINT `FK_login` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`UserID`,`Password`,`Auth`,`user_type`,`id`) values ('admin','admin','1',1,1),('kalyan','kalyan','2',2,2),('Nita','Nita','2',4,3),('pankaj','pankaj','1',3,4),('Rahul','Rahul','2',2,5),('Rajesh','raj','2',3,6),('Ram','ram','1',4,7),('Subhas','Subhas','1',3,8),('pop','pop','1',1,14),('murtaza.khan','12345','1',2,15);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `manager_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(64) DEFAULT NULL,
  `manager_emp_id` varchar(10) DEFAULT NULL,
  `manager_dept_id` bigint(20) DEFAULT NULL,
  `manager_lob_id` bigint(20) DEFAULT NULL,
  `manager_account_id` bigint(20) DEFAULT NULL,
  `manager_location_id` bigint(20) DEFAULT NULL,
  `manager_currency` bigint(20) DEFAULT NULL,
  `manager_descrition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager_id`),
  KEY `FK_manager` (`manager_currency`),
  KEY `FK_manager_location` (`manager_location_id`),
  KEY `FK_manager_lob` (`manager_lob_id`),
  KEY `FK_manager_acct` (`manager_account_id`),
  CONSTRAINT `FK_manager` FOREIGN KEY (`manager_currency`) REFERENCES `currency` (`currency_id`),
  CONSTRAINT `FK_manager_acct` FOREIGN KEY (`manager_account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FK_manager_lob` FOREIGN KEY (`manager_lob_id`) REFERENCES `lob` (`lob_id`),
  CONSTRAINT `FK_manager_location` FOREIGN KEY (`manager_location_id`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `manager` */

insert  into `manager`(`manager_id`,`manager_name`,`manager_emp_id`,`manager_dept_id`,`manager_lob_id`,`manager_account_id`,`manager_location_id`,`manager_currency`,`manager_descrition`) values (1,'zzxzxxzx','sddasdasda',1,1,1,1,1,'asccsaassdcsd'),(2,'Pankaj Amal','123456',1,1,1,1,1,'csdcdscsdcdscsd'),(3,'zzxzxxzx','sddasdasda',1,2,1,1,1,'rweewrewrw');

/*Table structure for table `menu_user_type` */

DROP TABLE IF EXISTS `menu_user_type`;

CREATE TABLE `menu_user_type` (
  `menu_seq_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu` varchar(30) NOT NULL,
  `page` varchar(100) NOT NULL,
  `user_type_id` bigint(30) NOT NULL,
  PRIMARY KEY (`menu_seq_id`),
  KEY `FK_menu_user_type` (`user_type_id`),
  CONSTRAINT `FK_menu_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `menu_user_type` */

insert  into `menu_user_type`(`menu_seq_id`,`menu`,`page`,`user_type_id`) values (1,'Home','AdminHome.jsp',1),(2,'Project','ProjectList.jsp',1),(3,'Manager','ManagerList.jsp',1),(4,'Account','AccountList.jsp',1),(5,'Lob','LobList.jsp',1),(6,'User','UserList.jsp',1);

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `module_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(20) DEFAULT NULL,
  `module_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `module` */

insert  into `module`(`module_id`,`module_name`,`module_description`) values (1,'Project','This is project'),(2,'Project Manager','PM'),(3,'Account','account'),(4,'LOB','Line of business');

/*Table structure for table `month` */

DROP TABLE IF EXISTS `month`;

CREATE TABLE `month` (
  `month_id` int(5) NOT NULL AUTO_INCREMENT,
  `month_name` varchar(20) NOT NULL,
  PRIMARY KEY (`month_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `month` */

insert  into `month`(`month_id`,`month_name`) values (1,'January'),(2,'February'),(3,'March'),(4,'April'),(5,'May'),(6,'June'),(7,'July'),(8,'August'),(9,'September'),(10,'October'),(11,'November'),(12,'December');

/*Table structure for table `priority` */

DROP TABLE IF EXISTS `priority`;

CREATE TABLE `priority` (
  `priority_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priority_code` varchar(10) DEFAULT NULL,
  `priority_desc` varbinary(64) DEFAULT NULL,
  PRIMARY KEY (`priority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `priority` */

insert  into `priority`(`priority_id`,`priority_code`,`priority_desc`) values (1,'TIME','TIME'),(2,'COST','COST'),(3,'PERFORMANC','PERFORMANCE');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(64) DEFAULT NULL,
  `project_lob` bigint(20) DEFAULT NULL,
  `project_account` bigint(20) DEFAULT NULL,
  `project_base_currency` bigint(20) DEFAULT NULL,
  `project_priority` bigint(20) DEFAULT NULL,
  `project_status` bigint(20) DEFAULT NULL,
  `project_type` bigint(20) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `project_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FK_lob` (`project_lob`),
  KEY `FK_currency` (`project_base_currency`),
  KEY `FK_type` (`project_type`),
  KEY `FK_priority` (`project_priority`),
  KEY `FK_account` (`project_account`),
  KEY `FK_status` (`project_status`),
  CONSTRAINT `FK_account` FOREIGN KEY (`project_account`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FK_currency` FOREIGN KEY (`project_base_currency`) REFERENCES `currency` (`currency_id`),
  CONSTRAINT `FK_lob` FOREIGN KEY (`project_lob`) REFERENCES `lob` (`lob_id`),
  CONSTRAINT `FK_priority` FOREIGN KEY (`project_priority`) REFERENCES `priority` (`priority_id`),
  CONSTRAINT `FK_status` FOREIGN KEY (`project_status`) REFERENCES `status` (`status_id`),
  CONSTRAINT `FK_type` FOREIGN KEY (`project_type`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_name`,`project_lob`,`project_account`,`project_base_currency`,`project_priority`,`project_status`,`project_type`,`start_date`,`end_date`,`project_desc`) values (1,'Test',3,1,68,2,1,2,NULL,NULL,''),(2,'Genesis',1,2,147,3,4,4,NULL,NULL,''),(3,'EMS Charts',2,2,6,2,3,2,NULL,NULL,''),(4,'FMS',1,2,2,2,2,3,NULL,NULL,''),(5,'Home And Abroad',2,1,50,2,2,3,NULL,NULL,''),(6,'ABC',6,2,2,1,2,2,NULL,NULL,'');

/*Table structure for table `project_manager_link` */

DROP TABLE IF EXISTS `project_manager_link`;

CREATE TABLE `project_manager_link` (
  `project_manager_link_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `project_id` bigint(30) NOT NULL,
  `manager_id` bigint(30) NOT NULL,
  PRIMARY KEY (`project_manager_link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project_manager_link` */

/*Table structure for table `resortsinfo` */

DROP TABLE IF EXISTS `resortsinfo`;

CREATE TABLE `resortsinfo` (
  `ResortID` varchar(100) NOT NULL,
  `LocationName` varchar(100) DEFAULT NULL,
  `ResortImage` varchar(200) DEFAULT NULL,
  `NoOfRooms` int(50) DEFAULT NULL,
  `NoOfRoomsAvailable` int(50) DEFAULT NULL,
  `Restaurant` varchar(100) DEFAULT NULL,
  `Swimmingpool` varchar(100) DEFAULT NULL,
  `GamesRoom` varchar(100) DEFAULT NULL,
  `Casino` varchar(100) DEFAULT NULL,
  `YogaandMeditation` varchar(100) DEFAULT NULL,
  `SteamBath` varchar(100) DEFAULT NULL,
  `GymandHealthCenter` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ResortID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `resortsinfo` */

insert  into `resortsinfo`(`ResortID`,`LocationName`,`ResortImage`,`NoOfRooms`,`NoOfRoomsAvailable`,`Restaurant`,`Swimmingpool`,`GamesRoom`,`Casino`,`YogaandMeditation`,`SteamBath`,`GymandHealthCenter`) values ('R001','Goa','GoaResort.jpg',6,6,'Yes','Yes','Yes','No','Yes','No','No'),('R002','Coorg','CoorgResort.jpg',6,6,'Yes','No','Yes','Yes','No','Yes','Yes'),('R003','Manali','ManaliResort.jpg',5,5,'Yes','Yes','Yes','Yes','Yes','Yes','Yes'),('R004','Kodaikanal','KodaikanalResort.jpg',5,5,'Yes','Yes','No','No','Yes','Yes','Yes'),('R005','Munnar','MunnarResort.jpg',6,6,'Yes','No','No','No','Yes','Yes','Yes');

/*Table structure for table `roomsinfo` */

DROP TABLE IF EXISTS `roomsinfo`;

CREATE TABLE `roomsinfo` (
  `Sno` varchar(100) NOT NULL,
  `RoomID` varchar(100) DEFAULT NULL,
  `ResortID` varchar(100) DEFAULT NULL,
  `LocationName` varchar(100) DEFAULT NULL,
  `RoomType` varchar(100) DEFAULT NULL,
  `RoomArea` varchar(100) DEFAULT NULL,
  `DryKitchenette` varchar(100) DEFAULT NULL,
  `SofacumBed` varchar(100) DEFAULT NULL,
  `DoubleBeds` varchar(100) DEFAULT NULL,
  `Telephone` varchar(100) DEFAULT NULL,
  `Television` varchar(100) DEFAULT NULL,
  `RoomCharges` float DEFAULT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `roomsinfo` */

insert  into `roomsinfo`(`Sno`,`RoomID`,`ResortID`,`LocationName`,`RoomType`,`RoomArea`,`DryKitchenette`,`SofacumBed`,`DoubleBeds`,`Telephone`,`Television`,`RoomCharges`) values ('1','R0011','R001','Goa','StudioApartment','450','Yes','Yes','No','Yes','Yes',500),('2','R0012','R001','Goa','SingleBedRoomApartment','450','Yes','Yes','Yes','Yes','Yes',650),('3','R0013','R001','Goa','DoubleBedRoomApartment','650','Yes','Yes','Yes','Yes','Yes',750),('4','R0024','R002','Coorg','StudioApartment','450','Yes','Yes','No','Yes','Yes',500),('5','R0015','R001','Goa','SingleBedRoomApartment','450','Yes','No','No','Yes','Yes',550),('6','R0016','R001','Goa','StudioApartment','450','Yes','Yes','No','Yes','Yes',500),('7','R0017','R001','Goa','DoubleBedRoomApartment','600','Yes','Yes','Yes','Yes','Yes',600),('8','R0028','R002','Coorg','SingleBedRoomApartment','500','Yes','Yes','Yes','Yes','Yes',600),('9','R0059','R005','Munnar','StudioApartment','500','Yes','Yes','Yes','Yes','Yes',600);

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `status_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_code` varchar(10) DEFAULT NULL,
  `status_desc` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `status` */

insert  into `status`(`status_id`,`status_code`,`status_desc`) values (1,'Active','Active'),(2,'Running','Running'),(3,'On Hold','On Hold'),(4,'Dropped','Dropped'),(5,'Completed','Completed');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(10) DEFAULT NULL,
  `type_desc` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `type` */

insert  into `type`(`type_id`,`type_code`,`type_desc`) values (1,'Single act','Single action'),(2,'Sequential','Sequential'),(3,'Parallel','Parallel'),(4,'Developmen','Development'),(5,'Testing','Testing'),(6,'Enhancemen','Enhancement');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `regid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) DEFAULT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `emailaddress` varchar(64) DEFAULT NULL,
  `designation` bigint(20) DEFAULT NULL,
  `empid` varchar(20) DEFAULT NULL,
  `contactnumber` varchar(20) DEFAULT NULL,
  `user_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`regid`),
  KEY `FK_userprofile_usertype` (`user_type`),
  CONSTRAINT `FK_userprofile` FOREIGN KEY (`regid`) REFERENCES `login` (`id`),
  CONSTRAINT `FK_userprofile_usertype` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`regid`,`userid`,`FirstName`,`LastName`,`address`,`emailaddress`,`designation`,`empid`,`contactnumber`,`user_type`) values (1,'admin','adczxv',NULL,'  cdsdsssc`','dasad@dewdewd.com',1,'1234','12233213',1),(2,'TEst','adczxv',NULL,'DCDSCCS','dasad@dewdewd.com',2,'1234','SFFSF',2),(3,'pankaj','adczxv','Amal',' dcdcdsc','panak@qwee.com',1,'1234','csscsacsc',3),(4,'pop','Pankaj','Bhanu','gdffgfddgd','qww@sdsd.com',1,'1234','gfdgddf',1),(5,'murtaza.khan','Murtaza','Khan','Vasai','murtaza.khan@bsil.com',3,'302606','9967108612',2);

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `user_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(20) DEFAULT NULL,
  `user_type_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user_type` */

insert  into `user_type`(`user_type_id`,`user_type`,`user_type_description`) values (1,'Admin','Admin'),(2,'Project Manager','Project Manager'),(3,'Account','Account Head'),(4,'LOB','LOB Head');

/*Table structure for table `wine` */

DROP TABLE IF EXISTS `wine`;

CREATE TABLE `wine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `grapes` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `description` blob,
  `picture` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `wine` */

insert  into `wine`(`id`,`name`,`year`,`grapes`,`country`,`region`,`description`,`picture`) values (1,'CHATEAU DE SAINT COSME','2009','Grenache / Syrah','France','Southern Rhone / Gigondas','The aromas of fruit and spice give one a hint of the light drinkability of this lovely wine, which makes an excellent complement to fish dishes.','saint_cosme.jpg'),(2,'LAN RIOJA CRIANZA','2006','Tempranillo','Spain','Rioja','A resurgence of interest in boutique vineyards has opened the door for this excellent foray into the dessert wine market. Light and bouncy, with a hint of black truffle, this wine will not fail to tickle the taste buds.','lan_rioja.jpg'),(3,'MARGERUM SYBARITE','2010','Sauvignon Blanc','USA','California Central Cosat','The cache of a fine Cabernet in ones wine cellar can now be replaced with a childishly playful wine bubbling over with tempting tastes of\nblack cherry and licorice. This is a taste sure to transport you back in time.','margerum.jpg'),(4,'OWEN ROE \"EX UMBRIS\"','2009','Syrah','USA','Washington','A one-two punch of black pepper and jalapeno will send your senses reeling, as the orange essence snaps you back to reality. Don\'t miss\nthis award-winning taste sensation.','ex_umbris.jpg'),(5,'REX HILL','2009','Pinot Noir','USA','Oregon','One cannot doubt that this will be the wine served at the Hollywood award shows, because it has undeniable star power. Be the first to catch\nthe debut that everyone will be talking about tomorrow.','rex_hill.jpg'),(6,'VITICCIO CLASSICO RISERVA','2007','Sangiovese Merlot','Italy','Tuscany','Though soft and rounded in texture, the body of this wine is full and rich and oh-so-appealing. This delivery is even more impressive when one takes note of the tender tannins that leave the taste buds wholly satisfied.','viticcio.jpg'),(7,'CHATEAU LE DOYENNE','2005','Merlot','France','Bordeaux','Though dense and chewy, this wine does not overpower with its finely balanced depth and structure. It is a truly luxurious experience for the\nsenses.','le_doyenne.jpg'),(8,'DOMAINE DU BOUSCAT','2009','Merlot','France','Bordeaux','The light golden color of this wine belies the bright flavor it holds. A true summer wine, it begs for a picnic lunch in a sun-soaked vineyard.','bouscat.jpg'),(9,'BLOCK NINE','2009','Pinot Noir','USA','California','With hints of ginger and spice, this wine makes an excellent complement to light appetizer and dessert fare for a holiday gathering.','block_nine.jpg'),(10,'DOMAINE SERENE','2007','Pinot Noir','USA','Oregon','Though subtle in its complexities, this wine is sure to please a wide range of enthusiasts. Notes of pomegranate will delight as the nutty finish completes the picture of a fine sipping experience.','domaine_serene.jpg'),(11,'BODEGA LURTON','2011','Pinot Gris','Argentina','Mendoza','Solid notes of black currant blended with a light citrus make this wine an easy pour for varied palates.','bodega_lurton.jpg'),(12,'LES MORIZOTTES','2009','Chardonnay','France','Burgundy','Breaking the mold of the classics, this offering will surprise and undoubtedly get tongues wagging with the hints of coffee and tobacco in\nperfect alignment with more traditional notes. Breaking the mold of the classics, this offering will surprise and\nundoubtedly get tongues wagging with the hints of coffee and tobacco in\nperfect alignment with more traditional notes. Sure to please the late-night crowd with the slight jolt of adrenaline it brings.','morizottes.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
