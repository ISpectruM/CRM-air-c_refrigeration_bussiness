package com.ispectrum.crmclima.areas.search.models;

public class SearchBindingModel {

    private String criteria;

    private String searchString;

    public SearchBindingModel() {
    }



    public String getSearchString() {
        return this.searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getCriteria() {
        return this.criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
}
