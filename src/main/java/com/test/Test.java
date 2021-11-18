package com.test;

import com.api.Student;
import com.dao.StudentDAOImplementation;
import com.service.StudentDAOHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("beans.xml file loaded");

        StudentDAOImplementation studentDAO = context.getBean("studentDAO" , StudentDAOImplementation.class);
/*
        Student newStudent1 = new Student();
        newStudent1.setRollno(007);
        newStudent1.setName("Kamal");
        newStudent1.setAddress("Chennai");
        studentDAO.insert(newStudent1);
        */

        /*
        boolean isDeleted =  studentDAO.deleteRecordByRollNo(001);
        if(isDeleted)
        {
            System.out.println("the roll no data got deleted");
        }*/

        //To delete records whose student name is mohan or address is hyderabad
        //studentDAO.deleteRecordByStudentNameAndStudentAddress("Mohan" , "Hyderabad");

        //To delete the entire table record
        //studentDAO.cleanUp();


        StudentDAOHelper studentDAOHelper = context.getBean("studentDaoHelper" , StudentDAOHelper.class);
        studentDAOHelper.setUpStudentTable();
    }
}
