# Spring boot kafka project
## Description
Project based on 'server-sent-events' technology, 
which will allow real-time tracking of event changes 
and displaying them in web UI (angularJS)

Event streaming platform - Kafka
Database - Mongo DB </br>
Web framework - Spring </br>
Java - 17 </br>
web UI - angularJS </br>
as an additional option, the project can be part of the spring cloud </br>


## Cloud kafka
free kafka online - https://www.cloudkarafka.com/ </br>
Free plan: $0 </br>
For testing and development we provide an Apache Kafka server 
that's shared between multiple users. </br>
Note that other users' actions may affect your experience on this server.
* Shared cluster
* Topic management
* Max 5 topics with 10 MB data/topic
* Max 28 days retention
* Certificate based authentication
* Consume and produce from Kafka in a UI
* Email and chat support

### How to set up kafka:
link for info - https://customer.cloudkarafka.com/instance </br>
documentation: https://www.cloudkarafka.com/docs/spring.html </br>
Springboot sample: https://github.com/CloudKarafka/springboot-kafka-example </br>

Hostname - url for CLOUD_KAFKA_BROKERS </br>
Default user - username for CLOUD_KAFKA_USERNAME</br>
Password - Password for CLOUD_KAFKA_PASSWORD </br>

### Add ENV properties to IDE or .env file
* CLOUD_KAFKA_USERNAME={username}
* CLOUD_KAFKA_PASSWORD={password}
* CLOUD_KAFKA_BROKERS={URL_brokers}

### Enable env configuration in IDE
1. open spring boot run class
2. edit configuration
3. enable env file and add to path
