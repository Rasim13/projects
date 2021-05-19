package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.messages.MessageProcessor;
import ru.itis.messages.MessageProcessorReplacerImpl;
import ru.itis.messages.MessageProcessorTimeImpl;
import ru.itis.printers.Printer;
import ru.itis.printers.PrinterErrorImpl;
import ru.itis.printers.PrinterStandardImpl;
import ru.itis.services.PrintMessagesService;
import ru.itis.services.PrintMessagesServiceImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PrintMessagesService service = context.getBean(PrintMessagesService.class);
        service.print("Hello!");

    }
}
