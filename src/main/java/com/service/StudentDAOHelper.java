package com.service;

import com.api.Student;
import com.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("studentDaoHelper")
public class StudentDAOHelper
{
    @Autowired
    private StudentDAO studentDAOImplementation;

    public void setUpStudentTable()
    {
        Student student1 = new Student();
        student1.setRollno(1);
        student1.setName("Hrithik");
        student1.setAddress("Nanded");

        Student student2 = new Student();
        student2.setRollno(2);
        student2.setName("Akash");
        student2.setAddress("Pune");

        Student student3 = new Student();
        student3.setRollno(3);
        student3.setName("Mohan");
        student3.setAddress("Banglore");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        studentDAOImplementation.insert(studentList);
    }
}
