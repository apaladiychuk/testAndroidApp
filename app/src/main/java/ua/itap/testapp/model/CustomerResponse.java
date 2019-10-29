package ua.itap.testapp.model;

import java.util.List;
import java.util.Map;

public class CustomerResponse {
    List<Customer> results;
    Map<String,Object> info;

    public List<Customer> getResults() {
        return results;
    }

    public void setResults(List<Customer> results) {
        this.results = results;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
