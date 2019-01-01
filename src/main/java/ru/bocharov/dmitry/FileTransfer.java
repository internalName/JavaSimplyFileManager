package ru.bocharov.dmitry;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;


public class FileTransfer {
    final static Logger logger = Logger.getLogger(FileTransfer.class);
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:C:\\Users\\Дмитрий\\Desktop\\программирование\\Проекты\\GitHub\\JavaSimplyFileManager\\.idea?noop=true")
                        .to("file:out");
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
        logger.info("Testing!!!");
    }
}
