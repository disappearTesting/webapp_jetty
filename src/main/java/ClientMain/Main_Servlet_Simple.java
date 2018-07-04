package ClientMain;

import Connectors.Connector_Simple;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main_Servlet_Simple {

    public static void main(String[] args) {

        Server server = new Server();

        server.addConnector(new Connector_Simple("localhost", 8080).applyConnector());

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    }
}
