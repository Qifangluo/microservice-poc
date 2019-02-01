package com.example.mspoc.mspoccourseservice.dao;

import com.example.mspoc.mspoccourseservice.model.Course;

import java.util.HashSet;
import java.util.Set;

public class CourseDAO {

    //Database
    public static Set<Course> courseDB = new HashSet<>();
    static {
        courseDB.add(new Course("PHYS101", 3));
        courseDB.add(new Course("CHEM101", 4));
        courseDB.add(new Course("MATH101", 3));
    }
}
