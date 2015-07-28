-- Table: job_control

DROP TABLE job_control;

CREATE TABLE job_control
(
  job_seq_id VARCHAR2(10) NOT NULL,
  job_app_cd VARCHAR2(10),
  job_arg_nm1 VARCHAR2(100),
  job_arg_nm2 VARCHAR2(100),
  job_arg_nm3 VARCHAR2(100),
  job_arg_nm4 VARCHAR2(100),
  job_arg_nm5 VARCHAR2(100),
  job_arg_nm6 VARCHAR2(100),
  job_arg_nm7 VARCHAR2(100),
  job_arg_nm8 VARCHAR2(100),
  job_arg_nm9 VARCHAR2(100),
  job_arg_nm10 VARCHAR2(100),
  job_arg_nm11 VARCHAR2(100),
  job_arg_nm12 VARCHAR2(100),
  job_arg_nm13 VARCHAR2(100),
  job_arg_nm14 VARCHAR2(100),
  job_arg_nm15 VARCHAR2(100),
  job_arg_nm16 VARCHAR2(100),
  job_arg_nm17 VARCHAR2(100),
  job_arg_nm18 VARCHAR2(100),
  job_arg_nm19 VARCHAR2(100),
  job_arg_nm20 VARCHAR2(100),
  blogic_app_status VARCHAR2(10),
  cur_app_status VARCHAR2(1),
  add_date_time timestamp,
  upd_date_time timestamp,
  CONSTRAINT pk_job_control PRIMARY KEY (job_seq_id)
);

quit;

