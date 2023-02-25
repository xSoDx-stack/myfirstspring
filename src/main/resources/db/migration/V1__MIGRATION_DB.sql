create table todo_entity (
    id uuid not null,
    title varchar(255),
    completed boolean,
    user_id uuid,
    primary key (id)
                                    )
create table user_entity (
        id uuid not null,
        password varchar(255),
        user_email varchar(255),
        username varchar(255),
        primary key (id)
                                        )
alter table if exists todo_entity
            add constraint FKf9ejdcjqxblhqgf1kgkuyry9s
            foreign key (user_id)
            references user_entity