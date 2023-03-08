package lesson32.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * @author spasko
 */
public class MainGroupServer {

    public static void main(String[] args) throws Exception {
        ServletContextHandler handler = buildUsingResourceConfig(); // or buildUsingInitParameter()
        Server server = new Server(9998);
        server.setHandler(handler);
        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }

    static ServletContextHandler buildUsingResourceConfig() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(GroupServiceImpl.class);
        handler.addServlet(new ServletHolder(new ServletContainer(resourceConfig)), "/api/*");
        return handler;
    }

    static ServletContextHandler buildUsingInitParameter() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");

        ServletHolder servletHolder = handler.addServlet(ServletContainer.class, "/api/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "root.resources");
        return handler;
    }
}
