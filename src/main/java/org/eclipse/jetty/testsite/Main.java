package org.eclipse.jetty.testsite;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
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

        ResourceHandler resHandler = new ResourceHandler();
        resHandler.setResourceBase("../webapp_jetty/src/main/java/webapp");
        // resHandler.setResourceBase("rest/loginPage");
        ContextHandler ctx = new ContextHandler("/rest/loginPage"); /* the server uri path */
        ctx.setHandler(resHandler);
        server.setHandler(ctx);

//        ResourceHandler rs2 = new ResourceHandler();
//        ContextHandler ch2 = new ContextHandler();
//        ch2.setContextPath("/");
//        ch2.setHandler(rs2);

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] {ctx});

        server.setConnectors(new Connector[]{http_testsite});
        server.setHandler(contexts);
        server.start();
        server.join();
    }
}
