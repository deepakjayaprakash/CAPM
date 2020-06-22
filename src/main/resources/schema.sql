create database capm;

CREATE TABLE `manager` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`access_level` varchar(40) NOT NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`)
);

CREATE TABLE `global_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`config_name` varchar(40) NOT NULL,
`config_value` varchar(40) NOT NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`),
UNIQUE KEY `config_name` (`config_name`)
);

CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`team_name` varchar(40) NOT NULL,
`manager_id` bigint(20) DEFAULT NULL,
`size` int(10) DEFAULT NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`),
UNIQUE KEY `team_name` (`team_name`),
KEY `fk_manager_id` (`manager_id`),
CONSTRAINT `fk_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`)
);

CREATE TABLE `team_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`config_name` varchar(40) NOT NULL,
`config_value` varchar(40) NOT NULL,
`team_id` bigint(20) NOT NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`),
UNIQUE KEY `config_name` (`config_name`),
KEY `fk_team_id` (`team_id`),
CONSTRAINT `fk_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
);

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(40) NOT NULL,
`code` varchar(40) NOT NULL,
`manager_id` bigint(20) default NULL,
`team_id` bigint(20) default NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`),
KEY `fk_employee_manager_id` (`manager_id`),
CONSTRAINT `fk_employee_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`),
KEY `fk_employee_team_id` (`team_id`),
CONSTRAINT `fk_employee_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
);

CREATE TABLE `datewise_attendance_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`date` datetime DEFAULT CURRENT_TIMESTAMP,
`employee_list` json DEFAULT NULL,
`team_id` bigint(20) NOT NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`),
UNIQUE KEY `date_team` (`date`, `team_id`),
KEY `fk_attendance_team_id` (`team_id`),
CONSTRAINT `fk_attendance_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
);


CREATE TABLE `employee_attendance_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
`date` datetime DEFAULT CURRENT_TIMESTAMP,
`employee_list` json DEFAULT NULL,
`employee_id` bigint(20) NOT NULL,
`created_at` datetime DEFAULT CURRENT_TIMESTAMP,
`updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `id` (`id`),
UNIQUE KEY `date_employee` (`date`, `employee_id`),
KEY `fk_attendance_employee_id` (`employee_id`),
CONSTRAINT `fk_attendance_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
);

