# Service One

## A sample Spring Boot application

This is a microservice which exposes the REST endpoint:

`GET /handle/{value}`

The input value is forwarded to another REST endpoint `GET /handle/{value}` whose base URL is specified using the environment variable `other-service.base-url`.

