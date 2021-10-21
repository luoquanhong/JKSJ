package com.service;

import com.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryAllData();

    int createDataToStudentTable(Student student);

    String queryAllDataToJson();
}
