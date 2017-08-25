use nippou_chan_db;


/*管理者フラグの追加*/
alter table users add column user_flag boolean not null;

/*フラグのデータを更新*/
update users set user_flag=0;

/*管理者アカウントの追加*/
insert into users values('admin','管理者','カンリシャ','$2a$08$ApLN5lJK2PD40cBFnHkmvOXPvSRQz5.mnhm.dttVSVcUxfFX1Shx6','cds2017f@unirita.co.jp',1);

-- 研修内容、学んだこと、困ったことのnot nullを解約 --
alter table nippou modify column nippou_contents text;
alter table nippou modify column nippou_study varchar(3000);
alter table nippou modify column nippou_problem varchar(3000);
