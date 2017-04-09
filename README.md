# Transation and Statistics API

## Prerequisites

knowledge of Java 1.8,H2 In-memory DB and Spring[4] Boot is required. 


### Overview

Exposing API for Transaction saving and statistics view
Used Java 1.8 with spring boot in combination with H2 In-memory DB for data storing.
Data Base state can be viewed using below URL
http://localhost:8080/console
username=sts
password=sts

API URLS
http://localhost:8080/statistics
http://localhost:8080/transactions
 
## Getting up and running locally

### System requirements

* Maven 3.x
* Java 1.8


### Steps

#### To Build

```
cd ~/git/statistics
mvn clean install
```

#### To Run

```
cd ~/git/statistics
java -Dspring.profiles.active=local -jar target/statistics-1.0.0.jar
```


