package com.jacksen.activeandroiddemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by Admin on 2016/7/1.
 */

@Table(name = "grades")
public class Grade extends Model {

    @Column(name = "gid", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public int id;

    @Column(name = "name")
    public String name;

    public List<Student> items() {
        return getMany(Student.class, "grade");
    }

}
