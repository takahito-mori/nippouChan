CREATE DATABASE `nippou_chan_db`;
USE `nippou_chan_db`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `users`;	
SET FOREIGN_KEY_CHECKS=1;				
				
CREATE TABLE `users` (				
`user_id`			VARCHAR(10) PRIMARY KEY,	
`user_name`			VARCHAR(30) NOT NULL,	
`user_kana`			VARCHAR(30) NOT NULL,	
`user_password`		VARCHAR(50) NOT NULL,	
`user_mail`			VARCHAR(300) NOT NULL	
);				
				
INSERT INTO `users` VALUES ('00001', '橋本智広', 'ハシモトトモヒロ', 'chan0815', 'cds2017c@unirita.co.jp');				
INSERT INTO `users` VALUES ('00002', '午後紅茶', 'ゴゴノコウチャ', 'chan0816', 'cds2017d@unirita.co.jp');				
INSERT INTO `users` VALUES ('00003', '伊藤将', 'イトウマサル', 'chan0817', 'cds2017e@unirita.co.jp');				
				
SET FOREIGN_KEY_CHECKS=0;				
DROP TABLE IF EXISTS `nippou`;				
SET FOREIGN_KEY_CHECKS=1;				
CREATE TABLE `nippou`(				
`nippou_id`			INT NOT NULL AUTO_INCREMENT,		
`nippou_title`		VARCHAR(100) NOT NULL,		
`nippou_register`	TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,		
`nippou_edit`		TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,		
`nippou_training`	DATE  NOT NULL,		
`nippou_contents`	TEXT  NOT NULL,		
`user_id`			VARCHAR(10)  NOT NULL,		
PRIMARY KEY `nippou` (`nippou_id`),				
KEY `fk_nippou` (`user_id`),				
CONSTRAINT `fk_nippou` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE				
);				
				
INSERT INTO `nippou` VALUES (null, 'test_title1',null, null,'2018-08-18','sample1','00001');				
INSERT INTO `nippou` VALUES (null, 'test_title2',null, null,'2018-08-18','sample2','00002');				
/*INSERT INTO `nippou` VALUES (null, 'test_title2',null, null,'2018-08-18','sample2','10');*/				
				
-- SET FOREIGN_KEY_CHECKS=0;				
DROP TABLE IF EXISTS `comments`;
-- SET FOREIGN_KEY_CHECKS=1;
CREATE TABLE `comments`(				
`comment_id`			INT NOT NULL AUTO_INCREMENT,	
`comment_content`		TEXT NOT NULL,		
`comment_register`		TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,		
`comment_edit`			TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,	
`user_id`				VARCHAR(10)  NOT NULL,
`nippou_id`				INT  NOT NULL,
PRIMARY KEY `comments` (`comment_id`),				
KEY `fk_users` (`user_id`),				
CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,				
KEY `fk_nippou2` (`nippou_id`),				
CONSTRAINT `fk_nippou2` FOREIGN KEY (`nippou_id`) REFERENCES `nippou` (`nippou_id`) ON DELETE CASCADE ON UPDATE CASCADE				
				
);				
				
INSERT INTO `comments` VALUES (null, 'test_comment1',null, null,'00001',1);				
INSERT INTO `comments` VALUES (null, 'test_comment2',null, null,'00002',2);				