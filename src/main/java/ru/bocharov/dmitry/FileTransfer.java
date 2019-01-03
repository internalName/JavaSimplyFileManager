package ru.bocharov.dmitry;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;


public class FileTransfer {
    private CamelContext context = null;
    private String path_a = "C:\\Users\\Дмитрий\\Desktop\\программирование\\Новая папка (2)";
    private String path_b = "out";

    public FileTransfer() {
        initialAddRoutes();
    }

    public FileTransfer(String path_a, String path_b) {
        this.path_a = path_a;
        this.path_b = path_b;

        initialAddRoutes();
    }

    private void initialAddRoutes() {
        try {
            context = new DefaultCamelContext();
            context.addRoutes(new RouteBuilder() {
                public void configure() {
                    from("file:" + path_a)
                            .to("file:" + path_b);
                }
            });
        } catch (Exception e) {
            LoggerFileTransfer.logger.error("error initialAddRoutes");
        }

    }

    public void transferThread() {
        try {
            context.start();
            LoggerFileTransfer.logger.info("Transfer start");
            Thread.sleep(10000);
            context.stop();
            LoggerFileTransfer.logger.info("Transfer stop");

        } catch (Exception e) {
            LoggerFileTransfer.logger.error("error initialAddRoutes");
        }
    }
}
