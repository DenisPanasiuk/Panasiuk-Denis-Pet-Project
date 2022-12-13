-- Creating database --

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(30),
    surname VARCHAR(30),
    sex VARCHAR(30),
    course VARCHAR(30)
)
ENGINE = InnoDB;

CREATE TABLE roles(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL
)
    ENGINE = InnoDB;

CREATE TABLE user_roles(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (user_id) REFERENCES users(id),

    UNIQUE (user_id, role_id)
)
    ENGINE = InnoDB;

CREATE TABLE marks(
    student_id INT NOT NULL,
    math INT,
    history INT,
    biology INT,
    english INT,
    geography INT,
    chemistry INT,
    FOREIGN KEY (student_id) REFERENCES users(id)
)
    ENGINE = InnoDB;

-- Insert data --

INSERT INTO users VALUES (1, 'Admin', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', 'Admin', 'Admin', 'm', '1');
# admin password is '12345678'
INSERT INTO users VALUES (2, 'DenisPanasiuk', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', 'Denis', 'Panasiuk', 'm', '4');
# user password is '12345678'

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1,2);
INSERT INTO user_roles VALUES (2,1);

insert marks values (2, 10, 9, 11, 3, 5, 10);