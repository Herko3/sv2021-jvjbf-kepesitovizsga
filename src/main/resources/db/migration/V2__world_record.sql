create table world_record(
    id bigint auto_increment,
    description varchar(255) not null,
    value double,
    unit_of_measure varchar(20) not null,
    date_of_record date,
    recorder_id bigint,
    primary key (id),
    foreign key (recorder_id) references recorder(id)
)