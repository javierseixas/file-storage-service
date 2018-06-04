# File Storage Service using Spring Boot

[![Build Status](https://travis-ci.org/javierseixas/file-storage-service.svg?branch=master)](https://travis-ci.org/javierseixas/file-storage-service)

## Run standalone
```
./gradlew bootRun
```
## Testing
```
./gradlew check
```

## Solution explanations
* Considering File as main Domain Entity

## Tech-debt
* There are still some classes to be unit tested
* Lacks a simple integration test
* `POST /files` endpoint should return `201`

## Product-debt
* It should be a `GET /files` endpoint for retrieving all persisted files