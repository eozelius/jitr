CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  first_name varchar(50) NOT NULL,
  last_name varchar(100) NOT NULL,
  email varchar(80) NOT NULL
)
