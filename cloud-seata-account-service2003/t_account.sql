/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MariaDB
 Source Server Version : 100311
 Source Host           : localhost:3306
 Source Schema         : seata_account

 Target Server Type    : MariaDB
 Target Server Version : 100311
 File Encoding         : 65001

 Date: 13/11/2020 11:57:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NULL DEFAULT NULL,
  `total` decimal(11, 0) NULL DEFAULT 0,
  `used` decimal(11, 0) NULL DEFAULT NULL,
  `residue` decimal(11, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES (1, 1, 1000, 0, 1000);

SET FOREIGN_KEY_CHECKS = 1;
