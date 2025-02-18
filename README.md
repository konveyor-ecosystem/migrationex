# Simple Library

A simple **Java 8-based** web application that allows users to manage a collection of books.

## Features
- **View all books** 
- **Add new books**
- **Find books by title**
- **Delete books**

## 1. Prerequisites
Make sure you have:
- **Java 8** (Ensure `java -version` outputs Java 8)
- **Apache Tomcat 9+** that uses java 8 
- **Maven 3+** (Ensure `mvn -version` works)

## 2. Build the Application

Compile and package the WAR:

```sh 
mvn clean package
```

## 3. Deploy to Tomcat

Copy the generated WAR file to Tomcat:
```
cp target/migrationex-0.0.1-SNAPSHOT.war $TOMCAT_HOME/webapps/migrationex.war
```
Restart Tomcat:
```
$TOMCAT_HOME/bin/shutdown.sh
$TOMCAT_HOME/bin/startup.sh
```

## 4. Usage

Open a browser:

```
http://localhost:8080/migrationex
```
