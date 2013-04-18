create table bib_ref (
  id                        varchar(255) not null,
  type                      varchar(255),
  constraint pk_bib_ref primary key (id))
;

create sequence bib_ref_seq;



