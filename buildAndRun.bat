@echo off
call mvn clean package
call docker build -t co.mz/randomproject .
call docker rm -f randomproject
call docker run -d -p 8080:8080 -p 9990:9990 --name randomproject co.mz/randomproject