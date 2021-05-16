create table `Student` (
    `id` bigint(16) NOT NULL COMMENT 'id',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator_id` varchar(32) NOT NULL COMMENT '创建人名称',
    `operator_id` varchar (32) DEFAULT NULL COMMENT '修改人id',
    `creator` varchar(32) NOT NULL COMMENT '创建人',
    `operator` varchar (32) DEFAULT NULL COMMENT '修改人',
    `is_delete` int(2) NOT NULL DEFAULT '0' comment '逻辑删除',
    `name` varchar (32) NOT NULL COMMENT '名字',
    `age` int (30) NOT NULL COMMENT '年龄',
    `address` varchar (32) DEFAULT NULL COMMENT '地址',
    `sex` int (2) NOT NULL DEFAULT '0' COMMENT '性别'
)

create table `user_operation` (
    `id` bigint(16)  unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `action` varchar (255) DEFAULT NULL  comment '行为',
     `method` varchar (255) default null comment '方法',
     `params` varchar(255)  default ''  comment '参数',
    `remark` varchar (255) DEFAULT NULL  comment '标记',
     `ip` varchar (255) default NULL comment 'ip地址',
    `create_time` datetime not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime not null DEFAULT CURRENT_TIMESTAMP ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator_id` varchar(32) DEFAULT NULL COMMENT '创建人名称',
    `operator_id` varchar (32) DEFAULT NULL COMMENT '修改人id',
    `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
    `operator` varchar (32) DEFAULT NULL COMMENT '修改人',
    `is_delete` int(2) not null DEFAULT 0 comment '逻辑删除',
    PRIMARY key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '用户操作记录表'