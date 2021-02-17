# Fullstack Task App

A Fullstack Task App that uses [Postgres](https://www.postgresql.org/) for `db`, [Spring Boot](https://spring.io/projects/spring-boot) for `backend`, [React](https://reactjs.org/) for `frontend`, and [Docker Compose](https://docs.docker.com/compose/) to glue it all together.

## Table of Contents

<!-- toc -->

- [One-Time Setup](#one-time-setup)
- [Run Everything With Docker Compose](#run-everything-with-docker-compose)
- [Hot Reloading](#hot-reloading)
- [Run The `backend` Locally](#run-the-backend-locally)
- [Run The `frontend` Locally](#run-the-frontend-locally)
- [Connect To The Database Server Via psql](#connect-to-the-database-server-via-psql)

<!-- tocstop -->

## One-Time Setup

1. Install [Docker](https://docs.docker.com/get-docker/)
1. Copy file `.env.sample` to new file `.env`

## Run Everything With Docker Compose

1. Build images and up containers

        docker-compose up --build

1. Navigate to the `frontend` via [`http://localhost:7777`](http://localhost:7777)

## Hot Reloading

Java is a compiled language, so changes to the `backend` require a `build` and `up` to be reloaded.

JavaScript is an interpreted language (in this context), so changes to the `frontend` are hot reloaded via Docker Compose [Volumes](https://docs.docker.com/compose/compose-file/compose-file-v3/#volumes) and the Create React App [start script](https://create-react-app.dev/docs/getting-started#npm-start-or-yarn-start).

## Run The `backend` Locally

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

## Run The `frontend` Locally

1. Install [Node.js](https://nodejs.org/en/download/) version 14 or higher
1. Up the `db` and `backend` in detached mode

        docker-compose up --build -d db backend

1. Navigate to the `frontend`

        cd frontend

1. Copy file `.env.sample` to new file `.env.local`
1. Download dependencies

        npm install

1. Run the `frontend` locally

        npm run start

## Connect To The Database Server Via psql

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
