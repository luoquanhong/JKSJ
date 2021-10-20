package com.service.impl;

import com.entity.SC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mappers.SCMapper;
import com.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCServiceImpl implements SCService {

    @Autowired
    private SCMapper scMapper;

    @Override
    public String queryAllData() {
        String result ="";
        List<SC> resultList = scMapper.findAllData();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(resultList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
