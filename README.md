# Fullstack Task App

A Fullstack Task App that uses:

- [Postgres](https://www.postgresql.org/) for `db`
- [Spring Boot](https://spring.io/projects/spring-boot) for `backend`
- [Vue.js](https://vuejs.org/) for `frontend`
- [Docker Compose](https://docs.docker.com/compose/) to glue it all together

## One-Time Setup

1. Install [Docker](https://docs.docker.com/get-docker/)
1. Copy file `.env.sample` to new file `.env`

## Run It

1. Build images and up containers

        docker-compose up --build

1. Navigate to the `frontend` via [`http://localhost:9999`](http://localhost:9999)

## Hot Reloading

Java is a compiled language, so changes to the `backend` require a `build` and `up` to be reloaded.

JavaScript is an interpreted language (in this context), so changes to the `frontend` are hot reloaded via [Docker Compose Volumes](https://docs.docker.com/compose/compose-file/compose-file-v3/#volumes) and the [Vue CLI `serve` command](https://cli.vuejs.org/guide/cli-service.html#using-the-binary).

## For Fun Tasks

### Run The `backend` Locally

<details>
<summary>Steps</summary>

1. Install [Java](https://adoptopenjdk.net/) version 11 or higher
1. Up the `db` in detached mode

        docker-compose up --build -d db

1. Navigate to the `backend`

        cd backend

1. Copy file `.env.sample` to new file `.env.local`
1. Source environment variables in your shell

        source task_setenv.sh

1. Run the `backend` locally. This uses the included [gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)

        ./gradlew bootRun

</details>

### Run The `frontend` Locally

<details>
<summary>Steps</summary>

1. Install [Node.js](https://nodejs.org/en/download/) version 14 or higher
1. Up the `db` and `backend` in detached mode

        docker-compose up --build -d db backend

1. Navigate to the `frontend`

        cd frontend

1. Download dependencies

        npm install

1. Run the `frontend` locally

        npm run serve -- --port 9999

</details>

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
