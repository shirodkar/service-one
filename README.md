# Service One

## A sample Spring Boot application

This is a microservice which exposes a REST endpoint:

`GET /handle/{value}`

The input value is forwarded to another endpoint that is specified using the environment variable `other-service.base-url`

