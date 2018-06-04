# File Storage Service using Spring Boot

[![Build Status](https://travis-ci.org/javierseixas/file-storage-service.svg?branch=master)](https://travis-ci.org/javierseixas/file-storage-service)

## Intro
This service is built over Spring Boot. It give an API which stores files and persists file info in an InMemory DB.

## Run standalone
```
./gradlew bootRun
```
## Testing
```
./gradlew check
```

## Solution explanations
* Design: `main` application structure has two parts, following a tiny DDD approach:
    * Domain: Has the principal entity `File` and a `FileRepository` Interface.
    * Infrastructure: Where are all parts that depends on third parties, in the current case, Spring. It also have the `FileRepository` implementation.
* CI: Every commit to `master` will trigger a travis-ci pipeline which will:
    * build and test the application
    * create a docker image and push it to Docker Hub

## Tech-debt
* There are still some classes to be unit tested
* Lacks a simple integration test
* `POST /files` endpoint should return `201`

## Product-debt
* ~~It should be a `GET /files` endpoint for retrieving all persisted files~~