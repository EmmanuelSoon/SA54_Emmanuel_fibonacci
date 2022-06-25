package emman.fibonacci.configuration;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

import org.checkerframework.checker.units.qual.min;

public class BasicConfiguration extends Configuration {

    @NotNull private final int maxNumber;
    @NotNull private final int minNumber;


    @JsonCreator
    public BasicConfiguration(@JsonProperty("maxNumber") final int maxNumber, @JsonProperty("minNumber") final int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    public int getmaxNumber() {
        return maxNumber;
    }

    public int getminNumber() {
        return minNumber;
    }
}