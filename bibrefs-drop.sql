SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists bib_ref;

drop table if exists ref_key;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists bib_ref_seq;

drop sequence if exists ref_key_seq;

