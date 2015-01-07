package hnrc.example;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class ExampleService extends Service<Configuration> {

    @Override
    public void run(final Configuration configuration, final Environment environment) throws Exception {
        environment.addResource(new Resource());
        environment.addServlet(new SseEventSourceServlet(), "/sse");
    }

    private int nothing(final int x) {
        if(true) {
            return 42;
        }
        return 0;
    }

    public static void main(final String[] args) throws Exception {
        new ExampleService().run(args);
        final int a = (3 + 5);
        // new ExampleService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {}
}
