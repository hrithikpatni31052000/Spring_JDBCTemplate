package com.dao;

import com.api.Student;

import java.util.List;

public interface StudentDAO
{
    void insert(Student student);
    void insert(List<Student> students);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByStudentNameAndStudentAddress(String studentName , String studentAddress);
}
