
create table test_questions (
question_id int4 primary key not null unique,
question_text varchar);

create table test_answers (
answer_id int4 primary key not null unique,
answer_text varchar,
answer_iscorrect boolean,
q_id int4);

alter table test_answers add constraint answers_fk foreign key (q_id) references test_questions(question_id);

create table tests (
test_id int4 primary key not null unique,
test_name varchar);

alter table test_questions add test_id int4;
alter table test_questions add constraint questions_fk foreign key (test_id) references tests(test_id);