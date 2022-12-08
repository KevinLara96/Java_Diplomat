@echo off
call mvn clean package
call docker build -t unam.dgtic.diplomado/proyecto-final .
call docker rm -f proyecto-final
call docker run -d -p 9080:9080 -p 9443:9443 --name proyecto-final unam.dgtic.diplomado/proyecto-final