drop table MSG_MODEL cascade constraints;

drop sequence SEQ_MSG_CODE;

create sequence SEQ_MSG_CODE
start with 1
increment by 1;

create table MSG_MODEL 
(
   ID                   NUMBER(14)           not null,
   MSG_TYPE             NUMBER(2),
   MSG_CODE             NUMBER(10),
   MSG_NAME             VARCHAR2(20),
   SEND_MODE            NUMBER(1),
   RECIPIENT_TYPE       NUMBER(1),
   MSG_CONTENT          VARCHAR2(500),
   OPT_TIME             DATE,
   OPT_USER             VARCHAR2(20),
   STATE                NUMBER(1),
   constraint PK_MSG_MODEL primary key (ID)
);

comment on table MSG_MODEL is
'消息模板表';

comment on column MSG_MODEL.MSG_TYPE is
'消息类型(业务变更:1 其他待定)';

comment on column MSG_MODEL.MSG_CODE is
'消息编码';

comment on column MSG_MODEL.MSG_NAME is
'消息名称';

comment on column MSG_MODEL.SEND_MODE is
'发送方式(1.系统消息 2.邮件 3.短信)';

comment on column MSG_MODEL.RECIPIENT_TYPE is
'接收人类型(1.客户 2.销售 3.坐席)';

comment on column MSG_MODEL.MSG_CONTENT is
'消息内容';

comment on column MSG_MODEL.OPT_TIME is
'操作时间';

comment on column MSG_MODEL.OPT_USER is
'操作人';

comment on column MSG_MODEL.STATE is
'状态(0,不可用 1.可用)';
