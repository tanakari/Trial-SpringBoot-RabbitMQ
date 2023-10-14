package com.example.mqreciver;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(String message) throws InterruptedException {

        System.out.println("受信メッセージ : " + message);
        // 連続したメッセージが待機されることを確認するために、スリープ
        Thread.sleep(3000);
    }
}