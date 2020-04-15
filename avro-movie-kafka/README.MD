kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic user

kafka-console-consumer --bootstrap-server localhost:9092 --topic user --from-beginning

One important implication of pushing data into many different services is we can’t manage consistency in the same way. We will have many copies of the same data embedded in different services which, if they were writable, could lead to collisions and inconsistency.

As this notion of ‘eventual consistency’ is often undesirable in business applications, one solution is to isolate consistency concerns (i.e. write operations) via the single writer principle. For example, the Orders Service would own how an Order evolves in time. Each downstream service then subscribes to the strongly ordered stream of events produced by this service, which they observe from their own temporal viewpoint. 