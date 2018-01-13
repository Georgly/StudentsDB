package com.example.studentsdb.stydentsdb.Model.Converter;

import com.example.studentsdb.stydentsdb.Model.DTO.StudentDTO;
import com.example.studentsdb.stydentsdb.Model.Students;

public class StudentConverter {

    public static Students ToEntity(StudentDTO studentDTO){
        Students student = new Students();
        student.setName(studentDTO.getName());
        student.setTask1(studentDTO.isTask1());
        student.setTask2(studentDTO.isTask2());
        student.setTask3(studentDTO.isTask3());
        return student;
    }

    public static StudentDTO ToDTO(Students student){
        return new StudentDTO(student.getName(), student.isTask1(), student.isTask2(), student.isTask3());
    }
}
