SET ROLE tq_admin;

CREATE TABLE IF NOT EXISTS public.properties (
  id 	BIGINT NOT NULL,
  _key 	TEXT NOT NULL,
  _val	TEXT NOT NULL
);


CREATE UNIQUE INDEX IF NOT EXISTS properties_idx ON public.properties (id);
