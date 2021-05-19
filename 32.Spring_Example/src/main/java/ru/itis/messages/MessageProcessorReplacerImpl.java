package ru.itis.messages;

public class MessageProcessorReplacerImpl implements MessageProcessor {

    private String toReplace;

    public MessageProcessorReplacerImpl(String toReplace) {
        this.toReplace = toReplace;
    }

    @Override
    public String process(String message) {
        return message.replace(toReplace, "");
    }
}
