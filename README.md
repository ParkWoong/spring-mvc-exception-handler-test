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

`AdviceController` maps request errors, validation errors, server errors, and unexpected exceptions to JSON responses. `ErrorResponse` contains the error name, code, and message. `SampleController` raises example errors. Unexpected exceptions return a generic message instead of internal details.

### Run and test

Use JDK 8 and Maven 3.6.3+. Run from the repository root:

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

Try `GET /sample/bad` and `GET /sample/fail`. The test checks HTTP 400/500 and the JSON error fields.

#### Postman API

Call GET http://localhost:8080/sample/bad with no body. Expected: HTTP 400 and JSON containing error: "Request Error", errorCode: "API400", and message.errorMessage: "Invalid sample". GET /sample/fail returns HTTP 500 with a generic message.

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

`AdviceController`가 요청 오류, 입력 검증 오류, 서버 오류 및 예기치 않은 예외를 JSON 응답으로 변환합니다. `ErrorResponse`에는 오류 이름·코드·메시지가 담깁니다. `SampleController`는 예제 오류를 발생시킵니다. 예기치 않은 예외의 내부 상세 정보는 응답에 노출하지 않습니다.

### 실행과 테스트

JDK 8과 Maven 3.6.3 이상을 사용합니다. 저장소 루트에서 실행하세요:

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

`GET /sample/bad`, `GET /sample/fail`을 호출하세요. 테스트는 HTTP 400/500과 JSON 오류 필드를 확인합니다.

#### Postman API

본문 없이 GET http://localhost:8080/sample/bad을 호출하세요. 예상 결과: HTTP 400과 error: "Request Error", errorCode: "API400", message.errorMessage: "Invalid sample"이 담긴 JSON입니다. GET /sample/fail은 일반화된 메시지와 HTTP 500을 반환합니다.
