FROM postgres:12.1-alpine

ENV POSTGRES_PASSWORD password
COPY ./resources/setup_database.sql /docker-entrypoint-initdb.d/deployment_setup_database.sql
