/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1：3306
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : kg_seventeen

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 13/07/2025 16:40:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appeal
-- ----------------------------
DROP TABLE IF EXISTS `appeal`;
CREATE TABLE `appeal`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_collaboration_network
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_collaboration_network`;
CREATE TABLE `appeal_to_collaboration_network`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `network_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `network_id`(`network_id`) USING BTREE,
  CONSTRAINT `appeal_to_collaboration_network_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_collaboration_network_ibfk_2` FOREIGN KEY (`network_id`) REFERENCES `collaboration_network` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_collaboration_network_activity
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_collaboration_network_activity`;
CREATE TABLE `appeal_to_collaboration_network_activity`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE,
  CONSTRAINT `appeal_to_collaboration_network_activity_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_collaboration_network_activity_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `collaboration_network_activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_consequence
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_consequence`;
CREATE TABLE `appeal_to_consequence`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `consequence_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `consequence_id`(`consequence_id`) USING BTREE,
  CONSTRAINT `appeal_to_consequence_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_consequence_ibfk_2` FOREIGN KEY (`consequence_id`) REFERENCES `consequence` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_entity
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_entity`;
CREATE TABLE `appeal_to_entity`  (
  `entity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `entity_id`(`entity_id`) USING BTREE,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  CONSTRAINT `appeal_to_entity_ibfk_1` FOREIGN KEY (`entity_id`) REFERENCES `entity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_entity_ibfk_2` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_event
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_event`;
CREATE TABLE `appeal_to_event`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `event_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `event_id`(`event_id`) USING BTREE,
  CONSTRAINT `appeal_to_event_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_event_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_hazard
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_hazard`;
CREATE TABLE `appeal_to_hazard`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hazard_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `hazard_id`(`hazard_id`) USING BTREE,
  CONSTRAINT `appeal_to_hazard_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_hazard_ibfk_2` FOREIGN KEY (`hazard_id`) REFERENCES `hazard` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_location
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_location`;
CREATE TABLE `appeal_to_location`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `location_id`(`location_id`) USING BTREE,
  CONSTRAINT `appeal_to_location_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_location_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_participant
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_participant`;
CREATE TABLE `appeal_to_participant`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `participant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `participant_id`(`participant_id`) USING BTREE,
  CONSTRAINT `appeal_to_participant_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_participant_ibfk_2` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_participant_activity
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_participant_activity`;
CREATE TABLE `appeal_to_participant_activity`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE,
  CONSTRAINT `appeal_to_participant_activity_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_participant_activity_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `participant_activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_risk
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_risk`;
CREATE TABLE `appeal_to_risk`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `risk_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `risk_id`(`risk_id`) USING BTREE,
  CONSTRAINT `appeal_to_risk_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_risk_ibfk_2` FOREIGN KEY (`risk_id`) REFERENCES `risk` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_time
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_time`;
CREATE TABLE `appeal_to_time`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `time_id`(`time_id`) USING BTREE,
  CONSTRAINT `appeal_to_time_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_time_ibfk_2` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for appeal_to_wealth
-- ----------------------------
DROP TABLE IF EXISTS `appeal_to_wealth`;
CREATE TABLE `appeal_to_wealth`  (
  `appeal_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `wealth_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `appeal_id`(`appeal_id`) USING BTREE,
  INDEX `wealth_id`(`wealth_id`) USING BTREE,
  CONSTRAINT `appeal_to_wealth_ibfk_1` FOREIGN KEY (`appeal_id`) REFERENCES `appeal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `appeal_to_wealth_ibfk_2` FOREIGN KEY (`wealth_id`) REFERENCES `wealth` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collaboration_network
-- ----------------------------
DROP TABLE IF EXISTS `collaboration_network`;
CREATE TABLE `collaboration_network`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collaboration_network_activity
-- ----------------------------
DROP TABLE IF EXISTS `collaboration_network_activity`;
CREATE TABLE `collaboration_network_activity`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collaboration_network_location
-- ----------------------------
DROP TABLE IF EXISTS `collaboration_network_location`;
CREATE TABLE `collaboration_network_location`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `latitude` float NULL DEFAULT NULL,
  `longitude` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collaborative_activity
-- ----------------------------
DROP TABLE IF EXISTS `collaborative_activity`;
CREATE TABLE `collaborative_activity`  (
  `network_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `network_id`(`network_id`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE,
  CONSTRAINT `collaborative_activity_ibfk_1` FOREIGN KEY (`network_id`) REFERENCES `collaboration_network` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collaborative_activity_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `collaboration_network_activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collaborative_to_location
-- ----------------------------
DROP TABLE IF EXISTS `collaborative_to_location`;
CREATE TABLE `collaborative_to_location`  (
  `network_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `network_id`(`network_id`) USING BTREE,
  INDEX `location_id`(`location_id`) USING BTREE,
  CONSTRAINT `collaborative_to_location_ibfk_1` FOREIGN KEY (`network_id`) REFERENCES `collaboration_network` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collaborative_to_location_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for conduct
-- ----------------------------
DROP TABLE IF EXISTS `conduct`;
CREATE TABLE `conduct`  (
  `participant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `participant_id`(`participant_id`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE,
  CONSTRAINT `conduct_ibfk_1` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `conduct_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `participant_activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for consequence
-- ----------------------------
DROP TABLE IF EXISTS `consequence`;
CREATE TABLE `consequence`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cooperation
-- ----------------------------
DROP TABLE IF EXISTS `cooperation`;
CREATE TABLE `cooperation`  (
  `participant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `network_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `participant_id`(`participant_id`) USING BTREE,
  INDEX `network_id`(`network_id`) USING BTREE,
  CONSTRAINT `cooperation_ibfk_1` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cooperation_ibfk_2` FOREIGN KEY (`network_id`) REFERENCES `collaboration_network` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employ
-- ----------------------------
DROP TABLE IF EXISTS `employ`;
CREATE TABLE `employ`  (
  `participant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `wealth_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `participant_id`(`participant_id`) USING BTREE,
  INDEX `wealth_id`(`wealth_id`) USING BTREE,
  CONSTRAINT `employ_ibfk_1` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employ_ibfk_2` FOREIGN KEY (`wealth_id`) REFERENCES `wealth` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity
-- ----------------------------
DROP TABLE IF EXISTS `entity`;
CREATE TABLE `entity`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `object` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exist_participant
-- ----------------------------
DROP TABLE IF EXISTS `exist_participant`;
CREATE TABLE `exist_participant`  (
  `hazard_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `participant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `hazard_id`(`hazard_id`) USING BTREE,
  INDEX `participant_id`(`participant_id`) USING BTREE,
  CONSTRAINT `exist_participant_ibfk_1` FOREIGN KEY (`hazard_id`) REFERENCES `hazard` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exist_participant_ibfk_2` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exist_risk
-- ----------------------------
DROP TABLE IF EXISTS `exist_risk`;
CREATE TABLE `exist_risk`  (
  `hazard_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `risk_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `hazard_id`(`hazard_id`) USING BTREE,
  INDEX `risk_id`(`risk_id`) USING BTREE,
  CONSTRAINT `exist_risk_ibfk_1` FOREIGN KEY (`hazard_id`) REFERENCES `hazard` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exist_risk_ibfk_2` FOREIGN KEY (`risk_id`) REFERENCES `risk` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hazard
-- ----------------------------
DROP TABLE IF EXISTS `hazard`;
CREATE TABLE `hazard`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for leads_to
-- ----------------------------
DROP TABLE IF EXISTS `leads_to`;
CREATE TABLE `leads_to`  (
  `event_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `consequence_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `event_id`(`event_id`) USING BTREE,
  INDEX `consequence_id`(`consequence_id`) USING BTREE,
  CONSTRAINT `leads_to_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `leads_to_ibfk_2` FOREIGN KEY (`consequence_id`) REFERENCES `consequence` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `latitude` float NULL DEFAULT NULL,
  `longitude` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for may_trigger
-- ----------------------------
DROP TABLE IF EXISTS `may_trigger`;
CREATE TABLE `may_trigger`  (
  `event_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `risk_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `event_id`(`event_id`) USING BTREE,
  INDEX `risk_id`(`risk_id`) USING BTREE,
  CONSTRAINT `may_trigger_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `may_trigger_ibfk_2` FOREIGN KEY (`risk_id`) REFERENCES `risk` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for participant
-- ----------------------------
DROP TABLE IF EXISTS `participant`;
CREATE TABLE `participant`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for participant_activity
-- ----------------------------
DROP TABLE IF EXISTS `participant_activity`;
CREATE TABLE `participant_activity`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for participant_location
-- ----------------------------
DROP TABLE IF EXISTS `participant_location`;
CREATE TABLE `participant_location`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `latitude` float NULL DEFAULT NULL,
  `longitude` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for participant_to_location
-- ----------------------------
DROP TABLE IF EXISTS `participant_to_location`;
CREATE TABLE `participant_to_location`  (
  `participant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `participant_id`(`participant_id`) USING BTREE,
  INDEX `location_id`(`location_id`) USING BTREE,
  CONSTRAINT `participant_to_location_ibfk_1` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `participant_to_location_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for risk
-- ----------------------------
DROP TABLE IF EXISTS `risk`;
CREATE TABLE `risk`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for susceptible_to
-- ----------------------------
DROP TABLE IF EXISTS `susceptible_to`;
CREATE TABLE `susceptible_to`  (
  `entity_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hazard_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `entity_id`(`entity_id`) USING BTREE,
  INDEX `hazard_id`(`hazard_id`) USING BTREE,
  CONSTRAINT `susceptible_to_ibfk_1` FOREIGN KEY (`entity_id`) REFERENCES `entity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `susceptible_to_ibfk_2` FOREIGN KEY (`hazard_id`) REFERENCES `hazard` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for time
-- ----------------------------
DROP TABLE IF EXISTS `time`;
CREATE TABLE `time`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `occurred_at` datetime(0) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wealth
-- ----------------------------
DROP TABLE IF EXISTS `wealth`;
CREATE TABLE `wealth`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
