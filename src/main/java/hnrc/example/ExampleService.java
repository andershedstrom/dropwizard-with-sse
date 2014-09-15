package org.ahedstrom.example;

import java.util.Map;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class ExampleService extends Service<Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.addResource(new Resource());
        environment.addServlet(new SseEventSourceServlet(), "/sse");
    }
    
    private int nothing(int x) {
        if(x > 7) {
            return 42;
        } else {
            return 7;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new ExampleService().run(args);
        int a = (3 + 5);
        //new ExampleService().run(args);
    }
}
