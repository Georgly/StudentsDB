package com.example.studentsdb.stydentsdb.Service;

import com.example.studentsdb.stydentsdb.Model.Converter.GroupConverter;
import com.example.studentsdb.stydentsdb.Model.DTO.GroupsDTO;
import com.example.studentsdb.stydentsdb.Model.DTO.StudentDTO;
import com.example.studentsdb.stydentsdb.Model.Groups;
import com.example.studentsdb.stydentsdb.Model.Students;
import com.example.studentsdb.stydentsdb.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public ArrayList<GroupsDTO> getAllGroupsDTO(){
        Iterable<Groups> groups = groupRepository.findAll();
        ArrayList<GroupsDTO> studentDTOs = new ArrayList<GroupsDTO>();

        for (Groups group: groups
                ) {
            studentDTOs.add(GroupConverter.ToDTO(group));
        }
        return studentDTOs;
    }

    public void addGroup(int group_number, int year){
        GroupsDTO groupsDTO = new GroupsDTO(group_number, year, new ArrayList<StudentDTO>());
        Groups group = GroupConverter.ToEntity(groupsDTO);
        for (Students student: group.getStudents()) {
            student.setGroup(group);
        }
        groupRepository.save(group);
    }

    public void addGroup(GroupsDTO groupsDTO){
        Groups group = GroupConverter.ToEntity(groupsDTO);
        for (Students student: group.getStudents()) {
            student.setGroup(group);
        }
        groupRepository.save(group);
    }

    public GroupsDTO find(int group_number, int year){

        for (GroupsDTO groupsDTO : getAllGroupsDTO()){
            if (groupsDTO.getGroup_number() == group_number &&
                    groupsDTO.getYear() == year){
                return groupsDTO;
            }
        }
        return null;
    }

    public String showAllGroups(){
        String allGroups = "";
        for (GroupsDTO groupsDTO : getAllGroupsDTO()){
            allGroups += groupsDTO.toString() + "\n";
        }
        System.out.println("groups list");
        return allGroups;
    }

    public void deleteGroup(int group_number, int year){
        for (Groups groups : groupRepository.findAll()){
            if (groups.getGroup_number() == group_number &&
                    groups.getYear() == year){
                groupRepository.delete(groups);
            }
        }
    }

    public boolean addStudent(GroupsDTO group, StudentDTO student){
        boolean rez = false;
        int group_number = group.getGroup_number();
        int year = group.getYear();
        group.addStudent(student);
        deleteGroup(group_number, year);
        addGroup(group);
        return true;
    }

    public void deleteStudent(GroupsDTO group, StudentDTO student){
        int group_number = group.getGroup_number();
        int year = group.getYear();
        group.DeleteStudent(student.getName());
        deleteGroup(group_number, year);
        addGroup(group);
    }

    public StudentDTO findStudent(String studentName){
        ArrayList<GroupsDTO> groupsDTOs = getAllGroupsDTO();
        for (GroupsDTO groupsDTO : groupsDTOs){
            ArrayList<StudentDTO> studentDTOs = groupsDTO.getStudents();
            for (StudentDTO studentDTO : studentDTOs){
                if (studentDTO.getName().equals(studentName)){
                    return studentDTO;
                }
            }
        }
        return null;
    }

    public void editTask(GroupsDTO group, StudentDTO student, boolean task1, boolean task2, boolean task3){
        student.setTask1(task1);
        student.setTask2(task2);
        student.setTask3(task3);
        group.DeleteStudent(student.getName());
        deleteGroup(group.getGroup_number(), group.getYear());
        group.addStudent(student);
        addGroup(group);
    }
}
