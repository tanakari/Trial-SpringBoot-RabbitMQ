package com.example.mqsender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SendController {

    private final Sender sender;

    @PostMapping("/send")
    public String greeting(@RequestParam(value = "message", defaultValue = "メッセージなし") String message) throws Exception {

        var now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        var sendMessage = "メッセージ=%s,送信日時=%s".formatted(message, now);
        sender.send(sendMessage);
        return "「" + sendMessage + "」って送ったよ。";
    }
}
