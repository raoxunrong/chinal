
    alter table city 
        drop 
        foreign key FK2E996B3D8DE699;

    alter table lendRecord 
        drop 
        foreign key FK6C574A2043B05F4F;

    alter table lendRecord 
        drop 
        foreign key FK6C574A2062F5EC0F;

    alter table loanCompany 
        drop 
        foreign key FK28E2A16D43B05F4F;

    alter table loanRecord 
        drop 
        foreign key FK192A96143B05F4F;

    alter table loanRecord 
        drop 
        foreign key FK192A96162F5EC0F;

    alter table news 
        drop 
        foreign key FK338AD34C807BA8;

    alter table news 
        drop 
        foreign key FK338AD3DED11908;

    alter table user 
        drop 
        foreign key FK36EBCB43B05F4F;

    drop table if exists admin;

    drop table if exists city;

    drop table if exists lendRecord;

    drop table if exists loanCompany;

    drop table if exists loanRecord;

    drop table if exists news;

    drop table if exists newsCategory;

    drop table if exists province;

    drop table if exists user;

    create table admin (
        adminID bigint not null auto_increment,
        loginName varchar(50) not null,
        plainPassword varchar(32),
        encrytedPassword varchar(255),
        name varchar(64) not null,
        email varchar(100),
        phone varchar(32),
        superAdmin boolean not null,
        primary key (adminID),
        unique (loginName)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table city (
        cityID bigint not null auto_increment,
        name varchar(50) not null,
        description varchar(255),
        provinceID bigint not null,
        primary key (cityID)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table lendRecord (
        lendRecordID bigint not null auto_increment,
        userID bigint not null,
        cityID bigint not null,
        money integer not null,
        allotedTime varchar(64) not null,
        applyDate datetime not null,
        extraInfo varchar(255),
        interestRate integer not null,
        primary key (lendRecordID)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table loanCompany (
        loanCompanyID bigint not null auto_increment,
        name varchar(50) not null,
        cityID bigint not null,
        description varchar(255),
        primary key (loanCompanyID)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table loanRecord (
        loanRecordID bigint not null auto_increment,
        userID bigint not null,
        cityID bigint not null,
        money integer not null,
        allotedTime varchar(64) not null,
        applyDate datetime not null,
        extraInfo varchar(255),
        interestRate integer not null,
        primary key (loanRecordID)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table news (
        newsID bigint not null auto_increment,
        title varchar(250) not null,
        content longtext not null,
        abstractContent varchar(500),
        originSource varchar(100),
        publishedTime datetime not null,
        categoryID bigint not null,
        hot boolean not null,
        publisherID bigint not null,
        primary key (newsID)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table newsCategory (
        categoryId bigint not null auto_increment,
        name varchar(50) not null,
        description varchar(255),
        primary key (categoryId),
        unique (name)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table province (
        provinceID bigint not null auto_increment,
        name varchar(50) not null,
        description varchar(255),
        primary key (provinceID),
        unique (name)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    create table user (
        userID bigint not null auto_increment,
        loginName varchar(50) not null,
        plainPassword varchar(32),
        encrytedPassword varchar(255),
        name varchar(64) not null,
        phone varchar(32) not null,
        email varchar(100),
        idCard varchar(32),
        cityID bigint not null,
        primary key (userID),
        unique (loginName)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

    alter table city 
        add index FK2E996B3D8DE699 (provinceID), 
        add constraint FK2E996B3D8DE699 
        foreign key (provinceID) 
        references province (provinceID);

    alter table lendRecord 
        add index FK6C574A2043B05F4F (cityID), 
        add constraint FK6C574A2043B05F4F 
        foreign key (cityID) 
        references city (cityID);

    alter table lendRecord 
        add index FK6C574A2062F5EC0F (userID), 
        add constraint FK6C574A2062F5EC0F 
        foreign key (userID) 
        references user (userID);

    alter table loanCompany 
        add index FK28E2A16D43B05F4F (cityID), 
        add constraint FK28E2A16D43B05F4F 
        foreign key (cityID) 
        references city (cityID);

    alter table loanRecord 
        add index FK192A96143B05F4F (cityID), 
        add constraint FK192A96143B05F4F 
        foreign key (cityID) 
        references city (cityID);

    alter table loanRecord 
        add index FK192A96162F5EC0F (userID), 
        add constraint FK192A96162F5EC0F 
        foreign key (userID) 
        references user (userID);

    alter table news 
        add index FK338AD34C807BA8 (categoryID), 
        add constraint FK338AD34C807BA8 
        foreign key (categoryID) 
        references newsCategory (categoryId);

    alter table news 
        add index FK338AD3DED11908 (publisherID), 
        add constraint FK338AD3DED11908 
        foreign key (publisherID) 
        references admin (adminID);

    alter table user 
        add index FK36EBCB43B05F4F (cityID), 
        add constraint FK36EBCB43B05F4F 
        foreign key (cityID) 
        references city (cityID);
