package com.altimetric.tripMicroservice.model.Air;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Air {
    @JsonProperty("results")
    private List<Result> airline = null;
    public List<Result> getResults() {
        return airline;
    }

    public void setResults(List<Result> results) {
        this.airline = results;
    }
}
