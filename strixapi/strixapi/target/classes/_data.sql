    create table title (
       id bigint generated by default as identity,
        status varchar(30),
        title varchar(255),
        primary key (id)
    );

INSERT INTO TITLE (title, status)
VALUES ('Game of Thrones', 'Finalizado');
