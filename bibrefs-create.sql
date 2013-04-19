create table bib_ref (
  id                        integer not null,
  shorthand                 varchar(255),
  type                      varchar(255),
  constraint pk_bib_ref primary key (id))
;

create table ref_key (
  id                        integer not null,
  bibref_id                 integer,
  key                       varchar(255),
  constraint pk_ref_key primary key (id))
;

create sequence bib_ref_seq;

create sequence ref_key_seq;

alter table ref_key add constraint fk_ref_key_bibref_1 foreign key (bibref_id) references bib_ref (id) on delete restrict on update restrict;
create index ix_ref_key_bibref_1 on ref_key (bibref_id);


