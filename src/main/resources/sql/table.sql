DROP TABLE IF EXISTS  answer;
DROP TABLE IF EXISTS  question;
DROP TABLE IF EXISTS  appraise;
DROP TABLE IF EXISTS  messagesend;
DROP TABLE IF EXISTS  messagerecieved;
DROP TABLE IF EXISTS  house;
DROP TABLE IF EXISTS  users;
CREATE TABLE users(
    u_id INT(250) AUTO_INCREMENT,
    u_username VARCHAR(50) NOT NULL,
    u_password VARCHAR(50) NOT NULL,
    u_email VARCHAR(50) NOT NULL,
    u_data VARCHAR(50) NOT NULL,
    PRIMARY KEY(u_id)
);
CREATE TABLE house(
    h_id INT(250) AUTO_INCREMENT,
    h_name VARCHAR(50) NOT NULL,
    h_address VARCHAR(100) NOT NULL,
    h_produce VARCHAR(200) NOT NULL,
    h_date VARCHAR(50) NOT NULL,
    h_state INT(10) NOT NULL,
    h_price DOUBLE(250,2),
    h_user_id INT(250),
    h_buyer_id INT(250),
    PRIMARY KEY (h_id),
    FOREIGN KEY(h_user_id) REFERENCES users(u_id) ON DELETE CASCADE,
    FOREIGN KEY(h_buyer_id) REFERENCES users(u_id) ON DELETE CASCADE
);

CREATE TABLE messagesend(
    ms_id INT(250) AUTO_INCREMENT,
    ms_senderid INT(250),
    ms_rid INT(250),
    ms_content VARCHAR(1000) NOT NULL,
    ms_date VARCHAR(50),
    PRIMARY KEY(ms_id),
    FOREIGN KEY(ms_senderid) REFERENCES users(u_id) ON DELETE CASCADE,
    FOREIGN KEY(ms_rid) REFERENCES users(u_id)
);
CREATE TABLE messagerecieved(
    mr_id INT(250) AUTO_INCREMENT,
    mr_sid INT(250),
    mr_recieveid INT(250),
    mr_content VARCHAR(1000) NOT NULL,
    mr_date VARCHAR(50),
    PRIMARY KEY(mr_id),
    FOREIGN KEY(mr_recieveid) REFERENCES users(u_id) ON DELETE CASCADE,
    FOREIGN KEY(mr_sid) REFERENCES users(u_id)
);
CREATE TABLE appraise(
    a_id INT(250) AUTO_INCREMENT,
    a_content VARCHAR(250) NOT NULL,
    a_userid INT(250),
    a_house INT(250),
    a_data VARCHAR(50),
    PRIMARY KEY(a_id),
    FOREIGN KEY(a_userid) REFERENCES users(u_id) ON DELETE CASCADE,
    FOREIGN KEY(a_house) REFERENCES house(h_id) ON DELETE CASCADE
);

CREATE TABLE orders(
    o_id INT(250) AUTO_INCREMENT,
    u_id INT(250),
    h_id INT(250),
    DATE VARCHAR(20),
    o_state INT(10) NOT NULL,
    h_money DOUBLE(250,2),#订单金额
    PRIMARY KEY(o_id),
    FOREIGN KEY(u_id) REFERENCES users(u_id) ON DELETE CASCADE,
    FOREIGN KEY(h_id) REFERENCES house(h_id) ON DELETE CASCADE
);

CREATE TABLE question(
    q_id INT(250) AUTO_INCREMENT,
    q_user_id INT(250),
    q_house_id INT(250),
    q_content VARCHAR(1000) NOT NULL,
    PRIMARY KEY(q_id),
    FOREIGN KEY(q_user_id) REFERENCES users(u_id) ON DELETE CASCADE,
    FOREIGN KEY(q_house_id) REFERENCES house(h_id) ON DELETE CASCADE
);
CREATE TABLE answer(
    a_id INT(250) AUTO_INCREMENT,
    a_content VARCHAR(1000) NOT NULL,
    a_question_id INT(250),
    a_house_id INT(250),
    a_user_id INT(250),
    PRIMARY KEY(a_id),
    FOREIGN KEY(a_question_id) REFERENCES question(q_id),
    FOREIGN KEY(a_house_id) REFERENCES house(h_id),
    FOREIGN KEY(a_user_id) REFERENCES users(u_id)
);
INSERT INTO users VALUES(0,'guanliyuan','123456','17603609610@163.com','2019-03-28');
INSERT INTO users VALUES(0,'micheallei','123456','17603609610@163.com','2019-03-28');
INSERT INTO users VALUES(0,'jony','123456','17603609610@163.com','2019-03-28');
INSERT INTO users VALUES(0,'lay','123456','17603609610@163.com','2019-03-28');
INSERT INTO house VALUES(0,'工大小区房1','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼111','2019-03-29',1,1000000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房2','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼115','2019-03-29',2,1010000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房3','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼116','2019-03-29',2,1000000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房4','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼117','2019-03-29',2,3000000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房5','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼118','2019-03-29',2,2000000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房6','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼119','2019-03-29',2,1980300.00,2,2);
INSERT INTO house VALUES(0,'工大小区房7','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼110','2019-03-29',2,100000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房8','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼121','2019-03-29',1,700000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房9','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼122','2019-03-29',1,23000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房10','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼112','2019-03-29',2,130000.00,2,2);
INSERT INTO house VALUES(0,'工大小区房11','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼113','2019-03-29',3,133000.00,2,3);
INSERT INTO house VALUES(0,'工大小区房12','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼114','2019-03-29',4,103000.00,2,4);
INSERT INTO house VALUES(0,'工大小区房13','哈尔滨市工业大学西苑小区','西苑小区一单元2号楼115','2019-03-29',3,1800000.00,3,2);
INSERT INTO house VALUES(0,'工大小区房14','哈尔滨市工业大学西苑小区','西苑小区一单元5号楼116','2019-03-29',4,1080000.00,3,2);
INSERT INTO house VALUES(0,'工大小区房15','哈尔滨市工业大学一校区西苑小区','西苑小区一单元2号楼123','2019-03-29',2,1008800.00,3,3);
INSERT INTO house VALUES(0,'会展中心隔壁小区的房子','哈尔滨市会展中心','这个房子可以直接观看到会展中心内部，演唱会不用买门票','2019-04-03',2,10000000.00,2,2);
INSERT INTO orders VALUES(0,3,11,'2019-03-29',1,100.00);
INSERT INTO orders VALUES(0,4,12,'2019-03-29',2,100.00);
INSERT INTO orders VALUES(0,2,13,'2019-03-29',1,100.00);
INSERT INTO orders VALUE(0,2,14,'2019-03-29',2,100.00);
