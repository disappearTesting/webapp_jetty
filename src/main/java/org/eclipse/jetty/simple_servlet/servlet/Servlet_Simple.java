package org.eclipse.jetty.simple_servlet.servlet;

import org.eclipse.jetty.simple_servlet.service.ListStorageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet_Simple extends HttpServlet {

    private ListStorageService listStorageService;

    public Servlet_Simple(ListStorageService service) {
        this.listStorageService = service;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bodyList = req.getParameter("body");
        if(bodyList != null) {

        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
