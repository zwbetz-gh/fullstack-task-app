FROM gradle:6.7.1-jdk11

# Set workdir
WORKDIR /app

# Copy dependency-related files
COPY build.gradle settings.gradle ./

# Download dependencies. Eat expected build failure since no source code has been copied yet. (This is a limitation of gradle)
RUN gradle build --no-daemon > /dev/null 2>&1 || true

# Copy all files
COPY ./ ./

# Build it
RUN gradle build --no-daemon

# List it
RUN ls -alt build/libs/

# Serve it
CMD gradle bootRun --no-daemon

# Run it
# CMD java -jar build/libs/fullstacktaskapp-0.0.1-SNAPSHOT.jar
