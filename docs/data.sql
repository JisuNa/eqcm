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
    id   bigint unsigned auto_increment comment '식별값',
    name varchar(20) unique not null comment '이름',
    primary key (id)
) comment '브랜드';

create table category
(
    id   bigint unsigned auto_increment comment '식별값',
    name varchar(20) unique not null comment '이름',
    primary key (id)
) comment '카테고리';

CREATE INDEX idx_name ON category (name);

create table product
(
    id          bigint unsigned auto_increment comment '식별값',
    name        varchar(100) not null comment '이름',
    price       int unsigned not null comment '가격',
    brand_id    bigint unsigned comment '브랜드 식별값',
    category_id bigint unsigned comment '카테고리 식별값',
    primary key (id)
) comment '상품';

CREATE INDEX idx_category_id ON product (category_id);
CREATE INDEX idx_price ON product (price);

create table product_stock
(
    product_id bigint unsigned not null comment '상품식별값',
    size       varchar(10)    not null comment '사이즈',
    stock      int unsigned not null comment '재고',
    primary key (product_id)
) comment '상품 재고';
