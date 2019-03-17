# H2Sample
This is a sample project for show the possibilities of Spring Boot and H2 database.

## Build
The project is configured for Maven and can build with `mvn package`. If maven is not installed, you can use
`mvnw package` to get maven online.

The build works for Java 1.8+

## Run
The result is a standalone jar for executing the application server. Just run `java -jar /target/h2sample.jar`.  

## Program
After start of the application the job will fill the H2 database with
sample data. You can open the statistic in your browser: `http://localhost:8080`

## Database
For query the database you can open the url `http://localhost:8080` in your browser.

For file based database please use this jdbc url: `jdbc:h2:file:./h2sample`


## Getting Started

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

