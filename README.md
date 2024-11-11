

```sh
mvn spring-boot:run
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=springboot3sample
docker run --rm -it -p 8080:8080 --name springboot3sample -t springboot3sample

mvn spring-boot:build-image -Dspring-boot.build-image.imageName=springboot3samplen -Pnative
docker run --rm -it -p 8080:8080 --name springboot3samplen -t springboot3samplen
```

```shell
mvn -Pnative clean native:compile
./target/SampleSpringBoot3Project
```

## Sources

* https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints