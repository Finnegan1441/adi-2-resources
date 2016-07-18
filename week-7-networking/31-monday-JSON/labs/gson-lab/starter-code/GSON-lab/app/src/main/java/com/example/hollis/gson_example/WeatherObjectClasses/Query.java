package com.example.hollis.gson_example.WeatherObjectClasses;

/**
 * Created by patrickcummins on 7/18/16.
 */

public class Query {
    private String created, lang;
    private Results results;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
