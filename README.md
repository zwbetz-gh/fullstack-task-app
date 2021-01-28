# Fullstack Task App

## One-Time Setup

1. Install [Docker](https://docs.docker.com/get-docker/)

## Run It

Substitute `SERVICE` with one of: `db` | `backend` | `frontend`

1. Build images and up containers in detached mode

        docker-compose up --build -d

1. Check status

        docker-compose ps

1. View logs

        docker-compose logs -f SERVICE

1. Navigate to TODO

## Various Tasks

### Connect To The Database Server Via psql

1. Run a shell inside the container

        docker-compose run db bash

1. Connect to the database server

        PGPASSWORD=postgres psql -h db -p 5432 -U postgres

1. Connect to the database

        \c task_db

1. Describe a table

        \d task_schema.task

1. Run a query

        select * from task_schema.task;

1. Quit psql

        \q

1. Exit the container

        exit

### Hit Swagger

TODO
