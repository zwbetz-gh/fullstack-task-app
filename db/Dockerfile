FROM postgres:13.1

# Make special dir, which postgres knows to read from
RUN mkdir -p /docker-entrypoint-initdb.d/

# Copy init script, which postgres knows to run on startup 
COPY init-db.sh /docker-entrypoint-initdb.d/
