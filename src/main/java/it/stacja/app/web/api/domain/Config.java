package it.stacja.app.web.api.domain;


import org.springframework.data.annotation.Id;

public class Config {

    @Id
    private String name;

    private String config;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
