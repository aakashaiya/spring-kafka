# spring-kafka
This project helps to configure kafka consumers to different partitions of a topic.

To achieve parallelism, consumers can be configured in a way to read data from multiple partitions of the same topic.

But no two consumers from the same group can read data from a single partition.

Also the number of consumer instances that can be created depends on the concurency factor which is set in the config file.
