#!/bin/ksh
java -jar scdf-server.jar \
--spring.datasource.url=jdbc:mysql://localhost:3306/scdf \
--spring.datasource.username=root \
--spring.datasource.password=pluralsight \
--spring.datasource.driver-class-name=org.mariadb.jdbc.Driver \
--spring.rabbitmq.host=localhost \
--spring.rabbitmq.port=5672 \
--spring.rabbitmq.username=guest \
--spring.rabbitmq.password=guest

