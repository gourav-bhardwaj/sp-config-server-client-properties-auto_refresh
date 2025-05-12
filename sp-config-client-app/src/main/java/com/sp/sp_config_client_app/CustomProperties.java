package com.sp.sp_config_client_app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
//@RefreshScope
@ConfigurationProperties(prefix = "echo.message")
public class CustomProperties {
    private String text;
    private String label;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "CustomProperties{" +
                "text='" + text + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
