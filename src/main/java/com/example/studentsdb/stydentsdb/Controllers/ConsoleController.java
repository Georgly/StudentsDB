package com.example.studentsdb.stydentsdb.Controllers;

import com.example.studentsdb.stydentsdb.Model.DTO.GroupsDTO;
import com.example.studentsdb.stydentsdb.Model.DTO.StudentDTO;
import com.example.studentsdb.stydentsdb.Model.Groups;
import com.example.studentsdb.stydentsdb.Model.Students;
import com.example.studentsdb.stydentsdb.Repository.GroupRepository;
import com.example.studentsdb.stydentsdb.Repository.StudentRepository;
import com.example.studentsdb.stydentsdb.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleController implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    private GroupService groupService;
    private Scanner scan=new Scanner(System.in);

    @Override
    public void run (String... args) {
        groupService = new GroupService(groupRepository);
        GroupsDTO groupsDTO1 = new GroupsDTO(1, 1, new ArrayList<StudentDTO>());
        GroupsDTO groupsDTO2 = new GroupsDTO(2, 3, new ArrayList<StudentDTO>());
        StudentDTO studentDTO1 = new StudentDTO("Kir Besonov", true, true, true);
        StudentDTO studentDTO2 = new StudentDTO("Alex Geras", true, true, true);
        StudentDTO studentDTO3 = new StudentDTO("Max Tutel", true, true, true);
        StudentDTO studentDTO4 = new StudentDTO("Gorg Korsakov", false, false, false);
        StudentDTO studentDTO5 = new StudentDTO("Vlad Dorogvtsev", false, false, false);
        StudentDTO studentDTO6 = new StudentDTO("Denchik Brandshtein", false, true, true);
        StudentDTO studentDTO7 = new StudentDTO("Urets Ogurets", true, false, false);
        groupService.addGroup(groupsDTO1);
        groupService.addGroup(groupsDTO2);
        groupService.addStudent(groupsDTO1, studentDTO1);
        groupService.addStudent(groupsDTO1, studentDTO2);
        groupService.addStudent(groupsDTO2, studentDTO3);
        groupService.addStudent(groupsDTO1, studentDTO4);
        groupService.addStudent(groupsDTO2, studentDTO5);
        groupService.addStudent(groupsDTO1, studentDTO6);
        groupService.addStudent(groupsDTO2, studentDTO7);
    }
}
