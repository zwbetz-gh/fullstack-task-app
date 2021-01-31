#!/usr/bin/env bash

DOTENV=.env.local

# Show env vars
grep -v '^#' ${DOTENV}

# Export env vars
set -o allexport
source ${DOTENV}
set +o allexport
