Part that accepts requests for sending emails \
To make work create in resources secure.properties file and write in it
```
spring.mail.username=
spring.mail.password=
```
with actual values. You can follow guide on https://www.baeldung.com/spring-email \
\
To actually run it you need to run from project directory
```
mvn package
docker build -t nets-sender .
```