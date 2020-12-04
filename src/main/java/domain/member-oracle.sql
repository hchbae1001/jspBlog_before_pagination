create sequence seq_m201712045 increment by 1 start with 1;

create table m201712045 (
    id number(11) not null primary key,
    email varchar2(30) not null unique,
    pw varchar2(20) not null,
    name varchar2(30) not null,
    phone varchar2(13),
    address varchar2(50)
);

INSERT INTO m201712045 VALUES(seq_m201712045.nextval,'egyou@induk.ac.kr', 'cometrue','유응구', '9507625', 'korea');
INSERT INTO m201712045 VALUES(seq_m201712045.nextval,'root@induk.ac.kr','cometrue','관리자','01030377903','korea');

select * from m201712045;

select pw from m201712045 where email = 'egyou@induk.ac.kr';

update m201712045 set name='comso', phone='7777', address='nowon, seoul' where email='comso1@induk.ac.kr' and pw='cometrue';
update m201712045 set pw='1234' where email='root@induk.ac.kr';
delete from m201712045 where id = 2;

drop sequence seq_m201712045;

drop table m201712045;