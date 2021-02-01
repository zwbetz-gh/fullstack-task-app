FROM gradle:6.7.1-jdk11

# Set workdir
WORKDIR /app

# Copy dependency-related files
COPY build.gradle settings.gradle ./

# Download dependencies. Eat expected build failure since no source code has been copied yet. (This is a limitation of gradle)
RUN gradle --no-daemon build > /dev/null 2>&1 || true

# Copy all files
COPY ./ ./

# Serve it
CMD gradle --no-daemon bootRun
