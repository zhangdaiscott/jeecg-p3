/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50037
Source Host           : localhost:3306
Source Database       : jeecg-p3

Target Server Type    : MYSQL
Target Server Version : 50037
File Encoding         : 65001

Date: 2016-06-28 20:36:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `cms_ad`
-- ----------------------------
DROP TABLE IF EXISTS `cms_ad`;
CREATE TABLE `cms_ad` (
  `id` varchar(36) NOT NULL,
  `create_name` varchar(50) default NULL COMMENT 'createName',
  `create_by` varchar(50) default NULL COMMENT 'createBy',
  `create_date` datetime default NULL COMMENT 'createDate',
  `title` varchar(20) default NULL COMMENT '标题',
  `image_href` varchar(255) default NULL COMMENT '图片地址',
  `image_name` varchar(255) default NULL COMMENT '图片名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_ad
-- ----------------------------
INSERT INTO `cms_ad` VALUES ('2E74717E30214B748A656263FBE49AB6', null, null, null, '111111', '2008822103119443_21466503870834.jpg', '2222222');
INSERT INTO `cms_ad` VALUES ('45952DE6A5ED487D8B61561844C33F02', null, '企业微信', '2016-06-18 10:23:22', '222222222222222', '138405284445531466503879084.png', '222222222222222');

-- ----------------------------
-- Table structure for `cms_article`
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` varchar(36) NOT NULL,
  `title` varchar(50) default NULL COMMENT '标题',
  `image_href` varchar(255) default NULL COMMENT '图片地址',
  `summary` varchar(255) default NULL COMMENT 'summary',
  `content` varchar(20000) default NULL COMMENT '内容',
  `column_id` varchar(36) default NULL COMMENT '栏目id',
  `create_name` varchar(255) default NULL COMMENT '创建人',
  `create_by` varchar(255) default NULL COMMENT '创建人id',
  `create_date` datetime default NULL COMMENT '创建日期',
  `publish` varchar(32) default NULL COMMENT '是否发布',
  `PUBLISH_DATE` datetime default NULL COMMENT '发布时间',
  `AUTHOR` varchar(32) default NULL COMMENT '作者',
  `LABEL` varchar(200) default NULL COMMENT '标签',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES ('51FA503CDC5D45E29BE38B8030196F87', '新闻一', '2008822103119443_21466585473920.jpg', null, '<p><img src=\"http://localhost/jeecg-p3-web/upload/ueditor/20160628/72431467092830594.gif\" title=\"1348502811_1337.gif\"/></p>', 'A01', null, null, null, 'Y', '2016-06-15 00:00:00', 'jeecg', 'jeecg');
INSERT INTO `cms_article` VALUES ('F4D5439F54094254A6694E9E39494F68', '新闻二', '70g58PICeGn1466585486280.jpg', null, '<h1 style=\"margin: 0px 0px 6px; padding: 16px 0px 8px; font-size: 22px; word-wrap: break-word; font-stretch: normal; line-height: 30px; font-family: 宋体, arial; text-align: center; color: rgb(0, 51, 102); border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(229, 229, 229); white-space: normal;\">骑士夺冠赌城疯玩 正点辣妹左拥右揽(组图)</h1><p><span id=\"pubtime_baidu\">发布时间：2016-06-21 18:10:15</span>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<span id=\"source_baidu\">来源：<a href=\"http://news.k618.cn/society/pic/201606/t20160621_7799242.htm\" target=\"_blank\" style=\"color: rgb(51, 51, 51); text-decoration: none;\">未来网</a></span>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<span id=\"author_baidu\">作者：佚名</span>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<span id=\"editor_baidu\">责任编辑：相涛</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 8px 0px; word-wrap: break-word; line-height: 23px; text-align: center;\"><img alt=\"骑士夺冠赌城疯玩\" src=\"http://jiangsu.china.com.cn/uploadfile/2016/0621/1466503684642411.jpg\" title=\"点击图片翻到下一页&gt;&gt;\" style=\"border: none; vertical-align: middle; max-width: 550px; cursor: pointer;\"/></p><p><br/></p>', 'A02', null, null, null, 'Y', '2016-06-15 00:00:00', 'jeewx', 'jeewx');

-- ----------------------------
-- Table structure for `cms_menu`
-- ----------------------------
DROP TABLE IF EXISTS `cms_menu`;
CREATE TABLE `cms_menu` (
  `ID` varchar(36) NOT NULL,
  `CREATE_BY` varchar(255) default NULL,
  `CREATE_DATE` datetime default NULL,
  `CREATE_NAME` varchar(255) default NULL,
  `IMAGE_HREF` varchar(255) default NULL COMMENT '图片地址',
  `IMAGE_NAME` varchar(255) default NULL COMMENT '图片名称',
  `NAME` varchar(20) default NULL COMMENT '栏目名称',
  `TYPE` varchar(20) default NULL COMMENT '类型',
  `PARENT_CODE` varchar(36) default NULL COMMENT '父节点',
  `HREF` varchar(100) default NULL COMMENT '地址',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_menu
-- ----------------------------
INSERT INTO `cms_menu` VALUES ('A01', null, null, null, '70g58PICeGn1466573738755.jpg', null, '公告栏目', 'link', '', null);
INSERT INTO `cms_menu` VALUES ('A02', '企业微信', '2016-06-21 18:12:18', null, '138405284445531466573747823.png', null, '新闻栏目', 'link', '', null);
INSERT INTO `cms_menu` VALUES ('A03', '企业微信', '2016-06-21 18:12:27', null, '2008822103119443_21466573757981.jpg', null, '休闲栏目', 'link', '', null);

-- ----------------------------
-- Table structure for `cms_site`
-- ----------------------------
DROP TABLE IF EXISTS `cms_site`;
CREATE TABLE `cms_site` (
  `ID` varchar(36) NOT NULL,
  `UPDATE_NAME` varchar(50) default NULL,
  `UPDATE_DATE` datetime default NULL,
  `CREATE_DATE` datetime default NULL,
  `CREATE_NAME` varchar(50) default NULL,
  `COMPANY_TEL` varchar(50) default NULL COMMENT '公司电话',
  `SITE_LOGO` varchar(200) default NULL COMMENT '站点Logo',
  `SITE_NAME` varchar(100) default NULL COMMENT '站点名称',
  `SITE_TEMPLATE_STYLE` varchar(50) default NULL COMMENT '站点模板',
  `SITE_PATH` varchar(50) default NULL COMMENT '站点地址',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点';

-- ----------------------------
-- Records of cms_site
-- ----------------------------
INSERT INTO `cms_site` VALUES ('8AE3E507F312439A9B077DB6CA0E345C', null, null, '2016-06-19 23:14:22', null, '01000000000', 'LOGO-mini1466994393835.jpg', 'JEECG官网', '无', '/jeecg-p3-web');

-- ----------------------------
-- Table structure for `cms_style`
-- ----------------------------
DROP TABLE IF EXISTS `cms_style`;
CREATE TABLE `cms_style` (
  `ID` varchar(36) NOT NULL,
  `CREATE_DATE` datetime default NULL,
  `CREATE_NAME` varchar(50) default NULL,
  `UPDATE_DATE` datetime default NULL,
  `UPDATE_NAME` varchar(50) default NULL,
  `TEMPLATE_NAME` varchar(100) default NULL COMMENT '模板名称',
  `REVIEW_IMG_URL` varchar(100) default NULL COMMENT '预览图',
  `TEMPLATE_URL` varchar(200) default NULL COMMENT '模板地址',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点模板';

-- ----------------------------
-- Records of cms_style
-- ----------------------------
