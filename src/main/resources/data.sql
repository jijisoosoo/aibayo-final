# 사용자 추가
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,0,0,NULL,'2020-01-01','admin@aico.co.kr','admin','1234');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,1,0,1,'2020-01-01','hangang@hangang.go.kr','류병완','0000');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,1,0,2,'2021-01-01','kookwon@kookwon.go.kr','박서현','0000');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,1,0,3,'2021-05-01','haesung@haesung.go.kr','김미령','0000');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,1,'2022-03-02','kyh@hangang.go.kr','김영희','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,1,'2022-03-02','lsm@hangang.go.kr','이승민','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,1,'2022-03-02','pjw@hangang.go.kr','박지원','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,2,'2022-03-02','csj@kookwon.go.kr','최성준','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,2,'2022-03-02','jmk@kookwon.go.kr','정미경','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,2,'2022-03-02','hdy@kookwon.go.kr','한도연','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,3,'2022-03-02','shy@haesung.go.kr','송현우','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,3,'2022-03-02','ljs@haesung.go.kr','임지수','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,2,0,3,'2022-03-02','yjh@haesung.go.kr','윤준호','1111');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,1,'2022-03-02','kty@gmail.com','김태영','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,1,'2022-03-02','ljw@gmail.com','이지원','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,1,'2022-03-02','psj@gmail.com','박수진','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,1,'2022-03-02','cjh@gmail.com','최재현','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,1,'2022-03-02','jsy@gmail.com','정서연','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,2,'2022-03-02','hsm@gmail.com','한승민','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,2,'2022-03-02','sjw@gmail.com','송지우','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,2,'2022-03-02','ldh@gmail.com','임도훈','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,2,'2022-03-02','yjh@gmail.com','윤주현','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,2,'2022-03-02','kyj@gmail.com','강유진','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,3,'2023-03-02','hsm@gmail.com','황성민','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,3,'2023-03-02','osj@gmail.com','오수진','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,3,'2023-03-02','hsh@gmail.com','한승호','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,3,'2023-03-02','jyn@gmail.com','조유나','2222');
INSERT INTO member(reg_type, role_no, status, kinder_no, reg_date, email, name, pw) VALUES(0,3,0,3,'2023-03-02','bjw@gmail.com','백진우','2222');


#등록 유치원 추가
INSERT INTO register_kinder (kinder_open_time, kinder_close_time, kinder_reg_date, announce_status, notepad_status, meal_status, medication_status, return_home_status, attendance_status, schedule_status, pick_drop_status, life_record_status, chat_status) VALUES('09:00','16:00','2020-01-01',1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO register_kinder (kinder_open_time, kinder_close_time, kinder_reg_date, announce_status, notepad_status, meal_status, medication_status, return_home_status, attendance_status, schedule_status, pick_drop_status, life_record_status, chat_status) VALUES('10:00','18:00','2021-01-01',1, 1, 1, 1, 1, 1, 1, 1, 1, 1);


# 원생 추가
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'김민준','2017-01-05',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'이서윤','2017-01-17',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'박지우','2017-01-29',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'최하윤','2017-02-10',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'정지훈','2017-02-22',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'강민서','2017-03-06',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'조현우','2017-03-18',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'윤서영','2017-03-30',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'장우진','2017-04-11',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'홍예린','2017-04-23',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'김서연','2017-05-05',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'이준서','2017-05-17',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'박지민','2017-05-29',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'최유진','2017-06-10',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'정수민','2017-06-22',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'강예서','2017-07-04',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'조민준','2017-07-16',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'윤지호','2017-07-28',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'장민지','2017-08-09',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'홍승현','2017-08-21',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'김하율','2017-09-02',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'이지안','2017-09-14',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'박서준','2017-09-26',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'최은우','2017-10-08',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'정시우','2017-10-20',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'강하린','2017-11-01',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'조서준','2017-11-13',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'윤채원','2017-11-25',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'장하윤','2017-12-07',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'홍민준','2017-12-19',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'김다연','2018-01-04',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'이우진','2018-01-16',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'박은서','2018-01-28',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'최현우','2018-02-09',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'정다인','2018-02-21',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'강하진','2018-03-05',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'조하율','2018-03-17',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'윤유진','2018-03-29',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'장하은','2018-04-10',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'홍지안','2018-04-22',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'김서현','2018-05-04',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'이민준','2018-05-16',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'박하윤','2018-05-28',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'최지훈','2018-06-09',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'정하율','2018-06-21',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'강지우','2018-07-03',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'조다은','2018-07-15',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'윤예준','2018-07-27',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'장지민','2018-08-08',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'홍서윤','2018-08-20',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'김지우','2018-09-01',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'이예린','2018-09-13',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'박민서','2018-09-25',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'최수민','2018-10-07',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'정지우','2018-10-19',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'강다은','2018-10-31',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'조서연','2018-11-12',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'윤민준','2018-11-24',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'장예린','2018-12-06',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'홍지호','2018-12-18',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'김채원','2019-01-03',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'이지훈','2019-01-15',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'박하은','2019-01-27',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'최민준','2019-02-08',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'정서연','2019-02-20',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'강지훈','2019-03-04',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'조하은','2019-03-16',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'윤은우','2019-03-28',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'장민서','2019-04-09',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'홍유진','2019-04-21',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'김하린','2019-05-03',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'이다인','2019-05-15',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'박유진','2019-05-27',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'최하린','2019-06-08',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'정서준','2019-06-20',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'강시우','2019-07-02',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'조예린','2019-07-14',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'윤다연','2019-07-26',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'장채원','2019-08-07',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(1,'홍다인','2019-08-19',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'김하은','2019-08-31',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'이지우','2019-09-12',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'박채원','2019-09-24',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'최하율','2019-10-06',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'정현우','2019-10-18',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'강채원','2019-10-30',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'조유진','2019-11-11',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'윤하윤','2019-11-23',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'장서준','2019-12-05',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'홍지우','2019-12-17',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'김하윤','2019-12-29',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'이지훈','2019-12-31',1,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'박하린','2019-12-02',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'최지안','2019-11-15',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'정은서','2019-10-28',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'강서윤','2019-10-11',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'조민서','2019-09-25',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'윤하린','2019-08-14',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'장다연','2019-07-29',2,'2024-03-04','0');
INSERT INTO kid(kinder_no, kid_name, kid_birth, kid_gender, admission_date, discharge_flag) VALUES(2,'홍지민','2019-06-12',2,'2024-03-04','0');


# 반 추가
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'해님반','5세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'달님반','6세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'별님반','7세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'무지개반','5세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'바다반','6세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'하늘반','7세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'숲속반','5세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'꽃님반','6세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'나비반','7세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(1,'구름반','5세반','2020-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'햇살반','5세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'바람반','6세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'샛별반','7세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'파랑새반','5세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'풀잎반','6세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'아기새반','7세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'은하수반','5세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'반디반','6세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'도토리반','7세반','2021-01-01','0');
INSERT INTO class(kinder_no, class_name, class_age, class_reg_date, class_delete_flag) VALUES(2,'민들레반','5세반','2021-01-01','0');


#원생_반 추가
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(3,1,1);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(3,2,2);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(3,3,3);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(3,4,4);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(3,5,5);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(6,6,6);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(6,7,7);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(6,8,8);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(6,9,9);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(6,10,10);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(9,11,11);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(9,12,12);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(9,13,13);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(9,14,14);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(9,15,15);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(13,16,16);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(13,17,17);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(13,18,18);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(13,19,19);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(13,20,20);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(16,21,21);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(16,22,22);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(16,23,23);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(16,24,24);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(16,25,25);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(19,26,26);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(19,27,27);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(19,28,28);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(19,29,29);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(19,30,30);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(2,31,31);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(2,32,32);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(2,33,33);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(2,34,34);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(2,35,35);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(5,36,36);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(5,37,37);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(5,38,38);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(5,39,39);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(5,40,40);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(8,41,41);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(8,42,42);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(8,43,43);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(8,44,44);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(8,45,45);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(12,46,46);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(12,47,47);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(12,48,48);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(12,49,49);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(12,50,50);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(15,51,51);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(15,52,52);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(15,53,53);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(15,54,54);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(15,55,55);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(18,56,56);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(18,57,57);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(18,58,58);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(18,59,59);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(18,60,60);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(1,61,61);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(1,62,62);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(1,63,63);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(1,64,64);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(1,65,65);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(4,66,66);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(4,67,67);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(4,68,68);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(4,69,69);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(4,70,70);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(7,71,71);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(7,72,72);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(7,73,73);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(7,74,74);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(7,75,75);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(10,76,76);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(10,77,77);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(10,78,78);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(10,79,79);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(10,80,80);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(11,81,81);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(11,82,82);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(11,83,83);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(11,84,84);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(11,85,85);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(14,86,86);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(14,87,87);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(14,88,88);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(14,89,89);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(14,90,90);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(17,91,91);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(17,92,92);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(17,93,93);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(17,94,94);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(17,95,95);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(20,96,96);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(20,97,97);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(20,98,98);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(20,99,99);
INSERT INTO class_kid(class_no, kid_no, accept_no) VALUES(20,100,100);


# 부모_원생 추가
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(42,14,1,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(43,15,2,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(44,16,3,1,'father');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(45,17,4,1,'father');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(46,17,5,1,'father');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(47,18,6,1,'father');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(48,19,7,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(49,19,8,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(50,20,9,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(51,21,10,1,'father');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(52,22,11,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(53,22,12,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(54,23,13,1,'father');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(55,24,14,1,'mother');
INSERT INTO parent_kid (accept_no, id, kid_no, is_main_parent, parent_relationship) VALUES(56,25,15,1,'father');


# 승인이력 추가
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2022-03-02 06:00:00','2022-03-02');

INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(3,1,'2022-03-02 06:00:00','2022-03-02');

INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(1,1,'2022-03-02 06:00:00','2022-03-02');

INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2023-03-02 06:00:00','2023-03-02');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');
INSERT INTO accept_log(accept_type, accept_status, accept_date, accept_reg_date) VALUES(0,1,'2024-03-04 06:00:00','2024-03-04');


# 게시글 추가
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','김민준의 알림장','<p>김민준 원생의<b>건강검진</b>이 7월 25일에 예정되어 있습니다.</p>','2024-06-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','해님반 알림장','<p>해님반 부모님들, 내일은 야외 활동이 예정되어 있으니 아이들이 모자와 물을 챙길 수 있도록 부탁드립니다.</p>','2024-06-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','강예서의 알림장','<p>강예서 원생의<b>건강검진</b>이 7월 25일에 예정되어 있습니다.</p>','2024-06-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','햇살반 알림장','<p>햇살반 친구들이 오늘 노래 부르기 시간에 열심히 참여했습니다. 우리 아이들의 노래를 들어주세요.</p>','2024-06-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','이서윤의 알림장','<p>이서윤 원생이 오늘 <b>미술 수업</b>에서 우수한 성과를 보였습니다.</p>','2024-06-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','해님반 알림장','<p>해님반 친구들이 오늘 미술 수업에서 아름다운 그림을 완성했습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','조민준의 알림장','<p>조민준 원생이 오늘 <b>미술 수업</b>에서 우수한 성과를 보였습니다.</p>','2024-06-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','햇살반 알림장','<p>햇살반 친구들이 오늘 공작 시간에 창의적인 작품을 만들었습니다. 집에서도 창의적인 활동을 격려해주세요.</p>','2024-06-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','박지우의 알림장','<p>박지우 원생이 오늘 <b>독서 활동</b>에서 활발히 참여했습니다.</p>','2024-06-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','해님반 알림장','<p>해님반 아이들이 오늘 체육 수업에서 에너지 넘치는 활동을 했습니다. 집에서도 활발하게 놀아주세요!</p>','2024-06-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','윤지호의 알림장','<p>윤지호 원생이 오늘 <b>독서 활동</b>에서 활발히 참여했습니다.</p>','2024-06-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','햇살반 알림장','<p>햇살반 친구들이 오늘 그림 그리기 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','최하윤의 알림장','<p>최하윤 원생의<b>생일 파티</b>가 8월 3일에 있습니다.</p>','2024-06-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','해님반 알림장','<p>해님반 의 생일 파티가 다음 주 월요일에 있습니다. 생일을 맞은 친구들을 축하해 주세요.</p>','2024-06-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','장민지의 알림장','<p>장민지 원생의<b>생일 파티</b>가 8월 3일에 있습니다.</p>','2024-06-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','햇살반 알림장','<p>햇살반 친구들이 오늘 운동회에서 뛰어난 실력을 발휘했습니다. 집에서도 활발한 운동을 권장해주세요.</p>','2024-06-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','정지훈의 알림장','<p>정지훈 원생이<b>점심시간</b>에 식사를 잘 하지 않았습니다.</p>','2024-06-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','해님반 알림장','<p>해님반 친구들이 과학 실험 시간에 큰 관심을 보였습니다. 호기심 많은 우리 친구들을 칭찬해 주세요.</p>','2024-06-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','홍승현의 알림장','<p>홍승현 원생이<b>점심시간</b>에 식사를 잘 하지 않았습니다.</p>','2024-06-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','햇살반 알림장','<p>햇살반 친구들이 오늘 도서관 시간에 책을 많이 읽었습니다. 책 읽는 습관을 길러주세요.</p>','2024-06-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','강민서의 알림장','<p>강민서 원생이 오늘 <b>체육 수업</b>에서 뛰어난 활약을 보였습니다.</p>','2024-06-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','달님반 알림장','<p>달님반 아이들이 오늘 음악 수업에서 즐겁게 노래를 불렀습니다. 집에서도 함께 노래 불러보세요!</p>','2024-06-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','김하율의 알림장','<p>김하율 원생이 오늘 <b>체육 수업</b>에서 뛰어난 활약을 보였습니다.</p>','2024-06-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','바람반 알림장','<p>바람반 친구들이 오늘 청소 시간에 자발적으로 참여했습니다. 집에서도 스스로 청소하는 습관을 길러주세요.</p>','2024-06-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','조현우의 알림장','<p>조현우 원생이<b>과학 실험</b> 시간에 큰 관심을 보였습니다.</p>','2024-06-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','달님반 알림장','<p>달님반 친구들이 오늘 영어 수업에서 새로운 단어를 많이 배웠습니다. 복습을 도와주세요.</p>','2024-06-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','이지안의 알림장','<p>이지안 원생이<b>과학 실험</b> 시간에 큰 관심을 보였습니다.</p>','2024-06-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','바람반 알림장','<p>바람반 친구들이 오늘 미술 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','윤서영의 알림장','<p>윤서영 원생이<b>음악 수업</b>에서 노래를 잘 불렀습니다.</p>','2024-06-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','달님반 알림장','<p>달님반 친구들이 오늘 책 읽기 시간에 많은 책을 읽었습니다. 집에서도 독서 시간을 가져주세요.</p>','2024-06-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','박서준의 알림장','<p>박서준 원생이<b>음악 수업</b>에서 노래를 잘 불렀습니다.</p>','2024-06-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','바람반 알림장','<p>바람반 친구들이 오늘 체험 학습에서 즐거운 시간을 보냈습니다. 오늘의 경험을 함께 나눠보세요.</p>','2024-06-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','장우진의 알림장','<p>장우진 원생이<b>영어 수업</b>에서 새로운 단어를 잘 배웠습니다.</p>','2024-06-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','달님반 알림장','<p>달님반 친구들이 오늘 노래 부르기 시간에 열심히 참여했습니다. 우리 아이들의 노래를 들어주세요.</p>','2024-06-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','최은우의 알림장','<p>최은우 원생이<b>영어 수업</b>에서 새로운 단어를 잘 배웠습니다.</p>','2024-06-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','바람반 알림장','<p>바람반 친구들이 오늘 자유 놀이 시간에 새로운 친구를 사귀었습니다. 사회성 발달을 칭찬해주세요.</p>','2024-06-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','홍예린의 알림장','<p>홍예린 원생이 오늘 <b>미술 시간</b>에 멋진 그림을 그렸습니다.</p>','2024-06-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','달님반 알림장','<p>달님반 친구들이 오늘 공작 시간에 창의적인 작품을 만들었습니다. 집에서도 창의적인 활동을 격려해주세요.</p>','2024-06-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','정시우의 알림장','<p>정시우 원생이 오늘 <b>미술 시간</b>에 멋진 그림을 그렸습니다.</p>','2024-06-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','바람반 알림장','<p>바람반 친구들이 오늘 퍼즐 놀이에서 뛰어난 성과를 보였습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','김서연의 알림장','<p>김서연 원생이<b>책 읽기</b> 활동에서 매우 적극적이었습니다.</p>','2024-06-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','별님반 알림장','<p>별님반 친구들이 오늘 그림 그리기 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','강하린의 알림장','<p>강하린 원생이<b>책 읽기</b> 활동에서 매우 적극적이었습니다.</p>','2024-06-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','샛별반 알림장','<p>샛별반 친구들이 오늘 노래 부르기 시간에 훌륭한 목소리를 보였습니다. 집에서도 함께 노래를 불러보세요.</p>','2024-06-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','이준서의 알림장','<p>이준서 원생이<b>놀이터 시간</b>에 친구들과 잘 어울렸습니다.</p>','2024-06-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','별님반 알림장','<p>별님반 친구들이 오늘 운동회에서 뛰어난 실력을 발휘했습니다. 집에서도 활발한 운동을 권장해주세요.</p>','2024-06-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','조서준의 알림장','<p>조서준 원생이<b>놀이터 시간</b>에 친구들과 잘 어울렸습니다.</p>','2024-06-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','샛별반 알림장','<p>샛별반 친구들이 내일 야외 활동이 예정되어 있습니다. 아이들이 편안한 옷을 입고 올 수 있도록 도와주세요.</p>','2024-06-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','박지민의 알림장','<p>박지민 원생이 오늘 <b>체험 학습</b>에서 즐거운 시간을 보냈습니다.</p>','2024-06-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','별님반 알림장','<p>별님반 친구들이 오늘 도서관 시간에 책을 많이 읽었습니다. 책 읽는 습관을 길러주세요.</p>','2024-06-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','윤채원의 알림장','<p>윤채원 원생이 오늘 <b>체험 학습</b>에서 즐거운 시간을 보냈습니다.</p>','2024-06-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','샛별반 알림장','<p>샛별반 친구들이 오늘 게임 활동에서 높은 집중력을 보였습니다. 집에서도 재미있는 게임을 함께 해주세요.</p>','2024-06-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','최유진의 알림장','<p>최유진 원생이<b>수학 수업</b>에서 빠르게 문제를 해결했습니다.</p>','2024-06-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','별님반 알림장','<p>별님반 친구들이 오늘 청소 시간에 자발적으로 참여했습니다. 집에서도 스스로 청소하는 습관을 길러주세요.</p>','2024-06-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','장하윤의 알림장','<p>장하윤 원생이<b>수학 수업</b>에서 빠르게 문제를 해결했습니다.</p>','2024-06-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','샛별반 알림장','<p>샛별반 친구들이 오늘 미술 시간에 아름다운 그림을 완성했습니다. 집에서도 칭찬을 아끼지 말아주세요.</p>','2024-06-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','정수민의 알림장','<p>정수민 원생이<b>자유 놀이</b> 시간에 새로운 친구를 사귀었습니다.</p>','2024-06-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','별님반 알림장','<p>별님반 친구들이 오늘 미술 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','홍민준의 알림장','<p>홍민준 원생이<b>자유 놀이</b> 시간에 새로운 친구를 사귀었습니다.</p>','2024-06-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','샛별반 알림장','<p>샛별반 친구들이 오늘 체육 시간에 에너지를 발산했습니다. 집에서도 함께 운동을 해주세요.</p>','2024-06-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','김다연의 알림장','<p>김다연 원생이<b>공작 시간</b>에 창의적인 작품을 만들었습니다.</p>','2024-06-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','무지개반 알림장','<p>무지개반 친구들이 오늘 체험 학습에서 즐거운 시간을 보냈습니다. 오늘의 경험을 함께 나눠보세요.</p>','2024-06-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','강지우의 알림장','<p>강지우 원생이<b>공작 시간</b>에 창의적인 작품을 만들었습니다.</p>','2024-06-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','파랑새반 알림장','<p>파랑새반의 생일 파티가 다가오고 있습니다. 생일을 맞은 친구들을 축하해 주세요.</p>','2024-06-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','이우진의 알림장','<p>이우진 원생이<b>퍼즐 놀이</b>에서 높은 집중력을 보였습니다.</p>','2024-06-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','무지개반 알림장','<p>무지개반 친구들이 오늘 자유 놀이 시간에 새로운 친구를 사귀었습니다. 사회성 발달을 칭찬해주세요.</p>','2024-06-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','조다은의 알림장','<p>조다은 원생이<b>퍼즐 놀이</b>에서 높은 집중력을 보였습니다.</p>','2024-06-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','파랑새반 알림장','<p>파랑새반 친구들이 오늘 과학 실험에서 새로운 지식을 얻었습니다. 집에서도 호기심을 키워주세요.</p>','2024-06-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','박은서의 알림장','<p>박은서 원생이<b>그림 그리기</b>에서 훌륭한 작품을 완성했습니다.</p>','2024-06-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','무지개반 알림장','<p>무지개반 친구들이 오늘 게임 활동에서 높은 집중력을 보였습니다. 집에서도 재미있는 게임을 함께 해주세요.</p>','2024-06-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','윤예준의 알림장','<p>윤예준 원생이<b>그림 그리기</b>에서 훌륭한 작품을 완성했습니다.</p>','2024-06-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','파랑새반 알림장','<p>파랑새반 친구들이 오늘 음악 시간에 즐겁게 노래를 불렀습니다. 함께 노래를 불러보세요!</p>','2024-06-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','최현우의 알림장','<p>최현우 원생이<b>운동회</b>에서 뛰어난 실력을 발휘했습니다.</p>','2024-06-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','무지개반 알림장','<p>무지개반 친구들이 오늘 퍼즐 놀이에서 뛰어난 성과를 보였습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','장지민의 알림장','<p>장지민 원생이<b>운동회</b>에서 뛰어난 실력을 발휘했습니다.</p>','2024-06-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','파랑새반 알림장','<p>파랑새반 친구들이 오늘 영어 수업에서 많은 단어를 배웠습니다. 집에서도 복습을 도와주세요.</p>','2024-06-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','정다인의 알림장','<p>정다인 원생이<b>도서관 시간</b>에 책을 많이 읽었습니다.</p>','2024-06-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','무지개반 알림장','<p>무지개반 친구들이 오늘 노래 부르기 시간에 훌륭한 목소리를 보였습니다. 집에서도 함께 노래를 불러보세요.</p>','2024-06-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','홍서윤의 알림장','<p>홍서윤 원생이<b>도서관 시간</b>에 책을 많이 읽었습니다.</p>','2024-06-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','파랑새반 알림장','<p>파랑새반 친구들이 오늘 책 읽기 시간에 많은 책을 읽었습니다. 책 읽는 시간을 가져주세요.</p>','2024-06-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','강하진의 알림장','<p>강하진 원생이<b>청소 시간</b>에 자발적으로 참여했습니다.</p>','2024-06-21');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','바다반 알림장','<p>바다반 친구들이 내일 야외 활동이 예정되어 있습니다. 아이들이 편안한 옷을 입고 올 수 있도록 도와주세요.</p>','2024-06-21');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','김지우의 알림장','<p>김지우 원생이<b>청소 시간</b>에 자발적으로 참여했습니다.</p>','2024-06-21');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','풀잎반 알림장','<p>풀잎반 친구들이 오늘 노래 부르기 시간에 열심히 참여했습니다. 우리 아이들의 노래를 들어주세요.</p>','2024-06-21');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','조하율의 알림장','<p>조하율 원생이<b>노래 부르기</b> 시간에 열심히 참여했습니다.</p>','2024-06-22');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','바다반 알림장','<p>바다반 친구들이 오늘 미술 시간에 아름다운 그림을 완성했습니다. 집에서도 칭찬을 아끼지 말아주세요.</p>','2024-06-22');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','이예린의 알림장','<p>이예린 원생이<b>노래 부르기</b> 시간에 열심히 참여했습니다.</p>','2024-06-22');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','풀잎반 알림장','<p>풀잎반 친구들이 오늘 공작 시간에 창의적인 작품을 만들었습니다. 집에서도 창의적인 활동을 격려해주세요.</p>','2024-06-22');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','윤유진의 알림장','<p>윤유진 원생이<b>음악 시간</b>에 새로운 악기를 배웠습니다.</p>','2024-06-23');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','바다반 알림장','<p>바다반 친구들이 오늘 체육 시간에 에너지를 발산했습니다. 집에서도 함께 운동을 해주세요.</p>','2024-06-23');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','박민서의 알림장','<p>박민서 원생이<b>음악 시간</b>에 새로운 악기를 배웠습니다.</p>','2024-06-23');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','풀잎반 알림장','<p>풀잎반 친구들이 오늘 그림 그리기 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-23');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','장하은의 알림장','<p>장하은 원생이<b>실험 활동</b>에서 훌륭한 결과를 얻었습니다.</p>','2024-06-24');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','바다반 알림장','<p>바다반의 생일 파티가 다가오고 있습니다. 생일을 맞은 친구들을 축하해 주세요.</p>','2024-06-24');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','최수민의 알림장','<p>최수민 원생이<b>실험 활동</b>에서 훌륭한 결과를 얻었습니다.</p>','2024-06-24');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','풀잎반 알림장','<p>풀잎반 친구들이 오늘 운동회에서 뛰어난 실력을 발휘했습니다. 집에서도 활발한 운동을 권장해주세요.</p>','2024-06-24');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','홍지안의 알림장','<p>홍지안 원생이<b>놀이 시간</b>에 친구들과 잘 놀았습니다.</p>','2024-06-25');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','바다반 알림장','<p>바다반 친구들이 오늘 과학 실험에서 새로운 지식을 얻었습니다. 집에서도 호기심을 키워주세요.</p>','2024-06-25');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','정지우의 알림장','<p>정지우 원생이<b>놀이 시간</b>에 친구들과 잘 놀았습니다.</p>','2024-06-25');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','풀잎반 알림장','<p>풀잎반 친구들이 오늘 도서관 시간에 책을 많이 읽었습니다. 책 읽는 습관을 길러주세요.</p>','2024-06-25');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','김서현의 알림장','<p>김서현 원생이<b>게임 활동</b>에서 높은 집중력을 보였습니다.</p>','2024-06-26');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','하늘반 알림장','<p>하늘반 친구들이 오늘 음악 시간에 즐겁게 노래를 불렀습니다. 함께 노래를 불러보세요!</p>','2024-06-26');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','강다은의 알림장','<p>강다은 원생이<b>게임 활동</b>에서 높은 집중력을 보였습니다.</p>','2024-06-26');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','아기새반 알림장','<p>아기새반 친구들이 오늘 청소 시간에 자발적으로 참여했습니다. 집에서도 스스로 청소하는 습관을 길러주세요.</p>','2024-06-26');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','이민준의 알림장','<p>이민준 원생이<b>그림 그리기</b>에서 훌륭한 작품을 완성했습니다.</p>','2024-06-27');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','하늘반 알림장','<p>하늘반 친구들이 오늘 영어 수업에서 많은 단어를 배웠습니다. 집에서도 복습을 도와주세요.</p>','2024-06-27');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','조서연의 알림장','<p>조서연 원생이<b>그림 그리기</b>에서 훌륭한 작품을 완성했습니다.</p>','2024-06-27');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','아기새반 알림장','<p>아기새반 친구들이 오늘 청소 시간에 자발적으로 참여했습니다. 집에서도 스스로 청소하는 습관을 길러주세요.</p>','2024-06-27');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','박하윤의 알림장','<p>박하윤 원생이<b>책 읽기</b> 시간에 많은 책을 읽었습니다.</p>','2024-06-28');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','하늘반 알림장','<p>하늘반 친구들이 오늘 책 읽기 시간에 많은 책을 읽었습니다. 책 읽는 시간을 가져주세요.</p>','2024-06-28');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','윤민준의 알림장','<p>윤민준 원생이<b>책 읽기</b> 시간에 많은 책을 읽었습니다.</p>','2024-06-28');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','아기새반 알림장','<p>아기새반 친구들이 오늘 미술 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-06-28');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','최지훈의 알림장','<p>최지훈 원생이<b>노래 부르기</b> 시간에 훌륭한 목소리를 보였습니다.</p>','2024-06-29');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','하늘반 알림장','<p>하늘반 친구들이 오늘 노래 부르기 시간에 열심히 참여했습니다. 우리 아이들의 노래를 들어주세요.</p>','2024-06-29');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','장예린의 알림장','<p>장예린 원생이<b>노래 부르기</b> 시간에 훌륭한 목소리를 보였습니다.</p>','2024-06-29');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','아기새반 알림장','<p>아기새반 친구들이 오늘 체험 학습에서 즐거운 시간을 보냈습니다. 오늘의 경험을 함께 나눠보세요.</p>','2024-06-29');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','정하율의 알림장','<p>정하율 원생이<b>체육 시간</b>에 뛰어난 실력을 보였습니다.</p>','2024-06-30');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','하늘반 알림장','<p>하늘반 친구들이 오늘 게임 활동에서 높은 집중력을 보였습니다. 집에서도 재미있는 게임을 함께 해주세요.</p>','2024-06-30');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','홍지호의 알림장','<p>홍지호 원생이<b>체육 시간</b>에 뛰어난 실력을 보였습니다.</p>','2024-06-30');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','아기새반 알림장','<p>아기새반 친구들이 오늘 자유 놀이 시간에 새로운 친구를 사귀었습니다. 사회성 발달을 칭찬해주세요.</p>','2024-06-30');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','김채원의 알림장','<p>김채원 원생이<b>미술 시간</b>에 멋진 그림을 그렸습니다.</p>','2024-07-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','숲속반 알림장','<p>숲속반 친구들이 오늘 공작 시간에 창의적인 작품을 만들었습니다. 집에서도 창의적인 활동을 격려해주세요.</p>','2024-07-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','김하은의 알림장','<p>김하은 원생이<b>미술 시간</b>에 멋진 그림을 그렸습니다.</p>','2024-07-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','은하수반 알림장','<p>은하수반 친구들이 오늘 퍼즐 놀이에서 뛰어난 성과를 보였습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-01');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','이지훈의 알림장','<p>이지훈 원생이<b>독서 시간</b>에 많은 책을 읽었습니다.</p>','2024-07-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','숲속반 알림장','<p>숲속반 친구들이 오늘 그림 그리기 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','이지우의 알림장','<p>이지우 원생이<b>독서 시간</b>에 많은 책을 읽었습니다.</p>','2024-07-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','은하수반 알림장','<p>은하수반 친구들이 오늘 노래 부르기 시간에 훌륭한 목소리를 보였습니다. 집에서도 함께 노래를 불러보세요.</p>','2024-07-02');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','박하은의 알림장','<p>박하은 원생이<b>놀이 시간</b>에 친구들과 잘 어울렸습니다.</p>','2024-07-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','숲속반 알림장','<p>숲속반 친구들이 오늘 운동회에서 뛰어난 실력을 발휘했습니다. 집에서도 활발한 운동을 권장해주세요.</p>','2024-07-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','박채원의 알림장','<p>박채원 원생이<b>놀이 시간</b>에 친구들과 잘 어울렸습니다.</p>','2024-07-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','은하수반 알림장','<p>은하수반 친구들이 내일 야외 활동이 예정되어 있습니다. 아이들이 편안한 옷을 입고 올 수 있도록 도와주세요.</p>','2024-07-03');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','최민준의 알림장','<p>최민준 원생이<b>체험 학습</b>에서 훌륭한 활동을 보였습니다.</p>','2024-07-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','숲속반 알림장','<p>숲속반 친구들이 오늘 도서관 시간에 책을 많이 읽었습니다. 책 읽는 습관을 길러주세요.</p>','2024-07-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','최하율의 알림장','<p>최하율 원생이<b>체험 학습</b>에서 훌륭한 활동을 보였습니다.</p>','2024-07-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','은하수반 알림장','<p>은하수반 친구들이 오늘 미술 시간에 아름다운 그림을 완성했습니다. 집에서도 칭찬을 아끼지 말아주세요.</p>','2024-07-04');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','정서연의 알림장','<p>정서연 원생이<b>음악 시간</b>에 노래를 잘 불렀습니다.</p>','2024-07-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','숲속반 알림장','<p>숲속반 친구들이 오늘 청소 시간에 자발적으로 참여했습니다. 집에서도 스스로 청소하는 습관을 길러주세요.</p>','2024-07-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','정현우의 알림장','<p>정현우 원생이<b>음악 시간</b>에 노래를 잘 불렀습니다.</p>','2024-07-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','은하수반 알림장','<p>은하수반 친구들이 오늘 체육 시간에 에너지를 발산했습니다. 집에서도 함께 운동을 해주세요.</p>','2024-07-05');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','강지훈의 알림장','<p>강지훈 원생이<b>실험 활동</b>에서 좋은 결과를 얻었습니다.</p>','2024-07-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','꽃님반 알림장','<p>꽃님반 친구들이 오늘 미술 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','강채원의 알림장','<p>강채원 원생이<b>실험 활동</b>에서 좋은 결과를 얻었습니다.</p>','2024-07-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','반디반 알림장','<p>반디반의 생일 파티가 다가오고 있습니다. 생일을 맞은 친구들을 축하해 주세요.</p>','2024-07-06');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','조하은의 알림장','<p>조하은 원생이<b>자유 놀이</b> 시간에 높은 집중력을 보였습니다.</p>','2024-07-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','꽃님반 알림장','<p>꽃님반 친구들이 오늘 체험 학습에서 즐거운 시간을 보냈습니다. 오늘의 경험을 함께 나눠보세요.</p>','2024-07-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','조유진의 알림장','<p>조유진 원생이<b>자유 놀이</b> 시간에 높은 집중력을 보였습니다.</p>','2024-07-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','반디반 알림장','<p>반디반 친구들이 오늘 과학 실험에서 새로운 지식을 얻었습니다. 집에서도 호기심을 키워주세요.</p>','2024-07-07');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','윤은우의 알림장','<p>윤은우 원생이<b>퍼즐 놀이</b>에서 뛰어난 성과를 보였습니다.</p>','2024-07-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','꽃님반 알림장','<p>꽃님반 친구들이 오늘 체험 학습에서 즐거운 시간을 보냈습니다. 오늘의 경험을 함께 나눠보세요.</p>','2024-07-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','윤하윤의 알림장','<p>윤하윤 원생이<b>퍼즐 놀이</b>에서 뛰어난 성과를 보였습니다.</p>','2024-07-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','반디반 알림장','<p>반디반 친구들이 오늘 음악 시간에 즐겁게 노래를 불렀습니다. 함께 노래를 불러보세요!</p>','2024-07-08');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','장민서의 알림장','<p>장민서 원생이<b>공작 시간</b>에 창의적인 작품을 만들었습니다.</p>','2024-07-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','꽃님반 알림장','<p>꽃님반 친구들이 오늘 자유 놀이 시간에 새로운 친구를 사귀었습니다. 사회성 발달을 칭찬해주세요.</p>','2024-07-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','장서준의 알림장','<p>장서준 원생이<b>공작 시간</b>에 창의적인 작품을 만들었습니다.</p>','2024-07-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','반디반 알림장','<p>반디반 친구들이 오늘 영어 수업에서 많은 단어를 배웠습니다. 집에서도 복습을 도와주세요.</p>','2024-07-09');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','홍유진의 알림장','<p>홍유진 원생이<b>책 읽기</b> 시간에 적극적으로 참여했습니다.</p>','2024-07-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','꽃님반 알림장','<p>꽃님반 친구들이 오늘 퍼즐 놀이에서 뛰어난 성과를 보였습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','홍지우의 알림장','<p>홍지우 원생이<b>책 읽기</b> 시간에 적극적으로 참여했습니다.</p>','2024-07-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','반디반 알림장','<p>반디반 친구들이 오늘 책 읽기 시간에 많은 책을 읽었습니다. 책 읽는 시간을 가져주세요.</p>','2024-07-10');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','김하린의 알림장','<p>김하린 원생이<b>음악 시간</b>에 새로운 악기를 배웠습니다.</p>','2024-07-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','나비반 알림장','<p>나비반 친구들이 오늘 노래 부르기 시간에 훌륭한 목소리를 보였습니다. 집에서도 함께 노래를 불러보세요.</p>','2024-07-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','김하윤의 알림장','<p>김하윤 원생이<b>음악 시간</b>에 새로운 악기를 배웠습니다.</p>','2024-07-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','도토리반 알림장','<p>도토리반 친구들이 오늘 노래 부르기 시간에 열심히 참여했습니다. 우리 아이들의 노래를 들어주세요.</p>','2024-07-11');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','이다인의 알림장','<p>이다인 원생이<b>운동회</b>에서 뛰어난 실력을 발휘했습니다.</p>','2024-07-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','나비반 알림장','<p>나비반 친구들이 내일 야외 활동이 예정되어 있습니다. 아이들이 편안한 옷을 입고 올 수 있도록 도와주세요.</p>','2024-07-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','이지훈의 알림장','<p>이지훈 원생이<b>운동회</b>에서 뛰어난 실력을 발휘했습니다.</p>','2024-07-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','도토리반 알림장','<p>도토리반 친구들이 오늘 공작 시간에 창의적인 작품을 만들었습니다. 집에서도 창의적인 활동을 격려해주세요.</p>','2024-07-12');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','박유진의 알림장','<p>박유진 원생이<b>청소 시간</b>에 자발적으로 참여했습니다.</p>','2024-07-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','나비반 알림장','<p>나비반 친구들이 오늘 게임 활동에서 높은 집중력을 보였습니다. 집에서도 재미있는 게임을 함께 해주세요.</p>','2024-07-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','박하린의 알림장','<p>박하린 원생이<b>청소 시간</b>에 자발적으로 참여했습니다.</p>','2024-07-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','도토리반 알림장','<p>도토리반 친구들이 오늘 그림 그리기 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-13');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','최하린의 알림장','<p>최하린 원생이<b>그림 그리기</b>에서 훌륭한 작품을 완성했습니다.</p>','2024-07-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','나비반 알림장','<p>나비반 친구들이 오늘 미술 시간에 아름다운 그림을 완성했습니다. 집에서도 칭찬을 아끼지 말아주세요.</p>','2024-07-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','최지안의 알림장','<p>최지안 원생이<b>그림 그리기</b>에서 훌륭한 작품을 완성했습니다.</p>','2024-07-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','도토리반 알림장','<p>도토리반 친구들이 오늘 운동회에서 뛰어난 실력을 발휘했습니다. 집에서도 활발한 운동을 권장해주세요.</p>','2024-07-14');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','정서준의 알림장','<p>정서준 원생이<b>놀이 시간</b>에 친구들과 잘 놀았습니다.</p>','2024-07-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','나비반 알림장','<p>나비반 친구들이 오늘 체육 시간에 에너지를 발산했습니다. 집에서도 함께 운동을 해주세요.</p>','2024-07-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','정은서의 알림장','<p>정은서 원생이<b>놀이 시간</b>에 친구들과 잘 놀았습니다.</p>','2024-07-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','도토리반 알림장','<p>도토리반 친구들이 오늘 도서관 시간에 책을 많이 읽었습니다. 책 읽는 습관을 길러주세요.</p>','2024-07-15');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','강시우의 알림장','<p>강시우 원생이<b>독서 시간</b>에 많은 책을 읽었습니다.</p>','2024-07-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','구름반 알림장','<p>구름반의 생일 파티가 다가오고 있습니다. 생일을 맞은 친구들을 축하해 주세요.</p>','2024-07-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','강서윤의 알림장','<p>강서윤 원생이<b>독서 시간</b>에 많은 책을 읽었습니다.</p>','2024-07-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','민들레반 알림장','<p>민들레반 친구들이 오늘 청소 시간에 자발적으로 참여했습니다. 집에서도 스스로 청소하는 습관을 길러주세요.</p>','2024-07-16');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','조예린의 알림장','<p>조예린 원생이<b>미술 시간</b>에 멋진 그림을 그렸습니다.</p>','2024-07-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','구름반 알림장','<p>구름반 친구들이 오늘 과학 실험에서 새로운 지식을 얻었습니다. 집에서도 호기심을 키워주세요.</p>','2024-07-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','조민서의 알림장','<p>조민서 원생이<b>미술 시간</b>에 멋진 그림을 그렸습니다.</p>','2024-07-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','민들레반 알림장','<p>민들레반 친구들이 오늘 미술 시간에 멋진 그림을 그렸습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-17');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','윤다연의 알림장','<p>윤다연 원생이<b>체험 학습</b>에서 즐거운 시간을 보냈습니다.</p>','2024-07-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','구름반 알림장','<p>구름반 친구들이 오늘 음악 시간에 즐겁게 노래를 불렀습니다. 함께 노래를 불러보세요!</p>','2024-07-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','윤하린의 알림장','<p>윤하린 원생이<b>체험 학습</b>에서 즐거운 시간을 보냈습니다.</p>','2024-07-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','민들레반 알림장','<p>민들레반 친구들이 오늘 체험 학습에서 즐거운 시간을 보냈습니다. 오늘의 경험을 함께 나눠보세요.</p>','2024-07-18');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','장채원의 알림장','<p>장채원 원생이<b>게임 활동</b>에서 높은 집중력을 보였습니다.</p>','2024-07-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','구름반 알림장','<p>구름반 친구들이 오늘 영어 수업에서 많은 단어를 배웠습니다. 집에서도 복습을 도와주세요.</p>','2024-07-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','장다연의 알림장','<p>장다연 원생이<b>게임 활동</b>에서 높은 집중력을 보였습니다.</p>','2024-07-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','민들레반 알림장','<p>민들레반 친구들이 오늘 자유 놀이 시간에 새로운 친구를 사귀었습니다. 사회성 발달을 칭찬해주세요.</p>','2024-07-19');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','홍다인의 알림장','<p>홍다인 원생이<b>음악 시간</b>에 노래를 잘 불렀습니다.</p>','2024-07-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'2','구름반 알림장','<p>구름반 친구들이 오늘 책 읽기 시간에 많은 책을 읽었습니다. 책 읽는 시간을 가져주세요.</p>','2024-07-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','홍지민의 알림장','<p>홍지민 원생이<b>음악 시간</b>에 노래를 잘 불렀습니다.</p>','2024-07-20');
INSERT INTO board (invisible_flag, board_type, writer, board_title, board_contents, board_reg_date) VALUES(0,0,'3','민들레반 알림장','<p>민들레반 친구들이 오늘 퍼즐 놀이에서 뛰어난 성과를 보였습니다. 많은 칭찬 부탁드립니다!</p>','2024-07-20');


# 알림장 추가
INSERT INTO notepad(board_no, has_life_record) VALUES(1,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(2,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(3,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(4,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(5,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(6,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(7,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(8,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(9,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(10,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(11,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(12,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(13,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(14,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(15,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(16,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(17,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(18,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(19,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(20,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(21,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(22,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(23,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(24,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(25,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(26,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(27,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(28,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(29,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(30,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(31,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(32,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(33,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(34,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(35,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(36,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(37,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(38,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(39,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(40,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(41,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(42,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(43,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(44,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(45,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(46,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(47,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(48,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(49,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(50,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(51,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(52,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(53,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(54,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(55,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(56,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(57,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(58,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(59,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(60,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(61,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(62,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(63,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(64,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(65,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(66,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(67,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(68,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(69,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(70,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(71,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(72,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(73,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(74,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(75,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(76,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(77,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(78,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(79,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(80,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(81,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(82,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(83,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(84,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(85,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(86,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(87,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(88,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(89,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(90,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(91,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(92,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(93,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(94,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(95,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(96,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(97,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(98,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(99,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(100,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(101,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(102,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(103,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(104,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(105,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(106,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(107,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(108,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(109,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(110,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(111,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(112,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(113,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(114,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(115,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(116,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(117,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(118,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(119,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(120,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(121,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(122,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(123,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(124,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(125,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(126,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(127,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(128,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(129,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(130,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(131,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(132,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(133,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(134,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(135,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(136,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(137,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(138,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(139,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(140,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(141,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(142,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(143,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(144,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(145,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(146,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(147,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(148,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(149,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(150,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(151,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(152,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(153,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(154,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(155,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(156,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(157,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(158,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(159,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(160,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(161,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(162,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(163,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(164,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(165,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(166,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(167,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(168,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(169,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(170,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(171,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(172,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(173,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(174,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(175,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(176,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(177,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(178,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(179,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(180,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(181,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(182,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(183,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(184,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(185,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(186,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(187,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(188,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(189,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(190,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(191,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(192,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(193,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(194,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(195,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(196,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(197,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(198,'0');
INSERT INTO notepad(board_no, has_life_record) VALUES(199,'1');
INSERT INTO notepad(board_no, has_life_record) VALUES(200,'0');


# 생활기록 추가
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(1,2,2,2,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(3,4,4,4,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(5,1,2,2,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(7,3,4,4,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(9,5,2,2,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(11,2,4,4,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(13,4,2,2,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(15,1,4,4,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(17,3,2,2,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(19,5,4,4,2,5,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(21,2,2,2,1,2,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(23,4,4,4,3,4,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(25,1,2,2,2,1,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(27,3,4,4,1,3,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(29,5,2,2,3,5,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(31,2,4,4,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(33,4,2,2,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(35,1,4,4,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(37,3,2,2,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(39,5,4,4,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(41,2,2,2,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(43,4,4,4,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(45,1,2,2,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(47,3,4,4,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(49,5,2,2,2,5,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(51,2,4,4,1,2,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(53,4,2,2,3,4,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(55,1,4,4,2,1,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(57,3,2,2,1,3,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(59,5,4,4,3,5,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(61,2,2,2,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(63,4,4,4,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(65,1,2,2,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(67,3,4,4,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(69,5,2,2,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(71,2,4,4,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(73,4,2,2,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(75,1,4,4,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(77,3,2,2,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(79,5,4,4,2,5,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(81,2,2,2,1,2,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(83,4,4,4,3,4,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(85,1,2,2,2,1,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(87,3,4,4,1,3,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(89,5,2,2,3,5,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(91,2,4,4,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(93,4,2,2,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(95,1,4,4,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(97,3,2,2,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(99,5,4,4,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(101,2,2,2,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(103,4,4,4,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(105,1,2,2,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(107,3,4,4,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(109,5,2,2,2,5,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(111,2,4,4,1,2,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(113,4,2,2,3,4,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(115,1,4,4,2,1,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(117,3,2,2,1,3,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(119,5,4,4,3,5,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(121,2,2,2,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(123,4,4,4,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(125,1,2,2,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(127,3,4,4,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(129,5,2,2,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(131,2,4,4,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(133,4,2,2,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(135,1,4,4,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(137,3,2,2,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(139,5,4,4,2,5,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(141,2,2,2,1,2,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(143,4,4,4,3,4,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(145,1,2,2,2,1,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(147,3,4,4,1,3,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(149,5,2,2,3,5,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(151,2,4,4,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(153,4,2,2,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(155,1,4,4,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(157,3,2,2,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(159,5,4,4,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(161,2,2,2,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(163,4,4,4,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(165,1,2,2,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(167,3,4,4,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(169,5,2,2,2,5,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(171,2,4,4,1,2,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(173,4,2,2,3,4,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(175,1,4,4,2,1,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(177,3,2,2,1,3,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(179,5,4,4,3,5,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(181,2,2,2,2,2,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(183,4,4,4,1,4,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(185,1,2,2,3,1,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(187,3,4,4,2,3,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(189,5,2,2,1,5,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(191,2,4,4,3,2,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(193,4,2,2,2,4,2);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(195,1,4,4,1,1,1);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(197,3,2,2,3,3,3);
INSERT INTO life_record(notepad_no, defecation_status, health, meal, mood, sleep_time, temperature) VALUES(199,5,4,4,2,5,2);


# 알림장_수신자 추가
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(1,null,1);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(2,1,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(3,null,51);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(4,11,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(5,null,2);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(6,1,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(7,null,52);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(8,11,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(9,null,3);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(10,1,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(11,null,53);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(12,11,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(13,null,4);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(14,1,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(15,null,54);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(16,11,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(17,null,5);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(18,1,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(19,null,55);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(20,11,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(21,null,6);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(22,2,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(23,null,56);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(24,12,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(25,null,7);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(26,2,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(27,null,57);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(28,12,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(29,null,8);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(30,2,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(31,null,58);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(32,12,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(33,null,9);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(34,2,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(35,null,59);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(36,12,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(37,null,10);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(38,2,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(39,null,60);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(40,12,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(41,null,11);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(42,3,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(43,null,61);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(44,13,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(45,null,12);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(46,3,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(47,null,62);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(48,13,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(49,null,13);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(50,3,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(51,null,63);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(52,13,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(53,null,14);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(54,3,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(55,null,64);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(56,13,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(57,null,15);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(58,3,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(59,null,65);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(60,13,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(61,null,16);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(62,4,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(63,null,66);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(64,14,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(65,null,17);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(66,4,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(67,null,67);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(68,14,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(69,null,18);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(70,4,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(71,null,68);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(72,14,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(73,null,19);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(74,4,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(75,null,69);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(76,14,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(77,null,20);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(78,4,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(79,null,70);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(80,14,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(81,null,21);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(82,5,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(83,null,71);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(84,15,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(85,null,22);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(86,5,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(87,null,72);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(88,15,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(89,null,23);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(90,5,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(91,null,73);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(92,15,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(93,null,24);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(94,5,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(95,null,74);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(96,15,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(97,null,25);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(98,5,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(99,null,75);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(100,15,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(101,null,26);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(102,6,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(103,null,76);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(104,16,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(105,null,27);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(106,6,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(107,null,77);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(108,16,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(109,null,28);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(110,6,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(111,null,78);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(112,16,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(113,null,29);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(114,6,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(115,null,79);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(116,16,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(117,null,30);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(118,6,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(119,null,80);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(120,16,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(121,null,31);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(122,7,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(123,null,81);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(124,17,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(125,null,32);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(126,7,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(127,null,82);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(128,17,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(129,null,33);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(130,7,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(131,null,83);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(132,17,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(133,null,34);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(134,7,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(135,null,84);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(136,17,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(137,null,35);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(138,7,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(139,null,85);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(140,17,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(141,null,36);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(142,8,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(143,null,86);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(144,18,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(145,null,37);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(146,8,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(147,null,87);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(148,18,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(149,null,38);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(150,8,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(151,null,88);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(152,18,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(153,null,39);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(154,8,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(155,null,89);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(156,18,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(157,null,40);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(158,8,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(159,null,90);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(160,18,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(161,null,41);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(162,9,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(163,null,91);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(164,19,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(165,null,42);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(166,9,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(167,null,92);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(168,19,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(169,null,43);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(170,9,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(171,null,93);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(172,19,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(173,null,44);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(174,9,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(175,null,94);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(176,19,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(177,null,45);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(178,9,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(179,null,95);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(180,19,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(181,null,46);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(182,10,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(183,null,96);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(184,20,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(185,null,47);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(186,10,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(187,null,97);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(188,20,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(189,null,48);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(190,10,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(191,null,98);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(192,20,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(193,null,49);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(194,10,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(195,null,99);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(196,20,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(197,null,50);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(198,10,null);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(199,null,100);
INSERT INTO notepad_receiver(notepad_no, class_no, kid_no) VALUES(200,20,null);

#-------------------------------board------------------------------------
INSERT INTO  board(
    invisible_flag,
    board_type,
    writer,
    board_title,
    board_contents,
    board_reg_date
) VALUES
      (0, 2, 5, '5월 예절교육', '2024년 5월 예절교육이 있을 예정입니다.', '2024-05-01 05:34:48'),
      (0, 2, 5, '가정의달 체험', '가정의 달을 맞아 어린이날 축하와 부모님께 감사하는 시간을 가질 예정입니다.', '2024-05-01 05:34:48'),
      (0, 2, 12, '텃밭가꾸기', '상추와 깻잎을 심는 자연체험이 있을 예정입니다.', '2024-06-01 05:38:48'),
      (0, 2, 5, '천문관 현장학습', '평창 천문관으로 과학 체험학습을 갈 예정입니다.', '2024-05-01 05:35:48'),
      (0, 2, 8, '화채만들기', '수박으로 화채를 만드는 요리실습이 있을 예정입니다.', '2024-05-01 05:35:48'),
      (0, 2, 8, '5월 생일축하', '5월에 생일을 맞는 원아들의 생일 파티가 있을 예정입니다.', '2024-05-01 05:36:48'),
      (0, 2, 12, '지진대피훈련', '유치원 전체 지진대피훈련이 있을 예정입니다.', '2024-05-01 05:37:48'),

      (0, 2, 5, '6월 예절교육', '2024년 6월 예절교육이 있을 예정입니다.', '2024-06-01 05:34:48'),
      (0, 2, 12, '텃밭수확하기', '상추와 깻잎에 물을 주고 수확하는 자연체험이 있을 예정입니다.', '2024-06-01 05:38:48'),
      (0, 2, 6, '컬러데이 패션쇼', '다양한 색상을 활용한 패션쇼를 통해 어린이들의 시각적 감각을 키웁니다.', '2024-06-01 05:39:48'),
      (0, 2, 9, '농촌 나들이', '농촌으로 고구마와 감자캐기 등 여러 다양한 체험활동을 할 예정입니다.', '2024-06-01 05:41:48'),
      (0, 2, 8, '6월 생일축하', '6월에 생일을 맞는 원아들의 생일 파티가 있을 예정입니다.', '2024-06-01 05:36:48'),
      (0, 2, 13, '운동회', '2024년 상반기 유치원 전체 운동회가 있을 예정입니다.', '2024-06-02 05:35:48'),
      (0, 2, 5, '시 낭독회', '유치원 전체 시 낭독회를 실시합니다.', '2024-06-03 05:35:48'),

      (0, 2, 5, '7월 예절교육', '2024년 7월 예절교육이 있을 예정입니다.', '2024-07-01 05:34:48'),
      (0, 2, 9, '학부모 심폐소생술 교육', '신청하신 학부모님들을 대상으로 심폐소생술 교육을 실시할 예정입니다.', '2024-07-01 05:37:48'),
      (0, 2, 8, '직업체험 지원기간', '직업체험의 날에 멘토 역할을 해주실 학부모님의 지원을 받습니다.', '2024-07-01 05:35:48'),
      (0, 2, 8, '7월 생일축하', '7월에 생일을 맞는 원아들의 생일 파티가 있을 예정입니다.', '2024-07-01 05:36:48'),
      (0, 2, 12, '화재대피훈련', '유치원 전체 화재대피훈련이 있을 예정입니다.', '2024-07-01 05:37:48'),
      (0, 2, 12, '직업체험의 날', '자원하신 학부모님들을 모시고 직업체험을 진행할 예정입니다.', '2024-07-01 05:37:48'),
      (0, 2, 13, '수영장 물놀이', '학원 수영장에서 다양한 액티비티를 비롯한 물놀이가 있을 예정입니다.', '2024-07-02 05:35:48'),

      (0, 2, 5, '8월 예절교육', '2024년 8월 예절교육이 있을 예정입니다.', '2024-08-01 05:34:48'),
      (0, 2, 12, '방울토마토 수확', '봄에 심은 방울토마토 모종에서 열매를 수확할 예정입니다.', '2024-08-01 05:38:48'),
      (0, 2, 6, '교통안전체험', '유치원 전체 교통안전체험이 있을 예정입니다.', '2024-08-01 05:39:48'),
      (0, 2, 9, '과학 현장체험학습', '서울시립과학관으로 현장체험학습 예정입니다.', '2024-08-02 05:41:48'),
      (0, 2, 8, '7월 생일축하', '8월에 생일을 맞는 원아들의 생일 파티가 있을 예정입니다.', '2024-07-01 05:36:48'),
      (0, 2, 5, '영어동요대회', '유치원 전체 영어동요대회를 실시합니다.', '2024-08-03 05:35:48'),
      (0, 2, 9, '여름 방학식', '2024년 1학기 방학식입니다.', '2024-08-21 05:37:48'),
      (0, 2, 5, '2024년 하반기 사전등록기간', '기간 내에 2024년 2학기 사전등록을 실시합니다', '2024-08-01 05:35:48');



#-------------------------------schedule------------------------------------
INSERT INTO  schedule(
    board_no,
    schedule_start_date,
    schedule_end_date
) VALUES
(201,'2024-05-01','2024-05-01'),
(202,'2024-05-03','2024-05-03'),
(203,'2024-05-07','2024-05-07'),
(204,'2024-05-14','2024-05-14'),
(205,'2024-05-17','2024-05-17'),
(206,'2024-05-21','2024-05-21'),
(207,'2024-05-23','2024-05-23'),
(208,'2024-06-03','2024-06-03'),
(209,'2024-06-05','2024-06-05'),
(210,'2024-06-12','2024-06-12'),
(211,'2024-06-17','2024-06-18'),
(212,'2024-06-21','2024-06-21'),
(213,'2024-06-24','2024-06-24'),
(214,'2024-06-29','2024-06-29'),
(215,'2024-07-03','2024-07-03'),
(216,'2024-07-05','2024-07-05'),
(217,'2024-07-22','2024-07-26'),
(218,'2024-07-10','2024-07-10'),
(219,'2024-07-16','2024-07-16'),
(220,'2024-07-24','2024-07-24'),
(221,'2024-07-29','2024-07-29'),
(222,'2024-08-01','2024-08-01'),
(223,'2024-08-06','2024-08-06'),
(224,'2024-08-08','2024-08-08'),
(225,'2024-08-14','2024-08-14'),
(226,'2024-08-15','2024-08-15'),
(227,'2024-08-20','2024-08-20'),
(228,'2024-08-26','2024-08-26'),
(229,'2024-08-01','2024-08-05');


#----------------------------board(announce)-----------------------------------
INSERT INTO board (board_type, board_reg_date, board_title, board_contents, invisible_flag, writer) VALUES
(1, '2024-01-03', '2024년 새해 인사', '새해 복 많이 받으세요! 2024년에도 잘 부탁드립니다.', 0, 2),
(1, '2024-01-07', '선생님 워크숍 안내', '2024년 1월 10일, 선생님 워크숍이 진행됩니다. 필히 참석 바랍니다.', 0, 2),
(1, '2024-01-12', '1월 교사 회의 공지', '2024년 1월 15일에 교사 회의가 있습니다. 중요한 안건이 있으니 참석해 주세요.', 0, 2),
(1, '2024-01-18', '교사 연수 프로그램 안내', '2024년 1월 20일, 교사 연수 프로그램이 진행됩니다. 자세한 내용은 공지사항을 참조하세요.', 0, 2),
(1, '2024-02-01', '2월 교사 워크숍 일정', '2024년 2월 5일 교사 워크숍이 예정되어 있습니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 2),
(1, '2024-02-10', '교사 직무 교육 안내', '2024년 2월 12일부터 2월 14일까지 교사 직무 교육이 진행됩니다.', 0, 2),
(1, '2024-02-15', '교사 연수 프로그램 안내', '2024년 2월 20일, 교사 연수 프로그램이 진행됩니다. 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-03-01', '3월 교사 회의 공지', '2024년 3월 5일 교사 회의가 있습니다. 모두 참석해 주세요.', 0, 2),
(1, '2024-03-08', '교사 업무 분장 안내', '2024년 3월 10일부터 새로 교사 업무 분장이 시작됩니다. 확인해 주세요.', 0, 2),
(1, '2024-03-15', '교사 연수 프로그램 안내', '2024년 3월 18일부터 3월 20일까지 교사 연수가 있습니다.', 0, 2),
(1, '2024-04-01', '4월 교사 워크숍 일정', '2024년 4월 5일 교사 워크숍이 진행됩니다. 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-04-10', '교사 건강 관리 팁', '교사의 건강을 위한 관리 방법과 팁을 안내드립니다.', 0, 2),
(1, '2024-04-15', '교사 직무 교육 안내', '2024년 4월 17일부터 4월 19일까지 교사 직무 교육이 진행됩니다.', 0, 2),
(1, '2024-05-01', '5월 교사 회의 공지', '2024년 5월 3일 교사 회의가 있습니다. 참석해 주세요.', 0, 2),
(1, '2024-05-10', '교사 연수 프로그램 안내', '2024년 5월 12일부터 5월 14일까지 교사 연수가 진행됩니다.', 0, 2),
(1, '2024-05-20', '교사 업무 분장 안내', '2024년 5월 22일부터 새로 교사 업무 분장이 시작됩니다.', 0, 2),
(1, '2024-06-01', '6월 교사 워크숍 안내', '2024년 6월 5일 교사 워크숍이 진행됩니다. 많은 참여 바랍니다.', 0, 2),
(1, '2024-02-18', '교사 건강 관리법', '겨울철 교사 건강 관리법에 대한 안내입니다.', 0, 3),
(1, '2024-03-05', '교사 워크숍 일정 안내', '2024년 3월 8일 교사 워크숍이 예정되어 있습니다.', 0, 3),
(1, '2024-03-12', '교사 연수 프로그램', '2024년 3월 14일부터 3월 16일까지 교사 연수가 진행됩니다.', 0, 3),
(1, '2024-04-07', '교사 회의 공지', '2024년 4월 10일 교사 회의가 있습니다. 모두 참석해 주세요.', 0, 3),
(1, '2024-05-03', '교사 직무 교육 안내', '2024년 5월 5일부터 5월 7일까지 교사 직무 교육이 진행됩니다.', 0, 3),
(1, '2024-06-20', '교사 연수 프로그램 안내', '2024년 6월 22일부터 6월 24일까지 교사 연수가 있습니다.', 0, 3),
(1, '2024-07-08', '교사 건강 관리법', '여름철 교사 건강 관리법과 예방 수칙을 안내드립니다.', 0, 3),
(1, '2024-07-15', '7월 교사 워크숍 안내', '2024년 7월 17일 교사 워크숍이 진행됩니다. 많은 참여 부탁드립니다.', 0, 3),
(1, '2024-01-14', '교사 교육 프로그램 안내', '2024년 1월 16일부터 1월 18일까지 교사 교육 프로그램이 진행됩니다.', 0, 3),
(1, '2024-02-08', '교사 직무 교육 공지', '2024년 2월 10일부터 2월 12일까지 교사 직무 교육이 있습니다.', 0, 3),
(1, '2024-03-20', '교사 복지 프로그램 안내', '2024년 3월 22일 복지 프로그램에 대해 안내드립니다.', 0, 3),
(1, '2024-01-03', '2024년 새해 인사', '새해 복 많이 받으세요! 2024년에도 잘 부탁드립니다.', 0, 3),
(1, '2024-02-05', '교사 연수 안내', '2024년 2월 7일부터 2월 9일까지 교사 연수가 진행됩니다.', 0, 3),
(1, '2024-02-20', '어린이집 교사 연수 안내', '2024년 2월 25일 어린이집 교사 연수가 진행됩니다. 교사 분들은 필히 참석해 주세요.', 0, 2),
(1, '2024-02-20', '어린이집 교사 연수 안내', '2024년 2월 25일 어린이집 교사 연수가 진행됩니다. 교사 분들은 필히 참석해 주세요.', 0, 3),
(1, '2024-01-02', '2024년 신년 맞이 행사 안내', '2024년 신년 맞이 행사에 대한 자세한 내용을 안내드립니다.', 0, 2),
(1, '2024-01-12', '2024년 1월 원생 건강검진 안내', '2024년 1월 20일 원생 건강검진이 진행됩니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 2),
(1, '2024-01-20', '겨울 방학 기간 안내', '겨울 방학 기간은 2024년 1월 15일부터 1월 19일까지입니다.', 0, 2),
(1, '2024-02-01', '2월 학사 일정 안내', '2024년 2월의 학사 일정을 안내드립니다. 세부 사항은 공지사항을 확인하세요.', 0, 2),
(1, '2024-02-15', '겨울철 실내 활동 안내', '겨울철 실내 활동 및 안전수칙에 대한 안내입니다. 참고하시기 바랍니다.', 0, 2),
(1, '2024-03-01', '2024년 봄학기 시작 알림', '2024년 3월 1일부터 봄학기가 시작됩니다. 준비물과 일정을 확인해 주세요.', 0, 2),
(1, '2024-03-15', '봄 방학 프로그램 안내', '봄 방학 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 2),
(1, '2024-04-01', '4월 어린이집 개방일 안내', '2024년 4월 5일 어린이집 개방일입니다. 부모님들의 많은 방문 부탁드립니다.', 0, 2),
(1, '2024-04-15', '여름 방학 준비사항 안내', '여름 방학에 대비하여 준비사항과 일정을 안내드립니다.', 0, 2),
(1, '2024-05-01', '5월 원생 활동 계획 안내', '5월의 원생 활동 계획과 주요 일정을 안내드립니다.', 0, 2),
(1, '2024-05-10', '2024년 5월 학부모 교육 강좌 안내', '2024년 5월 12일에 학부모 교육 강좌가 열립니다. 관심 있는 부모님들의 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-06-01', '6월 원생 건강검진 안내', '2024년 6월 5일부터 원생 건강검진이 진행됩니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 2),
(1, '2024-06-15', '여름 방학 일정 안내', '여름 방학 기간은 2024년 7월 1일부터 7월 14일까지입니다.', 0, 2),
(1, '2024-07-01', '2024년 7월 원생 안전 교육 안내', '2024년 7월 5일 원생들을 위한 안전 교육이 진행됩니다. 자세한 사항은 공지사항을 확인하세요.', 0, 2),
(1, '2024-07-10', '2024년 7월 생일 축하', '7월에 생일인 원생들을 축하합니다! 생일을 맞은 모든 아이들에게 행복을 기원합니다.', 0, 2),
(1, '2024-03-10', '3월 학부모 설명회 안내', '2024년 3월 15일에 학부모 설명회가 있습니다. 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-06-22', '2024년 여름 캠프 모집 안내', '여름 캠프는 2024년 7월 5일부터 7월 10일까지 진행됩니다. 많은 참여 바랍니다.', 0, 2),
(1, '2024-01-02', '2024년 신년 맞이 행사 안내', '2024년 신년 맞이 행사에 대한 자세한 내용을 안내드립니다.', 0, 3),
(1, '2024-01-12', '2024년 1월 원생 건강검진 안내', '2024년 1월 20일 원생 건강검진이 진행됩니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 3),
(1, '2024-01-20', '겨울 방학 기간 안내', '겨울 방학 기간은 2024년 1월 15일부터 1월 19일까지입니다.', 0, 3),
(1, '2024-02-01', '2월 학사 일정 안내', '2024년 2월의 학사 일정을 안내드립니다. 세부 사항은 공지사항을 확인하세요.', 0, 3),
(1, '2024-02-15', '겨울철 실내 활동 안내', '겨울철 실내 활동 및 안전수칙에 대한 안내입니다. 참고하시기 바랍니다.', 0, 3),
(1, '2024-03-01', '2024년 봄학기 시작 알림', '2024년 3월 1일부터 봄학기가 시작됩니다. 준비물과 일정을 확인해 주세요.', 0, 3),
(1, '2024-03-15', '봄 방학 프로그램 안내', '봄 방학 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 3),
(1, '2024-04-01', '4월 어린이집 개방일 안내', '2024년 4월 5일 어린이집 개방일입니다. 부모님들의 많은 방문 부탁드립니다.', 0, 3),
(1, '2024-04-15', '여름 방학 준비사항 안내', '여름 방학에 대비하여 준비사항과 일정을 안내드립니다.', 0, 3),
(1, '2024-05-01', '5월 원생 활동 계획 안내', '5월의 원생 활동 계획과 주요 일정을 안내드립니다.', 0, 3),
(1, '2024-05-10', '2024년 5월 학부모 교육 강좌 안내', '2024년 5월 12일에 학부모 교육 강좌가 열립니다. 관심 있는 부모님들의 많은 참여 부탁드립니다.', 0, 3),
(1, '2024-06-01', '6월 원생 건강검진 안내', '2024년 6월 5일부터 원생 건강검진이 진행됩니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 3),
(1, '2024-06-15', '여름 방학 일정 안내', '여름 방학 기간은 2024년 7월 1일부터 7월 14일까지입니다.', 0, 3),
(1, '2024-07-01', '2024년 7월 원생 안전 교육 안내', '2024년 7월 5일 원생들을 위한 안전 교육이 진행됩니다. 자세한 사항은 공지사항을 확인하세요.', 0, 3),
(1, '2024-07-10', '2024년 7월 생일 축하', '7월에 생일인 원생들을 축하합니다! 생일을 맞은 모든 아이들에게 행복을 기원합니다.', 0, 3),
(1, '2024-03-10', '3월 학부모 설명회 안내', '2024년 3월 15일에 학부모 설명회가 있습니다. 많은 참여 부탁드립니다.', 0, 3),
(1, '2024-06-22', '2024년 여름 캠프 모집 안내', '여름 캠프는 2024년 7월 5일부터 7월 10일까지 진행됩니다. 많은 참여 바랍니다.', 0, 3),
(1, '2024-01-01', '2024년 원 운영시간 변경 안내', '2024년부터 원의 운영시간이 변경됩니다. 새로운 운영시간은 오전 9시부터 오후 5시까지입니다.', 0, 2),
(1, '2024-01-10', '설 연휴 휴일 안내', '설 연휴로 인해 2024년 1월 21일부터 1월 23일까지 원이 휴원합니다. 이용에 참고해 주세요.', 0, 2),
(1, '2024-01-20', '원 내 건강 및 안전 수칙 안내', '원 내에서 지켜야 할 건강 및 안전 수칙에 대해 안내드립니다. 모든 부모님과 원생들이 준수해 주세요.', 0, 2),
(1, '2024-02-01', '겨울 방학 프로그램 안내', '2024년 겨울 방학 동안 진행될 특별 프로그램과 활동 일정입니다. 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-02-10', '2024년 봄학기 수업 일정 안내', '2024년 봄학기 수업 일정과 주요 활동 계획을 안내드립니다.', 0, 2),
(1, '2024-03-01', '원 내 외부 방문자 규칙 안내', '외부 방문자(학부모, 외부 강사 등) 방문 시 지켜야 할 규칙과 절차를 안내드립니다.', 0, 2),
(1, '2024-03-15', '봄학기 부모 면담 일정 안내', '봄학기 부모님과의 면담 일정을 안내드립니다. 면담 희망 시간은 사전에 예약해 주세요.', 0, 2),
(1, '2024-04-01', '원 내 시설 점검 및 보수 작업 안내', '2024년 4월 5일부터 4월 7일까지 원 내 시설 점검 및 보수 작업이 진행됩니다.', 0, 2),
(1, '2024-05-01', '어린이집 원장 인사말', '어린이집 원장님의 인사말과 2024년의 비전 및 목표를 공유합니다.', 0, 2),
(1, '2024-06-01', '여름 방학 계획 안내', '여름 방학 동안 진행될 특별 활동과 프로그램에 대한 안내입니다.', 0, 2),
(1, '2024-01-01', '2024년 원 운영시간 변경 안내', '2024년부터 원의 운영시간이 변경됩니다. 새로운 운영시간은 오전 9시부터 오후 5시까지입니다.', 0, 3),
(1, '2024-01-10', '설 연휴 휴일 안내', '설 연휴로 인해 2024년 1월 21일부터 1월 23일까지 원이 휴원합니다. 이용에 참고해 주세요.', 0, 3),
(1, '2024-01-20', '원 내 건강 및 안전 수칙 안내', '원 내에서 지켜야 할 건강 및 안전 수칙에 대해 안내드립니다. 모든 부모님과 원생들이 준수해 주세요.', 0, 3),
(1, '2024-02-01', '겨울 방학 프로그램 안내', '2024년 겨울 방학 동안 진행될 특별 프로그램과 활동 일정입니다. 많은 참여 부탁드립니다.', 0, 3),
(1, '2024-02-10', '2024년 봄학기 수업 일정 안내', '2024년 봄학기 수업 일정과 주요 활동 계획을 안내드립니다.', 0, 3),
(1, '2024-03-01', '원 내 외부 방문자 규칙 안내', '외부 방문자(학부모, 외부 강사 등) 방문 시 지켜야 할 규칙과 절차를 안내드립니다.', 0, 3),
(1, '2024-03-15', '봄학기 부모 면담 일정 안내', '봄학기 부모님과의 면담 일정을 안내드립니다. 면담 희망 시간은 사전에 예약해 주세요.', 0, 3),
(1, '2024-04-01', '원 내 시설 점검 및 보수 작업 안내', '2024년 4월 5일부터 4월 7일까지 원 내 시설 점검 및 보수 작업이 진행됩니다.', 0, 3),
(1, '2024-05-01', '어린이집 원장 인사말', '어린이집 원장님의 인사말과 2024년의 비전 및 목표를 공유합니다.', 0, 3),
(1, '2024-06-01', '여름 방학 계획 안내', '여름 방학 동안 진행될 특별 활동과 프로그램에 대한 안내입니다.', 0, 3),
(1, '2024-01-02', '2024년 신년 맞이 행사 안내', '2024년 신년 맞이 행사에 대한 자세한 내용을 안내드립니다.', 0, 2),
(1, '2024-01-10', '겨울 방학 기간 안내', '겨울 방학 기간은 2024년 1월 15일부터 1월 19일까지입니다.', 0, 2),
(1, '2024-01-20', '1월 학부모 설명회 안내', '2024년 1월 25일 학부모 설명회가 있습니다. 많은 참석 부탁드립니다.', 0, 2),
(1, '2024-02-10', '겨울철 실내 활동 안내', '겨울철 실내 활동 및 안전수칙에 대한 안내입니다. 참고하시기 바랍니다.', 0, 2),
(1, '2024-03-01', '2024년 봄학기 시작 알림', '2024년 3월 1일부터 봄학기가 시작됩니다. 준비물과 일정을 확인해 주세요.', 0, 2),
(1, '2024-03-10', '3월 학부모 설명회 안내', '2024년 3월 15일에 학부모 설명회가 있습니다. 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-03-15', '봄 방학 프로그램 안내', '봄 방학 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 2),
(1, '2024-04-01', '4월 어린이집 개방일 안내', '2024년 4월 5일 어린이집 개방일입니다. 부모님들의 많은 방문 부탁드립니다.', 0, 2),
(1, '2024-04-10', '원장님과의 만남 안내', '2024년 4월 12일 원장님과의 만남이 예정되어 있습니다. 참석 부탁드립니다.', 0, 2),
(1, '2024-04-15', '여름 방학 준비사항 안내', '여름 방학에 대비하여 준비사항과 일정을 안내드립니다.', 0, 2),
(1, '2024-05-01', '5월 원생 활동 계획 안내', '5월의 원생 활동 계획과 주요 일정을 안내드립니다.', 0, 2),
(1, '2024-05-10', '2024년 5월 학부모 교육 강좌 안내', '2024년 5월 12일에 학부모 교육 강좌가 열립니다. 관심 있는 부모님들의 많은 참여 부탁드립니다.', 0, 2),
(1, '2024-05-20', '여름 방학 일정 안내', '여름 방학 기간은 2024년 7월 1일부터 7월 14일까지입니다.', 0, 2),
(1, '2024-06-01', '6월 원생 건강검진 안내', '2024년 6월 5일부터 원생 건강검진이 진행됩니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 2),
(1, '2024-06-10', '6월 원생 안전 교육 안내', '2024년 6월 15일 원생들을 위한 안전 교육이 진행됩니다. 자세한 사항은 공지사항을 확인하세요.', 0, 2),
(1, '2024-06-15', '여름 방학 프로그램 안내', '여름 방학 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 2),
(1, '2024-06-22', '여름 캠프 모집 안내', '여름 캠프는 2024년 7월 5일부터 7월 10일까지 진행됩니다. 많은 참여 바랍니다.', 0, 2),
(1, '2024-07-01', '2024년 7월 원생 안전 교육 안내', '2024년 7월 5일 원생들을 위한 안전 교육이 진행됩니다. 자세한 사항은 공지사항을 확인하세요.', 0, 2),
(1, '2024-07-10', '2024년 7월 생일 축하', '7월에 생일인 원생들을 축하합니다! 생일을 맞은 모든 아이들에게 행복을 기원합니다.', 0, 2),
(1, '2024-01-25', '2024년 2월 학사 일정 안내', '2024년 2월의 학사 일정을 안내드립니다. 자세한 내용은 공지사항을 확인해 주세요.', 0, 2),
(1, '2024-02-28', '2024년 3월 행사 일정 안내', '2024년 3월의 주요 행사 일정을 공지드립니다.', 0, 2),
(1, '2024-03-25', '2024년 4월 주요 행사 안내', '2024년 4월의 주요 행사 일정과 세부 사항을 안내드립니다.', 0, 2),
(1, '2024-04-18', '2024년 5월 행사 일정 안내', '2024년 5월의 주요 행사 일정을 공지드립니다.', 0, 2),
(1, '2024-05-23', '2024년 6월 행사 일정 안내', '2024년 6월의 주요 행사 일정을 공지드립니다.', 0, 2),
(1, '2024-06-27', '2024년 7월 행사 일정 안내', '2024년 7월의 주요 행사 일정을 공지드립니다.', 0, 2),
(1, '2024-01-28', '2024년 봄학기 계획 안내', '2024년 봄학기 동안의 주요 계획과 일정입니다. 많은 관심 부탁드립니다.', 0, 2),
(1, '2024-02-25', '2024년 3월 방학 프로그램 안내', '2024년 3월 방학 기간 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 2),
(1, '2024-03-30', '2024년 4월 봄학기 시작 안내', '2024년 4월 1일부터 봄학기가 시작됩니다. 준비물과 일정을 확인해 주세요.', 0, 2),
(1, '2024-04-25', '2024년 여름 캠프 준비사항 안내', '2024년 여름 캠프에 대한 준비사항과 세부 일정을 안내드립니다.', 0, 2),
(1, '2024-05-28', '2024년 6월 여름 방학 준비 안내', '2024년 6월 여름 방학 준비 사항과 일정을 안내드립니다.', 0, 2),
(1, '2024-06-10', '2024년 6월 행사 안내', '2024년 6월의 주요 행사와 일정 안내입니다.', 0, 2),
(1, '2024-01-02', '2024년 신년 맞이 행사 안내', '2024년 신년 맞이 행사에 대한 자세한 내용을 안내드립니다.', 0, 3),
(1, '2024-01-10', '겨울 방학 기간 안내', '겨울 방학 기간은 2024년 1월 15일부터 1월 19일까지입니다.', 0, 3),
(1, '2024-01-20', '1월 학부모 설명회 안내', '2024년 1월 25일 학부모 설명회가 있습니다. 많은 참석 부탁드립니다.', 0, 3),
(1, '2024-02-10', '겨울철 실내 활동 안내', '겨울철 실내 활동 및 안전수칙에 대한 안내입니다. 참고하시기 바랍니다.', 0, 3),
(1, '2024-03-01', '2024년 봄학기 시작 알림', '2024년 3월 1일부터 봄학기가 시작됩니다. 준비물과 일정을 확인해 주세요.', 0, 3),
(1, '2024-03-10', '3월 학부모 설명회 안내', '2024년 3월 15일에 학부모 설명회가 있습니다. 많은 참여 부탁드립니다.', 0, 3),
(1, '2024-03-15', '봄 방학 프로그램 안내', '봄 방학 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 3),
(1, '2024-04-01', '4월 어린이집 개방일 안내', '2024년 4월 5일 어린이집 개방일입니다. 부모님들의 많은 방문 부탁드립니다.', 0, 3),
(1, '2024-04-10', '원장님과의 만남 안내', '2024년 4월 12일 원장님과의 만남이 예정되어 있습니다. 참석 부탁드립니다.', 0, 3),
(1, '2024-04-15', '여름 방학 준비사항 안내', '여름 방학에 대비하여 준비사항과 일정을 안내드립니다.', 0, 3),
(1, '2024-05-01', '5월 원생 활동 계획 안내', '5월의 원생 활동 계획과 주요 일정을 안내드립니다.', 0, 3),
(1, '2024-05-10', '2024년 5월 학부모 교육 강좌 안내', '2024년 5월 12일에 학부모 교육 강좌가 열립니다. 관심 있는 부모님들의 많은 참여 부탁드립니다.', 0, 3),
(1, '2024-05-20', '여름 방학 일정 안내', '여름 방학 기간은 2024년 7월 1일부터 7월 14일까지입니다.', 0, 3),
(1, '2024-06-01', '6월 원생 건강검진 안내', '2024년 6월 5일부터 원생 건강검진이 진행됩니다. 자세한 사항은 공지사항을 확인해 주세요.', 0, 3),
(1, '2024-06-10', '6월 원생 안전 교육 안내', '2024년 6월 15일 원생들을 위한 안전 교육이 진행됩니다. 자세한 사항은 공지사항을 확인하세요.', 0, 3),
(1, '2024-06-15', '여름 방학 프로그램 안내', '여름 방학 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 3),
(1, '2024-06-22', '여름 캠프 모집 안내', '여름 캠프는 2024년 7월 5일부터 7월 10일까지 진행됩니다. 많은 참여 바랍니다.', 0, 3),
(1, '2024-07-01', '2024년 7월 원생 안전 교육 안내', '2024년 7월 5일 원생들을 위한 안전 교육이 진행됩니다. 자세한 사항은 공지사항을 확인하세요.', 0, 3),
(1, '2024-07-10', '2024년 7월 생일 축하', '7월에 생일인 원생들을 축하합니다! 생일을 맞은 모든 아이들에게 행복을 기원합니다.', 0, 3),
(1, '2024-01-25', '2024년 2월 학사 일정 안내', '2024년 2월의 학사 일정을 안내드립니다. 자세한 내용은 공지사항을 확인해 주세요.', 0, 3),
(1, '2024-02-28', '2024년 3월 행사 일정 안내', '2024년 3월의 주요 행사 일정을 공지드립니다.', 0, 3),
(1, '2024-03-25', '2024년 4월 주요 행사 안내', '2024년 4월의 주요 행사 일정과 세부 사항을 안내드립니다.', 0, 3),
(1, '2024-04-18', '2024년 5월 행사 일정 안내', '2024년 5월의 주요 행사 일정을 공지드립니다.', 0, 3),
(1, '2024-05-23', '2024년 6월 행사 일정 안내', '2024년 6월의 주요 행사 일정을 공지드립니다.', 0, 3),
(1, '2024-06-27', '2024년 7월 행사 일정 안내', '2024년 7월의 주요 행사 일정을 공지드립니다.', 0, 3),
(1, '2024-01-28', '2024년 봄학기 계획 안내', '2024년 봄학기 동안의 주요 계획과 일정입니다. 많은 관심 부탁드립니다.', 0, 3),
(1, '2024-02-25', '2024년 3월 방학 프로그램 안내', '2024년 3월 방학 기간 동안 진행될 프로그램에 대한 자세한 내용입니다.', 0, 3),
(1, '2024-03-30', '2024년 4월 봄학기 시작 안내', '2024년 4월 1일부터 봄학기가 시작됩니다. 준비물과 일정을 확인해 주세요.', 0, 3),
(1, '2024-04-25', '2024년 여름 캠프 준비사항 안내', '2024년 여름 캠프에 대한 준비사항과 세부 일정을 안내드립니다.', 0, 3),
(1, '2024-05-28', '2024년 6월 여름 방학 준비 안내', '2024년 6월 여름 방학 준비 사항과 일정을 안내드립니다.', 0, 3),
(1, '2024-06-10', '2024년 6월 행사 안내', '2024년 6월의 주요 행사와 일정 안내입니다.', 0, 3),
(1, '2024-01-05', '2024년 신입 원생 교육 프로그램 안내', '2024년 신입 원생을 위한 교육 프로그램에 대해 안내드립니다.', 0, 2),
(1, '2024-01-15', '겨울철 실내 교육 활동 안내', '겨울철에 적합한 실내 교육 활동에 대해 안내드립니다.', 0, 2),
(1, '2024-01-25', '2024년 2월 교육 계획 안내', '2024년 2월의 교육 계획과 주요 활동에 대해 안내드립니다.', 0, 3),
(1, '2024-02-01', '2월 신입 원생 교육 안내', '2024년 2월 신입 원생을 위한 교육 내용과 일정입니다.', 0, 3),
(1, '2024-02-10', '어린이집 교육 자료 제공', '어린이집에서 사용할 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 2),
(1, '2024-03-01', '3월 교육 프로그램 안내', '2024년 3월의 교육 프로그램과 주요 활동 일정입니다.', 0, 2),
(1, '2024-03-10', '봄학기 교육 자료 안내', '봄학기 동안 사용할 교육 자료와 그 활용법에 대해 안내드립니다.', 0, 3),
(1, '2024-03-20', '2024년 4월 교육 계획 안내', '2024년 4월의 교육 계획과 주요 활동 일정을 안내드립니다.', 0, 3),
(1, '2024-04-05', '4월 교육 프로그램 안내', '2024년 4월 교육 프로그램과 주요 활동 일정입니다.', 0, 2),
(1, '2024-04-15', '어린이집 교육 자료 제공', '어린이집에서 사용할 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 2),
(1, '2024-04-25', '2024년 5월 교육 계획 안내', '2024년 5월의 교육 계획과 주요 활동 일정을 안내드립니다.', 0, 3),
(1, '2024-05-01', '여름 방학 교육 프로그램 안내', '2024년 여름 방학 동안 진행될 교육 프로그램에 대한 안내입니다.', 0, 3),
(1, '2024-05-10', '2024년 5월 교육 자료 제공', '2024년 5월의 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 2),
(1, '2024-05-15', '2024년 여름 방학 교육 계획', '여름 방학 동안 진행될 교육 계획과 일정 안내입니다.', 0, 2),
(1, '2024-06-01', '6월 교육 프로그램 안내', '2024년 6월의 교육 프로그램과 주요 활동 일정입니다.', 0, 3),
(1, '2024-06-10', '여름 방학 교육 자료 제공', '여름 방학 동안 사용할 교육 자료와 자료 활용법에 대해 안내드립니다.', 0, 3),
(1, '2024-06-15', '2024년 7월 교육 계획 안내', '2024년 7월의 교육 계획과 주요 활동 일정을 안내드립니다.', 0, 2),
(1, '2024-07-01', '여름 방학 교육 프로그램 안내', '2024년 여름 방학 동안 진행될 교육 프로그램에 대한 안내입니다.', 0, 2),
(1, '2024-07-10', '2024년 7월 교육 자료 제공', '2024년 7월의 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 3),
(1, '2024-07-15', '2024년 여름 방학 교육 활동 계획', '여름 방학 동안의 교육 활동 계획과 주요 일정 안내입니다.', 0, 3),
(1, '2024-01-15', '겨울철 교육 활동 가이드', '겨울철에 적합한 교육 활동과 가이드입니다.', 0, 2),
(1, '2024-02-05', '2024년 2월 교육 자료 제공', '2024년 2월의 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 3),
(1, '2024-03-01', '2024년 3월 교육 계획 안내', '2024년 3월의 교육 계획과 주요 활동 일정을 안내드립니다.', 0, 2),
(1, '2024-03-12', '봄학기 교육 자료 안내', '봄학기 동안 사용할 교육 자료와 그 활용법에 대해 안내드립니다.', 0, 3),
(1, '2024-04-01', '4월 교육 프로그램 안내', '2024년 4월의 교육 프로그램과 주요 활동 일정입니다.', 0, 2),
(1, '2024-04-15', '어린이집 교육 자료 제공', '어린이집에서 사용할 교육 자료와 자료 활용법에 대해 안내드립니다.', 0, 2),
(1, '2024-04-25', '2024년 5월 교육 계획 안내', '2024년 5월의 교육 계획과 주요 활동 일정을 안내드립니다.', 0, 3),
(1, '2024-05-05', '여름 방학 교육 프로그램 안내', '여름 방학 동안 진행될 교육 프로그램에 대한 안내입니다.', 0, 3),
(1, '2024-05-12', '2024년 5월 교육 자료 제공', '2024년 5월의 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 2),
(1, '2024-05-20', '여름 방학 교육 계획 안내', '여름 방학 동안 진행될 교육 계획과 일정 안내입니다.', 0, 2),
(1, '2024-06-01', '2024년 6월 교육 프로그램 안내', '2024년 6월의 교육 프로그램과 주요 활동 일정입니다.', 0, 3),
(1, '2024-06-10', '여름 방학 교육 자료 제공', '여름 방학 동안 사용할 교육 자료와 자료 활용법에 대해 안내드립니다.', 0, 3),
(1, '2024-06-15', '2024년 7월 교육 계획 안내', '2024년 7월의 교육 계획과 주요 활동 일정을 안내드립니다.', 0, 2),
(1, '2024-07-01', '여름 방학 교육 프로그램 안내', '2024년 여름 방학 동안 진행될 교육 프로그램에 대한 안내입니다.', 0, 2),
(1, '2024-07-10', '2024년 7월 교육 자료 제공', '2024년 7월의 교육 자료와 자료 사용 방법을 안내드립니다.', 0, 3),
(1, '2024-07-15', '2024년 여름 방학 교육 활동 계획', '여름 방학 동안의 교육 활동 계획과 주요 일정 안내입니다.', 0, 3),
(1, '2024-01-10', '2024년 2월 보육료 안내', '2024년 2월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-02-10', '2024년 3월 보육료 안내', '2024년 3월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-03-10', '2024년 4월 보육료 안내', '2024년 4월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-04-10', '2024년 5월 보육료 안내', '2024년 5월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-05-10', '2024년 6월 보육료 안내', '2024년 6월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-06-10', '2024년 7월 보육료 안내', '2024년 7월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-07-10', '2024년 8월 보육료 안내', '2024년 8월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 2),
(1, '2024-07-20', '2024년 하반기 보육료 인상 안내', '2024년 하반기 부터 보육료가 인상 될 예정입니다.', 0, 2),
(1, '2024-01-10', '2024년 2월 보육료 안내', '2024년 2월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-02-10', '2024년 3월 보육료 안내', '2024년 3월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-03-10', '2024년 4월 보육료 안내', '2024년 4월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-04-10', '2024년 5월 보육료 안내', '2024년 5월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-05-10', '2024년 6월 보육료 안내', '2024년 6월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-06-10', '2024년 7월 보육료 안내', '2024년 7월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-07-10', '2024년 8월 보육료 안내', '2024년 8월의 보육료와 납부 방법에 대해 안내드립니다.', 0, 3),
(1, '2024-07-20', '2024년 하반기 보육료 인상 안내', '2024년 하반기 부터 보육료가 인상 될 예정입니다.', 0, 3);

#--------------------------------------------------------announce---------------------------------------------------------
INSERT INTO announce (board_no, announce_type, announce_primary, can_comment) VALUES
(230,0,'0','0'),
(231,0,'1','0'),
(232,0,'0','0'),
(233,0,'0','0'),
(234,0,'0','0'),
(235,0,'0','0'),
(236,0,'0','0'),
(237,0,'0','0'),
(238,0,'0','0'),
(239,0,'0','0'),
(240,0,'0','0'),
(241,0,'0','0'),
(242,0,'0','0'),
(243,0,'0','0'),
(244,0,'0','0'),
(245,0,'0','0'),
(246,0,'1','0'),
(247,0,'0','0'),
(248,0,'0','0'),
(249,0,'0','0'),
(250,0,'0','0'),
(251,0,'0','0'),
(252,0,'0','0'),
(253,0,'0','0'),
(254,0,'0','0'),
(255,0,'0','0'),
(256,0,'0','0'),
(257,0,'0','0'),
(258,0,'0','0'),
(259,0,'0','0'),
(260,0,'0','1'),
(261,0,'0','1'),
(262,1,'0','1'),
(263,1,'1','1'),
(264,1,'0','1'),
(265,1,'0','1'),
(266,1,'0','1'),
(267,1,'0','1'),
(268,1,'0','1'),
(269,1,'0','1'),
(270,1,'0','1'),
(271,1,'0','1'),
(272,1,'0','1'),
(273,1,'0','1'),
(274,1,'0','1'),
(275,1,'0','1'),
(276,1,'0','1'),
(277,1,'0','1'),
(278,1,'0','1'),
(279,1,'0','1'),
(280,1,'0','1'),
(281,1,'0','1'),
(282,1,'0','1'),
(283,1,'0','1'),
(284,1,'0','1'),
(285,1,'0','1'),
(286,1,'0','1'),
(287,1,'0','1'),
(288,1,'0','1'),
(289,1,'0','1'),
(290,1,'0','1'),
(291,1,'0','1'),
(292,1,'0','1'),
(293,1,'0','1'),
(294,1,'0','1'),
(295,1,'1','1'),
(296,1,'0','1'),
(297,1,'0','1'),
(298,1,'0','1'),
(299,1,'0','1'),
(300,1,'0','1'),
(301,1,'0','1'),
(302,1,'0','1'),
(303,1,'0','1'),
(304,1,'0','1'),
(305,1,'0','1'),
(306,1,'0','1'),
(307,1,'0','1'),
(308,1,'0','1'),
(309,1,'0','1'),
(310,1,'0','1'),
(311,1,'1','1'),
(312,1,'0','1'),
(313,1,'0','1'),
(314,1,'0','1'),
(315,1,'0','1'),
(316,2,'0','1'),
(317,2,'0','1'),
(318,2,'0','1'),
(319,2,'0','1'),
(320,2,'0','1'),
(321,2,'0','1'),
(322,2,'0','1'),
(323,2,'0','1'),
(324,2,'0','1'),
(325,2,'0','1'),
(326,2,'0','1'),
(327,2,'0','1'),
(328,2,'0','1'),
(329,2,'0','1'),
(330,2,'0','1'),
(331,2,'0','1'),
(332,2,'0','1'),
(333,2,'0','1'),
(334,2,'0','1'),
(335,2,'0','1'),
(336,2,'0','1'),
(337,2,'0','1'),
(338,2,'0','1'),
(339,2,'0','1'),
(340,2,'0','1'),
(341,2,'0','1'),
(342,2,'0','1'),
(343,2,'0','1'),
(344,2,'0','1'),
(345,2,'0','1'),
(346,2,'0','1'),
(347,2,'0','1'),
(348,2,'0','1'),
(349,2,'0','1'),
(350,2,'0','1'),
(351,2,'0','1'),
(352,2,'0','1'),
(353,2,'0','1'),
(354,2,'0','1'),
(355,2,'0','1'),
(356,2,'0','1'),
(357,2,'0','1'),
(358,2,'0','1'),
(359,2,'0','1'),
(360,2,'0','1'),
(361,2,'0','1'),
(362,2,'0','1'),
(363,2,'0','1'),
(364,2,'1','1'),
(365,2,'0','1'),
(366,2,'0','1'),
(367,2,'0','1'),
(368,2,'0','1'),
(369,2,'0','1'),
(370,2,'0','1'),
(371,2,'0','1'),
(372,2,'0','1'),
(373,2,'0','1'),
(374,2,'0','1'),
(375,2,'0','1'),
(376,2,'0','1'),
(377,2,'0','1'),
(378,3,'0','1'),
(379,3,'0','1'),
(380,3,'0','1'),
(381,3,'0','1'),
(382,3,'0','1'),
(383,3,'0','1'),
(384,3,'0','1'),
(385,3,'0','1'),
(386,3,'0','1'),
(387,3,'0','1'),
(388,3,'0','1'),
(389,3,'0','1'),
(390,3,'0','1'),
(391,3,'0','1'),
(392,3,'0','1'),
(393,3,'0','1'),
(394,3,'0','1'),
(395,3,'0','1'),
(396,3,'0','1'),
(397,3,'0','1'),
(398,3,'0','1'),
(399,3,'0','1'),
(400,3,'0','1'),
(401,3,'0','1'),
(402,3,'0','1'),
(403,3,'0','1'),
(404,3,'0','1'),
(405,3,'0','1'),
(406,3,'0','1'),
(407,3,'0','1'),
(408,3,'0','1'),
(409,3,'0','1'),
(410,3,'0','1'),
(411,3,'0','1'),
(412,3,'0','1'),
(413,3,'0','1'),
(414,4,'0','0'),
(415,4,'0','0'),
(416,4,'0','0'),
(417,4,'0','0'),
(418,4,'0','0'),
(419,4,'0','0'),
(420,4,'0','0'),
(421,4,'0','0'),
(422,4,'0','0'),
(423,4,'0','0'),
(424,4,'0','0'),
(425,4,'0','0'),
(426,4,'0','0'),
(427,4,'0','0'),
(428,4,'0','0'),
(429,4,'0','0');

