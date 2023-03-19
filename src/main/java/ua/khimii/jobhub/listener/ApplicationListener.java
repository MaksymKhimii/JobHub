package ua.khimii.jobhub.listener;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ApplicationListener.class);

    @Value("${application.production}")
    private boolean production;

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("production", production);
        LOGGER.info("Application started");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Application destroyed");
    }
}
