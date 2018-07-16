package org.eclipse.jetty.testsite;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.testsite.servlets.Servlet_WindowPage;
import org.eclipse.jetty.util.resource.Resource;

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

//        ResourceHandler resHandler = new ResourceHandler();
//        resHandler.setResourceBase("../webapp_jetty/src/main/webapp/rest/windowPage");
//        ContextHandler ctx = new ContextHandler("/rest/windowPage"); /* the server uri path */
//        ctx.setHandler(resHandler);
//        server.setHandler(ctx);

        ServletContextHandler sch_WindowPage = new ServletContextHandler(ServletContextHandler.SESSIONS);
        sch_WindowPage.addServlet(Servlet_WindowPage.class, "/windowPage");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {sch_WindowPage});

        server.setConnectors(new Connector[]{http_testsite});
        server.setHandler(contexts);
        server.start();
        server.join();
    }
}
