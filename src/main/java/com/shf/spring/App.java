package com.shf.spring;

import com.shf.spring.config.MyImportBeanDefinitionRegistrar;
import com.shf.spring.config.MyImportSelector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Slf4j
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(App.class).web(WebApplicationType.NONE).run(args);

        int exitCode = SpringApplication.exit(ctx, (ExitCodeGenerator) () -> {
            // return the error code
            log.info("exit with code:{}", 0);
            return 0;
        });

        log.info("Process {} finished with exit code : {}.", new ApplicationPid().toString(), exitCode);
    }


    @EventListener(ContextStartedEvent.class)
    public void contextStartedEventExecute() {
        log.info("Context Started Event Listener is getting executed");
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEventExecute() {
        log.info("Context Refreshed Event Listener is getting executed");
    }

    @EventListener(ContextStoppedEvent.class)
    public void contextStoppedEventExecute() {
        log.info("Context Stopped Event Listener is getting executed");
    }

    @EventListener(ContextClosedEvent.class)
    public void contextClosedEventExecute() {
        log.info("Context Closed Event Listener is getting executed");
    }

    @EventListener(ApplicationContextEvent.class)
    public void applicationContextEventListenerExecute() {
        log.info("Application Context Event Listener is executed");
    }

    @EventListener(ApplicationStartedEvent.class)
    public void startedEventListenerExecute() {
        log.info("Application Started Event Listener is executed");
    }

    @EventListener(ApplicationStartingEvent.class)
    public void startingEventListenerExecute() {
        log.info("Application Starting Event Listener is executed");
    }

    @EventListener(ApplicationFailedEvent.class)
    public void failedEventListenerExecute() {
        log.info("Application Failed Event Listener is executed");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void readyEventListenerExecute() {
        log.info("Application Ready Event Listener is executed");
    }

}
