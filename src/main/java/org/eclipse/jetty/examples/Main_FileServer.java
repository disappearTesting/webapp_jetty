package org.eclipse.jetty.examples;

import org.eclipse.jetty.examples.Handler_GetResource;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class Main_FileServer {
    public static void main(String[] args) throws Exception {

        final String filename = "index.php";
        ResourceHandler resourceHandler = new ResourceHandler();

        // Create a basic Jetty server object that will listen on port 8080.
        Server server = new Server(8080);

        // Add the ResourceHandler to the server.
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{new Handler_GetResource(resourceHandler, filename).getResourceHandler(), new DefaultHandler()});
        server.setHandler(handlers);

        // Start and join, the server thread will join with the current thread.
        server.start();
        server.join();
    }
}
