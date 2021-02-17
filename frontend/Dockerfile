FROM node:14.15.4-alpine3.10

# Set workdir
WORKDIR /app

# Copy dependency-related files
COPY package*.json ./

# Download dependencies
RUN npm install

# Copy all files
COPY ./ ./

# Serve it
CMD npm run start | cat
