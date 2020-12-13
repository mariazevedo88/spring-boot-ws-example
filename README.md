# spring-boot-ws-example

## About the application
Example application of SOAP Web Service with Spring Boot

**Based on the tutorial:** [https://spring.io/guides/gs/producing-web-service](https://spring.io/guides/gs/producing-web-service)

### Test

* For unit test phase, you can run:

```bash
mvn test
```

* Testing via cURL:

```bash
cd src/test/resources

curl --header "content-type: text/xml" -d @request.xml http://localhost:9090/sbwsExample/ws/calculatorDemo
```

### Run

In order to run the API, run the jar simply as following:

```bash
mvn package

java -jar spring-boot-ws-example-1.0.0-SNAPSHOT.jar
```
    
or

```bash
mvn spring-boot:run
```

By default, the API will be available at [http://localhost:9090/sbwsExample/ws/calculatorDemo](http://localhost:9090/sbwsExample/ws/calculatorDemo)