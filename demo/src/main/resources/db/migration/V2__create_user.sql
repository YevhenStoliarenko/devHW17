CREATE TABLE notedb.users
(
    `user_id`  int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `username` varchar(45) NOT NULL,
    `password` varchar(64) NOT NULL,
    `role`     varchar(45) NOT NULL,
    `enabled`  tinyint(4) DEFAULT NULL
);