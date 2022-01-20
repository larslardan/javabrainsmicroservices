#!/bin/bash

java -jar discovery-server-0.0.1-SNAPSHOT.jar &
java -jar movie-catalog-service-0.0.1-SNAPSHOT.jar &
java -jar movie-info-service-0.0.1-SNAPSHOT.jar &
java -jar rating-data-service-0.0.1-SNAPSHOT.jar &
