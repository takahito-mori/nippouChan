use nippou_chan_db;

/*学んだことのカラムを追加*/
alter table nippou add column nippou_study varchar(3000) not null;
/*困ったことのカラムを追加*/
alter table nippou add column nippou_problem varchar(3000) not null;

/*カラムに内容を追加*/
update nippou set nippou_study="学んだ1！" where nippou_id='1';
update nippou set nippou_study="学んだ2！" where nippou_id='2';
update nippou set nippou_problem="困った1！" where nippou_id='1';
update nippou set nippou_problem="困った2！" where nippou_id='2';