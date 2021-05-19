package ru.itis.messages;

import java.time.LocalDateTime;

public class MessageProcessorTimeImpl implements MessageProcessor {
    @Override
    public String process(String message) {
        return LocalDateTime.now().toString() + " " + message;
    }
}
