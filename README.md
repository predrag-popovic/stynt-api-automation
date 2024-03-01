# Automation API Framework
## MAVEN - JAVA - JUNIT 4 - REST ASSURE

This framework example using JAVA programming language with integrated Rest Assure framework.
Automatic test used Rest Assure for executing junit tests and also this
framework have support for Allure report.

# New Features

- Supports POST, GET, PUT, DELETE, OPTIONS, PATCH and HEAD requests and can be used to validate and verify the response of these requests
- REST assured also supports several authentication schemes, for example OAuth, digest, certificate, form and preemptive basic authentication.
- Generate Allure report after test is finish

### Tech

Automation Basic Framework in order to work properly uses a number of dependencie:

* [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) - For Java Developers. Includes a complete JRE plus tools for developing, debugging, and monitoring Java applications.
* [RestAssure](https://rest-assured.io/) - Automation API framework.
* [Junit4](https://junit.org/junit4/) - JUnit is a simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.
* [Allure report](https://allurereport.org/) - Allure is designed to be agnostic of specific programming languages or testing frameworks.

### Installation

Automation Framework requires [Maven](https://maven.apache.org/download.cgi) v3.6.0+ to run.

Install the dependencies or put them in POM.xml file into your project:

```sh
Dependencies list:
[java JDK 17] - (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) v17.0.10+
[junit] - (https://mvnrepository.com/artifact/junit/junit) v4.12
[REST Assured] - (https://mvnrepository.com/artifact/io.rest-assured/rest-assured) v5.4.0+
[JSON Path] - (https://mvnrepository.com/artifact/io.rest-assured/json-path) v5.4.0+
[XML Path] - (https://mvnrepository.com/artifact/io.rest-assured/xml-path) v5.4.0+
[JSON Schema Validator] - (https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator) v5.4.0+
```
### Run API automation test

We can run this automation test on local machine or Jenkins build job

Command for execution all API automation tests:
```sh
mvn clean test
```
or 
```sh
mvn test
```
Command for execution single test:
```sh
mvn clean -Dtest=office_api_tests/officeUserLoginTest test
```

### Reports

This framework have one types of reports:

- Allure report

Reports is generate in root project folder. 

We need to setup on our OS allure command line to be able to generate report on local machine.

* [Allure command line](https://github.com/allure-framework/allure2/releases/tag/2.27.0) v2.27.0+

Unzip Allure command line in your root C disk and set a path to the bin folder in system PATH variable.

Command for generate report after tests are finished
```sh
allur generate --clean
```
Command for open Allure HTML report after we generate result
```sh
allur open
```
