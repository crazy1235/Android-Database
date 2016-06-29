package com.jacksen.sqlitedemo.bean;

/**
 * Created by Admin on 2016/6/28.
 */
public class Student {

    private int id;
    private String name;
    private int sex;
    private int classId;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int sex, int classId, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.classId = classId;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
