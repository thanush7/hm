
package com.hospital.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String loadHomePage() {
        
        return "home"; // This should return "home.html" or "home.jsp" based on your configuration
    }
}
