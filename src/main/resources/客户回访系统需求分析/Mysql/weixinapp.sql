use weixinapp; 
# 鼠标放到相应的表创建中一个一个创建，不用删除语句，每个语句都只执行一次而已 
#  首先要选中weixinapp这个数据库 

CREATE TABLE `info_sound` (
  `sound_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '语音ID',
  `sound_path` text COMMENT '语音路径',
  `sound_name` varchar(50) DEFAULT NULL COMMENT '语音名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`sound_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `info_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_num` varchar(20) DEFAULT NULL COMMENT '用户账号',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名字',
  `isdelete` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

CREATE TABLE `log_alarm` (
  `alarmlog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `alarmlog_date` datetime DEFAULT NULL COMMENT '日志时间',
  `alarm_message` varchar(200) DEFAULT NULL COMMENT '日志信息',
  `alarm_type` varchar(20) DEFAULT NULL COMMENT '报警类型',
  `tel_event` varchar(20) DEFAULT NULL COMMENT '电话事件',
  PRIMARY KEY (`alarmlog_id`),
  UNIQUE KEY `alarmlog_id_uni` (`alarmlog_id`) USING BTREE,
  KEY `alarmlog_date_idx` (`alarmlog_date`) USING BTREE,
  KEY `alarm_type_idx` (`alarm_type`) USING BTREE,
  KEY `alarmlog_date_message_idx` (`alarmlog_date`,`alarm_message`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `log_visit` (
  `visit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回访日志ID',
  `visitlog_date` datetime DEFAULT NULL COMMENT '回访时间',
  `visit_message` varchar(200) DEFAULT NULL COMMENT '回访信息',
  `question_id` int(11) DEFAULT NULL COMMENT '回访问题ID',
  `DTMF` int(11) DEFAULT NULL COMMENT '电话按键',
  `tel_event` varchar(20) DEFAULT NULL COMMENT '电话事件',
  PRIMARY KEY (`visit_id`),
  UNIQUE KEY `visit_id_uni` (`visit_id`) USING BTREE,
  KEY `FK_log_visit_question_id_idx` (`question_id`) USING BTREE,
  KEY `visitlog_date_idx` (`visitlog_date`) USING BTREE,
  KEY `visitlog_date_question_id_idx` (`visitlog_date`,`question_id`) USING BTREE,
  CONSTRAINT `FK_log_visit_question_id` FOREIGN KEY (`question_id`) REFERENCES `std_question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `std_question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题ID',
  `question` varchar(200) DEFAULT NULL COMMENT '问题内容',
  `question_type` char(10) DEFAULT NULL COMMENT '问题类型',
  `sound_id` int(11) DEFAULT NULL COMMENT '语音ID',
  `create_user` int(11) DEFAULT NULL COMMENT '创建用户',
  `isdelete` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `question_id_UNIQUE` (`question_id`),
  KEY `sound_id_idx` (`sound_id`) USING BTREE,
  KEY `FK_std_question_create_user_idx` (`create_user`),
  CONSTRAINT `FK_std_question_create_sound` FOREIGN KEY (`sound_id`) REFERENCES `info_sound` (`sound_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_std_question_create_user` FOREIGN KEY (`create_user`) REFERENCES `info_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

CREATE TABLE `std_questionpaper` (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问卷ID',
  `paper_name` varchar(50) DEFAULT NULL COMMENT '问卷名称',
  `create_user` int(11) DEFAULT NULL COMMENT '创建用户',
  `isdefault` tinyint(4) DEFAULT NULL COMMENT '是否默认',
  `isdelete` tinyint(4) DEFAULT NULL COMMENT '可用状态',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`paper_id`),
  UNIQUE KEY `paper_id_UNIQUE` (`paper_id`),
  KEY `FK_std_questionpaper_create_user_ibx` (`create_user`) USING BTREE,
  CONSTRAINT `FK_std_questionpaper_create_user` FOREIGN KEY (`create_user`) REFERENCES `info_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE `tr_question_paper` (
  `question_paper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `question_id` int(11) DEFAULT NULL COMMENT '问题ID',
  `paper_id` int(11) DEFAULT NULL COMMENT '问卷ID',
  PRIMARY KEY (`question_paper_id`),
  KEY `FK_tr_question_paper_question_id_idx` (`question_id`) USING BTREE,
  KEY `FK_tr_question_paper_paper_id_idx` (`paper_id`) USING BTREE,
  CONSTRAINT `FK_tr_question_paper_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `std_questionpaper` (`paper_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tr_question_paper_question_id` FOREIGN KEY (`question_id`) REFERENCES `std_question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

CREATE TABLE `tr_question_paper` (
  `question_paper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `question_id` int(11) DEFAULT NULL COMMENT '问题ID',
  `paper_id` int(11) DEFAULT NULL COMMENT '问卷ID',
  PRIMARY KEY (`question_paper_id`),
  KEY `FK_tr_question_paper_question_id_idx` (`question_id`) USING BTREE,
  KEY `FK_tr_question_paper_paper_id_idx` (`paper_id`) USING BTREE,
  CONSTRAINT `FK_tr_question_paper_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `std_questionpaper` (`paper_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tr_question_paper_question_id` FOREIGN KEY (`question_id`) REFERENCES `std_question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

CREATE TABLE `vt_alarm` (
  `id` int(11) NOT NULL,
  `count_date` date DEFAULT NULL COMMENT '统计日期',
  `alarm_total` int(11) DEFAULT NULL COMMENT '报警统计',
  `call_total` int(11) DEFAULT NULL COMMENT '呼出统计',
  `call_out` int(11) DEFAULT NULL COMMENT '挂机统计',
  `alarm_cancel` int(11) DEFAULT NULL COMMENT '取消报警统计',
  `alarm_1` int(11) DEFAULT NULL,
  `alarm_2` int(11) DEFAULT NULL,
  `alarm_3` int(11) DEFAULT NULL,
  `alarm_4` int(11) DEFAULT NULL,
  `alarm_5` int(11) DEFAULT NULL,
  `alarm_6` int(11) DEFAULT NULL,
  `alarm_7` int(11) DEFAULT NULL,
  `alarm_8` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
