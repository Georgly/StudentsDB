package com.example.studentsdb.stydentsdb.Model.DTO;

public class StudentDTO {

    private String name;
    private boolean task1;
    private boolean task2;
    private boolean task3;

    public StudentDTO(String name, boolean task1, boolean task2, boolean task3) {
        this.name = name;
        this.task1 = task1;
        this.task2 = task2;
        this.task3 = task3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTask1() {
        return task1;
    }

    public void setTask1(boolean task1) {
        this.task1 = task1;
    }

    public boolean isTask2() {
        return task2;
    }

    public void setTask2(boolean task2) {
        this.task2 = task2;
    }

    public boolean isTask3() {
        return task3;
    }

    public void setTask3(boolean task3) {
        this.task3 = task3;
    }

    @Override
    public String toString() {
        return "    Name: " + name
                + "; Task: 1. "
                + (isTask1() ? "сдал" : "не сдал")
                + " 2. " + (isTask2() ? "сдал" : "не сдал")
                + " 3. " + (isTask3() ? "сдал" : "не сдал");
    }
}
