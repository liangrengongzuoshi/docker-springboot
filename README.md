# docker-springboot
docker镜像测试


#### Dockerfile
```$xslt
## 使用官方maven镜像
FROM maven:3.5.4-alpine
## 
ADD . /app
WORKDIR /app/
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar target/docker-springboot-1.0.jar

```