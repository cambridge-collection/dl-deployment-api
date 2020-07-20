drop table IF EXISTS currentversions;

create table currentversions(
    instanceid varchar unique not null,
    version varchar not null,
    url varchar not null,
    displayorder int,
    primary key (instanceid)
);

-- NOTE: to test on localhost use
-- docker network inspect bridge --format='{{( index .IPAM.Config 0).Gateway}}'
-- to find localhost host ip
-- In later versions should be 'host.docker.internal'
-- URL is used to find status info at url+/data/status for the deployment process

-- Insert test instances
insert into currentversions (instanceid, version, url, displayorder)
values ('dev', 'this-data-version-1', 'http://172.17.0.1:8080/', 1);

--insert into currentversions (instanceid, version, url, displayorder)
--values ('staging', 'this-data-version-1', 'http://thisone-staging.ac.uk', 1);

--insert into currentversions (instanceid, version, url, displayorder)
--values ('live', 'this-data-version-1', 'http://thisone-live.ac.uk', 1);
