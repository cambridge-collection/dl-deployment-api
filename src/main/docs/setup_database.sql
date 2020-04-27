drop table currentversions;

create table currentversions(
    instanceid varchar unique not null,
    version varchar not null,
    url varchar not null,
    displayorder int,
    primary key (instanceid)
);

-- Insert test instances
insert into currentversions (instanceid, version, url, displayorder)
values ('dev', 'this-data-version-1', 'http://thisone-dev.ac.uk', 1)

insert into currentversions (instanceid, version, url, displayorder)
values ('staging', 'this-data-version-1', 'http://thisone-staging.ac.uk', 1)

insert into currentversions (instanceid, version, url, displayorder)
values ('live', 'this-data-version-1', 'http://thisone-live.ac.uk', 1)
