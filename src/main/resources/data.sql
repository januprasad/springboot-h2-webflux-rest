/*
CREATE TABLE employee (
                id SERIAL PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                code VARCHAR(255) NOT NULL
);

 */
truncate table employee;

INSERT INTO employee(`id`, `name`, `code`)
values (1, 'JK','H010'),
       (2, 'KP','H011'),
       (3, 'VR','H012'),
       (4, 'BT','H013');