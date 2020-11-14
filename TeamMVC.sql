show user;

-- === 이지은 DB 시작 === -- 

-- 테이블 보기 --
select * from tabs;

-- 메인 캐러셀 이미지 테이블 --
create table tbl_carousel_image
(imgno           number not null                    -- 이미지번호
,imgfilename     varchar2(100) not null             -- 이미지파일이름
,constraint PK_tbl_carousel_image primary key(imgno)
);

-- 메인 캐러셀 이미지 테이블의 시퀀스 생성 -- 
create sequence seq_carousel_image
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

-- 메인 캐러셀 이미지 삽입 -- 
-- 여자 -- 
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel1.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel2.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel3.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel4.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel5.jpg');

-- 남자 -- 
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel6.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel7.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel8.jpg');
insert into tbl_carousel_image(imgno, imgfilename) values(seq_carousel_image.nextval, 'carousel9.jpg');



commit;

-- 조회 -- 
select imgno, imgfilename
from tbl_carousel_image
ORDER BY imgno;

-- 메인 이미지 테이블 -- 
create table tbl_main_image
(imgno           number not null                    -- 이미지번호
,imgfilename     varchar2(100) not null             -- 이미지파일이름
,constraint PK_tbl_main_image primary key(imgno)
);

-- 메인 이미지 테이블의 시퀀스 생성 -- 
create sequence seq_main_image
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
 
-- 테이블 삭제 -- 
-- drop table tbl_main_image PURGE;

-- 시퀀스 삭제 -- 
-- drop SEQUENCE seq_main_image;

-- 메인 이미지 삽입
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '1_2.png');  
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '2_2.png');  
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '3_2.png');  
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '4_2.png');  
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '5_2.png'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '6_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '7_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '8_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '9_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '10_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '11_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '12_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '13_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '14_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '15_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '16_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '17_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '18_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '19_2.PNG'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '20_2.PNG'); 

commit;

-- 조회 -- 
select imgno, imgfilename
from tbl_main_image
ORDER BY imgno;

update tbl_main_image set imgfilename = replace(imgfilename, '.png', '.PNG');

-- 카테고리 테이블 생성 -- 
create table tbl_category
(
 cgno           number(8)               not null    -- 카테고리 대분류 번호
,cgcode         varchar2(20)            not null    -- 카테고리 코드
,cgname         varchar2(100)           not null    -- 카테고리 명
,CONSTRAINT PK_tbl_category_cgno    primary key(cgno)  
,constraint UQ_tbl_category_cgcode  unique(cgcode)
);

-- 카테고리 시퀀스 테이블 생성 -- 
create sequence seq_category_cgno
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

insert into tbl_category values(seq_category_cgno.nextval, '1', '코트');
insert into tbl_category values(seq_category_cgno.nextval, '2', '자켓');
insert into tbl_category values(seq_category_cgno.nextval, '3', '점퍼');
insert into tbl_category values(seq_category_cgno.nextval, '4', '무스탕');
insert into tbl_category values(seq_category_cgno.nextval, '5', '가디건');

select cgno, cgcode, cgname 
from tbl_category;

-- 제품 테이블 생성--
create table tbl_product
( 
 pdno                   number(8)       not null    -- 제품번호
,pdname                 varchar2(100)   not null    -- 제품명
,pdcategory_fk          varchar2(20)    not null    -- 카테고리코드
,pdimage1               varchar2(100)               -- 제품이미지1    
,pdimage2               varchar2(100)               -- 제품이미지2
,pdqty                  number(8)       default 0   -- 제품 재고량
,price                  number(8)       default 0   -- 제품 정가
,saleprice              number(8)       default 0   -- 제품 판매가
,pdcontent              varchar2(4000)              -- 제품 설명 ( varchar2의 경우 최대 4000바이트까지 작성가능하다. 이것보다 더 큰 경우에는 clob를 사용한다.
,point                  number(8)       default 0   -- 포인트 점수
,pdinputdate            date    default sysdate     -- 제품등록일자
,texture                varchar2(20)                -- 제품소재
,pdgender                varchar2(1)                 -- 성별
,constraint CK_tbl_product_pdgender check( pdgender in('1', '2') ) -- 남자 : 1, 여자 : 2
,constraint PK_tbl_product_pdno primary key(pdno)
,constraint FK_tbl_product_pdcategory_fk foreign key(pdcategory_fk) references tbl_category(cgcode)
);

-- 제품 시퀀스 테이블 생성 -- 
create sequence seq_product_pdno
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

-- 가격, 포인트는 나중에 설정 --
-- 제품 insert -- 
insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 1, 'long handmade coat', '1', '1_1.PNG', '1_2.PNG', 100, 200000, 200000, 'long handmade coat 롱 핸드메이드 코트', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 2, 'H trench coat', '1', '2_1.PNG', '2_2.PNG', 100, 200000, 200000, 'H trench coat 초겨울까지든든하게 :) 탄탄트렌치', 100, 'cotton', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 3, 'BEFORE TRENCH COAT', '1', '3_1.PNG', '3_2.PNG', 100, 200000, 200000, 'BEFORE TRENCH COAT', 100, 'cotton', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 4, 'Powder pur short coat', '1', '4_1.PNG', '4_2.PNG', 100, 200000, 200000, 'Powder pur short coat 파우더 퍼 숏 코트', 100, 'polyester', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 5, 'lemer jacket', '1', '5_1.PNG', '5_2.PNG', 100, 200000, 200000, 'lemer jacket', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 6, 'The Note Jacket', '2', '6_1.PNG', '6_2.PNG', 100, 200000, 200000, 'The Note Jacket', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 7, 'lowe check jacket', '2', '7_1.PNG', '7_2.PNG', 100, 200000, 200000, 'lowe check jacket', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 8, 'praha short jacket', '2', '8_1.PNG', '8_2.PNG', 100, 200000, 200000, 'praha short jacket', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 9, 'classic corduroy jumper', '3', '9_1.PNG', '9_2.PNG', 100, 200000, 200000, 'classic corduroy jumper', 100, 'cotton', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 10, 'pastel padding jumper' , '3', '10_1.PNG', '10_2.PNG', 100, 200000, 200000, 'pastel padding jumper' , 100, 'polyester', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 11, 'onion quiltin jumper', '3', '11_1.PNG', '11_2.PNG', 100, 200000, 200000, 'onion quiltin jumper', 100, 'polyester', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 12, 'my favorite jumper', '3', '12_1.PNG', '12_2.PNG', 100, 200000, 200000, 'my favorite jumper', 100, 'cotton', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 13, 'meishu mustang', '4', '13_1.PNG', '13_2.PNG', 100, 200000, 200000, 'meishu mustang 메이슈 무스탕', 100, 'leather', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 14, 'Creans mustang', '4', '14_1.PNG', '14_2.PNG', 100, 200000, 200000, 'Creans mustang', 100, 'leather', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 15, 'winter mink pur mustang', '4', '15_1.PNG', '15_2.PNG', 100, 200000, 200000, 'winter mink pur mustang', 100, 'leather', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 16, 'mush double mustang', '4', '16_1.PNG', '16_2.PNG', 100, 200000, 200000, 'mush double mustang', 100, 'leather', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 17, 'From lambswool cardigan', '5', '17_1.PNG', '17_2.PNG', 100, 200000, 200000, 'From lambswool cardigan 프롬 울 가디건', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 18, 'Midnight long knit cardigan', '5', '18_1.PNG', '18_2.PNG', 100, 200000, 200000, 'Midnight long knit cardigan 미드나잇 롱 니트 가디건', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 19, 'Angora Twist Cardigan', '5', '19_1.PNG', '19_2.PNG', 100, 200000, 200000, 'Angora Twist Cardigan 앙고라 꽈배기 가디건', 100, 'wool', 2 ); 

insert into tbl_product(pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, texture, pdgender) 
values( 20, 'Argyle loosefit knit cardigan', '5', '20_1.PNG', '20_2.PNG', 100, 200000, 200000, 'Argyle loosefit knit cardigan 아가일 루즈핏 니트 가디건', 100, 'wool', 2 ); 

select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, pdqty, price, saleprice, pdcontent, point, pdinputdate, texture, pdgender 
from tbl_product
order by pdno;

commit;

-- 제품 상세 정보(색상, 사이즈) 테이블 생성 -- 
create table tbl_product_info
(
 pinfono    number(8)                    not null    -- 제품상세일련번호
,pdno_fk    number(8)                    not null    -- 제품번호(제품 테이블의 제품번호 참조)
,pcolor      varchar2(20)                 not null    -- 색상
,psize       varchar2(8) default 'free'   not null    -- 사이즈(디폴트 free)
,Constraint PK_tbl_product_info_pinfono  primary key(pinfono)
,constraint FK_tbl_product_info_pdno_fk  foreign key(pdno_fk) references tbl_product(pdno)   
);

--  제품 상세 정보 시퀀스 생성 --
create sequence seq_product_info_pinfono
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;


--insert into tbl_product_info(pinfono, pdno_fk, pcolor)
--values(seq_product_info_pinfono.nextval, 1, '베이지');
--
--insert into tbl_product_info(pinfono, pdno_fk, pcolor)
--values(seq_product_info_pinfono.nextval, 1, '그레이');
--
--insert into tbl_product_info(pinfono, pdno_fk, pcolor)
--values(seq_product_info_pinfono.nextval, 1, '블랙');

-- 제품 상세 정보 데이터 insert -- 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 1, 1, 'gray'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 2, 1, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 3, 1, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 4, 2, 'cream'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 5, 2, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 6, 2, 'charcoal'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 7, 3, 'cream'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 8, 3, 'gray'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 9, 4, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 10, 4, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 11, 5, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 12, 6, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 13, 6, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 14, 7, 'gray'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 15, 8, 'gray'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 16, 8, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 17, 8, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 18, 8, 'ivory'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 19, 9, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 20, 9, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 21, 9, 'khaki');  
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 22, 10, 'mint'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 23, 10, 'pink'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 24, 11, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 25, 11, 'ivory'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 26, 12, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 27, 12, 'khaki'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 28, 13, 'ivory'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 29, 13, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 30, 14, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 31, 14, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 32, 15, 'cream'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 33, 15, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 34, 16, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 35, 16, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 36, 16, 'ivory'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 37, 17, 'cream'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 38, 17, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 39, 17, 'gray'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 40, 18, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 41, 18, 'brown'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 42, 18, 'black'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 43, 19, 'beige'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 44, 19, 'gray'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 45, 19, 'charcoal'); 
insert into tbl_product_info(pinfono, pdno_fk, pcolor) values( 46, 20, 'navy'); 


select pinfono, pdno_fk, pcolor, psize
from tbl_product_info;

commit;

select * 
from TBL_PRODUCT_IMAGEFILE;


select *
from tabs;

select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender, pdinputdate
from tbl_product;

-- 상품 테이블 1달 전으로 update commit x -- 
update tbl_product set pdinputdate = add_months(pdinputdate , -1)
where pdno in(1,5,6,8,9,10,30,33,44,26,12,38,3,15,32);

-- 상품 테이블 2달 전으로 update commit x -- 
update tbl_product set pdinputdate = add_months(pdinputdate , -2)
where pdno in(2,4,7,6,11,14,31,35,46,24,18,28,37,13,22);

-- 상품 가격 높은 순 (saleprice) 리스트 조회 (여자)-- 
-- pdimage1 을 메인화면, 조회화면 : pdimage2 --
select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender
from tbl_product
where pdgender = 2
ORDER BY saleprice desc;


-- 상품 가격 높은 순 (saleprice) 리스트 조회 (남자)-- 
select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender
from tbl_product
where pdgender = 1
ORDER BY saleprice desc;

-- 상품 가격 낮은 순 (saleprice) 리스트 조회 (여자)-- 
select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender
from tbl_product
where pdgender = 2
ORDER BY saleprice asc;

-- 상품 가격 높은 순 (saleprice) 리스트 조회 (남자)-- 
select pdno, pdname, pdcategory_fk, pdimage2,price, sale, saleprice
from tbl_product
where pdgender = 1
ORDER BY saleprice asc;

-- 신상품 (현재 기준으로부터 30일 이전) 여자 -- 
select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender, pdinputdate
from tbl_product
where pdgender = 2 and (pdinputdate BETWEEN DATE_ADD(NOW(),INTERVAL -1 MONTH) AND NOW());
order by pdno asc;


   from TestTable
   where regDate >= to_date(add_months(sysdate, -1))
   
select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender, pdinputdate
from tbl_product
where pdgender = 2 and pdinputdate >= to_date(add_months(sysdate, -1))
order by pdno asc;

-- !!!!! 한달 전 상품(최신 상품) 조회하기 !!!! --
select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender
from tbl_product
where pdgender = 2 and pdinputdate >= (sysdate - 31);
order by pdno asc;
      
select sysdate - 30 
from dual;

update tbl_product set pdinputdate = ( pdinputdate + 20 )
where pdno in(1,7);

select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender, pdinputdate
from tbl_product
where pdgender = 2
order by pdno asc;

commit;

select pdno, pdname, pdcategory_fk, pdimage1, saleprice
from tbl_product
where pdgender = 2;

select * 
from tbl_product_info;

desc tbl_product_info;

-- 이거 사용 불가 사진 이미지 pdno당 1개인데 join 해서 색상 개수만큼 나온다. -- 
select  p.pdno, p.pdname, p.pdcategory_fk, p.pdimage1, p.saleprice, pi.pcolor, pi.psize
from tbl_product p right join tbl_product_info pi
on p.pdno = pi.pdno_fk
where p.pdgender = 2;

-- 조인 없이 사진, 이름, 가격 출력 select 문 -- 
select  pdno, pdname, pdcategory_fk, pdimage1, price, saleprice
from tbl_product
where pdgender = 2;

select *
from tabs;

select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender
from tbl_product
where pdcategory_fk = 1 and pdgender = 2 and pdname like '%%';

select * 
from tbl_category;

select email
from tbl_member_test
where userid = 'leess';

select c.cgcode, c.cgname, p.pdimage2, p.price, p.saleprice
from tbl_category c inner join tbl_product p
on p.pdcategory_fk = c.cgcode;

-- 카테고리 테이블에서 코트, 자켓, 점퍼, 무스탕, 가디건 조회하기
select c.cgcode, c.cgname, p.pdimage2, p.price, p.saleprice
from tbl_category c inner join tbl_product p
on p.pdcategory_fk = c.cgcode;

select *
from tbl_product;

select c.cgcode, c.cgname, p.pdimage2, p.price, p.saleprice
from tbl_category c inner join tbl_product p
on p.pdcategory_fk = c.cgcode;

select *
from tbl_category;

select cgno, cgcode, cgname
from tbl_category;

desc tbl_category;

-- === 이지은 DB 끝 === -- 

select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and pdcategory_fk = 1;    

desc tbl_product;


select p.pdno, pi.pcolor
from tbl_product p right join tbl_product_info pi
on p.pdno = pi.pdno_fk
where p.pdgender = 2 and pdno = 1;

select pdno_fk, pcolor
from tbl_product_info
where pdno_fk = 1;

select pdno,pdgender
from tbl_product
where pdno = 1;

select pdno, pdname, pdcategory_fk, pdimage1, price, saleprice 
from tbl_product
where pdgender = 2
ORDER BY saleprice desc;


----------------------------------------------------
-- 남자 신상품 조회 -- 
select  pdno, pdname, pdcategory_fk, pdimage1, price, saleprice
from tbl_product
where pdgender = 1 and pdinputdate > (sysdate - 31);

select  pdno, pdname, pdcategory_fk, pdimage1, price, saleprice
from tbl_product
where pdgender = 1;

select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender, pdinputdate
from tbl_product
where pdgender = 2 and pdcategory_fk = 1 and pdinputdate >= (sysdate - 31)
order by saleprice desc;

and 

select pdno, pdname, pdimage1, pdimage2, pdcategory_fk
from tbl_product
where pdgender = 2 and pdcategory_fk = 1;

select distinct pdcategory_fk
from tbl_product;

select *
from tbl_category;

-- 남자 이면서 코트 클릭하고 신상품 클릭한경우 --
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender, pdinputdate
from tbl_product
where pdgender = 1 and pdcategory_fk = 1 and pdinputdate >= (sysdate - 31);

---------------------------------- =========================== 페이지 select 테스트 ============================== -----------------------------------------

-- 여자이면서 코트 클릭 한 경우 --
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and  pdcategory_fk = 1;

-- 화면과의 test : ok --

-- 여자이면서 자켓 클릭 한 경우 --
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and  pdcategory_fk = 2;

-- 화면과의 test : ok --

-- 여자이면서 점퍼 클릭 한 경우 --
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and  pdcategory_fk = 3;

-- 화면과의 test : ok --

-- 여자이면서 무스탕 클릭 한 경우 --
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and  pdcategory_fk = 4;

-- 화면과의 test : ok --

-- 여자이면서 가디건 클릭 한 경우 --
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and  pdcategory_fk = 5;

-- 화면과의 test : ok --

-- 여자이면서 코트 클릭한 상태에서 정렬인 신상품 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 2 and  pdcategory_fk = 1 and pdinputdate >= (sysdate - 31);

-- 남자이면서 코트를 클릭한 상태에서 낮은 가격을 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 1 and  pdcategory_fk = 1
order by saleprice asc;

-- 화면과의 test : ok -- 

-- 남자이면서 자켓을 클릭한 상태에서 낮은 가격을 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 1 and  pdcategory_fk = 2 
order by saleprice asc;

-- 화면과의 test : ok -- 

-- 남자이면서 점퍼를 클릭한 상태에서 낮은 가격을 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 1 and  pdcategory_fk = 3
order by saleprice asc;

-- 화면과의 test : ok -- 

-- 남자이면서 무스탕을 클릭한 상태에서 낮은 가격을 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 1 and  pdcategory_fk = 4
order by saleprice asc;

-- 화면과의 test : ok -- 

-- 남자이면서 무스탕을 클릭한 상태에서 낮은 가격을 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 1 and  pdcategory_fk = 4
order by saleprice asc;

-- 화면과의 test : ok -- 

-- 남자이면서 가디건을 클릭한 상태에서 낮은 가격을 클릭한 경우 -- 
select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender
from tbl_product
where pdgender = 1 and  pdcategory_fk = 5
order by saleprice asc;

-- 화면과의 test : ok -- 