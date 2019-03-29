# KnowledgeManagement


The knowledge management application is based on the value of **Sharing** in the companies specialized in IT. 

The application offers a platform where the employees can share the anomalies and hurdles they meet, and they can not find a solution, or they have already found the solution, and they want to share it with their colleagues. 

The difference between StackOverFlow (Or any others platform) and this application is that KnowledgeManagement is dedicated to the internal framework of companies and different internal products that use APIs and Libraries developed in the internal scale. 

In that way you can give and get a hand in a more **efficient** and secured way (You don't have to put your source code on the internet) ;)

This repository contain the Backend part of the application

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


### Prerequisites

To install and run this project you need as requirements:

* [Java JDK and JRE](https://www.java.com/fr/download/) - Java 8 or a Higher version
* [Maven](https://maven.apache.org/) - Maven 2 or a Higher version


### Setting up

To download the project, clone it from github using the next command:

```
$ git clone https://github.com/jradbayrem/KnowledgeManagement.git
```


## Running the tests

Navigate to the project directory and use the next command:

```
$ mvn test 
```

## Installing

To install the project use the next command:

```
$ mvn install
```

## Running

To run the project use the next command:

```
$ mvn spring-boot:run
```

## Technologies

* [Java EE](https://www.oracle.com/technetwork/java/javaee/overview/index.html) - The web framework used
* [Spring Boot](https://spring.io/projects/spring-boot) - The framework used for Microservice Architecture
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - The framework used in the persistence Layer
* [Spring WebService](https://spring.io/projects/spring-ws) - The framework used in the Rest Controller Layer
* [JUnit](https://junit.org/junit5/) - The framework used in the unit test
* [Mockito](https://site.mockito.org/) - The framework used in the unit test
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Jrad Bayrem** - *Initial work* - [JradBayrem](https://github.com/jradbayrem)

## License

This project is licensed under the MIT License.
