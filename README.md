# stableAPI

## Supported versions:
- Java 8 to 17
- MongoDB server 5.0 and up
- MongoDB Java Driver 4.4.1
- Maven 3.8.4

## Quick Start 
1. Start a local MongoDB instance.  If you have yet to install Mongo on your machine use the following [instructions](https://docs.mongodb.com/guides/server/install/).
2. Clone this repo<br>
    <code>git clone https://github.com/scottcapista/stableAPI.git</code>
3. Move to project directory<br>
    <code>cd stableAPI</code>
4. Start the spring boot application.  Server will start on localhost:8081.<br>
    <code>mvn spring-boot:run</code>
5. Use Postman by importing the below link as a collection. 
    https://www.getpostman.com/collections/9ff71190f9ebb13add48

## Results
Stable API has to be defined when instantiating the java driver so that connections established from the client are in the pool of active connections.  This can not be overridden at the time of performing a CRUD operation so any customer using the stable API will have to instantiate two client instances with seperate connection pools.
