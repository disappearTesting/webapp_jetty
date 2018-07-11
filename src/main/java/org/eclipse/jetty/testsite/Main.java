package org.eclipse.jetty.testsite;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Throwable {

        Server server = new Server();

        HttpConfiguration http_config = new HttpConfiguration();
        http_config.setSecureScheme("https");
        http_config.setSecurePort(8443);
        http_config.setOutputBufferSize(32768);

        ServerConnector http_testsite = new ServerConnector(server, new HttpConnectionFactory(http_config));
        http_testsite.setPort(8080);
        http_testsite.setIdleTimeout(15000);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        contextHandler.addServlet(new ServletHolder(new Servlet_Simple()), "/rest/loginPage");

        server.setConnectors(new Connector[]{http_testsite});
        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}
