package com.lexisnexi.risk.model;

import java.util.List;

public class CompanyDetailsResponse {

    private long total_results;
    private List<Item> items;

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
