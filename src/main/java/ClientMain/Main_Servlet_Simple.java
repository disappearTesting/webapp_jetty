package ClientMain;

import Connectors.Connector_Simple;
import Servlets.ListServlet;
import Servlets.Servlet_Simple;
import Servlets.service.ListStorageService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main_Servlet_Simple {

    public static void main(String[] args) throws Throwable {

        ListStorageService storageService = ListStorageService.getInstance();

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        contextHandler.addServlet(new ServletHolder(new Servlet_Simple(storageService)), "/api/servlet/simple");
        contextHandler.addServlet(new ServletHolder(new ListServlet(storageService)), "/api/servlet/lists");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("index.php");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[]{resourceHandler, contextHandler});

        Server server = new Server();
        server.addConnector(new Connector_Simple(new ServerConnector(server),"localhost", 8080).applyConnector());
        server.setHandler(handlerList);

        server.start();
        server.join();
    }
}