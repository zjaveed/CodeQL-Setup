package com.github.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * A status page servlet that will report success if the application has been
 * instantiated.
 * this provides a useful status check for containers and deployment purposes.
 */
public class StatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(StatusServlet.class);

    public StatusServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String apiVersion = req.getHeader("X-Api-Version");
        ThreadContext.put("api.version", apiVersion);

        logger.info("status servlet GET");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write("ok");
    }
}
