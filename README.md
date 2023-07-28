# Backend challenge project implementation

https://github.com/mraqkhan/backend-challenge
# Scope
Use common libraries (for DI, networking etc.) to structure your app.
Get location data from https://payback-coding-challenge.s3.eu-central-1.amazonaws.com/germany.json
Parse location and search query from request parameters (use 0,0 if not provided).
Filter the list based on the search string and return the list of places sorted by distance from the location.
List items show the name of an item, the address and the distance to the current location.
Write a unit test for one component of the application.
# What was done
I created a Spring Boot WebFlux service that has one endpoint /place which takes dynamically parameters so you can pass location and the filtering parameters to be searched of the places list.
The architecture of the service is as follows

```
Service ---> Repository ---> Data Source
```
**Service** uses **PlaceFilter** to filter out the items.
I created a unit test for the filtering part of the service.
# Why not everything was done?
It took me 3 hours to create that service and I think that's enough for showing the skills.
That kind of interview code creation after the interview shouldn't take more than 2 hours at max.
# License
As a reminder, you are not allowed to use that code in any kind of the applications, either internal/external, commercial or uncommercial.
That service was created only for interview process.
# Documentation
[Getting Started with Spring WebFlux](https://www.springcloud.io/post/2022-03/getting-started-with-spring-webflux/#gsc.tab=0)

[Spring Reactive RESTFull Service with WebFlux](https://spring.io/guides/gs/reactive-rest-service/)
