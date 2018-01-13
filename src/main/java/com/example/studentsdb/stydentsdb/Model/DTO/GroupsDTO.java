package com.example.studentsdb.stydentsdb.Model.DTO;

import java.util.ArrayList;

public class GroupsDTO {

    private int group_number;
    private int year;
    private ArrayList<StudentDTO> students;

    public GroupsDTO(int group_number, int year, ArrayList<StudentDTO> students) {
        this.group_number = group_number;
        this.year = year;
        this.students = students;
    }

    public int getGroup_number() {
        return group_number;
    }

    public void setGroup_number(int group_number) {
        this.group_number = group_number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentDTO> students) {
        this.students = students;
    }

    public boolean DeleteStudent(String name)
    {
        boolean rez = false;
        StudentDTO falseStudent = null;

        for (StudentDTO student: students){
            if (student.getName().equals(name)) {
                falseStudent = student;
                rez = true;
            }
        }
        if (rez){
            students.remove(falseStudent);
        }
        return rez;
    }

    public void addStudent(StudentDTO student){
        students.add(student);
    }

    @Override
    public String toString(){
        String studentList = "Students: \n";
        for (StudentDTO student : students){
            studentList += student.toString() + "\n";
        }
        return getGroup_number() + " " + getYear() + "\n" + studentList;
    }
}
