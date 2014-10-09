/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : expertsystem

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-10-10 00:53:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'user1', 'user1', 'User One', 'Male', '32', '2014-10-10 00:30:31');
INSERT INTO `users` VALUES ('2', 'user2', 'user2', 'User One', 'Male', '32', '2014-10-10 00:31:00');
INSERT INTO `users` VALUES ('3', 'user3', 'user3', 'User Three', 'Male', '28', '2014-10-10 00:52:19');
