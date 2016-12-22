/*
CREATE TABLE developers(
dev_id INT NOT NULL PRIMARY KEY,
dev_name VARCHAR(60) NOT NULL,
dev_salary  INT
);
CREATE TABLE skills(
sk_id INT NOT NULL PRIMARY KEY,
sk_name VARCHAR(60) NOT NULL
);
CREATE TABLE projects(
pj_id INT NOT NULL PRIMARY KEY,
pj_name VARCHAR(60) NOT NULL,
pj_desc VARCHAR(100),
pj_cost INT
);
CREATE TABLE company(
com_id INT NOT NULL PRIMARY KEY,
com_name VARCHAR(60) NOT NULL
);
CREATE TABLE customers(
customer_id SMALLINT NOT NULL PRIMARY KEY,
customer_name VARCHAR(60) NOT NULL
);

CREATE TABLE customers_pj(
pj_id INT NOT NULL,
customer_id SMALLINT NOT NULL,
FOREIGN KEY (pj_id) REFERENCES projects(pj_id),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE TABLE com_pj(
pj_id INT NOT NULL,
com_id INT NOT NULL,
FOREIGN KEY (pj_id) REFERENCES projects(pj_id),
FOREIGN KEY (com_id)REFERENCES company(com_id)
);
CREATE TABLE com_dev(
com_id INT NOT NULL,
dev_id INT NOT NULL,
FOREIGN KEY (com_id) REFERENCES company(com_id),
FOREIGN KEY(dev_id) REFERENCES developers(dev_id)
);
CREATE TABLE dev_skills (
sk_id INT NOT NULL,
dev_id INT NOT NULL,
FOREIGN KEY (sk_id) REFERENCES skills(sk_id),
FOREIGN KEY(dev_id) REFERENCES developers(dev_id)
);
CREATE TABLE dev_pj (
pj_id INT NOT NULL,
dev_id INT NOT NULL,
FOREIGN KEY (pj_id) REFERENCES projects(pj_id),
FOREIGN KEY (dev_id) REFERENCES developers(dev_id);

CREATE TABLE TEST_TABLE(
test_id INT NOT NULL PRIMARY KEY,
test_name VARCHAR(60) NOT NULL
);

*/