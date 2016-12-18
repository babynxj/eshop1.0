/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : e-store

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2015-06-20 20:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `password` varchar(10) CHARACTER SET latin1 NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1001', '111', '张林');
INSERT INTO `admin` VALUES ('1002', '111', '李晓鹏');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsID` int(11) NOT NULL,
  `goodsName` varchar(30) NOT NULL,
  `goodsClassID` int(11) NOT NULL,
  `goodsImg` varchar(30) DEFAULT NULL,
  `goodsDepict` varchar(60) DEFAULT NULL,
  `goodsPrice` float NOT NULL,
  `goodsAmount` int(11) NOT NULL,
  `goodsLeaveNum` int(11) NOT NULL,
  `regTime` date NOT NULL,
  `manufacturer` varchar(30) NOT NULL,
  PRIMARY KEY (`goodsID`),
  KEY `goodsClassID` (`goodsClassID`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`goodsClassID`) REFERENCES `goodsclass` (`goodsClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '美的电磁炉', '1', '/upload/1_1.jpg', '美的', '600', '300', '300', '2015-11-11', '美的');
INSERT INTO `goods` VALUES ('2', '手机', '2', '/upload/2_6.jpg', 'HTC', '6000', '3000', '3000', '2015-05-17', 'HTC');
INSERT INTO `goods` VALUES ('3', '笔记本电脑', '3', '/upload/3_3.jpg', '', '3000', '111', '1000', '2015-11-11', 'aaa');
INSERT INTO `goods` VALUES ('4', '华为B199', '2', '/upload/2_2.jpg', 'HTC', '6000', '3000', '3000', '2015-05-17', 'HTC');
INSERT INTO `goods` VALUES ('5', '笔记本电脑', '1', '/upload/3_3.jpg', '笔记本电脑', '6000', '300', '300', '2015-05-17', 'HTC');
INSERT INTO `goods` VALUES ('6', '数码摄像机', '5', '/upload/5_4.png', '数码摄像机', '8000', '300', '300', '2015-11-11', '数码摄像机');
INSERT INTO `goods` VALUES ('7', '笔记本电脑', '3', '/upload/3_5.jpg', '笔记本电脑', '6000', '300', '300', '2015-11-11', '自行车');
INSERT INTO `goods` VALUES ('8', '笔记本', '3', '/upload/3_7.jpg', '', '6000', '300', '300', '2015-11-11', '笔记本');
INSERT INTO `goods` VALUES ('9', '三星G3819D', '2', '/upload/2_5.jpg', 'Iphone5', '1', '1', '1', '2015-05-20', 'A');
INSERT INTO `goods` VALUES ('10', '自行车', '4', '/upload/4_1.jpg', '自行车', '123', '123', '2321', '2015-11-11', '自行车');
INSERT INTO `goods` VALUES ('11', '大康M2蓝牙耳机', '5', '/upload/5_1.jpg', '耳机', '1232', '112', '11', '2015-11-11', '大康M2');
INSERT INTO `goods` VALUES ('12', '数码摄像机', '5', '/upload/5_4.png', '数码产品', '1223', '1232', '111', '2015-11-11', '数码产品');
INSERT INTO `goods` VALUES ('13', '海信EG966', '2', '/upload/2_7.jpg', '海信', '2132', '21323', '2112', '2015-11-11', '海信');
INSERT INTO `goods` VALUES ('14', '三星G3819D', '2', '/upload/2_5.jpg', '三星', '1222', '32122', '2111', '2015-11-11', '三星');
INSERT INTO `goods` VALUES ('15', '酷派5892', '2', '/upload/2_4.jpg', '酷派', '12312', '2321', '112', '2015-11-11', '酷派');
INSERT INTO `goods` VALUES ('16', 'AIKA八爪鱼L5_12', '5', '/upload/5_2.jpg', 'AIKA', '122', '12321', '2321', '2015-11-11', 'AIKA');
INSERT INTO `goods` VALUES ('17', 'AIKA USB插排-AD221', '1', '/upload/1_2.jpg', 'AIKA', '123', '112112', '122', '2015-11-11', 'AIKA');
INSERT INTO `goods` VALUES ('18', '华为B199', '2', '/upload/2_2.jpg', '华为', '2132', '12321', '12211', '2015-11-11', '华为');
INSERT INTO `goods` VALUES ('111', 'HTC', '2', '/upload/book.png', 'HTC', '6000', '3000', '3000', '2015-05-20', 'HTC');

-- ----------------------------
-- Table structure for `goodsclass`
-- ----------------------------
DROP TABLE IF EXISTS `goodsclass`;
CREATE TABLE `goodsclass` (
  `goodsClassID` int(11) NOT NULL,
  `goodsClassName` varchar(30) NOT NULL,
  PRIMARY KEY (`goodsClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsclass
-- ----------------------------
INSERT INTO `goodsclass` VALUES ('1', '家用电器');
INSERT INTO `goodsclass` VALUES ('2', '手机');
INSERT INTO `goodsclass` VALUES ('3', '电脑/笔记本');
INSERT INTO `goodsclass` VALUES ('4', '山地车/自行车');
INSERT INTO `goodsclass` VALUES ('5', '数码配件');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noticeID` int(11) NOT NULL,
  `noticeContent` varchar(60) NOT NULL,
  PRIMARY KEY (`noticeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', 'HTC智能手机上架');
INSERT INTO `notice` VALUES ('2', '商城系统更新上线');
INSERT INTO `notice` VALUES ('3', '五一商城促销活动');
INSERT INTO `notice` VALUES ('4', '联想笔记本电脑上架');
INSERT INTO `notice` VALUES ('5', 'HTC智能手机上架');
INSERT INTO `notice` VALUES ('6', '商城系统更新上线');
INSERT INTO `notice` VALUES ('7', '五一商城促销活动');
INSERT INTO `notice` VALUES ('8', '联想笔记本电脑上架了');
INSERT INTO `notice` VALUES ('9', 'HTC智能手机上架了');
INSERT INTO `notice` VALUES ('10', '商城系统更新上线');
INSERT INTO `notice` VALUES ('11', '五一商城促销活动');
INSERT INTO `notice` VALUES ('12', '联想笔记本电脑上架了');
INSERT INTO `notice` VALUES ('123', '欢迎使用网上商城');

-- ----------------------------
-- Table structure for `orderform`
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `orderFormID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `goodsID` int(11) NOT NULL,
  `submitTime` date NOT NULL,
  `consignmentTime` date NOT NULL,
  `totalPrice` float NOT NULL,
  `isPayoff` varchar(1) NOT NULL,
  `isConsignmenet` varchar(1) NOT NULL,
  PRIMARY KEY (`orderFormID`),
  KEY `goodsID` (`goodsID`),
  KEY `userID` (`userID`),
  CONSTRAINT `orderform_ibfk_1` FOREIGN KEY (`goodsID`) REFERENCES `goods` (`goodsID`),
  CONSTRAINT `orderform_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES ('1', '3001', '1', '2015-11-11', '2015-11-11', '3000', '0', '1');
INSERT INTO `orderform` VALUES ('2', '3002', '1', '2015-11-11', '2015-11-11', '3000', '0', '1');
INSERT INTO `orderform` VALUES ('5', '3001', '15', '2015-05-20', '2015-11-11', '61560', '0', '0');
INSERT INTO `orderform` VALUES ('12', '123', '1', '2015-05-20', '2015-11-11', '6000', '0', '0');
INSERT INTO `orderform` VALUES ('14', '3002', '2', '2015-05-20', '2015-11-11', '12000', '0', '0');

-- ----------------------------
-- Table structure for `orderlist`
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `orderListID` int(11) NOT NULL,
  `orderFormID` int(11) NOT NULL,
  `goodsID` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`orderListID`),
  KEY `orderFormID` (`orderFormID`),
  CONSTRAINT `orderlist_ibfk_1` FOREIGN KEY (`orderFormID`) REFERENCES `orderform` (`orderFormID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('1', '1', '1', '30');
INSERT INTO `orderlist` VALUES ('4', '5', '15', '5');
INSERT INTO `orderlist` VALUES ('11', '12', '1', '10');
INSERT INTO `orderlist` VALUES ('13', '14', '2', '2');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `userSex` varchar(2) NOT NULL,
  `password` varchar(10) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `regTime` date NOT NULL,
  `postcode` int(11) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('123', '李海涛', '男', '111', '上海', '上海', '12312312SSs', '2015-05-20', '123123');
INSERT INTO `users` VALUES ('3001', '张晓钦', '男', '111', '汕头', '156111231223', '232311232@qq.com', '2015-11-11', '11311');
INSERT INTO `users` VALUES ('3002', '李飞扬', '女', '111', '上海', '153221231231', '231231232@qq.com', '2015-11-11', '12312');
INSERT INTO `users` VALUES ('3003', '张晓钦', '男', '111', '上海', '上海', '123123212@qq.com', '2015-05-20', '212212');
