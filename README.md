# Spring cloud Netflix sidecar
> Spring cloud Netflix sidecar 샘플 프로젝트

- node-service : simple non JVM microservice
- sidecar : spring cloud netflix sidecar example

## Getting started

- System Requirements

1. node-service

| Type      	| Tool         	| Version      	|
|-----------	|--------------	|--------------	|
| Environment  	| Node         	| LTS     	|
| Framework 	| Express     	| 4.16 이상        	|

2. sidecar

| Type      	| Tool         	| Version      	|
|-----------	|--------------	|--------------	|
| Compiler  	| JDK         	| 1.8 이상     	|
| Builder   	| maven        	| 3.2 이상     	|
| Framework 	| Spring Boot  	| 2.0.2        	|
|           	| Spring Cloud 	| Finchley.BUILD-SNAPSHOT 	|

- Initial Configuration

1. node-service 설치 및 실행

```bash
# 간단한 express 서버가 8008포트로 동작합니다.
cd node-service
npm install
node index.js
```
        
2. sidecar 설치 및 실행

```bash
# sidecar 예제 프로그램이 8009포트로 동작합니다.
cd sidecar
./mvnw clean package
java -jar ./target/sidecar-0.0.1.SNAPSHOT.jar
```

- Screenshot

![sidecar-pattern](./document/images/sidecar-pattern.png)

## Related Links

- [MSA CoE Guide](https://coe.gitbook.io/guide/sidecar-pattern/springcloudnetflixsidecar)

- [Official site](https://cloud.spring.io/spring-cloud-netflix/multi/multi__polyglot_support_with_sidecar.html)