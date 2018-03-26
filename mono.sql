/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mono

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-08 17:03:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `m_userinfo`;
CREATE TABLE `m_userinfo` (
  `userid` varchar(255) NOT NULL,
  `errcode` varchar(255) DEFAULT NULL,
  `errmsg` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `isleader` varchar(255) DEFAULT NULL,
  `extattr` varchar(255) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `enable` varchar(255) DEFAULT NULL,
  `hide_mobile` varchar(255) DEFAULT NULL,
  `orders` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_userinfo
-- ----------------------------
INSERT INTO `m_userinfo` VALUES ('ZhanGuoYe', '0', 'ok', '湛国业', '[1, 5]', '测试', '13897753778', '1', '2522926659@qq.com', 'http://p.qlogo.cn/bizmail/Z2ITib82ZGtcqFJK7p8LickXbANibOh7FbNEXVicq7s1QNyDZBM5uTrBmw/0', '1', '0', '{\r\n		\"attrs\": []\r\n	}', 'GuoYe', '002-123456', '1', '0', '[0, 0]');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123');
INSERT INTO `user` VALUES ('2', '23', '23');
INSERT INTO `user` VALUES ('3', '34', '34');
INSERT INTO `user` VALUES ('4', 'loginName', 'password');
INSERT INTO `user` VALUES ('5', 'loginName', 'password');
INSERT INTO `user` VALUES ('6', 'loginName', 'password');
INSERT INTO `user` VALUES ('7', 'loginName', 'password');
INSERT INTO `user` VALUES ('15', 'qwdq', 'qwdq');
INSERT INTO `user` VALUES ('16', 'qwdq', 'qwdq');
INSERT INTO `user` VALUES ('17', 'loginName', 'password');
INSERT INTO `user` VALUES ('18', 'qwdq', 'sdqd');
INSERT INTO `user` VALUES ('23', '十大', '大声道');
INSERT INTO `user` VALUES ('24', 'loginName', 'password');
INSERT INTO `user` VALUES ('25', 'loginName', 'password');
INSERT INTO `user` VALUES ('26', 'loginName', 'password');
INSERT INTO `user` VALUES ('27', 'loginName', 'password');
INSERT INTO `user` VALUES ('28', 'loginName', 'password');
INSERT INTO `user` VALUES ('29', 'loginName', 'password');
