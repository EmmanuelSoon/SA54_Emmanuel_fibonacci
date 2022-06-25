package emman.fibonacci;

import emman.fibonacci.api.health.Healthcheck;
import emman.fibonacci.configuration.BasicConfiguration;
import emman.fibonacci.resources.FibonacciResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FibonacciApplication extends Application<BasicConfiguration> {
    public static void main(String[] args) throws Exception {
        new FibonacciApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(BasicConfiguration configuration, Environment environment) throws Exception {
        final FibonacciResource resource = new FibonacciResource();
        final Healthcheck healthCheck =
        new Healthcheck(configuration.getmaxNumber());
        environment.healthChecks().register("maxNumber", healthCheck);
        environment.jersey().register(resource);
    }
}
