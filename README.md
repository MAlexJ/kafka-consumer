# Spring boot kafka project

## Description

Project based on 'server-sent-events' technology,
which will allow real-time tracking of event changes
and displaying them in web UI

Event streaming platform - Kafka
Web framework - Spring </br>
Java - 21 </br>

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

* Hostname with port - url for CLOUD_KAFKA_BROKER_URL
* Default user - username for CLOUD_KAFKA_USERNAME
* oPassword - Password for CLOUD_KAFKA_PASSWORD

### Add ENV properties to IDE or .env file

```
CLOUD_KAFKA_USERNAME={Default user}
CLOUD_KAFKA_PASSWORD={Password}
CLOUD_KAFKA_BROKER_URL=test-speedcar-01.srvs.cloudkafka.com:9094
```
