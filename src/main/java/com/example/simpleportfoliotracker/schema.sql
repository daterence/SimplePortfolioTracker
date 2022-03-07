drop table if exists description;
drop table if exists portfolio;
drop table if exists user;

create table if not exists user
(
    username varchar(64)  not null primary key ,
    password varchar(256) not null,
    email    varchar(64)  not null,
    roles    varchar(64)  not null
    );

INSERT INTO simplePortfolioTracker.user (username, password, email, roles)
VALUES ('foo', 'foo', 'foo@email.com', 'ROLE_USER');
INSERT INTO simplePortfolioTracker.user (username, password, email, roles)
VALUES ('emily', 'emily', 'emily@email.com', 'ROLE_USER');
# INSERT INTO simplePortfolioTracker.user (username, password, email, roles)
# VALUES ('tom', 'tom', 'tom@email.com', 'ROLE_USER');
# INSERT INTO simplePortfolioTracker.user (username, password, email, roles)
# VALUES ('demo', 'demo', 'demo@email.com', 'ROLE_USER');

create table portfolio
(
    id int not null auto_increment primary key ,
    symbol     varchar(64) not null ,
    username   varchar(64) null, -- foreign key
    quantity   int,
    unit_price float,
    constraint fk_portfolio foreign key (username) references user (username)
);

# create table description (
#                              id int not null primary key , -- foreign key
#                              symbol varchar(64) not null ,
#                              url varchar(256) not null ,
#                              name varchar(64) not null ,
#                              exchange varchar(64) not null ,
#                              industry varchar(64) not null ,
#                              website varchar(256) not null,
#                              constraint fk_desc foreign key (id) references portfolio(id)
# );
