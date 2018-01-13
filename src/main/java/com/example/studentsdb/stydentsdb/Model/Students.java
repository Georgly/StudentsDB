package com.example.studentsdb.stydentsdb.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Students implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Groups group;
    @Column(name = "task1")
    private boolean task1;
    @Column(name = "task2")
    private boolean task2;
    @Column(name = "task3")
    private boolean task3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
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
}
