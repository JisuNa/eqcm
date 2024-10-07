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
) comment '상품';

create unique index member_email_uindex on member (email);

create table member_social
(
    member_id     bigint unsigned not null comment '회원식별값',
    provider_type varchar(20)     not null comment '제공자',
    social_id     varchar(100)    not null comment '소셜식별값',
    primary key (member_id)
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

create table verify_number
(
    id            bigint unsigned auto_increment comment '식별값',
    phone_number  varchar(20) not null comment '전화번호',
    number varchar(4)  not null comment '인증번호',
    expired_dtm   datetime     not null comment '만료일시',
    primary key (id)
) comment '인증번호';

create unique index verify_number_phone_number_uindex on verify_number (phone_number);