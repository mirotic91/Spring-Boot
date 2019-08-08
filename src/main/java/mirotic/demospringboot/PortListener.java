package mirotic.demospringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent servletWebServerInitializedEvent) {
        ServletWebServerApplicationContext applicationContext = servletWebServerInitializedEvent.getApplicationContext();
        int port = applicationContext.getWebServer().getPort();
        log.debug("WebServer Port[{}]", port);
    }
}
