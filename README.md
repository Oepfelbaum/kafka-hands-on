# Hands-On Kafka Workshop by Oepfelbaum IT Management AG

Welcome to the Hands-On Kafka Workshop provided by [Oepfelbaum IT Management AG](https://www.oepfelbaum.com/). This
repository contains all the necessary materials for the workshop participants to set up and interact with a Kafka
cluster, as well as to perform exercises using Kafka Streams and KSQL.

All solutions can be found on this branch: `origin/solutions`

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

After learning about the Kafka basics in the first part, we are developing our own Java applications using Kafka
Streams:

- Creating streams
- Filtering messages
- Joining streams

The instructions for this sections are [here](streams.md).

### Exercises Using KSQL

- Initial setup using Docker Compose
- Exploring KSQL using the CLI
- Creating streams
- Aggregations
- Materialized views
- Windowing

You can find the details instructions [here](ksql.md).

## Prerequisites

* Docker
* Docker Compose
* Development IDE (eg. IntelliJ or VS Code)
* Java JDK 21
* Git
* Maven (if not already included in IDE)

## Contact

For any questions or feedback related to the workshop, please contact Oepfelbaum IT Management AG at
info@oepfelbaum.com.

Enjoy the workshop, and happy learning!