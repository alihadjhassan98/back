FROM openjdk:11.0.9
RUN apt-get  update && apt -y upgrade
RUN apt-get install -y maven
Run apt-get clean 
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . /app/ 
RUN mvn install -DskipTests
EXPOSE 8082
ENTRYPOINT ["mvn","spring-boot:run"]

