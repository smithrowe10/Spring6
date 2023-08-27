package com.lm.spring6.ditest;

import org.apache.logging.log4j.util.Strings;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ming
 * @date 2023.06.19
 * @about
 */
public class Student {
    private String name;

    private School school;

    private String[] course;

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void study(){

        school.info();
        System.out.println(Arrays.toString(course));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
