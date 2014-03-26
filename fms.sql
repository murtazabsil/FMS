/*
SQLyog Community v9.02 
MySQL - 5.6.16 : Database - fms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fms`;

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

/*Table structure for table `extn` */

DROP TABLE IF EXISTS `extn`;

CREATE TABLE `extn` (
  `sr_no` int(5) NOT NULL,
  `emp_name` text NOT NULL,
  `extn_num` int(8) NOT NULL,
  PRIMARY KEY (`sr_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `extn` */

insert  into `extn`(`sr_no`,`emp_name`,`extn_num`) values (1,'AASHISH SHARMA',6863),(2,'ABHIJIT BRAHMANE',6155),(3,'ABHIJIT DESHPANDE',6224),(4,'ABHINAY BAGUL',6189),(5,'ABHISHEK W - IRP',6821),(6,'ADITYA B',6845),(7,'ADITYA SHARMA',6817),(8,'AGNELO FERNANDES',6207),(9,'AJINKYA SAMANT',6167),(10,'AJIT SAMENDLA',6140),(11,'AKSHAY HEDAU',6893),(12,'ALOK THAKKAR',6148),(13,'AMEX',6127),(14,'AMEX',6126),(15,'AMEX',6126),(16,'AMEX',6125),(17,'AMEX',6125),(18,'AMEX',6124),(19,'AMEX',6131),(20,'AMEX',6130),(21,'AMEX',6130),(22,'AMEX',6129),(23,'AMEX',6129),(24,'AMEX',6128),(25,'AMEX',6110),(26,'AMEX',6112),(27,'ANCITA NAZARETH',6851),(28,'ANU JACOB',6206),(29,'ANUP MENON',6123),(30,'ANUPAM CHAHAR',6197),(31,'ANURADHA MAHULI',6849),(32,'ANURADHA SAWANT',6163),(33,'APEKSHA MEHTA',6895),(34,'ARCEE GOMES',6190),(35,'ARUN SHETTY',6857),(36,'ATUL SHETIYA',6859),(37,'AVINASH MITTAL',6169),(38,'AYESHA GARG',6157),(39,'BHAGYASHREE MANE',6119),(40,'BHARAT PRAJAPATI',6139),(41,'BHAVESH JOSHI',6802),(42,'BHAVIN CHAWDA',6869),(43,'BHAVISHYA SULTAN',6135),(44,'BHOOMI SHAH',6143),(45,'BHUSHAN RAJE',6188),(46,'CABIN no. 2',6216),(47,'CABIN no. 5',6222),(48,'CABIN no. 6',6226),(49,'CHANDANI SHAH',6202),(50,'DARSHANA TODA',6120),(51,'DEEPAK CHAWDA',6166),(52,'DHANANJAY S',6200),(53,'DHIRAJ MANYANKAR',6811),(54,'DHRUV DHAVAL',6158),(55,'DIVYA B',6196),(56,'DIVYATA PATIL',6826),(57,'GAYATRI VENUGOPAL',6197),(58,'HARDIK DEDANIA',6118),(59,'HEMANT MALI',6896),(60,'HITENDRA SHINDE',6807),(61,'JANHAVI GAONKAR',6150),(62,'JANKI DESAI',6146),(63,'JATIN PATIL',6182),(64,'JAYDEEP GARUD',6140),(65,'JENNY JOSEPH',6144),(66,'JESHURAN PAUL',6249),(67,'JUDITH N',6209),(68,'JUNAID SHAIKH',6121),(69,'KAILASH PILLAI',6178),(70,'KAJAL PATANKAR',6165),(71,'KARTIK KASI',6163),(72,'KDS & CO. FORUM ',6867),(73,'KEDAR DATAR',6211),(74,'KEYURI SINGH',6832),(75,'KINARI BHATT',6202),(76,'KINJAL DESAI',6134),(77,'KRUTI SHETTY',6116),(78,'KUMAR RAJWANI',6179),(79,'KUSHAL PRABHU',6139),(80,'LALIT NALAWADE',6205),(81,'LINDA ALMEIDA',6883),(82,'LOKESH M',6160),(83,'MADAN GAWDE',6866),(84,'MANAGER\'S CABIN ',6856),(85,'MANAGER\'S CABIN ',6884),(86,'MANAGER\'S CABIN ',6858),(87,'MANAGER\'S CABIN ',6829),(88,'MANDAR DESHMUKH',6113),(89,'MANGESH SHELAR',6201),(90,'MANOJ PRAJAPATI',6186),(91,'MIHIR RAJGOR',6891),(92,'MITALI CHATTERJEE',6816),(93,'MITHILA R',6853),(94,'MITUL SHAH',6824),(95,'MOHAN RAMANUJAM',6225),(96,'MOHSIN KHAN',6894),(97,'MUKESH SINGH',6803),(98,'MUNAF K',6835),(99,'MURTUZA KHAN',6183),(100,'NAMITA MARATHE',6116),(101,'NAMRATA PARAB ',6877),(102,'NAVIN LOBO',6888),(103,'NAZMUDDIN FAROOQUI',6892),(104,'NEHA AGRAWAL',6122),(105,'NIKHIL KAKKAD',6865),(106,'NILESH ANGANE',6804),(107,'NISHIT SAMPAT ',6812),(108,'NITIN BHASKARAN',6164),(109,'NITIN PAI',6837),(110,'NUTAN KALE',6870),(111,'OMKAR CHAVAN',6136),(112,'PANKAJ SABNIS',6219),(113,'PARUL RAJPUT',6842),(114,'PARVEZ HAJIANI',6198),(115,'POOJA SHAH',6151),(116,'PRAGATI MORE',6868),(117,'PRAJAKTA ROKDE',6158),(118,'PRAMOD ASKAR',6183),(119,'PRAMOD YADAV',6880),(120,'PRASAD MODI',6162),(121,'PRASANNA C',6102),(122,'PRASUN DATTA',6818),(123,'PRATHIBHA TATKARE',6133),(124,'PRAVEEN SINGH',6153),(125,'PRAVIN BABAR',6152),(126,'PREMAL SAIYA',6221),(127,'PRITI SHARMA',6809),(128,'PRIYANKA C M',6107),(129,'PROGNA B',6875),(130,'PRONOB MUKHERJEE',6154),(131,'RADHAKRISHNAN K',6838),(132,'RAHUL BADANI',6815),(133,'RAJ PATIL',6149),(134,'RAJEEV KHANNA',6192),(135,'RAJENDER BEERAM',6167),(136,'RAJKUMAR SHARMA',6890),(137,'RAJNI GIRISEAN',6108),(138,'RAMAKANT KOLI',6137),(139,'RAMESH RAPELLY',6176),(140,'RAMESH S',6830),(141,'RASIKA CHITNIS',6878),(142,'RATISH AGARWAL',6871),(143,'RAVINDRA CHOUDHARY',6180),(144,'RAYLET R',6848),(145,'RICHA YADAV',6181),(146,'RISHABH KAPOOR',6147),(147,'RITESH MODI',6860),(148,'ROHIT GAWDE',6117),(149,'ROHIT SINHA',6831),(150,'RONAK SEQUERIA',6881),(151,'RUNEETA',6852),(152,'SACHIN D',6262),(153,'SACHIN JOSHI',6199),(154,'SAM P',6825),(155,'SAMEER SALUNKE',6185),(156,'SAMIKSHA SAMANPURA',6142),(157,'SANDEEP SHETTY',6823),(158,'SANDESH POTDAR',6808),(159,'SARIN PARAYIL',6173),(160,'SATHIS KUMAR P',6186),(161,'SATISH PATIL',6162),(162,'SAURABH TAMANG',6897),(163,'SAYALI GAD',6150),(164,'SAYLEE BAHETI',6120),(165,'SHEEL THAKKER',6841),(166,'SHIVAM PARASHAR',6117),(167,'SHRADDHA DINESH',6159),(168,'SHRADHA CHOPDEKAR',6133),(169,'SHRIDUTTA M',6261),(170,'SHRIKANT PATKI',6101),(171,'SIDDHARTH LALE',6135),(172,'SIDDHARTH POOJARY',6814),(173,'SNEHAL UBHARE',6121),(174,'SONAM RELAN',6161),(175,'SRIKANT AKOJU',6195),(176,'SUDESHNA MUKHERJEE',6810),(177,'SUDHISH SUKUMAR',6145),(178,'SUDIP KUMAR BHADRA',6813),(179,'SUKESH SETH',6168),(180,'SUMIT SHARMA',6122),(181,'SUMIT SHETH',6223),(182,'SUMIT ZITSHI',6187),(183,'SUNIL BHATIA',6800),(184,'SUNOJ MICHEAL SWAMY',6168),(185,'SUPRIYA KAMBLE',6855),(186,'SUSHAMA PAWAR',6138),(187,'SUSHMA D\'SOUZA',6205),(188,'SWARNIMA DATAR',6103),(189,'SWARUPA JAGTAP',6105),(190,'SWATI SHARDUL',6166),(191,'SWATI TARI',6822),(192,'TAUSIF A DESHMUKH',6189),(193,'TEJAL V',6203),(194,'TEJAS BHAVISHI',6177),(195,'TULIKA MITTAL',6194),(196,'UMESH CHITRE',6836),(197,'UMESH NAIK',6111),(198,'USHA NARAYANAN',6132),(199,'USHA SUBRAMANIUM',6805),(200,'UTKARSHA OAK',6149),(201,'UTSAHA K',6889),(202,'V SUDARSHAN ',6886),(203,'VANMALI POOJARI',6828),(204,'VIJAY DAREKAR',6862),(205,'VIJAY RAMA CHANDRAN',6154),(206,'VIKAS KHANDEKAR',6806),(207,'VINAY MURPANE',6181),(208,'VINISHA NAGARAJAN',6143),(209,'VINIT KHATAVKAR',6178),(210,'VIPUL WAGHELA',6220),(211,'VIRENDRA YADAV',6163),(212,'VISHAL KHORASIA',6114),(213,'VISHAL LAVALE',6172),(214,'YASHWANT JOSHI',6215),(215,'YATIN BODKE',6115),(216,'YOGESH ZANZANE',6184),(217,'YOGITA VERMA',6115),(218,'ZALAK DHARIA',6286),(229,'BOARD ROOM',6898),(230,'EXEC. LUNCH ROOM',6827),(231,'CANTEEN 3RD FLR',6305),(232,'CANTEEN 8TH FLR',6885),(233,'IRP - 3RD FLOOR',6261),(234,'IRP - 3RD FLOOR',6262),(235,'CTRL - 3RD',6227),(236,'SYMPHONY RM  - 3RD ',6227),(237,'ESC RM  - 3RD ',6228),(238,'CONCORD RM  - 3RD ',6229),(239,'CONFLUENCE RM  - 3RD ',6307),(240,'CONVERGONCE RM  - 3RD ',6308),(241,'SYNERGY RM - 8TH FLR ',6873),(242,'SYMBIOSIS RM - 8TH FLR ',6872),(243,'SECURITY - 3RD FLR',6240),(244,'SEC. BACK - 3RD FLR',6300),(245,'SECURITY - 8TH FLR',6887),(246,'SEC. BACK - 8TH FLR',6833),(247,'TRANNING ROOM ',6306),(248,'UTILITY RM 3RD FLR',6232),(249,'UTILITY RM 8TH FLR',6861);

/*Table structure for table `forecast` */

DROP TABLE IF EXISTS `forecast`;

CREATE TABLE `forecast` (
  `forecast_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `forecast_name` varchar(50) NOT NULL,
  `forecast_year` int(5) NOT NULL,
  `forecast_month` int(5) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_on` datetime NOT NULL,
  PRIMARY KEY (`forecast_id`),
  KEY `FK_forecast_manager` (`created_by`),
  KEY `FK_forecast_project` (`project_id`,`created_by`),
  KEY `FK_forecast_month` (`forecast_month`),
  CONSTRAINT `FK_forecast_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_forecast_manager` FOREIGN KEY (`created_by`) REFERENCES `manager` (`manager_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_forecast_month` FOREIGN KEY (`forecast_month`) REFERENCES `month` (`month_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `forecast` */

insert  into `forecast`(`forecast_id`,`forecast_name`,`forecast_year`,`forecast_month`,`project_id`,`created_by`,`created_on`) values (1,'Test',2014,5,2,2,'2014-02-25 00:00:00'),(2,'Test',2014,7,24,2,'2014-02-25 00:00:00'),(3,'Test',2014,7,24,2,'2014-02-25 00:00:00'),(4,'Test',2015,5,24,2,'2014-02-25 00:00:00'),(5,'Test',2015,5,24,2,'2014-02-25 00:00:00'),(6,'Test',2015,5,24,2,'2014-02-25 00:00:00'),(7,'My New ForeCast',2014,10,2,2,'2014-02-25 00:00:00'),(8,'Test',2014,10,24,2,'2014-02-25 00:00:00'),(9,'My New ForeCast',2015,4,24,2,'2014-02-25 00:00:00'),(10,'My New',2014,7,24,2,'2014-02-25 00:00:00'),(11,'Test',2014,5,2,2,'2014-02-25 00:00:00');

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `forecast_detail` */

insert  into `forecast_detail`(`forecast_detail_id`,`forecast_id`,`cost`,`month_id`) values (1,1,123,1),(2,1,123,2),(3,1,65,3),(4,2,123,1),(5,2,231,5),(6,2,12,7),(7,3,123,1),(8,3,231,5),(9,3,12,7),(10,4,123,1),(11,5,123,1),(12,6,123,1),(13,7,24,1),(14,7,123,2),(15,7,65,3),(16,8,123,1),(17,9,213,4),(18,10,123,1),(19,11,123,1),(20,11,213,4);

/*Table structure for table `forecast_type` */

DROP TABLE IF EXISTS `forecast_type`;

CREATE TABLE `forecast_type` (
  `forecast_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `forecast_type` varchar(30) NOT NULL,
  PRIMARY KEY (`forecast_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `forecast_type` */

insert  into `forecast_type`(`forecast_type_id`,`forecast_type`) values (1,'Monthly'),(2,'Quarterly'),(3,'Yearly');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `manager` */

insert  into `manager`(`manager_id`,`manager_name`,`manager_emp_id`,`manager_dept_id`,`manager_lob_id`,`manager_account_id`,`manager_location_id`,`manager_currency`,`manager_descrition`) values (1,'zzxzxxzx','sddasdasda',1,1,1,1,1,'asccsaassdcsd'),(2,'Pankaj Amal','123456',1,1,1,1,1,'csdcdscsdcdscsd'),(3,'zzxzxxzx','sddasdasda',1,2,1,1,1,'rweewrewrw'),(4,'savil','302604',NULL,NULL,NULL,NULL,NULL,NULL),(5,'chandani','302643',NULL,NULL,NULL,NULL,NULL,NULL),(6,'murtaza','302606',NULL,NULL,NULL,NULL,NULL,NULL),(7,'murtaza','302606',NULL,NULL,NULL,NULL,NULL,NULL),(8,'m','302606',NULL,NULL,NULL,NULL,NULL,NULL),(9,'m','302606',NULL,NULL,NULL,NULL,NULL,NULL),(10,'m','302606',NULL,NULL,NULL,NULL,NULL,NULL),(11,'m','302606',NULL,NULL,NULL,NULL,NULL,NULL);

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

insert  into `menu_user_type`(`menu_seq_id`,`menu`,`page`,`user_type_id`) values (1,'Home','AdminHome.jsp',1),(2,'Project','ProjectList.jsp',1),(3,'Manager','ManagerList.jsp',1),(4,'Account','AccountList.jsp',1),(5,'Lob','LobList.jsp',1),(6,'User','UserList.jsp',1),(7,'Project','MgrProjectList.jsp',2);

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `module_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(20) DEFAULT NULL,
  `module_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `module` */

insert  into `module`(`module_id`,`module_name`,`module_description`) values (1,'Project','This is project'),(2,'Project Manager','PM'),(3,'Account','Account'),(4,'LOB','Line of business');

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_name`,`project_lob`,`project_account`,`project_base_currency`,`project_priority`,`project_status`,`project_type`,`start_date`,`end_date`,`project_desc`) values (1,'Test',3,1,68,2,1,2,NULL,NULL,''),(2,'Genesis',1,2,147,3,4,4,NULL,NULL,''),(3,'EMS Charts',2,2,6,2,3,2,NULL,NULL,''),(4,'FMS',1,2,2,2,2,3,NULL,NULL,''),(5,'Home And Abroad',2,1,50,2,2,3,NULL,NULL,''),(6,'ABC',6,2,2,1,2,2,NULL,NULL,''),(7,'PMS',2,3,5,2,3,4,NULL,NULL,''),(8,'HOF',1,2,4,1,1,3,NULL,NULL,''),(9,'test',2,3,3,3,3,2,NULL,NULL,''),(10,'HOF',1,2,4,1,1,3,NULL,NULL,''),(11,'test',2,3,3,3,3,2,NULL,NULL,''),(12,'HOF',1,2,4,1,1,3,NULL,NULL,''),(13,'test',2,3,3,3,3,2,NULL,NULL,''),(14,'HOF',1,2,4,1,1,3,NULL,NULL,''),(15,'test',2,3,3,3,3,2,NULL,NULL,''),(16,'HOF',1,2,4,1,1,3,NULL,NULL,''),(17,'test',2,3,3,3,3,2,NULL,NULL,''),(18,'HOF',1,2,4,1,1,3,NULL,NULL,''),(19,'test',2,3,3,3,3,2,NULL,NULL,''),(20,'ABC',5,2,5,3,1,3,NULL,NULL,''),(21,'LMS',1,2,68,1,1,4,NULL,NULL,'Test Project.'),(22,'Test',3,2,2,3,3,2,NULL,NULL,''),(23,'LMS',2,1,4,1,2,2,NULL,NULL,''),(24,'Test Project',3,3,5,2,3,4,NULL,NULL,'');

/*Table structure for table `project_manager_link` */

DROP TABLE IF EXISTS `project_manager_link`;

CREATE TABLE `project_manager_link` (
  `project_manager_link_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `project_id` bigint(30) NOT NULL,
  `manager_id` bigint(30) NOT NULL,
  PRIMARY KEY (`project_manager_link_id`),
  KEY `FK_project_manager_link_project` (`project_id`),
  KEY `FK_project_manager_link_manager` (`manager_id`),
  CONSTRAINT `FK_project_manager_link_manager` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_project_manager_link_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `project_manager_link` */

insert  into `project_manager_link`(`project_manager_link_id`,`project_id`,`manager_id`) values (1,2,2),(2,24,2);

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
  `userid` varchar(64) NOT NULL,
  `password` varchar(30) NOT NULL,
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
  CONSTRAINT `FK_userprofile_usertype` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`regid`,`userid`,`password`,`FirstName`,`LastName`,`address`,`emailaddress`,`designation`,`empid`,`contactnumber`,`user_type`) values (1,'admin','admin','adczxv',NULL,'  cdsdsssc`','dasad@dewdewd.com',1,'1234','12233213',1);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
