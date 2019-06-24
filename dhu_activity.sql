# Host: 127.0.0.1  (Version: 5.5.62)
# Date: 2019-06-22 23:47:02
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "t_activity"
#

CREATE TABLE `t_activity` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT 'null',
  `class` int(1) NOT NULL DEFAULT '0' COMMENT '1-学习类 2-体育类 3-晚会 4-玩耍 5-其他',
  `isLong` int(1) NOT NULL DEFAULT '0' COMMENT '1-短期 2-长期',
  `begin` date NOT NULL DEFAULT '0000-00-00',
  `end` date NOT NULL DEFAULT '0000-00-00',
  `teamNum` int(11) NOT NULL DEFAULT '0',
  `commentNum` int(11) DEFAULT '0',
  `content` varchar(510) NOT NULL DEFAULT '这里什么都没有',
  `warning` varchar(255) DEFAULT NULL,
  `owner` int(11) NOT NULL DEFAULT '0',
  `img` varchar(255) DEFAULT NULL COMMENT '宣传图文件名',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

#
# Data for table "t_activity"
#

INSERT INTO `t_activity` VALUES (13,'test1',1,2,'2019-04-16','2019-04-16',1,0,'text1',NULL,5,NULL),(14,'test2',2,1,'2018-06-27','2018-06-30',3,1,'fight','14',6,NULL),(15,'meeting today',3,1,'2018-02-11','2019-04-16',6,4,'weekend。来自管理员的修改','你好~我是管理员',6,NULL),(16,'test4',1,1,'2018-02-11','2018-02-11',2,4,'est','你个小样能耐了哈？',6,NULL),(17,'dinner',4,1,'2018-06-18','2018-06-18',1,0,'weekend',NULL,8,NULL),(18,'movie',4,1,'2019-04-16','2019-04-22',0,0,'weekend','你小子行啊？不把我放眼里啊~',8,NULL),(19,'go to play',4,1,'2018-06-18','2018-06-18',0,0,'weekend',NULL,8,NULL),(20,'find girlfriend',5,2,'2018-06-18','2018-07-07',1,0,'beauty is OK',NULL,5,NULL),(21,'find boyfriend',5,1,'2018-06-06','2018-06-07',1,0,'joe is OK.',NULL,2,NULL),(22,'last my key',5,2,'2018-06-02','2018-06-15',0,0,'help!!',NULL,8,NULL),(23,'study together',1,2,'2018-06-19','2018-06-30',0,0,'study in summer','good good study',17,NULL),(24,'aaa',3,1,'2018-06-09','2018-06-08',0,0,'aaa',NULL,15,NULL),(25,'test4\'s activity',3,1,'2018-06-19','2018-06-19',1,0,'check your homework\r\nFIGHT!!','do your best',18,NULL),(26,'123',3,1,'2018-06-19','2018-06-19',0,0,'123',NULL,18,NULL),(27,'123',1,1,'2018-06-15','2018-06-16',0,0,'123','do your best',18,NULL),(28,'456',3,1,'2018-06-08','2018-06-09',0,0,'456',NULL,19,NULL),(29,'有图',5,2,'2019-04-08','2019-04-27',0,0,'有图',NULL,6,NULL),(30,'System.out.println(\"有图！！！！！！！！！！！！！！！！！！！！！\");',5,2,'2019-04-23','2019-05-02',0,0,'System.out.println(\"有图！！！！！！！！！！！！！！！！！！！！！\");',NULL,23,'5N7ILgeNjl.jpg'),(31,'这就是个测试22',5,1,'2019-04-18','2019-04-19',0,0,'测试你好222',NULL,0,NULL),(32,'这就是个测试',3,1,'2019-04-16','2019-04-06',4,1,'啦啦啦',NULL,21,'kSChwWYtBb.jpg'),(33,'给老师捶腿',1,2,'2019-04-19','2020-04-19',6,1,'给老师捶腿','你好~我是管理员',21,'yndPeWKC9e.jpg');

#
# Structure for table "t_user"
#

CREATE TABLE `t_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT 'null',
  `pwd` varchar(255) NOT NULL DEFAULT 'null',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `grade` enum('保密','大一','大二','大三','大四') DEFAULT '保密' COMMENT '年级',
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `QQ` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "t_user"
#

INSERT INTO `t_user` VALUES (2,'1','1',NULL,NULL,0,NULL,NULL),(3,'4','4',NULL,NULL,0,NULL,NULL),(4,'5','5',NULL,NULL,0,NULL,NULL),(5,'333','333',NULL,NULL,1,NULL,NULL),(6,'gloria','123','软件工程','保密',1,'12345678910','I can\'t have everything'),(7,'eee','eee',NULL,NULL,1,NULL,NULL),(8,'lalala','123',NULL,NULL,0,NULL,NULL),(15,'123','123',NULL,NULL,0,NULL,NULL),(16,'pipi','123456',NULL,NULL,1,NULL,NULL),(17,'ha','123',NULL,NULL,0,NULL,NULL),(18,'test4','123',NULL,NULL,1,NULL,NULL),(19,'test5','123',NULL,NULL,1,NULL,NULL),(20,'gggg','gggg',NULL,NULL,0,NULL,NULL),(21,'无题','12345','软件工程','大三',1,'947727923','Ican\'t have everything'),(22,'wrq','111','11111','大三',0,'11111111','111111111'),(23,'嘻嘻嘻','123','你猜','保密',1,'947727923','I can\'t have everything');

#
# Structure for table "t_team"
#

CREATE TABLE `t_team` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '匿名野队',
  `state` int(11) NOT NULL DEFAULT '0',
  `memberNum` int(11) NOT NULL DEFAULT '0',
  `leader` int(11) NOT NULL DEFAULT '0',
  `QQ` varchar(255) NOT NULL DEFAULT '神秘人没有QQ',
  `message` varchar(255) NOT NULL DEFAULT '高冷的队伍没有宣言',
  `visible` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Id`),
  KEY `leader` (`leader`),
  CONSTRAINT `t_team_ibfk_1` FOREIGN KEY (`leader`) REFERENCES `t_user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

#
# Data for table "t_team"
#

INSERT INTO `t_team` VALUES (11,'123',0,2,5,'123','123',1),(12,'444',0,1,5,'444','444',0),(13,'hahaha',0,7,5,'14142424','hahahhaha',1),(14,'777',0,1,5,'777','777',1),(15,'hyhy',0,1,7,'1111','hyhy',0),(16,'lookME',0,1,15,'947727923','MEMEME?how about me?Im cool',0),(17,'pipi111',0,1,16,'1234','pipi1',1),(18,'test4\'s team',0,1,18,'123456789','im test4',1),(19,'456',0,1,19,'456','456',0),(20,'hahaha22',0,1,23,'1414242422','hahahhaha22',1),(21,'这就是我们',1,1,23,'1414242422','申请组队的同时需要添加QQ群，进群2天内不说话将被踢出队伍。',0),(22,'hahaha',0,1,23,'14142424','hahahhaha',1),(23,'hahaha222',0,1,23,'14142424','hahahhaha222',1),(24,'呵呵',0,1,6,'该队伍已解散','123',1),(25,'呵呵',1,1,6,'该队伍已解散','123',1),(26,'嘻嘻嘻',0,1,23,'','',1),(27,'老师揉肩小分队',0,1,21,'1414242422','上老师的课结束后必须给老师揉肩！',1),(28,'今天是6.8',1,1,21,'该队伍已解散','要考试了，我却在看美剧',1);

#
# Structure for table "t_team_comment"
#

CREATE TABLE `t_team_comment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `team` int(11) NOT NULL DEFAULT '0',
  `date` date NOT NULL DEFAULT '2019-02-10',
  `content` varchar(500) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`),
  KEY `team` (`team`),
  CONSTRAINT `t_team_comment_ibfk_1` FOREIGN KEY (`team`) REFERENCES `t_team` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='队伍动态';

#
# Data for table "t_team_comment"
#

INSERT INTO `t_team_comment` VALUES (1,22,'2019-04-08','测试动态'),(2,22,'2019-04-08','测试动态2'),(3,21,'2019-04-08','测试'),(4,21,'2019-04-08','# 进度 #\r\n完成第一部分。'),(5,13,'2019-04-09','呵呵'),(6,21,'2019-04-15','动态测试'),(7,21,'2019-04-15','d'),(8,27,'2019-04-19','今天给老师揉肩了，很开心');

#
# Structure for table "t_act_team"
#

CREATE TABLE `t_act_team` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `activity` int(11) NOT NULL DEFAULT '0',
  `team` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `activity` (`activity`),
  KEY `team` (`team`),
  CONSTRAINT `t_act_team_ibfk_1` FOREIGN KEY (`activity`) REFERENCES `t_activity` (`Id`),
  CONSTRAINT `t_act_team_ibfk_2` FOREIGN KEY (`team`) REFERENCES `t_team` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

#
# Data for table "t_act_team"
#

INSERT INTO `t_act_team` VALUES (9,16,11),(10,16,12),(11,14,13),(12,13,14),(13,15,15),(14,21,16),(15,17,17),(16,25,18),(17,20,19),(18,14,20),(19,15,21),(20,15,22),(21,15,23),(22,14,25),(23,15,26),(24,15,27),(25,33,28);

#
# Structure for table "t_comment"
#

CREATE TABLE `t_comment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `critic` int(11) NOT NULL DEFAULT '0',
  `date` date NOT NULL DEFAULT '2019-02-10',
  `content` varchar(500) NOT NULL DEFAULT '空',
  `belong` int(11) NOT NULL DEFAULT '0' COMMENT '评价所属ID',
  PRIMARY KEY (`Id`),
  KEY `critic` (`critic`),
  KEY `belong` (`belong`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`critic`) REFERENCES `t_user` (`Id`),
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`belong`) REFERENCES `t_activity` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "t_comment"
#

INSERT INTO `t_comment` VALUES (1,6,'2019-04-07','你好',15),(2,23,'2019-04-07','试试看',15),(3,6,'2019-04-07','测试',15),(4,23,'2019-04-07','',15),(5,6,'2019-04-15','啊~心好痛',16),(6,6,'2019-04-15','有一个测试',16),(7,6,'2019-04-15','哈哈哈',16),(8,6,'2019-04-15','他有一些疯狂',16),(9,21,'2019-04-18','呵呵呵呵',14),(10,21,'2019-04-18','欢迎沙雕网友发表言论',31),(11,21,'2019-04-18','你为什么不说话~',31),(12,21,'2019-04-19','哈哈哈',32),(13,6,'2019-06-09','诶哟，好羞耻',33);

#
# Structure for table "t_application"
#

CREATE TABLE `t_application` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `applicant` int(11) DEFAULT NULL COMMENT '申请人',
  `team` int(11) DEFAULT NULL COMMENT '申请小队',
  `content` varchar(500) DEFAULT NULL COMMENT '申请说明',
  `date` date DEFAULT NULL COMMENT '申请时间',
  `state` enum('accept','deny','auditing') NOT NULL DEFAULT 'auditing',
  PRIMARY KEY (`Id`),
  KEY `applicant` (`applicant`),
  KEY `team` (`team`),
  CONSTRAINT `t_application_ibfk_1` FOREIGN KEY (`applicant`) REFERENCES `t_user` (`Id`),
  CONSTRAINT `t_application_ibfk_2` FOREIGN KEY (`team`) REFERENCES `t_team` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "t_application"
#

INSERT INTO `t_application` VALUES (1,21,13,'呵呵','2019-04-09','deny'),(2,21,21,'求你了','2019-04-18','accept'),(3,6,23,'求带','2019-06-09','auditing');

#
# Structure for table "t_user_team"
#

CREATE TABLE `t_user_team` (
  `team` int(11) NOT NULL DEFAULT '0',
  `member` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`team`,`member`),
  KEY `member` (`member`),
  CONSTRAINT `t_user_team_ibfk_1` FOREIGN KEY (`team`) REFERENCES `t_team` (`Id`),
  CONSTRAINT `t_user_team_ibfk_2` FOREIGN KEY (`member`) REFERENCES `t_user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "t_user_team"
#

INSERT INTO `t_user_team` VALUES (11,5),(11,16),(12,5),(13,5),(13,7),(13,17),(13,18),(13,19),(13,21),(13,23),(14,5),(15,7),(16,15),(17,16),(18,18),(19,19),(20,23),(21,21),(22,23),(23,23),(24,6),(25,6),(26,23),(27,21),(28,21);
