DROP TABLE IF EXISTS PROCESS;

CREATE TABLE PROCESS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  "position" VARCHAR(250) NOT NULL,
  maxSalary INT NOT NULL,
  location VARCHAR(250) DEFAULT NULL,
  technology VARCHAR(250) DEFAULT NULL,
  target INT NOT NULL,
  date VARCHAR(250) DEFAULT NULL,
  candidates_in_the_process INT NOT NULL
);