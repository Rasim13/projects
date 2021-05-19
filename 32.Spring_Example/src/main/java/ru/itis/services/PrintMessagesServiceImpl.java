package ru.itis.services;

import ru.itis.messages.MessageProcessor;
import ru.itis.printers.Printer;

public class PrintMessagesServiceImpl implements PrintMessagesService {
    private MessageProcessor messageProcessor;
    private Printer printer;

    public PrintMessagesServiceImpl(MessageProcessor messageProcessor, Printer printer) {
        this.messageProcessor = messageProcessor;
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        String newMessage = messageProcessor.process(message);
        printer.print(newMessage);
    }
}
