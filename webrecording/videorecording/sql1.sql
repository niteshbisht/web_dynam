show databases;
create schema videoservice

use videoservice;

CREATE TABLE videos (ID integer PRIMARY KEY AUTO_INCREMENT,video_name varchar(90) ,video_content LONGBLOB, date_created timestamp);
select * from videos;