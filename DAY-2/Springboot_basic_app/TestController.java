package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalTime;
import java.util.Map;
import java.util.Random;

@Controller
public class TestController {

    // Route 1: Serves the beautiful index.html page
    @GetMapping("/")
    public String showDashboard() {
        return "index";
    }

    // Route 2: Live API endpoint used by the webpage JavaScript button
    @GetMapping("/api/status")
    @ResponseBody
    public Map<String, Object> getLiveStatus() {
        Random random = new Random();
        return Map.of(
                "timestamp", LocalTime.now().toString().substring(0, 8),
                "loadPercent", random.nextInt(40) + 60
        );
    }
}
