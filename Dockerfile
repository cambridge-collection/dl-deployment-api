FROM openjdk:11.0.7

# TODO hardcoded version
COPY ./target/api-0.1.0-SNAPSHOT.war /usr/local/dl-deployment-api.war
COPY ./src/main/resources/application.properties /usr/local/conf/dl-deployment-api/application.properties

CMD java -jar -debug /usr/local/dl-deployment-api.war --spring.config.additional-location=/usr/local/conf/dl-deployment-api/