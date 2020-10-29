CREATE TABLE posts (
  id SERIAL PRIMARY KEY,
  title varchar(50) NOT NULL,
  body varchar(500) NOT NULL,
  user_id INTEGER NOT NULL REFERENCES users (id)
)