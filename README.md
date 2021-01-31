# Fullstack Task App

A Fullstack Task App that uses [Postgres](https://www.postgresql.org/) for `db`, [Spring Boot](https://spring.io/projects/spring-boot) for `backend`, [Vue.js](https://vuejs.org/) for `frontend`, and [Docker Compose](https://docs.docker.com/compose/) to glue it all together.

## One-Time Setup

1. Install [Docker](https://docs.docker.com/get-docker/)
1. Copy file `.env.sample` to new file `.env`. The default values work well, but feel free to change them if desired

## Run It

1. Build images and up containers

        docker-compose up --build

1. Navigate to the `frontend` via [`http://localhost:9999`](http://localhost:9999)

## Hot Reloading

Java is a compiled language, so changes to the `backend` require a `build` and `up` (or a `up --build backend`) to be reloaded.

JavaScript is _generally_ an interpreted language, so changes to the `frontend` are hot reloaded via [Docker Compose Volumes](https://docs.docker.com/compose/compose-file/compose-file-v3/#volumes) and the [Vue CLI `serve` command](https://cli.vuejs.org/guide/cli-service.html#using-the-binary).

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
