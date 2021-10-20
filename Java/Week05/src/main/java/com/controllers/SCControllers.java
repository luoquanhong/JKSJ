package com.controllers;

import com.service.SCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/sc")
public class SCControllers {

    @Autowired
    private SCService service;

    @GetMapping(value = "/findAll")
    public String findAll(){
        return service.queryAllData();
    }
}
