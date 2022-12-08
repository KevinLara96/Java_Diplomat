#!/bin/sh
if [ $(docker ps -a -f name=proyecto-final | grep -w proyecto-final | wc -l) -eq 1 ]; then
  docker rm -f proyecto-final
fi
mvn clean package && docker build -t unam.dgtic.diplomado/proyecto-final .
docker run -d -p 9080:9080 -p 9443:9443 --name proyecto-final unam.dgtic.diplomado/proyecto-final
