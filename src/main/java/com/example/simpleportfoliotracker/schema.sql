drop database simplePortfolioTracker;
create database simplePortfolioTracker;

use simplePortfolioTracker;

create table if not exists users
(
    username varchar(64)  not null primary key ,
    password varchar(256) not null,
    email    varchar(64)  not null,
    roles    varchar(64)  not null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO simplePortfolioTracker.users (username, password, email, roles)
VALUES ('fooo', 'fooo@123', 'foo@email.com', 'ROLE_USER');
INSERT INTO simplePortfolioTracker.users (username, password, email, roles)
VALUES ('emily', 'emily@123', 'emily@email.com', 'ROLE_USER');
INSERT INTO simplePortfolioTracker.users (username, password, email, roles)
VALUES ('jane', 'jane@123', 'jane@email.com', 'ROLE_USER');

create table portfolio
(
    id bigint not null auto_increment primary key ,
    symbol  varchar(64) not null ,
    username   varchar(64) null, -- foreign key
    quantity   int,
    unit_price float,
    constraint fk_portfolio foreign key (username) references users (username)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('TSLA', 'fooo', 100, 420.69);

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('AMZN', 'fooo', 30, 1509.84);

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('AAPL', 'fooo', 150, 75.87);

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('MSFT', 'fooo', 200, 178.92);

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('PLTR', 'fooo', 12, 1100);

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('TSLA', 'emily', 30, 487.21);

INSERT INTO simplePortfolioTracker.portfolio (symbol, username, quantity, unit_price) VALUES ('MSFT', 'emily', 150, 150);
