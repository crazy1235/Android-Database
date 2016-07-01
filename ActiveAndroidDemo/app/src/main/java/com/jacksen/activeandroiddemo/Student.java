package com.jacksen.activeandroiddemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Admin on 2016/7/1.
 */


@Table(name = "students")
public class Student extends Model {

    @Column(name = "sid", unique = true, onUniqueConflicts = Column.ConflictAction.REPLACE)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    public int age;

    @Column(name = "grade")
    public Grade grade;
}
