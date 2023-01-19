create table custom(
id varchar(100) primary key, 
pw varchar(500) not null, 
name varchar(100) not null,
email varchar(200),
address varchar(200),
tel varchar(100),
regdate date default sysdate,
visited int default 0
); 
select * from custom;

create sequence board_seq;
create sequence notice_seq;
create table board(
no int seq primary key,
title varchar(200) not null,
content varchar(1000) not null,
author varchar(100) not null,
resdate date default sysdate,
visited int default 0
);
create table board2(
no int auto_increment primary key,
title varchar(200) not null,
content varchar(1000) not null,
author varchar(100) not null,
resdate datetime default now(),
visited int default 0
);
create table QnA(
no int auto_increment primary key,
title varchar(200) not null,
content varchar(1000) not null,
author varchar(100) not null,
resdate datetime default now(),
lev int,
parno int,
visited int default 0
);
select * from board;
select * from board order by resdate desc;
select * from board2;
select * from board3;
select * from board3 where lev=0 order by resdate desc; 
update board set visited=visited+1 where no=1;

insert into board values(default, '공지사항 제목1','공지사항 내용1','admin',default,default);
insert into board values(default, '공지사항 제목2','공지사항 내용2','admin',default,default);

insert into board2 values(default, '자유게시판 제목1','자유게시판 내용1','hth',default,default);
insert into board2 values(default, '자유게시판 제목2','자유게시판 내용2','hth',default,default);

insert into board3 values(default, 'Qna게시판 질문1','QnA게시판 질문 내용1','hth',default,0,1,default);
insert into board3 values(default, 'Qna게시판 질문2','QnA게시판 질문 내용2','hth',default,0,2,default);
insert into board3 values(default, 'Qna게시판 질문3','QnA게시판 질문 내용3','hth',default,0,3,default);

insert into board3 values(default, 'Qna게시판 답변1','QnA게시판 답변 내용1','hth',default,1,1,default);
insert into board3 values(default, 'Qna게시판 답변2','QnA게시판 답변 내용2','hth',default,1,2,default);
insert into board3 values(default, 'Qna게시판 답변3','QnA게시판 답변 내용3','hth',default,1,3,default);

insert into board3 values(default, 'Qna게시판 질문5', 'QnA게시판 질문 내용5','hth',default,0,(SELECT MAX(no)+1 from board3),default);
delete from board3 where no=18;
select (last_insert_id())+1 from board3;
select max(no)+1 as parno from board3;