CREATE TABLE `sample` (
  `sample_id` int(11) NOT NULL AUTO_INCREMENT,
  `sample_img` blob,
  `sample_name` varchar(200) DEFAULT NULL,
  `sample_date` date DEFAULT NULL,
  PRIMARY KEY (`sample_id`)
);