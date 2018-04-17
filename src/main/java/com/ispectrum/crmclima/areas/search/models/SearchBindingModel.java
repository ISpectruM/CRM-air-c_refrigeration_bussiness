package com.ispectrum.crmclima.areas.search.models;

public class SearchBindingModel {

    private boolean isPhoneSearch;

    private boolean isAddressSearch;

    private boolean isNameSearch;

    private String searchString;

    public SearchBindingModel() {
    }


    public boolean getIsPhoneSearch() {
        return this.isPhoneSearch;
    }

    public void setIsPhoneSearch(boolean phoneSearch) {
        this.isPhoneSearch = phoneSearch;
    }

    public boolean isAddressSearch() {
        return this.isAddressSearch;
    }

    public void setIsAddressSearch(boolean addressSearch) {
        isAddressSearch = addressSearch;
    }

    public boolean getIsNameSearch() {
        return this.isNameSearch;
    }

    public void setIsNameSearch(boolean nameSearch) {
        isNameSearch = nameSearch;
    }

    public String getSearchString() {
        return this.searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
