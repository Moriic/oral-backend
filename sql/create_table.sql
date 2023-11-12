-- 删除原数据库
drop database oral;
-- 创建库
create database if not exists oral;
-- 使用库
use oral;

-- 患者表
create table if not exists patient
(
    id         bigint auto_increment comment 'id' primary key,
    name       varchar(50)                        not null comment '姓名',
    gender     varchar(10)                        not null comment '性别',
    age        integer                            not null comment '年龄',
    phone      varchar(20)                        not null comment '联系方式',
    blood      varchar(10)                        not null comment '血型',
    ssCard     varchar(50)                        not null comment '社保卡号',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
) comment '患者' collate = utf8mb4_unicode_ci;


-- 检测图像
create table if not exists image
(
    id             bigint auto_increment comment 'id' primary key,
    patientId      bigint                             not null comment '患者id',
    originalImage  varchar(256)                       not null comment '原图像',
    processedImage varchar(256)                       not null comment '处理后的图像',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除',
    foreign key (patientId) references patient (id)
) comment '图像' collate = utf16_unicode_ci;


-- TODO 更新内容
-- 科室表
create table if not exists department
(
    id         bigint auto_increment comment 'id' primary key,
    dept       varchar(50)                        not null comment '科室名称',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
) comment '科室' collate = utf16_unicode_ci;

-- 医生表
create table if not exists doctor
(
    id         bigint auto_increment comment 'id' primary key,
    account    varchar(256)                       not null comment '账号',
    password   varchar(256)                       not null comment '密码',
    name       varchar(50)                        not null comment '姓名',
    age        integer                            not null comment '年龄',
    birthday   date                               not null comment '出生日期',
    gender     varchar(10)                        not null comment '性别',
    phone      varchar(20)                        not null comment '联系方式',
    job        varchar(50)                        not null comment '职称',
    avatar     varchar(1024)                      null comment '头像',
    photo      varchar(1024)                      null comment '照片',
    profile    varchar(512)                       null comment '简介',
-- TODO   更新医生内容
    deptId     bigint                             not null comment '关联科室id',
    office     varchar(50)                        null comment '办公室',

    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    foreign key (deptId) references department (id)
) comment '医生' collate = utf8mb4_unicode_ci;

-- 手术表
create table if not exists surgery
(
    id             bigint auto_increment comment 'id' primary key,
    patientId      bigint                                 not null comment '患者id',
    doctorId       bigint                                 not null comment '医生id',
    name           varchar(50)                            not null comment '手术名称',
    startTime      datetime                               not null comment '开始时间',
    duration       tinyint                                not null comment '手术时长',
    job            varchar(50)                            not null comment '医生工作(主刀)',
    medicalHistory varchar(256) default '无' comment '既往病史',
    chronicHistory varchar(256) default '无' comment '慢性病史',
    allergy        varchar(256) default '无' comment '药物过敏',
    reaction       varchar(256) default '无' comment '不良反应',
    evaluation     tinyint                                not null comment '术前评估,1-无风险 2-低风险 3-中风险 4-高风险',
    examination    tinyint                                not null comment '术前检查,1-合格 2-不合格',
    createTime     datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint      default 0                 not null comment '是否删除',
    foreign key (patientId) references patient (id),
-- TODO 更新关联表doctor
    foreign key (doctorId) references doctor (id)
) comment '手术' collate = utf8mb4_unicode_ci;

-- TODO 新增表
-- 管理者表
create table if not exists admin
(
    id         bigint auto_increment comment 'id' primary key,
    account    varchar(256)                       not null comment '账号',
    password   varchar(256)                       not null comment '密码',
    name       varchar(50)                        not null comment '姓名',
    phone      varchar(20)                        not null comment '联系方式',
    avatar     varchar(1024)                      null comment '头像',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
) comment '管理者' collate = utf8mb4_unicode_ci;


-- 挂号表
create table if not exists register
(
    id         bigint auto_increment comment 'id' primary key,
    patientId  bigint                             not null comment '关联患者id',
    deptId     bigint                             not null comment '关联科室id',
    type       tinyint  default 0                 not null comment '挂号类型,0-平诊 1-急诊',
    status     tinyint  default 0                 not null comment '就诊状态,0-未就诊 1-已就诊',
    fee        integer                            not null comment '挂号费',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    foreign key (patientId) references patient (id),
    foreign key (deptId) references department (id)
) comment '挂号' collate = utf16_unicode_ci;

-- 病房表
create table if not exists sickroom
(
    id         bigint auto_increment comment 'id' primary key,
    roomNo     integer                            not null comment '病房号',
    deptId     bigint                             not null comment '关联所属科室id',
    type       tinyint  default 0                 not null comment '0-普通病房，1-重症病房',
    roomNumber tinyint  default 6                 not null comment '病床数',
#     nurseId    bigint                             not null comment '护士id',
    nurse      varchar(50)                        not null comment '护士',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    foreign key (deptId) references department (id)
) comment '病房' collate = utf16_unicode_ci;

-- 床位表
create table if not exists sickbed
(
    id         bigint auto_increment comment 'id' primary key,
    bedNo      integer                            not null comment '床号',
    roomId     bigint                             not null comment '关联病房id',
    status     tinyint                            not null comment '状态 0-未启用 1-启用',
    patient    varchar(20)                        null comment '患者名称',
    illness    varchar(20)                        null comment '患者病情',
    days       integer                            null comment '住院天数',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除',
    foreign key (roomId) references sickroom (id)
) comment '床位' collate = utf16_unicode_ci;

insert into department (id, dept)
values (1, '牙体牙髓科'),
       (2, '牙周科'),
       (3, '牙槽外科'),
       (4, '口腔修复科'),
       (5, '口腔正畸科'),
       (6, '口腔颌面外科'),
       (7, '颞下颌关节科'),
       (8, '正颌美容科'),
       (9, '口腔种植科'),
       (10, '口腔黏膜科');

-- 默认账号 doctor 123456 md5加密
insert into doctor (id, account, password, name, age, birthday, gender, phone, job, avatar, photo, profile, deptId,
                    office)
VALUES (1, 'doctor', 'e10adc3949ba59abbe56e057f20f883e', '张三', 37, '1986-10-17', '男', 133333333333,
        '主任医师', null, null,
        '口腔全科医生，掌握口腔医学各学科知识与基本能力，擅长牙体牙髓常见病疑难病诊断治疗,显微根管治疗,牙齿美白美容修复。',
        1, 'H1-505');

-- 默认账号 admin 123456 md5加密
insert into admin (id, account, password, name, phone, avatar)
VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '张三', 133333333333, null);

insert into patient (id, name, gender, age, phone, blood, ssCard)
values (1, '李四', '男', 25, 13222222222, 'B', '1140001140001');

insert into surgery (id, patientId, doctorId, name, startTime, duration, job, evaluation, examination)
values (1, 1, 1, '口腔内肿瘤手术', '2023-10-17 12:00:00', 5, '主刀', 3, 1)
ON DUPLICATE KEY UPDATE patientId = 1;


-- 挂号内容
insert into register (id, patientId, deptId, type, status, fee)
values (1, 1, 1, 0, 0, 10);

insert into sickroom (id, roomNo, deptId, type, roomNumber, nurse)
values (1, 501, 1, 0, 6, '吴芳');

insert into sickbed (id, bedNo, roomId, status, patient, illness, days)
values (1, 1, 1, 1, '张三', '口腔溃疡', 5);