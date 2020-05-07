DROP TABLE IF EXISTS things;

CREATE TABLE things (
  thing_id SERIAL,
  thing_name varchar (20) NOT NULL,
  quantity integer NOT NULL,
  life_time float,
  date_added date,
  PRIMARY KEY (thing_id)
);

INSERT INTO things (thing_name, quantity, life_time) VALUES ('Milk', 2, 1.0);
SELECT * FROM things;