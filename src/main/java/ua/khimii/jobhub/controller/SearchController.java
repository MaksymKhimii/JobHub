package ua.khimii.jobhub.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;
import ua.khimii.jobhub.service.NameService;

import java.io.IOException;


@WebServlet("/search")
public class SearchController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(SearchController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("doGet search");
        req.getRequestDispatcher("/WEB-INF/jsp/search-form.jsp").forward(req, resp);
    }

    private boolean isValid(String name) {
        return name != null && name.trim().length() != 0;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug((Object) "doPost search: {}");
        String name = req.getParameter("query");
        if (!isValid(name)) {
            req.setAttribute("invalid", Boolean.TRUE);
            req.getRequestDispatcher("/WEB-INF/jsp/search-form.jsp").forward(req, resp);
            return;
        }
        String result = NameService.getInstance().convertName(name);
        req.setAttribute("name", result);
        req.getRequestDispatcher("/WEB-INF/jsp/search-result.jsp").forward(req, resp);
    }
}