package com.sp.sp_config_client_app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final CustomProperties properties;

    public AppController(CustomProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/show-props")
    public ResponseEntity<String> showProperties() {
        return ResponseEntity.ok(properties.toString());
    }

}
