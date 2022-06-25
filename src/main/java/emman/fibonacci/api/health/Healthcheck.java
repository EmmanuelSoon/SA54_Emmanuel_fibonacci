package emman.fibonacci.api.health;

import com.codahale.metrics.health.HealthCheck;

public class Healthcheck extends HealthCheck {
    private final int element;

    public Healthcheck(int element) {
        super();
        this.element = element;
    }

    @Override
    protected Result check() throws Exception{
        final int element = 0;
        if (element != 0) {
            return Result.unhealthy("element is not zero");
        }
        return Result.healthy();
    }

}
