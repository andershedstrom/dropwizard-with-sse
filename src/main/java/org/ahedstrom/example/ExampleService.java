package org.ahedstrom.example;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class ExampleService extends Service<Configuration> {

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.addResource((new Resource()));
        environment.addServlet(new SseEventSourceServlet(), "/sse");
    }
    
    private void nothing() {
        
    }

    public static void main(String[] args) throws Exception {
        new ExampleService().run(args);
    }
}
