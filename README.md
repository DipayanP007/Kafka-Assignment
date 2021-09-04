# README

## Clone the git repository
Execute the following command to clone the git repository.
```bash
git clone https://github.com/DipayanP007/Kafka-Assignment.git
```

## Start the Zookeeper Server and Kafka Server
Change directory to the directory where Apache Kafka is downloaded and execute the following command to start the Zookeeper Server.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
In a new terminal execute the following command to start the Kafka Server.
```bash
bin/kafka-server-start.sh config/server.properties
```
## Produce and Consume User Message

1. Execute the Consumer Class to start the Consumer
2. Execute the Producer Class to start the Producer
3. Open the UserData.txt file and check if the message produced by the producer is stored in the file.