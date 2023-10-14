# Trial-SpringBoot-RabbitMQ

SpringBoot × RabbitMQ のお試し

## 概要

SpringBoot × RabbitMQ の実装、動きを確認するための簡易的なアプリ

## アプリの説明

送信アプリ、受信アプリの各々の説明は以下の通り。

- 送信アプリ
  - SpringBoot(Rest)で作成する。
  - POST されたメッセージを RabbitMQ に送信する。
  - RabbitMQ に送信するメッセージは、POST されたメッセージに加えて送信日時を送信する。
- 受信アプリ
  - Spring for RabbitMQ で作成する。
  - RabbitMQ からのメッセージをログに出力する。

## 前提

以下がセットアップ済みであること

- Java17 がインストール済み
- RabbitMQ がインストール（起動）済み

## 動作確認方法

### MQ 送信アプリの起動

```
./gradlew :mq-sender:bootRun
```

### MQ 受信アプリの起動

```
./gradlew :mq-reciver:bootRun
```

## メッセージの送信

```
curl -X POST -d "message=テストメッセージ" http://localhost:8080/send
```

※「テストメッセージ」の部分は、任意のメッセージ変更可能。
