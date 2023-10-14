# Trial-SpringBoot-RabbitMQ

SpringBoot × RabbitMQ のお試し

## MQ 送信アプリの起動

```
./gradlew :mq-sender:bootRun
```

## MQ 受信アプリの起動

```
./gradlew :mq-reciver:bootRun
```

## MQ 送信

```
curl -X POST -d "message=テスト" http://localhost:8080/send
```
