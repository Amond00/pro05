use myshop;
use shop;
ALTER TABLE qna MODIFY no INT NOT NULL AUTO_INCREMENT primary key;
create table board select * from myshop.board;
alter table custom drop level;
commit;

desc qna;
desc custom;
desc notice;
desc board;
desc product;
desc cart;
select * from qna;
select * from custom;
select * from board;
select * from notice;
select * from product;
select * from cart;
select * from cart where cusid='admin';
-- QnA
drop table board;
delete from qna where no=27;
create table qna(no int primary key auto_increment, title varchar(200) not null, content varchar(1000) not null, author varchar(20) not null, resdate datetime default now(), lev int, parno int);
insert into qna (no, title, content, author, parno, lev) values (default, '테스트', '테스트', 'testid', (select last_insert_id())+1, 0);

insert into qna values (default,'문의 합니다 1','문의합니다 1 내용','hth',default,0,1);
insert into qna values (default,'문의 합니다 2','문의합니다 2 내용','hth',default,0,2);
insert into qna values (default,'문의 합니다 3','문의합니다 3 내용','hth',default,0,3);
insert into qna values (default,'문의 합니다 4','문의합니다 4 내용','hth',default,0,4);
insert into qna values (default,'문의 합니다 5','문의합니다 5 내용','hth',default,0,5);
insert into qna values (default,'문의 합니다 6','문의합니다 6 내용','hth',default,0,6);

insert into qna values (default,'문의 합니다 1 답변','문의 합니다 1 답변 내용','admin',default,1,1);
insert into qna values (default,'문의 합니다 2 답변','문의 합니다 2 답변 내용','admin',default,1,2);
insert into qna values (default,'문의 합니다 3 답변','문의 합니다 3 답변 내용','admin',default,1,3);
insert into qna values (default,'문의 합니다 4 답변','문의 합니다 4 답변 내용','admin',default,1,4);
insert into qna values (default,'문의 합니다 5 답변','문의 합니다 5 답변 내용','admin',default,1,5);
insert into qna values (default,'문의 합니다 6 답변','문의 합니다 6 답변 내용','admin',default,1,6);

select * from qna where no=3 and lev=0;
select * from qna where parno=1;
select title as title2, content as content2 from qna where parno=1 and lev=1;
select * from qna where parno=1 and lev=0;
select title as title2, content as content2 from qna where parno=1 and lev=1;

-- Board
create table board (no int auto_increment primary key, title varchar(200) not null, content varchar(1000) not null, author varchar(100), resdate datetime default now(), visitied int default 0);
insert into board values (default, '공지사항입니다','공지사항내용입니다','admin',default,1000);
update custom set visited=visited+1, point=point+5 where cusid = 'hth';

-- Product, Cart
create table product (proNo int auto_increment primary key, cateNo int not null, proName varchar(100) not null, proSpec varchar(200) not null, proPrice int not null);
insert into product values();

create table cart (cartNo int auto_increment primary key, cusId varchar(13) not null, proNo int not null, amount int not null);
insert into cart values (default, 'admin',1,1000);
insert into cart values (default, 'admin',2,1000);