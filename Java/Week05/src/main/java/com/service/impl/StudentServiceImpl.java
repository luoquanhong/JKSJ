package com.service.impl;

import com.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mappers.StudentMapper;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAllData() {
        return studentMapper.findAllData();
    }

    @Override
    public int createDataToStudentTable(Student student) {
        return studentMapper.createData(student);
    }

    @Override
    public String queryAllDataToJson() {
        String result = "";
        try {
            result = new ObjectMapper().writeValueAsString(studentMapper.findAllData());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
