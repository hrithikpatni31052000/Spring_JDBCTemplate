package com.dao;

import com.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("studentDAO")
//same as @Component
public class StudentDAOImplementation implements StudentDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student)
    {
        String sql = "Insert into student values(?,?,?)";

        Object[] arg = {student.getRollno() , student.getName() , student.getAddress()};
        int noOfRowInserted = jdbcTemplate.update(sql , arg);

        System.out.println("No of row inserted is " + noOfRowInserted );
    }

    @Override
    public boolean deleteRecordByRollNo(int rollNo)
    {
        String sql = "Delete from student where roll_no = ? ";

        int noOfRowDeleted = jdbcTemplate.update(sql , rollNo);
        System.out.println("no of row deleted = " + noOfRowDeleted);
        return noOfRowDeleted == 1;
    }

    @Override
    public int deleteRecordByStudentNameAndStudentAddress(String studentName,String studentAddress)
    {
        String sql = "delete from student where student_name = ? or student_address = ?";

        int noOfRowDeleted = jdbcTemplate.update(sql , studentName , studentAddress);
        System.out.println("No of rows deleted " + noOfRowDeleted);
        return noOfRowDeleted;
    }

    public void cleanUp()
    {
        String sql = "Truncate table student";
        jdbcTemplate.execute(sql);
        System.out.println("Table Cleaned Up");
    }

    @Override
    public void insert(List<Student> students)
    {
        String sql = "insert into student(roll_no , student_name , student_address) values(?,?,?)";

        ArrayList<Object[]> sqlArgs = new ArrayList<>();
        for(Student tempStudent : students)
        {
            Object[] studentData = {tempStudent.getRollno(),tempStudent.getName(),tempStudent.getAddress()};
            sqlArgs.add(studentData);
        }
        jdbcTemplate.batchUpdate(sql , sqlArgs);
        System.out.println("Batch update completed");
    }
}
