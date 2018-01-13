package com.example.studentsdb.stydentsdb.Model.Converter;

import com.example.studentsdb.stydentsdb.Model.DTO.GroupsDTO;
import com.example.studentsdb.stydentsdb.Model.DTO.StudentDTO;
import com.example.studentsdb.stydentsdb.Model.Groups;
import com.example.studentsdb.stydentsdb.Model.Students;

import java.util.ArrayList;
import java.util.List;

public class GroupConverter {

    public static Groups ToEntity(GroupsDTO groupsDTO){
        Groups group = new Groups();
        group.setGroup_number(groupsDTO.getGroup_number());
        group.setYear(groupsDTO.getYear());

        if (groupsDTO.getStudents() != null){
            List<StudentDTO> studentDTOs = groupsDTO.getStudents();
            List<Students> students = new ArrayList<>();
            for (StudentDTO studentDTO : studentDTOs){
                students.add(StudentConverter.ToEntity(studentDTO));
            }
            group.setStudents(students);
        }
        else {
            group.setStudents(new ArrayList<Students>());
        }

        return group;
    }

    public static GroupsDTO ToDTO(Groups group){
        ArrayList<StudentDTO> studentDTOs;
        if (group.getStudents() != null){
            studentDTOs = new ArrayList<>();
            List<Students> students = group.getStudents();
            for (Students student: students){
                studentDTOs.add(StudentConverter.ToDTO(student));
            }
        }
        else {
            studentDTOs = null;
        }

        return new GroupsDTO(group.getGroup_number(), group.getYear(), studentDTOs);
    }
}
