#!/bin/bash

cd /home/daniel/workspace/microservices/javabrainsmicroservices/discovery-server
mvn spring-boot:run &

cd /home/daniel/workspace/microservices/javabrainsmicroservices/movie-catalog-service
mvn spring-boot:run &

cd /home/daniel/workspace/microservices/javabrainsmicroservices/movie-info-service
mvn spring-boot:run &

cd /home/daniel/workspace/microservices/javabrainsmicroservices/rating-data-service
mvn spring-boot:run &
