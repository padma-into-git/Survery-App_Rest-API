create table survey_master
(
  id integer not null,
  survey_subject varchar(100) not null,
  active boolean,
  created_by varchar(50),
  created_at timestamp,
  updated_by varchar(50),
  updated_at timestamp,
  
  primary key(id)
);

create table survey_question_master
(
  id integer not null,
  question_description varchar(250) not null,
  active boolean,
  created_by varchar(50),
  created_at timestamp,
  updated_by varchar(50),
  updated_at timestamp,
  
  primary key(id)
);

create table survey_answer_master
(
  id integer not null,
  answer_description varchar(250) not null,
  active boolean,
  created_by varchar(50),
  created_at timestamp,
  updated_by varchar(50),
  updated_at timestamp,
  
  primary key(id)
);

create table survey_question_answer_mapping
(
  id integer not null,
  survey_id integer not null,
  question_id integer not null,
  answer_id integer not null,
  active boolean,
  created_by varchar(50),
  created_at timestamp,
  updated_by varchar(50),
  updated_at timestamp,
  
  primary key(id),
    CONSTRAINT FK_MAP_SURVEY_ID FOREIGN KEY (map_survey_id) REFERENCES survey_master(id),
  	CONSTRAINT FK_MAP_QUESTION_ID FOREIGN KEY (map_question_id) REFERENCES survey_question_master(id),
    CONSTRAINT FK_MAP_ANSWER_ID FOREIGN KEY (map_answer_id) REFERENCES survey_answer_master(id)
);

create table survey_response
(
  id integer not null,
  survey_id integer not null,
  question_id integer not null,
  answer_id integer not null,
  survey_date timestamp,
  
  primary key(id) ,
    CONSTRAINT FK_RESPONSE_SURVEY_ID FOREIGN KEY (response_survey_id) REFERENCES survey_master(id),
    CONSTRAINT FK_RESPONSE_QUESTION_ID FOREIGN KEY (response_question_id) REFERENCES survey_question_master(id),
    CONSTRAINT FK_RESPONSE_ANSWER_ID FOREIGN KEY (response_answer_id) REFERENCES survey_answer_master(id)
   
);
