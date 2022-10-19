#!/bin/sh
mvn clean package && docker build -t unam.dgtic.core/practica1 .
docker rm -f practica1 || true && docker run -d -p 8080:8080 -p 4848:4848 --name practica1 unam.dgtic.core/practica1 
