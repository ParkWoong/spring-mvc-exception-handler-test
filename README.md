# MVC exception responses / MVC 예외 응답

[ENG](#eng) | [KR](#kr)

## ENG

### Project structure

```text
pom.xml
src/main/java/io/github/parkwoong/example/Application.java
src/main/java/io/github/parkwoong/example/SampleController.java
src/main/java/io/github/parkwoong/example/exception/AdviceController.java
src/main/java/io/github/parkwoong/example/exception/error/CoreServerError.java
src/main/java/io/github/parkwoong/example/exception/error/InvalidDataError.java
src/main/java/io/github/parkwoong/example/exception/error/RequestError.java
src/main/java/io/github/parkwoong/example/exception/error/common/ErrorCode.java
src/main/java/io/github/parkwoong/example/exception/error/common/ErrorResponse.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/example/AdviceTest.java
```

### Code explanation

`AdviceController` maps request errors, validation errors, server errors, and unexpected
exceptions to JSON responses. `ErrorResponse` contains the error name, code, and message.
`SampleController` raises example errors. Unexpected exceptions return a generic message instead
of internal details.

### Run and test

Use JDK 8 and Maven 3.6.3+. Run from the repository root:

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

Try `GET /sample/bad` and `GET /sample/fail`. The test checks HTTP 400/500 and the JSON error
fields.

#### Postman API

##### 1. Request error

**Request**

- Method: GET
- URL: http://localhost:8080/sample/bad
- Body: none

**Response**

- Status: 400 Bad Request

~~~json
{
  "error": "Request Error",
  "errorCode": "API400",
  "message": {
    "errorMessage": "Invalid sample"
  }
}
~~~

##### 2. Server error

**Request**

- Method: GET
- URL: http://localhost:8080/sample/fail
- Body: none

**Response**

- Status: 500 Internal Server Error

~~~json
{
  "error": "Internal Server Error",
  "errorCode": "API500",
  "message": {
    "errorMessage": "Unexpected error"
  }
}
~~~

## KR

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/example/Application.java
src/main/java/io/github/parkwoong/example/SampleController.java
src/main/java/io/github/parkwoong/example/exception/AdviceController.java
src/main/java/io/github/parkwoong/example/exception/error/CoreServerError.java
src/main/java/io/github/parkwoong/example/exception/error/InvalidDataError.java
src/main/java/io/github/parkwoong/example/exception/error/RequestError.java
src/main/java/io/github/parkwoong/example/exception/error/common/ErrorCode.java
src/main/java/io/github/parkwoong/example/exception/error/common/ErrorResponse.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/example/AdviceTest.java
```

### 코드 설명

`AdviceController`가 요청 오류, 입력 검증 오류, 서버 오류 및 예기치 않은 예외를 JSON 응답으로
변환한다. `ErrorResponse` 에는 오류 이름·코드·메시지가 담깁니다. `SampleController`는 예제
오류를 발생시킵니다. 예기치 않은 예외의 내부 상세 정보는 응답에 노출하지 않는다.

### 실행과 테스트

JDK 8, Maven 3.6.3 이상 사용. 저장소 루트에서 실행.

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

`GET /sample/bad`, `GET /sample/fail`을 호출. 테스트는 HTTP 400/500과 JSON
오류 필드를 확인한다.

#### Postman API

##### 1. 요청 오류

**요청**

- 메서드: GET
- URL: http://localhost:8080/sample/bad
- 본문: 없음

**응답**

- 상태: 400 Bad Request

~~~json
{
  "error": "Request Error",
  "errorCode": "API400",
  "message": {
    "errorMessage": "Invalid sample"
  }
}
~~~

##### 2. 서버 오류

**요청**

- 메서드: GET
- URL: http://localhost:8080/sample/fail
- 본문: 없음

**응답**

- 상태: 500 Internal Server Error

~~~json
{
  "error": "Internal Server Error",
  "errorCode": "API500",
  "message": {
    "errorMessage": "Unexpected error"
  }
}
~~~
