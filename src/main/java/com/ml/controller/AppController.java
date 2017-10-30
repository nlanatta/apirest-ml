package com.ml.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ml.model.WeatherResult;

@RestController
public class AppController {

    @RequestMapping("/clima")
    public WeatherResult greeting(@RequestParam(value="dia", defaultValue="1") int day) {
        return new WeatherResult(day,"LLUVIA");
    }
}
