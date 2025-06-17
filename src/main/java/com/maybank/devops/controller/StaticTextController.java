package com.maybank.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StaticTextController {

    @GetMapping("/static-text")
    public String getStaticText() {
        return "Ini adalah teks statis.";
    }

}
