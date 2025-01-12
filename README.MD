# Project Deployment Guide

## Prerequisites
- Docker
- Docker Compose

## Deployment with Docker Compose

1. **Build and start the services:**
```sh
  docker-compose up --build
  # or
  docker-compose up --build -d
```
2 **Access the application:**
    - Open POSTMAN and execute querys to `http://localhost:80/<endpoint-service>
3. **Access api documentation:**
    - Open browser and access `http://localhost:80/<endpoint-service>/api-docs

4. **Stop the services:**
    ```sh
   docker-compose down
   ```

 ## Deployment with Docker Swarm
1. **Initialize the swarm:**
   ```sh
   docker swarm init
   ```
2. **Build the images:**
   ```sh
    ./build.sh
    ```
3. **Build and start the services:**
   ```sh
    docker stack deploy -c docker-stack.yml <stack-name>
    ```
4. **Access the application:**
    - Open POSTMAN and execute querys to `http://localhost:80/<endpoint-service>
5. **Access api documentation:**
    - Open browser and access `http://localhost:80/<endpoint-service>/api-docs
   

