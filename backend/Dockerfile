FROM gradle:6.7.1-jdk11

WORKDIR /app

# Only copy dependency-related files
COPY build.gradle settings.gradle /app/

# Only download dependencies. Eat expected build failure since no source code has been copied yet
RUN gradle build > /dev/null 2>&1 || true

# Copy all files
COPY . /app/

# Build it
RUN gradle build

# List it
RUN ls -alt build/libs/

# Run it
CMD java -jar build/libs/fullstacktaskapp-0.0.1-SNAPSHOT.jar
