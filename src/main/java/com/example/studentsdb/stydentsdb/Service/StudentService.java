package com.example.studentsdb.stydentsdb.Service;

import com.example.studentsdb.stydentsdb.Model.Converter.StudentConverter;
import com.example.studentsdb.stydentsdb.Model.DTO.GroupsDTO;
import com.example.studentsdb.stydentsdb.Model.DTO.StudentDTO;
import com.example.studentsdb.stydentsdb.Model.Students;
import com.example.studentsdb.stydentsdb.Repository.GroupRepository;
import com.example.studentsdb.stydentsdb.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<StudentDTO> getAllStudentsDTO(){
        Iterable<Students> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();

        for (Students student: students
                ) {
            studentDTOs.add(StudentConverter.ToDTO(student));
        }
        return studentDTOs;
    }
}
