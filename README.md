# Hands-On Kafka Workshop by Oepfelbaum IT Management AG

Welcome to the Hands-On Kafka Workshop provided by [Oepfelbaum IT Management AG](https://www.oepfelbaum.com/). This repository contains all the necessary materials for the workshop participants to set up and interact with a Kafka cluster, as well as to perform exercises using Kafka Streams and KSQL.

## Workshop Topics

### Setting Up a Kafka Cluster and interacting with Kafka using the CLI
The first part covers the following topics:
- Running a Kafka cluster using Docker
- Create topics 
- Produce and consume messages
- Partitioning and consumer groups
- Log compaction

Follow along [here](cluster.md).


### Exercises Using Kafka Streams
After learning about the Kafka basics in the first part, we are developing our own Java applications using Kafka Streams:
- Implementing a simple Kafka streams application
- Creating and filtering of streams
- Joining topics
- Kafka time and window calculation

The instructions for this sections are [here](streams.md).


### Exercises Using KSQL
- Initial setup using Docker compose
- Exploring KSQL using the CLI
- Creating Streams
- Aggregations and materialized views:
- Windowed aggregations

You can find the details instructions [here](ksql.md).

## Prerequisites

The following service components should be installed on your training device before attending the training. A detailed installation guide will be given afterwards.

* Docker Desktop
* Docker Compose
* Development:
    * IntelliJ or VS Code (or your IDE/text editor of choice)
    * Java JDK 21
    * Git
    * Maven (if not already included in IDE)

In addition, required for Windows users:
* Windows Subsystem for Linux (WSL)
* Ubuntu 20.04 for WSL (recommended, other distributions might work too)
* Windows Terminal (optional, but very nice)

## Contact
For any questions or feedback related to the workshop, please contact Oepfelbaum IT Management AG at info@oepfelbaum.com.

Enjoy the workshop, and happy learning!