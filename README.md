# Fullstack Task App

## One-Time Setup

1. Install [Docker](https://docs.docker.com/get-docker/)
1. Copy file `.env.sample` to new file `.env`. The default values work well, but feel free to change them if desired

## Run It

1. Build images and up containers

        docker-compose up --build

1. Navigate to [`http://localhost:9999`](http://localhost:9999)

## For Fun Tasks

### Connect To The Database Server Via psql

<details>
<summary>Steps</summary>

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

</details>

### Hit Swagger

<details>
<summary>Steps</summary>

TODO

</details>
