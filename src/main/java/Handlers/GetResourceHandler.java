package Handlers;

import org.eclipse.jetty.server.handler.ResourceHandler;

public class GetResourceHandler {

    ResourceHandler resourceHandler;
    private final String filename;

    public GetResourceHandler(ResourceHandler resourceHandler, String filename) {
        this.resourceHandler = resourceHandler;
        this.filename = filename;
    }

    private void configureResourceHandler() {
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{filename});
        resourceHandler.setResourceBase(".");
    }

    public ResourceHandler getResourceHandler() {
        configureResourceHandler();
        return resourceHandler;
    }
}