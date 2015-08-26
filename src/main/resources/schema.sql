CREATE TABLE `player` (
`playerrowid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
`firstname` varchar(20) NOT NULL,
`lastname` varchar(20) NOT NULL,
`dateofbirth` DATE NOT NULL, 
`country` varchar(20) NOT NULL,
`position` varchar(20) NOT NULL,
`salary` bigint(20) NOT NULL,
-- `currency` varchar(10) NOT NULL,
`statistics_statisticsrowid` bigint(20),
PRIMARY KEY (`playerrowid`)
);


CREATE TABLE `statistics` (
`statisticsrowid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
`goals` int(5) NOT NULL,
`bookings` int(5) NOT NULL,
`playerrowid` bigint(20) NOT NULL,
PRIMARY KEY (`statisticsrowid`),
FOREIGN KEY (`playerrowid`) REFERENCES `player`(`playerrowid`)
);
-- KEY `i_fk_playerrowid` (`playerrowid`) USING BTREE,
-- KEY `i_statisticsrowid` (`statisticsrowid`) USING BTREE,
-- CONSTRAINT `fk_stats_playerrowid` FOREIGN KEY (`playerrowid`) REFERENCES `player` (`playerrowid`) ON DELETE NO ACTION ON UPDATE NO ACTION
-- )ENGINE=InnoDB  DEFAULT CHARSET=latin1;

