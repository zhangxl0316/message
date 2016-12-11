/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : oracle(本地)zxl
Source Server Version : 110200
Source Host           : 127.0.0.1:1521
Source Schema         : ZXL

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2016-12-11 23:04:17
*/


-- ----------------------------
-- Table structure for MSG_MODEL
-- ----------------------------
DROP TABLE "ZXL"."MSG_MODEL";
CREATE TABLE "ZXL"."MSG_MODEL" (
"ID" NUMBER(14) NOT NULL ,
"MSG_TYPE" NUMBER(2) NULL ,
"MSG_MODE" NUMBER(2) NULL ,
"RECIPIENT_TYPE" NUMBER(2) NULL ,
"MSG_CONTENT" VARCHAR2(500 BYTE) NULL ,
"STATE" NUMBER(1) DEFAULT 1  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "ZXL"."MSG_MODEL"."MSG_TYPE" IS '消息类型';
COMMENT ON COLUMN "ZXL"."MSG_MODEL"."MSG_MODE" IS '消息方式(1:邮件,2:短信,3:系统消息)';
COMMENT ON COLUMN "ZXL"."MSG_MODEL"."RECIPIENT_TYPE" IS '接收人类型';
COMMENT ON COLUMN "ZXL"."MSG_MODEL"."MSG_CONTENT" IS '消息内容';
COMMENT ON COLUMN "ZXL"."MSG_MODEL"."STATE" IS '状态(0:不可用,1:可用)';

-- ----------------------------
-- Indexes structure for table MSG_MODEL
-- ----------------------------

-- ----------------------------
-- Checks structure for table MSG_MODEL
-- ----------------------------
ALTER TABLE "ZXL"."MSG_MODEL" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table MSG_MODEL
-- ----------------------------
ALTER TABLE "ZXL"."MSG_MODEL" ADD PRIMARY KEY ("ID");
