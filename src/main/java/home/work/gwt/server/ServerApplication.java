package home.work.gwt.server;

import home.work.gwt.server.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
@ComponentScan("home.work.gwt.server")
@Import({Config.class})
public class ServerApplication {

    final static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    @Autowired
    Environment env;

    /**
     * entry point
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
