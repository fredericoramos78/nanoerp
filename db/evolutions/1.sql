# Initial schema

# --- !Ups

create sequence USERS_SEQ start with 1 increment by 1;
create sequence ORDERS_SEQ start with 1 increment by 1;
create sequence ORDER_PAYMENTS_SEQ start with 1 increment by 1;
create sequence ORDER_PAYMENT_COUPONS_SEQ start with 1 increment by 1;

create table USERS (
   USR_ID number not null,
   USR_NAME varchar2(200) not null,
   USR_EMAIL varchar2(200) not null,
   USR_CREATION_DATE date not null,
   USR_STATUS number(1) not null
);

alter table USERS add constraint USERS_PK 
   primary key ( USR_ID );

create unique index IX_USERS_UK_EMAIL
    on USERS ( USR_EMAIL );
      
create table ORDERS (
   ORD_ID number not null,
   ORD_CREATION_DATE date not null,
   ORD_CLOUSURE_DATE date,
   ORD_STATUS number(1) not null,
   ORD_GROSS_AMOUNT float not null,
   ORD_DISCOUNT_AMOUNT float,
   USR_ID number,
   ORD_NET_AMOUNT float not null
);

alter table ORDERS add constraint ORDERS_PK 
   primary key ( ORD_ID );

alter table ORDERS add constraint ORDERS_FK_USR_ID
   foreign key ( USR_ID ) references USERS ( USR_ID );

create table ORDER_PAYMENTS (
   OPM_ID number not null,
   ORD_ID number not null,
   OPM_SEQ number(3),
   OPM_DUE_DATE date not null,
   OPM_DUE_AMOUNT float not null
);

alter table ORDER_PAYMENTS add constraint ORDER_PAYMENTS_PK 
   primary key ( OPM_ID );

alter table ORDER_PAYMENTS add constraint ORDER_PAYMENTS_FK_ORD_ID
   foreign key ( ORD_ID ) references ORDERS ( ORD_ID );
   
   
create table ORDER_PAYMENT_COUPONS (
   OPC_ID number not null,
   OPM_ID number not null,
   OPC_COUPON_CODE varchar2(50),
   OPC_ISSUED_DATE date,
   OPC_DUE_AMOUNT float not null,
   OPC_PAYED_DATE date,
   OPC_PAYED_AMOUNT float
);

alter table ORDER_PAYMENT_COUPONS add constraint ORDER_PAYMENT_COUPONS_PK 
   primary key ( OPC_ID );

alter table ORDER_PAYMENT_COUPONS add constraint ORDER_PYMT_COUPONS_FK_OPM_ID
   foreign key ( OPM_ID ) references ORDER_PAYMENTS ( OPM_ID );

# --- !Downs

drop sequence ORDER_PAYMENT_COUPONS_SEQ;
drop sequence ORDER_PAYMENTS_SEQ;
drop sequence ORDERS_SEQ;
drop sequence USERS_SEQ;

drop table ORDER_PAYMENT_COUPONS;
drop table ORDER_PAYMENTS;
drop table ORDERS;
drop table USERS;
