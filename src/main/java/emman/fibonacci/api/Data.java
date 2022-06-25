package emman.fibonacci.api;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    private List<Long> fibonacci;
    private List<Long> sorted;

    public Data() {
        // Jackson deserialization
    }

    public Data(ArrayList<Long> fibonacci, ArrayList<Long> sorted) {
        super();
        this.fibonacci = fibonacci;
        this.sorted = sorted;
    }

    @JsonProperty
    public List<Long> getFibonacci() {
        return fibonacci;
    }

    @JsonProperty
    public List<Long> getSorted() {
        return sorted;
    }
}
