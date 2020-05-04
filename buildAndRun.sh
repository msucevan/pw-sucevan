#!/bin/sh
mvn clean package && docker build -t com.mycompany/sdsad .
docker rm -f sdsad || true && docker run -d -p 8080:8080 -p 4848:4848 --name sdsad com.mycompany/sdsad 
