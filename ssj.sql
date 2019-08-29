/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : ssj

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-07-23 12:52:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'IT部');
INSERT INTO `department` VALUES ('2', '采购部');
INSERT INTO `department` VALUES ('3', '销售部');

-- ----------------------------
-- Table structure for depot
-- ----------------------------
DROP TABLE IF EXISTS `depot`;
CREATE TABLE `depot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `maxCapacity` decimal(19,2) DEFAULT NULL,
  `currentCapacity` decimal(19,2) DEFAULT NULL,
  `totalAmount` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depot
-- ----------------------------
INSERT INTO `depot` VALUES ('1', '成都仓库', '10000.00', '100.00', '10000.00');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '部门2');
INSERT INTO `dept` VALUES ('2', '阿斯蒂芬');
INSERT INTO `dept` VALUES ('3', '2342134');
INSERT INTO `dept` VALUES ('4', '玩儿');
INSERT INTO `dept` VALUES ('6', '1111111111');
INSERT INTO `dept` VALUES ('7', '23t456');
INSERT INTO `dept` VALUES ('8', '4htry45y');
INSERT INTO `dept` VALUES ('10', '二医院 ');
INSERT INTO `dept` VALUES ('12', '1234');
INSERT INTO `dept` VALUES ('16', '123');
INSERT INTO `dept` VALUES ('17', 'new');
INSERT INTO `dept` VALUES ('18', 'new');
INSERT INTO `dept` VALUES ('19', 'new');
INSERT INTO `dept` VALUES ('20', 'new');
INSERT INTO `dept` VALUES ('21', 'asadf');
INSERT INTO `dept` VALUES ('22', 'asdfasdf');
INSERT INTO `dept` VALUES ('23', 'asdf');
INSERT INTO `dept` VALUES ('24', 'qwe');
INSERT INTO `dept` VALUES ('25', 'adsf');
INSERT INTO `dept` VALUES ('26', '123123');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `headImage` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL COMMENT '1代表可用，0代表禁用',
  `firstln` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4AFD4ACE851EFECF` (`department_id`),
  CONSTRAINT `FK4AFD4ACE851EFECF` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'admin', '3b8d68c1beb601d481fb2c6d05cd1f0d', 'cyjxhu@163.com', '/images/head/5.jpg', '35', '2', '', '');
INSERT INTO `employee` VALUES ('2', 'roleAdmin', '1d3e950bbd8353cc943485cba7f10880', 'roleAdmin@163.cn', '/images/head/5.jpg', '25', '1', '', '');
INSERT INTO `employee` VALUES ('3', 'admin1', 'abc4bb86cc451719d918fcab91dba269', 'amdin1@163.cn', '/images/head/5.jpg', '25', '1', '', '');
INSERT INTO `employee` VALUES ('4', 'admin2', '337dcc4da3f4eef8719dde3ca10ace98', 'amdin2@163.cn', '/images/head/5.jpg', '25', '2', '', '');
INSERT INTO `employee` VALUES ('5', 'admin3', 'da23aaf4570cedd5d5acd0e35b5ba3a1', 'amdin3@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('7', 'admin5', '6b06a47cb051fc891a29c218cdfd4641', 'amdin5@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('8', 'admin6', '3a932f2095b312e1ce1882ac7deef868', 'amdin6@163.cn', '/images/head/5.jpg', '67', '2', '', '\0');
INSERT INTO `employee` VALUES ('9', 'admin7', 'f17b404b5bb44576a0a949e526a0f6f8', 'amdin7@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('10', 'admin8', 'cf2c5d1cd24d8ef04ebf909d17c99a14', 'amdin8@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('12', 'admin10', '85e7924ec191651dfce6bb4b30deefde', 'amdin10@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('13', 'admin11', '471449798810eb84da7d1f3275738ac3', 'amdin11@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('14', 'admin12', 'c5ba72680115661d0f2d6315dd5d975d', 'amdin12@163.cn', '/images/head/5.jpg', '10', '3', '', '\0');
INSERT INTO `employee` VALUES ('15', 'admin13', 'a31e521a02fc28324a07cd6d96950576', 'amdin13@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('16', 'admin14', '37b5df7e95049d5687f0ead30be7c06a', 'amdin14@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('17', 'admin15', 'ff0dfb4f4f86ee4c81deb56d94cd8d00', 'amdin15@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('18', 'admin16', '9d667d04005113599680799bedd1725d', 'amdin16@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('19', 'admin17', '34843f65c4aa2e17399438923e41fcbe', 'amdin17@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('20', 'admin18', '0ef171d5afb515957dbca46b6a22c718', 'amdin18@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('21', 'admin19', '0512238519b381c6821a0aeca4c357ba', 'amdin19@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('23', 'admin21', '7488a5773190e93b97a3260156cb5fe0', 'amdin21@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('24', 'admin22', '5702b072ba936d62f397f82e31156671', 'amdin22@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('25', 'admin23', 'fa36132dc51e0c34706208127357f6c5', 'amdin23@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('26', 'admin24', '9d484a7df127f9cafa3ea80000885702', 'amdin24@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('27', 'admin25', '7baac68a76daad9518fae07e7c8f16f1', 'amdin25@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('28', 'admin26', '4494d3331a2d4f8a41b2f5ef0dfcef53', 'amdin26@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('29', 'admin27', 'b6c837208a431e7f0832b0180a3b3ad3', 'amdin27@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('30', 'admin28', '883c6ce1bfdb57c0430f48e23da463d6', 'amdin28@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('31', 'admin29', '7dea52116f15c5cbe5d96b14f33e4e09', 'amdin29@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('32', 'admin30', '94affbbb5c47ddea83373a2f8470a3a6', 'amdin30@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('33', 'admin31', 'af319f0c146fc255fca0fb91f7852a06', 'amdin31@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('34', 'admin32', 'a953137caa300c479423a7b39a0c7dfd', 'amdin32@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('35', 'admin33', 'eba8c4910a495c9b19b297d00fb8adf8', 'amdin33@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('36', 'admin34', '9ac78e687949bdd9a754aeb723f9e424', 'amdin34@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('37', 'admin35', '72f966be0930d0934404cabbfc0e1236', 'amdin35@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('38', 'admin36', '6fcac316a2e7339272d1a9b6c884638c', 'amdin36@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('39', 'admin37', 'd0b5bbb3e700ddeec601c899248948aa', 'amdin37@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('40', 'admin38', 'ce20a0c4a0cd1e89f17e83bdf2baf2fc', 'amdin38@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('41', 'admin39', '725a9086839d1b0eabc3c5ea4ce406c9', 'amdin39@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('42', 'admin40', '3a68bfa9aebdfa5cd5f3b99fcb7abfab', 'amdin40@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('43', 'admin41', 'b7adb9572b11f663f3b4a9e7de6c57f1', 'amdin41@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('44', 'admin42', '94832a7cdb9005d662888b2a4d279246', 'amdin42@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('45', 'admin43', 'a5c213db82a31202095abe5ca4c291aa', 'amdin43@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('46', 'admin44', 'e8ddac66086772bda7200208bf34b118', 'amdin44@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('47', 'admin45', 'de16a6b6e7ce94c01032c83795628881', 'amdin45@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('48', 'admin46', '1e88ca1b086897fa579b963d910df1de', 'amdin46@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('49', 'admin47', '22818c8acd91e360a70d3d215abe26ee', 'amdin47@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('50', 'admin48', '5929e32b985e94e8c39cf5fcaa3cab82', 'amdin48@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('51', 'admin49', '81ac86dcf80543210df5e8da20a824be', 'amdin49@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('52', 'admin50', '2cb08cecd72c176f75b46eff3b00bb75', 'amdin50@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('53', 'admin51', '3f5c0c5d04f762a81ae98fbf712513db', 'amdin51@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('54', 'admin52', 'ab7b40bf8e8766ce3bf1393c14573412', 'amdin52@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('55', 'admin53', '931fd3f0dc7c640a7fd50f0356ffd3b1', 'amdin53@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('56', 'admin54', 'ff90659898e0a0ffa81faf6ec8913799', 'amdin54@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('57', 'admin55', 'ee42568644e73f7a8616886371786eb4', 'amdin55@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('58', 'admin56', '2eabdae2b42195fb6787970469b1647e', 'amdin56@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('59', 'admin57', '38ad88321179a411f4e8ff659e4f3b50', 'amdin57@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('60', 'admin58', '46d4c1b4b746c19958b348d6864c8801', 'amdin58@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('61', 'admin59', '92cdd795698aa8c2310e87042ce9091a', 'amdin59@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('62', 'admin60', '9012b1828bd82f9f50845b90896e37fb', 'amdin60@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('63', 'admin61', 'f0cd2443cb428507d9916c5690088ffe', 'amdin61@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('64', 'admin62', '984e75e5d1df16775f218e11f72eeb0d', 'amdin62@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('65', 'admin63', '1575d0c5aacb1651ea5d0ae7c0cc1352', 'amdin63@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('66', 'admin64', '342363b61d4ca0da25dac1439a61d9ea', 'amdin64@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('67', 'admin65', 'e37ad60a1c80bd404b25384dd79ebc07', 'amdin65@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('68', 'admin66', '603945cb61f54638dac0dd5c589a6619', 'amdin66@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('69', 'admin67', '77173b9c51cb7b69b00c66872a90f504', 'amdin67@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('70', 'admin68', '835a13ba445cc0657aad65daa1f25290', 'amdin68@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('71', 'admin69', 'e66e8fb64f590b66fcf7d52eabf35a3a', 'amdin69@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('72', 'admin70', '03f00b2273cb35bf5c7b09d58c40703b', 'amdin70@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('73', 'admin71', 'dcd5f4dcc93486a85114134c05c9a935', 'amdin71@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('74', 'admin72', '6201ae91c7489b36c23734b1b6b2f0c8', 'amdin72@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('75', 'admin73', '1de1b22ecf237a7447bfdf1318a817af', 'amdin73@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('76', 'admin74', 'e2d1e7e15320d85ebc185670873b8724', 'amdin74@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('77', 'admin75', 'a3be49b00e478730290430082ff4ff47', 'amdin75@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('78', 'admin76', '9a6776e009691cb4b95524e9bb287599', 'amdin76@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('79', 'admin77', '9a87a5821a920e8657db648bc67a4c79', 'amdin77@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('80', 'admin78', '620a3852754d33d9880a3cd407c9330c', 'amdin78@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('81', 'admin79', 'ea78b8fea20b5fe780cbec010857bfd0', 'amdin79@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('82', 'admin80', 'ee6c43b62e701c0f69a552a50c74210f', 'amdin80@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('84', 'admin82', 'd8db2863e5ed184d4621d99572d99f44', 'amdin82@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('85', 'admin83', '63a508832f4d5cb521ac82539cc6f837', 'amdin83@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('86', 'admin84', 'e87addfc58683c64eabe8df7d67d3b87', 'amdin84@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('87', 'admin85', '9f2f55d32808bf2f7eedb2c4d0f6af74', 'amdin85@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('88', 'admin86', '636e357d75919d18a6b0edd6f9ed78c2', 'amdin86@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('89', 'admin87', 'e5405650028c27aa8bba6521c8177a43', 'amdin87@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('90', 'admin88', '6187f44603ef67ad5dc1992591304e2b', 'amdin88@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('91', 'admin89', '15008ea329019f34917a73c882bf3899', 'amdin89@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('92', 'admin90', '43bb38b2f7d459d9bceda0324ef848fb', 'amdin90@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('94', 'admin92', 'e4de06f5428f889437c1c3cce3353e4b', 'amdin92@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('95', 'admin93', '5adae56fbf948a39be5d8ca95e345ef7', 'amdin93@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('96', 'admin94', '9338e49433842b0cf86bb8123d9c4d16', 'amdin94@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('97', 'admin95', 'c9ab8dad7cf7ca2ef1a9a9bb433b5cca', 'amdin95@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('98', 'admin96', '65f726a77e3b27803f7bb1b0ae49cc43', 'amdin96@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('99', 'admin97', 'a23df4122abac377dec73f0fe9d2d792', 'amdin97@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('100', 'admin98', '28b12b0ed1f3516fff7ca94e015ac393', 'amdin98@163.cn', '/images/head/5.jpg', '25', '3', '', '\0');
INSERT INTO `employee` VALUES ('101', 'admin99', 'bc725d5c232fcd8d83436b3a73723cb1', 'amdin99@163.cn', '/images/head/5.jpg', '25', '2', '', '\0');
INSERT INTO `employee` VALUES ('174', '左右', '4f7cbc2c6d5c86f6ff8778c4ebd146ff', '23123', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('175', '顶替', '0f59d2a3c6ca4d80bbc2aed25deddce5', '234', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('176', '234', '79b6a6946009361db496d6e056d4f360', '234234', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('177', 'aaaa', 'f50b4455f176c42d337e77806e4d885b', '23434', '/images/head/5.jpg', '44', '2', '', '\0');
INSERT INTO `employee` VALUES ('178', 'sdf', '9f60d33691b0949c209bb3f765c48f0b', '123', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('179', 'ewr', '378c7e68c66c8720542fd5865c092c4c', '123', '/images/head/5.jpg', '34', '3', '', '\0');
INSERT INTO `employee` VALUES ('181', 'admin77', '9a87a5821a920e8657db648bc67a4c79', 'amdin7@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('184', 'asdf', 'a1907118695b4e13c366ac82a780521d', '234', '/images/head/5.jpg', null, '1', '', '\0');
INSERT INTO `employee` VALUES ('190', 'sdfasdf', 'e758ef4bc54326a1b23ef9022060d798', '', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('191', 'sfsdaf', 'd56aa2d8403d6f8be7a414033c3fa920', '', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('192', 'sdfa', '3c74ec41c082834c93580d247997a514', '', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('198', 'admin811c5f', 'e64508989db01ed4de1dcb86afe08a18', 'lsq@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('199', 'admin185c14d', 'cdfb559cbccd5e6842e75af09fe044a2', 'amdin1@163.cn', '/images/head/5.jpg', '60', '1', '', '\0');
INSERT INTO `employee` VALUES ('200', 'admin5d6c610', '095dbac237418a7f7a7096dba94bc995', 'amdin5@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('201', 'admin11d639b3', 'ea9aba7fedb3888d62341310c9806eb1', 'amdin11@163.cn', '/images/head/5.jpg', '25', '1', '', '\0');
INSERT INTO `employee` VALUES ('204', 'fasdfasdf', '1de377c118a2d2a900499f5086507162', '', '/images/head/5.jpg', null, '1', '', '\0');
INSERT INTO `employee` VALUES ('208', 'sadfsdf', '1b275b53c28895e1311546ba76f0b149', null, '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('210', 'sadfdfwe', '471a5c7a0a97b4c3dada156218f94d34', null, '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('229', 'aaaaa', 'af5ee744890eeb878ef999055a1979c2', '', '/images/head/5.jpg', null, null, '', '\0');
INSERT INTO `employee` VALUES ('230', 'bbbb', 'cb8ad05b60a309c15b76192e80a800b4', '213', '/images/head/5.jpg', '23', null, '\0', '\0');
INSERT INTO `employee` VALUES ('233', 'dfsdf', '6dc57e6b8dcb35c27862e65af3a48616', 'sdfsdf', '/images/head/5.jpg', '324', '2', '', '\0');
INSERT INTO `employee` VALUES ('234', 'sfafs', 'e63d7d67dea57c1592c0ed6f75331212', 'wer', '/images/head/5.jpg', '23', '1', '\0', '\0');
INSERT INTO `employee` VALUES ('235', 'wer', '8a7895018551c59c6094981974027370', 'wer', '/images/head/5.jpg', '34', '2', '\0', '\0');
INSERT INTO `employee` VALUES ('236', '222222', '28094d48f890fb8c93e1fd8877f2318d', 'qe', '/images/head/5.jpg', '23', '2', '\0', '\0');
INSERT INTO `employee` VALUES ('240', '123222', '7ba3fbbc21d66f30e1aaa836cd45e7ac', '123@qq.com', '/images/head/5.jpg', '21', '3', '\0', '\0');
INSERT INTO `employee` VALUES ('245', 'admin1111', '8937c169e0448dc52b750babceb4ac1f', '', '/images/head/5.jpg', null, null, '\0', '\0');
INSERT INTO `employee` VALUES ('246', 'sfsfsf', 'fa5aebc7aa00c3bdc92f38e16a64a549', '123@qq.com', '/images/head/5.jpg', '123', '1', '\0', '\0');
INSERT INTO `employee` VALUES ('247', 'sfsfsf', 'fa5aebc7aa00c3bdc92f38e16a64a549', '', '/images/head/5.jpg', null, null, '\0', '\0');
INSERT INTO `employee` VALUES ('262', 'asdf23', '8aa96c99aa67de7284c06ba2a722c0e3', 'wqe@qq.com', '/images/head/5.jpg', '31', '2', '\0', '\0');
INSERT INTO `employee` VALUES ('263', 'asdfxx', '956378dfd667a373e71ee7facb3df49e', 'sdf@qq.com', '/images/head/5.jpg', '34', '1', '\0', '\0');
INSERT INTO `employee` VALUES ('279', 'wang', '14c0720910332f5b3408c5f1f91dd1cf', 'wang@qq.com', null, '20', null, '\0', '\0');
INSERT INTO `employee` VALUES ('280', 'wang', '14c0720910332f5b3408c5f1f91dd1cf', 'wang@qq.com', null, '20', null, '\0', '\0');

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role` (
  `employee_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`employee_id`,`role_id`),
  KEY `FK87184F674D26E00F` (`role_id`),
  KEY `FK87184F6710B1828F` (`employee_id`),
  CONSTRAINT `FK87184F6710B1828F` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK87184F674D26E00F` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_role
-- ----------------------------
INSERT INTO `employee_role` VALUES ('1', '1');
INSERT INTO `employee_role` VALUES ('2', '2');
INSERT INTO `employee_role` VALUES ('3', '4');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK24897F76799044` (`parent_id`),
  CONSTRAINT `FK24897F76799044` FOREIGN KEY (`parent_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', null, '6.png', null);
INSERT INTO `menu` VALUES ('2', '角色管理', '/role/index', '6.png', '1');
INSERT INTO `menu` VALUES ('3', '菜单管理', '/menu/index', '6.png', '1');
INSERT INTO `menu` VALUES ('4', '权限管理', '/permission/index', '6.png', '1');
INSERT INTO `menu` VALUES ('5', '导入管理', '/import/index', '6.png', '1');
INSERT INTO `menu` VALUES ('6', '组织机构', null, '6.png', null);
INSERT INTO `menu` VALUES ('7', '部门管理', '/department/index', '6.png', '6');
INSERT INTO `menu` VALUES ('8', '员工管理', '/employee/index', 'friendgroup.png', '6');
INSERT INTO `menu` VALUES ('9', '基础数据', null, '6.png', null);
INSERT INTO `menu` VALUES ('10', '数据字典类型', '/systemdictionarytype/index', '6.png', '9');
INSERT INTO `menu` VALUES ('11', '数据字典明细', '/systemdictionarydetail/index', '6.png', '9');
INSERT INTO `menu` VALUES ('12', '产品类型', '/producttype/index', '6.png', '9');
INSERT INTO `menu` VALUES ('13', '产品管理', '/product/index', '6.png', '9');
INSERT INTO `menu` VALUES ('14', '供应商管理', '/supplier/index', '6.png', '9');
INSERT INTO `menu` VALUES ('15', '采购模块', null, '6.png', null);
INSERT INTO `menu` VALUES ('16', '采购管理', '/purchasebill/index', '6.png', '15');
INSERT INTO `menu` VALUES ('17', '采购报表', 'purchasebillitem/index', '6.png', '15');
INSERT INTO `menu` VALUES ('20', '其他模块', null, null, null);
INSERT INTO `menu` VALUES ('21', '查看在线用户', '/onlineuser/index', '6.png', '20');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '添加用户', '/employee/save', null, 'employee:save', null);
INSERT INTO `permission` VALUES ('2', '删除用户', '/employee/delete', null, 'employee:delete', null);
INSERT INTO `permission` VALUES ('3', '修改用户', '/employee/update', null, 'employee:update', null);
INSERT INTO `permission` VALUES ('4', '员工管理', '/employee/index', null, 'employee:index', '8');
INSERT INTO `permission` VALUES ('5', '用户列表', '/employee/page', null, 'employee:page', null);
INSERT INTO `permission` VALUES ('10', '角色管理', '/role/index', null, 'role:index', '2');
INSERT INTO `permission` VALUES ('11', '菜单管理', '/menu/index', null, 'menu:index', '3');
INSERT INTO `permission` VALUES ('12', '权限管理', '/permission/index', null, 'permission:index', '4');
INSERT INTO `permission` VALUES ('13', '导入管理', '/import', null, 'import:*', '5');
INSERT INTO `permission` VALUES ('14', '部门管理', '/department/index', null, 'department:index', '7');
INSERT INTO `permission` VALUES ('15', '数据字典类型', '/systemDictionaryType/index', null, 'systemDictionaryType:index', '10');
INSERT INTO `permission` VALUES ('16', '数据字典明细', '/systemDictionaryDetail/index', null, 'systemDictionaryDetail:index', '11');
INSERT INTO `permission` VALUES ('17', '产品类型', '/productType/index', null, 'productType:index', '12');
INSERT INTO `permission` VALUES ('18', '产品管理', '/product/index', null, 'product:index', '13');
INSERT INTO `permission` VALUES ('19', '供应商管理', '/supplier/index', null, 'supplier:index', '14');
INSERT INTO `permission` VALUES ('20', '采购管理', '/purchaseBill/index', null, 'purchaseBill:index', '16');
INSERT INTO `permission` VALUES ('21', '采购报表', '/purchaseBillItem/index', null, 'purchaseBillItem:index', '17');
INSERT INTO `permission` VALUES ('22', '查看在线用户', '/onlineuser/index', '新增', 'onlineuser:index', '21');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `smallPic` varchar(255) DEFAULT NULL,
  `costPrice` decimal(19,2) DEFAULT NULL,
  `salePrice` decimal(19,2) DEFAULT NULL,
  `types_id` bigint(20) NOT NULL,
  `unit_id` bigint(20) NOT NULL,
  `brand_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50C664CF8DF77FB5` (`types_id`),
  KEY `FK50C664CF422B987E` (`brand_id`),
  KEY `FK50C664CF329AED61` (`unit_id`),
  CONSTRAINT `FK50C664CF329AED61` FOREIGN KEY (`unit_id`) REFERENCES `systemdictionarydetail` (`id`),
  CONSTRAINT `FK50C664CF422B987E` FOREIGN KEY (`brand_id`) REFERENCES `systemdictionarydetail` (`id`),
  CONSTRAINT `FK50C664CF8DF77FB5` FOREIGN KEY (`types_id`) REFERENCES `producttype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '产品1', 'red', '/images/upload/1_large.jpg', '/images/upload/1.jpg', '1.00', '1.00', '2', '3', '1');
INSERT INTO `product` VALUES ('2', '产品2', 'green', '/images/upload/2_large.jpg', '/images/upload/2.jpg', '2.00', '2.00', '7', '4', '2');
INSERT INTO `product` VALUES ('12', 'sdf', 'red', '/images/upload/3_large.jpg', '/images/upload/3.jpg', '23.00', '34.00', '3', '3', '1');

-- ----------------------------
-- Table structure for productstock
-- ----------------------------
DROP TABLE IF EXISTS `productstock`;
CREATE TABLE `productstock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` decimal(19,2) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `incomeDate` datetime DEFAULT NULL,
  `warning` bit(1) DEFAULT NULL,
  `topNum` decimal(19,2) DEFAULT NULL,
  `bottomNum` decimal(19,2) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `depot_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK459B4B879F064DC5` (`depot_id`),
  KEY `FK459B4B87D6A81925` (`product_id`),
  CONSTRAINT `FK459B4B879F064DC5` FOREIGN KEY (`depot_id`) REFERENCES `depot` (`id`),
  CONSTRAINT `FK459B4B87D6A81925` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productstock
-- ----------------------------

-- ----------------------------
-- Table structure for producttype
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA8168A931A015E4` (`parent_id`),
  CONSTRAINT `FKA8168A931A015E4` FOREIGN KEY (`parent_id`) REFERENCES `producttype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producttype
-- ----------------------------
INSERT INTO `producttype` VALUES ('1', '汽车', '汽车', null);
INSERT INTO `producttype` VALUES ('2', '大货车', '大货车', '1');
INSERT INTO `producttype` VALUES ('3', '小轿车', '小轿车', '1');
INSERT INTO `producttype` VALUES ('4', '越野车', '越野车', '1');
INSERT INTO `producttype` VALUES ('5', '电视', '电视', null);
INSERT INTO `producttype` VALUES ('6', '3D电视', '3D电视', '5');
INSERT INTO `producttype` VALUES ('7', '液晶电视', '液晶电视', '5');

-- ----------------------------
-- Table structure for purchasebill
-- ----------------------------
DROP TABLE IF EXISTS `purchasebill`;
CREATE TABLE `purchasebill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vdate` datetime DEFAULT NULL,
  `totalAmount` decimal(19,2) DEFAULT NULL,
  `totalNum` decimal(19,2) DEFAULT NULL,
  `inputTime` datetime DEFAULT NULL,
  `auditorTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier_id` bigint(20) NOT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `inputUser_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9BD788C89FE0CD6A` (`buyer_id`),
  KEY `FK9BD788C83FF7A83F` (`auditor_id`),
  KEY `FK9BD788C8A902BD48` (`inputUser_id`),
  KEY `FK9BD788C812C245CF` (`supplier_id`),
  CONSTRAINT `FK9BD788C812C245CF` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FK9BD788C83FF7A83F` FOREIGN KEY (`auditor_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK9BD788C89FE0CD6A` FOREIGN KEY (`buyer_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK9BD788C8A902BD48` FOREIGN KEY (`inputUser_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchasebill
-- ----------------------------
INSERT INTO `purchasebill` VALUES ('1', '2015-04-21 00:00:00', '5.00', '3.00', '2015-04-21 21:01:12', null, '0', '1', '1', '1', '1');
INSERT INTO `purchasebill` VALUES ('2', '2015-04-23 00:00:00', '22.00', '22.00', '2015-04-21 21:01:27', null, '1', '1', null, '1', '1');
INSERT INTO `purchasebill` VALUES ('3', '2015-04-21 12:00:00', '4.00', '2.00', '2015-04-21 21:01:39', null, '-1', '2', null, '1', '1');
INSERT INTO `purchasebill` VALUES ('11', '2018-06-08 00:00:00', '16.00', '8.00', '2018-06-08 19:03:36', null, '0', '1', null, '1', '4');
INSERT INTO `purchasebill` VALUES ('12', '2018-06-07 00:00:00', '98.00', '7.00', '2018-06-12 09:38:11', null, '0', '1', null, '1', '8');
INSERT INTO `purchasebill` VALUES ('16', '2018-07-02 00:00:00', '990.00', '30.00', '2018-07-09 09:44:08', null, '0', '2', null, '1', '12');
INSERT INTO `purchasebill` VALUES ('19', '2018-07-04 00:00:00', '266.00', '33.00', '2018-07-09 14:09:39', null, '0', '1', null, '1', '12');
INSERT INTO `purchasebill` VALUES ('22', '2018-10-18 00:00:00', '74.00', '3.00', '2018-10-18 12:45:11', null, '0', '2', null, '1', '4');
INSERT INTO `purchasebill` VALUES ('27', '2019-07-01 00:00:00', '288.00', '13.00', null, null, null, '1', null, '1', '1');
INSERT INTO `purchasebill` VALUES ('28', '2019-07-09 00:00:00', '2.00', '2.00', null, null, '0', '2', null, '1', '8');

-- ----------------------------
-- Table structure for purchasebillitem
-- ----------------------------
DROP TABLE IF EXISTS `purchasebillitem`;
CREATE TABLE `purchasebillitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` decimal(19,2) DEFAULT NULL,
  `num` decimal(19,2) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `bill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5FF8D3FBD6A81925` (`product_id`),
  KEY `FK5FF8D3FB60931610` (`bill_id`),
  CONSTRAINT `FK5FF8D3FB60931610` FOREIGN KEY (`bill_id`) REFERENCES `purchasebill` (`id`),
  CONSTRAINT `FK5FF8D3FBD6A81925` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchasebillitem
-- ----------------------------
INSERT INTO `purchasebillitem` VALUES ('1', '1.00', '1.00', '1.00', '1', '1', '1');
INSERT INTO `purchasebillitem` VALUES ('2', '2.00', '2.00', '4.00', '', '2', '1');
INSERT INTO `purchasebillitem` VALUES ('3', '1.00', '11.00', '11.00', '', '1', '2');
INSERT INTO `purchasebillitem` VALUES ('4', '1.00', '11.00', '11.00', '', '1', '2');
INSERT INTO `purchasebillitem` VALUES ('5', '2.00', '2.00', '4.00', '', '2', '3');
INSERT INTO `purchasebillitem` VALUES ('7', '2.00', '3.00', '6.00', '', '2', '11');
INSERT INTO `purchasebillitem` VALUES ('8', '2.00', '5.00', '10.00', '', '2', '11');
INSERT INTO `purchasebillitem` VALUES ('37', '2.00', '3.00', '6.00', '', '2', '12');
INSERT INTO `purchasebillitem` VALUES ('38', '23.00', '4.00', '92.00', '', '12', '12');
INSERT INTO `purchasebillitem` VALUES ('41', '33.00', '30.00', '990.00', '', '2', '16');
INSERT INTO `purchasebillitem` VALUES ('45', '2.00', '23.00', '46.00', 'fsdfsdf', '2', '19');
INSERT INTO `purchasebillitem` VALUES ('46', '22.00', '10.00', '220.00', 'sdfaf', '1', '19');
INSERT INTO `purchasebillitem` VALUES ('53', '34.00', '1.00', '34.00', '', '1', '22');
INSERT INTO `purchasebillitem` VALUES ('54', '20.00', '2.00', '40.00', '', '2', '22');
INSERT INTO `purchasebillitem` VALUES ('59', '23.00', '2.00', '46.00', '', '1', '27');
INSERT INTO `purchasebillitem` VALUES ('60', '22.00', '11.00', '242.00', '', '2', '27');
INSERT INTO `purchasebillitem` VALUES ('61', '1.00', '2.00', '2.00', '', '12', '28');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '用户添加', '/employee/save', '用户添加');
INSERT INTO `resource` VALUES ('2', '用户页面访问', '/employee/index', '是否能够进入访问用户的页面');
INSERT INTO `resource` VALUES ('3', '用户分页数据', '/employee/page', '查询分页的数据');
INSERT INTO `resource` VALUES ('4', '用户修改', '/employee/update', '用户修改');
INSERT INTO `resource` VALUES ('5', '用户删除', '/employee/delete', '用户删除');
INSERT INTO `resource` VALUES ('6', '检查用户名', '/employee/checkUsername', '检查用户名');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sn` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'admin');
INSERT INTO `role` VALUES ('2', '角色管理员', 'guest');
INSERT INTO `role` VALUES ('4', '人事部', 'renShiBu');
INSERT INTO `role` VALUES ('9', '一般用户', 'usual');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `FK1404278833B84B6F` (`menu_id`),
  KEY `FK140427884D26E00F` (`role_id`),
  CONSTRAINT `FK1404278833B84B6F` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `FK140427884D26E00F` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1');
INSERT INTO `role_menu` VALUES ('2', '1');
INSERT INTO `role_menu` VALUES ('1', '2');
INSERT INTO `role_menu` VALUES ('2', '2');
INSERT INTO `role_menu` VALUES ('1', '3');
INSERT INTO `role_menu` VALUES ('1', '4');
INSERT INTO `role_menu` VALUES ('1', '5');
INSERT INTO `role_menu` VALUES ('1', '6');
INSERT INTO `role_menu` VALUES ('1', '7');
INSERT INTO `role_menu` VALUES ('1', '8');
INSERT INTO `role_menu` VALUES ('1', '9');
INSERT INTO `role_menu` VALUES ('1', '10');
INSERT INTO `role_menu` VALUES ('1', '11');
INSERT INTO `role_menu` VALUES ('1', '12');
INSERT INTO `role_menu` VALUES ('1', '13');
INSERT INTO `role_menu` VALUES ('1', '14');
INSERT INTO `role_menu` VALUES ('1', '15');
INSERT INTO `role_menu` VALUES ('1', '16');
INSERT INTO `role_menu` VALUES ('1', '17');
INSERT INTO `role_menu` VALUES ('1', '20');
INSERT INTO `role_menu` VALUES ('1', '21');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKAEE599B74D26E00F` (`role_id`),
  KEY `FKAEE599B7C854068F` (`permission_id`),
  CONSTRAINT `FKAEE599B74D26E00F` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKAEE599B7C854068F` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('1', '3');
INSERT INTO `role_permission` VALUES ('1', '4');
INSERT INTO `role_permission` VALUES ('1', '5');
INSERT INTO `role_permission` VALUES ('1', '10');
INSERT INTO `role_permission` VALUES ('1', '11');
INSERT INTO `role_permission` VALUES ('1', '12');
INSERT INTO `role_permission` VALUES ('1', '13');
INSERT INTO `role_permission` VALUES ('1', '14');
INSERT INTO `role_permission` VALUES ('1', '15');
INSERT INTO `role_permission` VALUES ('1', '16');
INSERT INTO `role_permission` VALUES ('1', '17');
INSERT INTO `role_permission` VALUES ('1', '18');
INSERT INTO `role_permission` VALUES ('1', '19');
INSERT INTO `role_permission` VALUES ('1', '20');
INSERT INTO `role_permission` VALUES ('1', '21');
INSERT INTO `role_permission` VALUES ('1', '22');
INSERT INTO `role_permission` VALUES ('2', '4');
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('2', '10');
INSERT INTO `role_permission` VALUES ('4', '1');
INSERT INTO `role_permission` VALUES ('4', '3');
INSERT INTO `role_permission` VALUES ('4', '4');
INSERT INTO `role_permission` VALUES ('4', '5');
INSERT INTO `role_permission` VALUES ('9', '1');
INSERT INTO `role_permission` VALUES ('9', '2');
INSERT INTO `role_permission` VALUES ('9', '3');
INSERT INTO `role_permission` VALUES ('9', '4');
INSERT INTO `role_permission` VALUES ('9', '5');

-- ----------------------------
-- Table structure for stockincomebill
-- ----------------------------
DROP TABLE IF EXISTS `stockincomebill`;
CREATE TABLE `stockincomebill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vdate` datetime DEFAULT NULL,
  `totalAmount` decimal(19,2) DEFAULT NULL,
  `totalNum` decimal(19,2) DEFAULT NULL,
  `inputTime` datetime DEFAULT NULL,
  `auditorTime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier_id` bigint(20) NOT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `inputUser_id` bigint(20) NOT NULL,
  `keeper_id` bigint(20) NOT NULL,
  `depot_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK54AC64E69F064DC5` (`depot_id`),
  KEY `FK54AC64E63FF7A83F` (`auditor_id`),
  KEY `FK54AC64E6A902BD48` (`inputUser_id`),
  KEY `FK54AC64E6725F67CB` (`keeper_id`),
  KEY `FK54AC64E612C245CF` (`supplier_id`),
  CONSTRAINT `FK54AC64E612C245CF` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FK54AC64E63FF7A83F` FOREIGN KEY (`auditor_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK54AC64E6725F67CB` FOREIGN KEY (`keeper_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK54AC64E69F064DC5` FOREIGN KEY (`depot_id`) REFERENCES `depot` (`id`),
  CONSTRAINT `FK54AC64E6A902BD48` FOREIGN KEY (`inputUser_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockincomebill
-- ----------------------------

-- ----------------------------
-- Table structure for stockincomebillitem
-- ----------------------------
DROP TABLE IF EXISTS `stockincomebillitem`;
CREATE TABLE `stockincomebillitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` decimal(19,2) DEFAULT NULL,
  `num` decimal(19,2) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `descs` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `bill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKACA67119D6A81925` (`product_id`),
  KEY `FKACA671192B5E3024` (`bill_id`),
  CONSTRAINT `FKACA671192B5E3024` FOREIGN KEY (`bill_id`) REFERENCES `stockincomebill` (`id`),
  CONSTRAINT `FKACA67119D6A81925` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockincomebillitem
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '成都供应商');
INSERT INTO `supplier` VALUES ('2', '东莞供应商');

-- ----------------------------
-- Table structure for systemdictionarydetail
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionarydetail`;
CREATE TABLE `systemdictionarydetail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `types_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK81BC50F6718C93B5` (`types_id`),
  CONSTRAINT `FK81BC50F6718C93B5` FOREIGN KEY (`types_id`) REFERENCES `systemdictionarytype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdictionarydetail
-- ----------------------------
INSERT INTO `systemdictionarydetail` VALUES ('1', '法拉利', '1');
INSERT INTO `systemdictionarydetail` VALUES ('2', '长虹', '1');
INSERT INTO `systemdictionarydetail` VALUES ('3', '辆', '2');
INSERT INTO `systemdictionarydetail` VALUES ('4', '台', '2');

-- ----------------------------
-- Table structure for systemdictionarytype
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionarytype`;
CREATE TABLE `systemdictionarytype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sn` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdictionarytype
-- ----------------------------
INSERT INTO `systemdictionarytype` VALUES ('1', 'productBrand', '产品品牌');
INSERT INTO `systemdictionarytype` VALUES ('2', 'productUnit', '产品单位');
