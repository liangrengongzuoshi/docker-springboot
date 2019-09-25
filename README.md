# docker-springboot
docker镜像测试


#### Dockerfile
```$xslt
## 使用官方maven镜像
FROM maven:3.5.4-alpine
## 复制文件到容器
ADD . /app
## 设置工作目录
WORKDIR /app/
RUN mvn clean package
## 声明需要暴露的端口
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar target/docker-springboot-1.0.jar


```
