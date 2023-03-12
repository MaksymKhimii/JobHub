package ua.khimii.jobhub.listener;


import org.apache.log4j.Logger;
import ua.khimii.jobhub.controller.SearchController;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(SearchController.class.getName());
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.trace("Application started");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.trace("Application destroyed");
    }

}