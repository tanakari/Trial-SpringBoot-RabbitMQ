package com.example.mqsender;

import java.time.LocalDateTime;

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

        var sendMessage = message + ":" + LocalDateTime.now();
        sender.send(sendMessage);
        return sendMessage + "って送ったよ。";
    }
}
