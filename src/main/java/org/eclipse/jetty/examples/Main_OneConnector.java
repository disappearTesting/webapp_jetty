package org.eclipse.jetty.examples;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class Main_OneConnector {
    public static void main(String[] args) throws Throwable {

        // The Server
        Server server = new Server();

        // The Connector
        ServerConnector http = new ServerConnector(server);
        http.setHost("localhost");
        http.setPort(8080);
        http.setIdleTimeout(15000);

        // Set the Connector
        server.addConnector(http);

        // Set a Handler
        server.setHandler(new ResourceHandler());

        server.start();
        server.join();
    }
}
