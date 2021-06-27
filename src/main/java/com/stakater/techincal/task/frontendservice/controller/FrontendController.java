package com.stakater.techincal.task.frontendservice.controller;

import com.stakater.techincal.task.frontendservice.config.FrontendServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("frontend-service")
public class FrontendController {
    @Autowired
    private FrontendServiceConfig frontendServiceConfig;

    @Autowired
    private RestTemplate rest;

    @GetMapping
    public String getBackendEnvironmentName()
    {
        final Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        final String dateFormatAsString = dateFormat.format(date);

        final String backendResponse = rest.getForObject(frontendServiceConfig.getBackendRestApiUrl(), String.class);

        return dateFormatAsString + " "+ backendResponse;
    }
}
