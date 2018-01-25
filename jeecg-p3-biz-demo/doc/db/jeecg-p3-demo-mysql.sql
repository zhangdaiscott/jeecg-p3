/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50037
Source Host           : localhost:3306
Source Database       : jeecg-p3

Target Server Type    : MYSQL
Target Server Version : 50037
File Encoding         : 65001

Date: 2016-09-09 14:30:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `jp_demo_activity`
-- ----------------------------
DROP TABLE IF EXISTS `jp_demo_activity`;
CREATE TABLE `jp_demo_activity` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '活动名称',
  `begin_time` datetime default NULL COMMENT '活动开始时间',
  `end_time` datetime default NULL COMMENT ' 活动结束时间',
  `hdurl` varchar(300) default NULL COMMENT '入口地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='红包活动表';

-- ----------------------------
-- Records of jp_demo_activity
-- ----------------------------
INSERT INTO `jp_demo_activity` VALUES ('95B6BF61945043039008299AA53A2991', '2', '2016-03-26 15:50:32', '2016-03-26 15:50:34', '2');
INSERT INTO `jp_demo_activity` VALUES ('DEBCE74A2E87406EBA557748BE0FA700', '1', '2016-04-10 14:33:50', '2016-04-10 14:33:52', '1');
INSERT INTO `jp_demo_activity` VALUES ('F4EAEF41A7DF4B59AE9A41455E1643F9', '3', '2016-06-30 23:52:20', '2016-06-30 23:52:21', '3');

-- ----------------------------
-- Table structure for `jp_demo_auth`
-- ----------------------------
DROP TABLE IF EXISTS `jp_demo_auth`;
CREATE TABLE `jp_demo_auth` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '序号',
  `auth_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '权限编码',
  `auth_name` varchar(100) collate utf8_bin default NULL COMMENT '权限名称',
  `auth_type` varchar(2) collate utf8_bin default NULL COMMENT '权限类型 0:菜单;1:功能',
  `auth_contr` varchar(256) collate utf8_bin default NULL COMMENT '权限控制',
  `parent_auth_id` char(12) collate utf8_bin default NULL COMMENT '上一级权限编码',
  `leaf_ind` char(2) collate utf8_bin default NULL COMMENT '是否叶子节点',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_authid` (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运营系统权限表';

-- ----------------------------
-- Records of jp_demo_auth
-- ----------------------------
INSERT INTO `jp_demo_auth` VALUES ('1', '21', '系统管理', '0', null, null, 'N');
INSERT INTO `jp_demo_auth` VALUES ('2', '2101', '用户管理', '0', '/system/back/jwSystemUser/list.do', '21', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('3', '210101', '新增用户', '1', '/system/back/jwSystemUser/doAdd.do', '2101', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('4', '210102', '编辑用户', '1', '/system/back/jwSystemUser/doEdit.do', '2101', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('5', '2102', '角色管理', '0', '/system/back/jwSystemRole/list.do', '21', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('6', '210201', '新增角色', '1', '/system/back/jwSystemRole/doAdd.do', '2102', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('7', '210202', '编辑角色', '1', '/system/back/jwSystemRole/doEdit.do', '2102', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('8', '210203', '角色授权', '1', '/system/back/jwSystemRole/editRoleAuth.do', '2102', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('9', '210204', '删除角色', '1', '/system/back/jwSystemRole/doDelete.do', '2102', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('10', '2103', '权限管理', '0', '/system/back/jwSystemAuth/list.do', '21', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('11', '210301', '新增权限', '1', '/system/back/jwSystemAuth/doAdd.do', '2103', 'Y');
INSERT INTO `jp_demo_auth` VALUES ('12', '210302', '编辑权限', '1', '/system/back/jwSystemAuth/doEdit.do1', '2103', 'Y');

-- ----------------------------
-- Table structure for `jp_demo_order_custom`
-- ----------------------------
DROP TABLE IF EXISTS `jp_demo_order_custom`;
CREATE TABLE `jp_demo_order_custom` (
  `ID` varchar(32) NOT NULL,
  `CREATE_DT` datetime default NULL,
  `CRTUSER` varchar(12) default NULL,
  `CRTUSER_NAME` varchar(10) default NULL,
  `DEL_DT` datetime default NULL,
  `DELFLAG` int(11) default '0',
  `GO_ORDER_CODE` varchar(12) NOT NULL COMMENT '团购订单号',
  `GOC_BUSS_CONTENT` varchar(33) default NULL COMMENT '业务',
  `GOC_CONTENT` varchar(66) default NULL COMMENT '备注',
  `GOC_CUS_NAME` varchar(16) default NULL COMMENT '姓名',
  `GOC_IDCARD` varchar(18) default NULL COMMENT '身份证号',
  `GOC_PASSPORT_CODE` varchar(10) default NULL COMMENT '护照号',
  `GOC_SEX` varchar(255) default NULL COMMENT '性别',
  `MODIFIER` varchar(12) default NULL,
  `MODIFIER_NAME` varchar(10) default NULL,
  `MODIFY_DT` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jp_demo_order_custom
-- ----------------------------
INSERT INTO `jp_demo_order_custom` VALUES ('8AEFBACB0E954D1B98143674A9C799C3', '2016-09-06 18:33:42', null, null, null, '0', '2', '1', '1', '11', '0000000000000', '1', '1', null, null, null);
INSERT INTO `jp_demo_order_custom` VALUES ('970DD348071346FB8A4710920824743B', '2016-09-03 15:47:46', null, null, null, '0', '1212', '1', '1', '2', '111111111111111', '222', '1', null, null, null);

-- ----------------------------
-- Table structure for `jp_demo_order_main`
-- ----------------------------
DROP TABLE IF EXISTS `jp_demo_order_main`;
CREATE TABLE `jp_demo_order_main` (
  `ID` varchar(32) NOT NULL,
  `CREATE_DT` datetime default NULL,
  `CRTUSER` varchar(12) default NULL,
  `CRTUSER_NAME` varchar(10) default NULL,
  `DEL_DT` datetime default NULL,
  `DELFLAG` int(11) default '0',
  `GO_ALL_PRICE` decimal(10,2) default NULL COMMENT '总价(不含返款)',
  `GO_CONTACT_NAME` varchar(16) default NULL COMMENT '联系人',
  `GO_CONTENT` varchar(66) default NULL COMMENT '备注',
  `GO_ORDER_CODE` varchar(12) NOT NULL COMMENT '订单号',
  `GO_ORDER_COUNT` int(11) default NULL COMMENT '订单人数',
  `GO_RETURN_PRICE` decimal(10,2) default NULL COMMENT '返款',
  `GO_TELPHONE` varchar(11) default NULL COMMENT '手机',
  `GODER_TYPE` varchar(255) default NULL COMMENT '订单类型',
  `MODIFIER` varchar(12) default NULL,
  `MODIFIER_NAME` varchar(10) default NULL,
  `MODIFY_DT` datetime default NULL,
  `USERTYPE` varchar(255) default NULL COMMENT '顾客类型 : 1直客 2同行',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jp_demo_order_main
-- ----------------------------
INSERT INTO `jp_demo_order_main` VALUES ('20E478EF3B38444EBE6D9BF6CF7AD60B', '2016-09-03 15:47:46', null, null, null, '0', '1.00', '12', '1', '2', '12', '1.00', '18611788525', '1', null, null, null, '1');

-- ----------------------------
-- Table structure for `jp_demo_order_product`
-- ----------------------------
DROP TABLE IF EXISTS `jp_demo_order_product`;
CREATE TABLE `jp_demo_order_product` (
  `ID` varchar(32) NOT NULL,
  `CREATE_DT` datetime default NULL,
  `CRTUSER` varchar(12) default NULL,
  `CRTUSER_NAME` varchar(10) default NULL,
  `DEL_DT` datetime default NULL,
  `DELFLAG` int(11) default '0',
  `GO_ORDER_CODE` varchar(12) NOT NULL COMMENT '团购订单号',
  `GOP_CONTENT` varchar(66) default NULL COMMENT '备注',
  `GOP_COUNT` int(11) default NULL COMMENT '个数',
  `GOP_ONE_PRICE` decimal(10,2) default NULL COMMENT '单价',
  `GOP_PRODUCT_NAME` varchar(33) default NULL COMMENT '产品名称',
  `GOP_PRODUCT_TYPE` varchar(1) NOT NULL COMMENT '服务项目类型',
  `GOP_SUM_PRICE` decimal(10,2) default NULL COMMENT '小计',
  `MODIFIER` varchar(12) default NULL,
  `MODIFIER_NAME` varchar(10) default NULL,
  `MODIFY_DT` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jp_demo_order_product
-- ----------------------------
INSERT INTO `jp_demo_order_product` VALUES ('5DE5A7EAD60142C28E9731521A420BC7', '2016-09-03 15:47:46', null, null, null, '0', '1212', '1', '1', '111.00', '1', '1', '1.00', null, null, null);
INSERT INTO `jp_demo_order_product` VALUES ('9E3244FB84FB453990F4669327A5F4DF', '2016-09-06 18:33:42', null, null, null, '0', '2', '11', '111', '111.00', '111', '1', '11.00', null, null, null);
