

```shell
mvn spring-boot:run
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=springboot3sample
docker run --rm -it -p 8080:8080 --name springboot3sample -t springboot3sample

mvn spring-boot:build-image -Dspring-boot.build-image.imageName=springboot3samplen -Pnative
docker run --rm -it -p 8080:8080 --name springboot3samplen -t springboot3samplen
```

```shell
mvn -Pnative native:compile
./target/SampleSpringBoot3Project
```


## New hetzner server

```shell
apt update
apt install -y git maven openjdk-19-jdk ca-certificates curl gnupg lsb-release
mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null 
apt-get update
apt-get install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin

docker run hello-world
```

## Sources

* https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints