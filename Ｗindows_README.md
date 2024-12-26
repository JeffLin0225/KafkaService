set JAVA_HOME=C:\Program Files\RedHat\java-17-openjdk-17.0.9.0.9-1

set PATH=%JAVA_HOME%\bin;%PATH%

echo %JAVA_HOME%

Windows 版本
===== ZooKeeper ================

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

===== Broker ================

.\bin\windows\kafka-server-start.bat .\config\server.properties

===== New Topic ================

.\bin\windows\kafka-topics.bat --create --topic my-new-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

===== Check ================

.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
