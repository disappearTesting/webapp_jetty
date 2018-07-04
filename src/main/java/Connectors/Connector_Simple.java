package Connectors;

import org.eclipse.jetty.server.ServerConnector;

public class Connector_Simple {

    private final String host;
    private final int port;
    private final long idleTimeout;
    ServerConnector connector;

    public Connector_Simple(String host, int port) {
        this(host, port, 0);
    }

    public Connector_Simple(String host, int port, long idleTimeout) {
        this.host = host;
        this.port = port;
        this.idleTimeout = idleTimeout;
    }

    public ServerConnector applyConnector() {
        connector.setHost(host);
        connector.setPort(port);
        if(idleTimeout != 0) {
            connector.setIdleTimeout(idleTimeout);
        }
        return connector;
    }
}