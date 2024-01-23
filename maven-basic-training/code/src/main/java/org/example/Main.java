package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("John");
        student.setAge(20);
        student.setSubjects(Arrays.asList("Maths", "English", "History"));

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Subjects: " + student.getSubjects());
    }
}