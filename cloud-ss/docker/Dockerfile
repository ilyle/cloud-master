# 基础镜像使用java
FROM java:8

# 作者
MAINTAINER xiaoqi <617314917@qq.com>

# 指定容器的工作目录，以后各层当前目录就为该目录
WORKDIR /cloud-ss

# 将jar包添加到容器中并更名为app.jar
COPY cloud-ss.jar /cloud-ss

# 运行jar包
CMD java -jar cloud-ss.jar