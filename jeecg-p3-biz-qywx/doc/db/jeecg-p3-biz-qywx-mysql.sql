/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50037
Source Host           : localhost:3306
Source Database       : jeecg-p3

Target Server Type    : MYSQL
Target Server Version : 50037
File Encoding         : 65001

Date: 2016-04-19 13:33:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qywx_account
-- ----------------------------
DROP TABLE IF EXISTS `qywx_account`;
CREATE TABLE `qywx_account` (
  `id` varchar(50) NOT NULL,
  `accont_name` varchar(100) default NULL COMMENT '名称',
  `corpid` varchar(255) default NULL COMMENT '企业号标识CorpID',
  `secret` varchar(255) default NULL COMMENT '管理组凭证密钥Secret',
  `access_token` varchar(512) default NULL COMMENT 'AccessToken',
  `account_desc` varchar(300) default NULL COMMENT '描述',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_corpid` (`corpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号信息表';

-- ----------------------------
-- Records of qywx_account
-- ----------------------------
INSERT INTO `qywx_account` VALUES ('402880a94742e24e014742e8942b0002', '捷微企业号', 'wx967db4406788c64c', 'kIeWcG7xN-15Sy-VYymr6ZHeYsDRx28RCj7pfWwXEQQ0GHXdD518C1qxnO2kBjhb', null, '', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_agent
-- ----------------------------
DROP TABLE IF EXISTS `qywx_agent`;
CREATE TABLE `qywx_agent` (
  `id` varchar(50) NOT NULL COMMENT '主键Id',
  `account_id` varchar(200) NOT NULL COMMENT '企业号ID',
  `wx_agentid` varchar(200) default NULL COMMENT '应用ID(微信)',
  `agent_name` varchar(200) default NULL COMMENT '应用名称',
  `token` varchar(50) default NULL COMMENT '回调token',
  `encodingAESKey` varchar(100) default NULL COMMENT '回调EncodingAESKey',
  `square_logo_url` varchar(200) default NULL COMMENT '方形头像',
  `round_logo_url` varchar(200) default NULL COMMENT '圆形头像',
  `logo_mediaid` varchar(100) default NULL COMMENT '头像mediaid',
  `description` varchar(200) default NULL COMMENT '描述',
  `close_status` varchar(200) default NULL COMMENT '是否被禁用',
  `redirect_domain` varchar(200) default NULL COMMENT '可信域名',
  `report_location_flag` varchar(2) default NULL COMMENT '是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报',
  `isreportuser` varchar(2) default NULL COMMENT '是否接收用户变更通知。0：不接收；1：接收',
  `isreportenter` varchar(2) default NULL COMMENT '是否上报用户进入应用事件。0：不接收；1：接收',
  `app_type` varchar(2) default NULL COMMENT '应用类型。1：消息型；2：主页型',
  `home_url` varchar(200) default NULL COMMENT '主页型应用url',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_accountid_appid` (`account_id`,`wx_agentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用信息表';

-- ----------------------------
-- Records of qywx_agent
-- ----------------------------
INSERT INTO `qywx_agent` VALUES ('1', '402880a94742e24e014742e8942b0002', '1', '微信考勤', 'jeewx', 'asV5OOITVJg9BhEU4445OLg91IfF6GPued1sAR8RgYY', '111url', '11', null, '', '1', '', '2', '1', '0', '1', null, null, null, null, null, null, null);
INSERT INTO `qywx_agent` VALUES ('DC46552CD5AE4DF2AE12680C4636C9BA', '402880a94742e24e014742e8942b0002', '4', '公司公告', 'jeewx', 'b2rxXq7GMymOskwpkMnwKPctb6ySWnmDQVIu7q0lKOW', '', null, null, '', '0', 'http://fly1206.xicp.net/weixinCoreController.do?wechat&corpid=wx967db4406788c64c&appid=4', '0', '0', '0', '1', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_autoresponse
-- ----------------------------
DROP TABLE IF EXISTS `qywx_autoresponse`;
CREATE TABLE `qywx_autoresponse` (
  `id` varchar(100) NOT NULL,
  `key_word` varchar(200) default NULL COMMENT '关键字',
  `res_content` varchar(500) default NULL COMMENT '回复内容',
  `msg_type` varchar(100) default NULL COMMENT '消息类型',
  `template_name` varchar(100) default NULL COMMENT '模板名称',
  `accountid` varchar(100) default NULL COMMENT '微信账号id',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`),
  KEY `idx_accountid` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关键字管理';

-- ----------------------------
-- Records of qywx_autoresponse
-- ----------------------------
INSERT INTO `qywx_autoresponse` VALUES ('694835F2933C4410A639906639F18D77', '555', 'F65B42281D1E46E69FBEAEEC43587F6D', 'text', 'nihao', '402880a94742e24e014742e8942b0002', null, null, '2016-04-18 12:43:00', null, null, null);
INSERT INTO `qywx_autoresponse` VALUES ('8a792db34fdf51b3014fdfa937e90038', '02', '8a792db34fdf51b3014fdfa3c6aa002c', 'news', 'TEST', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_autoresponse_default
-- ----------------------------
DROP TABLE IF EXISTS `qywx_autoresponse_default`;
CREATE TABLE `qywx_autoresponse_default` (
  `id` varchar(50) NOT NULL COMMENT '主键Id',
  `templatename` varchar(200) NOT NULL COMMENT '模板名称',
  `templateid` varchar(50) NOT NULL COMMENT '模板Id',
  `msgtype` varchar(40) default NULL COMMENT '消息类型',
  `accountid` varchar(40) default NULL COMMENT '微信账号Id',
  `iswork` varchar(10) default NULL COMMENT '是否启用',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='默认关键字回复';

-- ----------------------------
-- Records of qywx_autoresponse_default
-- ----------------------------
INSERT INTO `qywx_autoresponse_default` VALUES ('8a792db34fdf51b3014fdfb22e87004f', '默认回复语', '8a792db34fdf51b3014fdfb1fdb3004c', 'text', '402880a94742e24e014742e8942b0002', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_group
-- ----------------------------
DROP TABLE IF EXISTS `qywx_group`;
CREATE TABLE `qywx_group` (
  `id` varchar(100) NOT NULL COMMENT '部门Id',
  `name` varchar(200) default NULL COMMENT '部门名称',
  `parentid` varchar(100) default NULL COMMENT '上级部门Id',
  `accountid` varchar(100) default NULL COMMENT '微信账号ID',
  `orders` varchar(11) default NULL,
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注用户组';

-- ----------------------------
-- Records of qywx_group
-- ----------------------------
INSERT INTO `qywx_group` VALUES ('1', '北京国炬公司', '0', '402880a94742e24e014742e8942b0002', '200', null, null, null, null, null, null);
INSERT INTO `qywx_group` VALUES ('28', '人力资源', '1', '402880a94742e24e014742e8942b0002', '1', null, null, null, null, null, null);
INSERT INTO `qywx_group` VALUES ('3', '测试部门', '1', '402880a94742e24e014742e8942b0002', '1', null, null, null, null, null, null);
INSERT INTO `qywx_group` VALUES ('5', '软件开发部', '1', '402880a94742e24e014742e8942b0002', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_gzentity
-- ----------------------------
DROP TABLE IF EXISTS `qywx_gzentity`;
CREATE TABLE `qywx_gzentity` (
  `id` varchar(100) NOT NULL,
  `template_name` varchar(100) default NULL COMMENT '模板名称',
  `template_id` varchar(100) default NULL COMMENT '模板id',
  `template_type` varchar(100) default NULL COMMENT '类型 文本_text,图文_news',
  `is_work` varchar(100) default NULL COMMENT '是否启用 未启用_0,启用_1',
  `accountid` varchar(100) default NULL COMMENT '微信账号id',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注回复';

-- ----------------------------
-- Records of qywx_gzentity
-- ----------------------------
INSERT INTO `qywx_gzentity` VALUES ('402880a94936f3ee0149370671400001', '关注回复', '4028098246b78d570146b7915d020004', 'text', '0', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_gzentity` VALUES ('8a792db34fdf51b3014fdfa74adf0034', '图文素材1', '8a792db34fdf51b3014fdfa3c6aa002c', 'news', '1', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_gzuserinfo
-- ----------------------------
DROP TABLE IF EXISTS `qywx_gzuserinfo`;
CREATE TABLE `qywx_gzuserinfo` (
  `id` varchar(100) character set gbk NOT NULL COMMENT '主键',
  `userid` varchar(100) default NULL COMMENT '账号',
  `name` varchar(100) default NULL COMMENT '姓名',
  `department` varchar(200) default NULL COMMENT '部门',
  `position` varchar(100) default NULL COMMENT '职位',
  `mobile` varchar(100) default NULL COMMENT '电话',
  `province` varchar(100) default NULL COMMENT '省份',
  `gender` varchar(100) default NULL COMMENT '性别gender=1表示男，=0表示女',
  `email` varchar(400) default NULL COMMENT '邮箱',
  `weixinid` varchar(100) default NULL COMMENT '微信号',
  `avatar` varchar(100) default NULL COMMENT '头像url',
  `subscribe_status` varchar(100) default NULL COMMENT '关注状态: 1=已关注，2=已冻结，4=未关注',
  `subscribe_time` datetime default NULL COMMENT '关注时间',
  `accountid` varchar(100) default NULL COMMENT '微信账号ID',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注用户';

-- ----------------------------
-- Records of qywx_gzuserinfo
-- ----------------------------

-- ----------------------------
-- Table structure for qywx_menu
-- ----------------------------
DROP TABLE IF EXISTS `qywx_menu`;
CREATE TABLE `qywx_menu` (
  `ID` varchar(32) NOT NULL,
  `agent_id` varchar(255) default NULL COMMENT '应用主键ID',
  `menu_name` varchar(255) default NULL COMMENT '菜单标题',
  `menu_type` varchar(255) default NULL COMMENT '菜单类型',
  `menu_key` varchar(255) default NULL COMMENT '菜单KEY',
  `orders` varchar(10) default NULL COMMENT '菜单位置',
  `msg_type` varchar(255) default NULL COMMENT '响应消息类型',
  `template_id` varchar(255) default NULL COMMENT '关联素材ID',
  `url` varchar(1000) default NULL COMMENT '网页链接',
  `father_id` varchar(32) default NULL COMMENT '父ID',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `menu_key` (`menu_key`),
  UNIQUE KEY `order` (`orders`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自定义菜单表';

-- ----------------------------
-- Records of qywx_menu
-- ----------------------------
INSERT INTO `qywx_menu` VALUES ('0DC5CDEBFE3145E3A79201ED28B12C31', '1', '考勤', 'click', '1', '1', 'text', 'F65B42281D1E46E69FBEAEEC43587F6D', '', null, null, null, null, null, null, null);
INSERT INTO `qywx_menu` VALUES ('A32B19D7739E4A92AB8E007C36697D65', '1', '打卡', 'click', '11', '11', 'news', '8a792db34fdf51b3014fdfa3c6aa002c', '', '0DC5CDEBFE3145E3A79201ED28B12C31', null, null, null, null, null, null);
INSERT INTO `qywx_menu` VALUES ('F5ACDC56960941B89A6140FA8DEF551B', '1', '百度', 'view', 'baidu', '12', 'text', 'F65B42281D1E46E69FBEAEEC43587F6D', 'http://www.jeewx.com/', '0DC5CDEBFE3145E3A79201ED28B12C31', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_newsitem
-- ----------------------------
DROP TABLE IF EXISTS `qywx_newsitem`;
CREATE TABLE `qywx_newsitem` (
  `id` varchar(100) NOT NULL,
  `title` varchar(300) default NULL COMMENT '标题',
  `author` varchar(100) default NULL COMMENT '作者',
  `image_path` varchar(100) default NULL COMMENT '图片路径',
  `content` longtext COMMENT '内容',
  `templateid` varchar(100) default NULL COMMENT '图文模板id',
  `description` varchar(400) default NULL COMMENT '摘要',
  `order_no` varchar(100) default NULL COMMENT '新闻顺序',
  `url` varchar(100) default NULL COMMENT '消息内容的url',
  `hdid` varchar(100) default NULL COMMENT '活动id',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图文素材新闻';

-- ----------------------------
-- Records of qywx_newsitem
-- ----------------------------
INSERT INTO `qywx_newsitem` VALUES ('18342D4E58884D55B70D93C1D3F2A24A', '12', '12', 'upload/files/1348502772_8826.gif', '<p>121212</p>', '0A1776E6FE6F4AFB9CF558175AAF495D', '12', '1', '', null, null, null, null, null, null, null);
INSERT INTO `qywx_newsitem` VALUES ('8a792db34fdf51b3014fdfa41353002e', 'test', 'test', 'upload/files/2008822103119443_2.jpg', '<ul style=\"padding: 0px; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 26px; white-space: normal; background-color: rgb(255, 255, 255);\" class=\" list-paddingleft-2\"><li><p><span style=\"margin: 0px; padding: 0px; font-family: &#39;Microsoft YaHei&#39;;\"><strong>相册页面</strong></span><span style=\"margin: 0px; padding: 0px; font-family: &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;</span><span style=\"margin: 0px; padding: 0px; font-size: 12px; font-family: &#39;Microsoft YaHei&#39;;\">http://localhost/jeecg-p3-web/p3test.do?page&amp;url=oa/test/basic_gallery.html</span></p></li></ul><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 26px; white-space: normal; background-color: rgb(255, 255, 255);\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 26px; white-space: normal; background-color: rgb(255, 255, 255);\"><br/></p><p><span style=\"margin: 0px; padding: 0px; font-family: &#39;Microsoft YaHei&#39;;\"><img src=\"http://img.blog.csdn.net/20160412171725458?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center\" alt=\"\" style=\"border: none; max-width: 100%;\"/><br/></span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 26px; white-space: normal; background-color: rgb(255, 255, 255);\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 26px; white-space: normal; background-color: rgb(255, 255, 255);\"><br/></p><ul style=\"padding: 0px; color: rgb(51, 51, 51); font-family: Arial; font-size: 14px; line-height: 26px; white-space: normal; background-color: rgb(255, 255, 255);\" class=\" list-paddingleft-2\"><li><p><span style=\"margin: 0px; padding: 0px; font-family: &#39;Microsoft YaHei&#39;;\"><strong>联系人</strong>&nbsp;&nbsp;</span><span style=\"margin: 0px; padding: 0px; font-family: &#39;Microsoft YaHei&#39;;\"><span style=\"margin: 0px; padding: 0px; font-size: 12px;\">http://localhost/jeecg-p3-web/p3test.do?page&amp;url=oa/test/contacts.html</span></span></p></li></ul><p><span style=\"margin: 0px; padding: 0px; font-family: &#39;Microsoft YaHei&#39;; font-size: 12px;\"><img src=\"http://img.blog.csdn.net/20160412171812709?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center\" alt=\"\" style=\"border: none; max-width: 100%;\"/></span></p><p><br/></p>', '8a792db34fdf51b3014fdfa3c6aa002c', '111', '1', '', '', null, null, null, null, null, null);
INSERT INTO `qywx_newsitem` VALUES ('BC89EDABF05E4678A7DC46087A8B1FBD', '1231', '123123', 'upload/files/70g58PICeGn.jpg', '<p>123<br/></p>', '3D4ABC0B6B5F46EA9A53311FD9E871DA', '123', '1', '', null, null, null, null, null, null, null);
INSERT INTO `qywx_newsitem` VALUES ('ff808081538e81b40153a1602d3c006b', '2323', '23', 'upload/files/20160323104906i8kA3KPF.jpg', '<p>2323</p>', 'ff808081538e81b401539bb4b1c80034', '23', '23', '23', '', null, null, null, null, null, null);
INSERT INTO `qywx_newsitem` VALUES ('ff808081538e81b40153a17b319a0076', 'sss', 'ddddd', 'upload/files/20160323111823UttemyYU.png', '<p>ssssss</p>', 'ff808081538e81b40153a1787a020074', 'jjjjjj', '11', '	http://www.zstobacco.com.cn:9091/tobacco-marketing/f/wxcp?verify&a=37', '', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_newstemplate
-- ----------------------------
DROP TABLE IF EXISTS `qywx_newstemplate`;
CREATE TABLE `qywx_newstemplate` (
  `id` varchar(100) NOT NULL,
  `template_name` varchar(200) default NULL COMMENT '模板名称',
  `template_type` varchar(100) default NULL COMMENT '模板类型',
  `accountid` varchar(100) default NULL COMMENT '微信企业号账号id',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图文素材模板';

-- ----------------------------
-- Records of qywx_newstemplate
-- ----------------------------
INSERT INTO `qywx_newstemplate` VALUES ('8a792db34fdf51b3014fdfa3c6aa002c', 'TEST', 'common', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_newstemplate` VALUES ('ff808081538e81b401539bb4b1c80034', '庆祝', 'common', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_newstemplate` VALUES ('ff808081538e81b401539bb4ed540035', '庆祝', 'common', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_newstemplate` VALUES ('ff808081538e81b40153a15dc6aa0065', '3434', 'cl', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_newstemplate` VALUES ('ff808081538e81b40153a1690761006f', 'kk', 'common', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_newstemplate` VALUES ('ff808081538e81b40153a1761fe00071', 'sss', 'common', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_newstemplate` VALUES ('ff808081538e81b40153a1787a020074', 'pzw', 'common', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for qywx_receivetext
-- ----------------------------
DROP TABLE IF EXISTS `qywx_receivetext`;
CREATE TABLE `qywx_receivetext` (
  `id` varchar(100) NOT NULL,
  `tousername` varchar(100) NOT NULL COMMENT '开发者微信号',
  `fromusername` varchar(100) default NULL COMMENT '发送方帐号（一个OpenID）',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '消息创建时间 （整型）',
  `msgtype` varchar(100) default NULL COMMENT '消息类型（text/image/location/link）',
  `msgid` varchar(100) default NULL COMMENT '消息id，64位整型',
  `content` varchar(400) default NULL COMMENT '消息内容',
  `response` varchar(10) default NULL COMMENT '是否回复',
  `rescontent` varchar(400) default NULL COMMENT '回复内容',
  `nickname` varchar(100) default NULL COMMENT '用户昵称',
  `accountid` varchar(40) default NULL COMMENT '微信账号Id',
  `agent_id` varchar(200) default NULL COMMENT '应用ID(微信)',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文本消息';

-- ----------------------------
-- Records of qywx_receivetext
-- ----------------------------
INSERT INTO `qywx_receivetext` VALUES ('24C811109C514A79BEA9F1B7241C5323', 'wx967db4406788c64c', 'scott', '2016-04-18 12:38:31', 'text', '4402369717809971223', '02', '0', null, '', '402880a94742e24e014742e8942b0002', '1', null, null, '2016-04-18 12:38:31', null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('3C05A2E2A61F47B08A1E2554C902BFEF', 'wx967db4406788c64c', 'scott', '2016-04-18 15:22:07', 'text', '4402369717809971226', '02', '0', null, '', '402880a94742e24e014742e8942b0002', '1', null, null, '2016-04-18 15:22:07', null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('4239F833C49F4B8C8094FBACEC0101CA', 'wx967db4406788c64c', 'scott', '2016-04-18 12:39:18', 'text', '4402369717809971224', '02', '0', null, '', '402880a94742e24e014742e8942b0002', '1', null, null, '2016-04-18 12:39:18', null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34e735e21014e8b4bb4cb00b3', 'wx967db4406788c64c', 'ileida', '2015-07-14 14:41:11', 'text', '4402369717809971201', '测试消息', '1', '通融通融通', '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfa4b4940030', 'wx967db4406788c64c', 'scott', '2015-09-18 16:49:17', 'text', '4402369717809971206', '你好', '1', '', '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfa4b56f0031', 'wx967db4406788c64c', 'scott', '2015-09-18 16:49:17', 'text', '4402369717809971207', '哦哦哦', '1', '111', '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfa5285c0032', 'wx967db4406788c64c', 'scott', '2015-09-18 16:49:47', 'text', '4561284207841640449', '1111444', '0', null, '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfa95d920039', 'wx967db4406788c64c', 'scott', '2015-09-18 16:54:22', 'text', '4402369717809971208', '01', '0', null, '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfa9a22d003b', 'wx967db4406788c64c', 'scott', '2015-09-18 16:54:40', 'text', '4402369717809971209', '02', '0', null, '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfaa399a003c', 'wx967db4406788c64c', 'scott', '2015-09-18 16:55:19', 'text', '4561284207841640450', '01', '1', '', '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('8a792db34fdf51b3014fdfb28dfd0051', 'wx967db4406788c64c', 'scott', '2015-09-18 17:04:25', 'text', '4402369717809971210', '1111111', '1', '2', '', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null, null);
INSERT INTO `qywx_receivetext` VALUES ('9C19A1878B3B433D997368423C0848DB', 'wx967db4406788c64c', 'scott', '2016-04-18 12:42:18', 'text', '4402369717809971225', '02', '0', null, '', '402880a94742e24e014742e8942b0002', '1', null, null, '2016-04-18 12:42:22', null, null, null);

-- ----------------------------
-- Table structure for qywx_texttemplate
-- ----------------------------
DROP TABLE IF EXISTS `qywx_texttemplate`;
CREATE TABLE `qywx_texttemplate` (
  `id` varchar(100) NOT NULL,
  `template_name` varchar(200) NOT NULL COMMENT '模板名称',
  `template_content` varchar(500) NOT NULL COMMENT '模板内容',
  `accountid` varchar(100) default NULL COMMENT '微信企业账户id',
  `create_name` varchar(50) default NULL COMMENT '创建人名称',
  `create_by` varchar(50) default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_name` varchar(50) default NULL COMMENT '更新人名称',
  `update_by` varchar(50) default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文本模板';

-- ----------------------------
-- Records of qywx_texttemplate
-- ----------------------------
INSERT INTO `qywx_texttemplate` VALUES ('8a792db34fdf51b3014fdfa391fd002a', '素材1一句话冠亚军', '测试素材1很干净', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_texttemplate` VALUES ('8a792db34fdf51b3014fdfb196200049', '验证回复语', '验证回复语', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_texttemplate` VALUES ('8a792db34fdf51b3014fdfb1fdb3004c', '默认回复语', '默认回复语', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
INSERT INTO `qywx_texttemplate` VALUES ('F65B42281D1E46E69FBEAEEC43587F6D', 'nihao', 'nihao 欢迎你测试 jeewx-qywx', '402880a94742e24e014742e8942b0002', null, null, '2016-03-25 15:46:48', null, null, null);
INSERT INTO `qywx_texttemplate` VALUES ('ff808081538e81b40153a172bfcc0070', '花海', '水水水水水', '402880a94742e24e014742e8942b0002', null, null, null, null, null, null);
