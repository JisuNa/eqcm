create table member
(
    id           bigint unsigned auto_increment comment '식별값',
    email        varchar(100) not null comment '이메일',
    password     varchar(100) null comment '비밀번호',
    name         varchar(30)  not null comment '이름',
    gender       varchar(10)  not null comment '성별',
    birthday     date         not null comment '생년월일',
    phone_number varchar(20)  not null comment '전화번호',
    created_dtm  datetime     not null comment '생성일시',
    updated_dtm  datetime     not null comment '수정일시',
    primary key (id)
) comment '회원';

create unique index member_email_uindex on member (email);

create table member_sns
(
    member_id       bigint unsigned not null comment '회원식별값',
    sns_id          varchar(255)    not null comment 'SNS 식별값',
    sns_type        varchar(20)     not null comment '제공자',
    sns_profile     varchar(100)    not null comment '프로필',
    sns_connect_dtm datetime        not null comment '연결일시',
    primary key (member_id, sns_id)
) comment '회원 소셜';

create unique index member_social_provider_social_id_uindex on member_social (provider_type, social_id);

create table member_agreement
(
    member_id   bigint unsigned not null comment '회원식별값',
    terms_type  varchar(30)     not null comment '약관 유형',
    agree_yn    char(1)         not null comment '동의 여부',
    created_dtm datetime        not null comment '생성일시',
    updated_dtm datetime        not null comment '수정일시',
    primary key (member_id)
) comment '회원 동의';

create table brand
(
    id       bigint unsigned auto_increment comment '식별값',
    name     varchar(20) unique not null comment '이름',
    sub_copy varchar(100)       not null comment '서브카피',
    primary key (id)
) comment '브랜드';

create table category
(
    id        bigint unsigned auto_increment comment '식별값',
    name      varchar(20) unique not null comment '이름',
    parent_id bigint unsigned comment '상위 카테고리 식별값',
    primary key (id)
) comment '카테고리';

CREATE INDEX idx_name ON category (name);

create table product
(
    id            bigint unsigned auto_increment comment '식별값',
    name          varchar(100)    not null comment '이름',
    price         int unsigned    not null comment '가격',
    discount_rate int unsigned    not null comment '할인율',
    brand_id      bigint unsigned not null comment '브랜드 식별값',
    category_id   bigint unsigned not null comment '카테고리 식별값',
    primary key (id)
) comment '상품';

create table product_option_group
(
    id   bigint unsigned auto_increment comment '식별값',
    name varchar(20) not null comment '이름',
    primary key (id)
) comment '상품 옵션 그룹';

create table product_option
(
    id                   bigint unsigned auto_increment comment '식별값',
    item_option_group_id bigint unsigned not null comment '상품 옵션 그룹 식별값',
    name                 varchar(20)     not null comment '이름',
    primary key (id)
) comment '상품 옵션';

create table item
(
    id             bigint unsigned auto_increment comment '식별값',
    product_id     bigint unsigned not null comment '상품 식별값',
    item_option_id bigint unsigned null comment '상품 옵션 그룹 식별값',
    primary key (id)
) comment '항목';

create table item_stock
(
    id       bigint unsigned auto_increment comment '식별값',
    item_id  bigint unsigned not null comment '항목 식별값',
    quantity int unsigned    not null comment '수량',
    primary key (id)
) comment '항목 재고';
