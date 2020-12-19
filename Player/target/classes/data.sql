CREATE TABLE IF NOT EXISTS player (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  type VARCHAR(50) NOT NULL
);

create sequence IF NOT EXISTS player_seq;