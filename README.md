＊＊＊KafkaService 分流作為 數值中介服務 ＊＊＊

起動 zookeeper , brokerService 

加入  Topic

(有人工設定環靜變數)

macOS 版本 跟 Windows版本 都在文件夾


@echo off
chcp 65001

REM 1. 設定 JAVA_HOME 
set "JAVA_HOME=C:\Program Files\RedHat\java-17-openjdk-17.0.9.0.9-1"
REM 2. 設定 KAFKA_HOME
set "KAFKA_HOME=D:\kafka_2.13-3.9.0"

echo # 啟動 ZooKeeper...
start "ZooKeeper" cmd /k "cd /d %KAFKA_HOME% & bin\windows\zookeeper-server-start.bat config\zookeeper.properties"

echo.
echo # ZooKeeper 啟動完成。
echo.

echo|set /p=.
REM 檢查 2181 連接埠是否在監聽中
netstat -an | findstr "2181" | findstr "LISTENING" > nul

REM 判斷上一行指令的結果
if %ERRORLEVEL% equ 0 (
    echo.
    echo [成功] ZooKeeper 服務已在連接埠 2181 上就緒！
    goto :zookeeper_ready
)

:zookeeper_ready
echo # 啟動 Broker...
start "Broker" cmd /k "cd /d %KAFKA_HOME% & bin\windows\kafka-server-start.bat config\server.properties"
echo.
echo # Broker 啟動完成。

echo # 貼心操作頁面...
start "Sweet dashboard!" cmd /k "cd /d %KAFKA_HOME%"


echo # 相關指令:
echo # 查看topic 
echo # bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

echo # 新增topic 
echo # bin\windows\kafka-topics.bat --create --topic  mailrouter-topic  --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1


pause
