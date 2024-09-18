/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Student;
import util.Validation;

/**
 *
 * @author quyet
 */
public class StudentConTroller {

    private final ArrayList<Student> listOfStudent;
    private final Validation validation = new Validation();

    public StudentConTroller() {
        this.listOfStudent = new ArrayList<>();
    }

    public StudentConTroller(ArrayList<Student> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }

    public ArrayList<Student> getListOfStudent() {
        return listOfStudent;
    }

    /**
     * function: add new student
     */
    public void addNewStudent() {
        int countNumberOfStudentEnter = 0;
        while (true) {
            String id = validation.genarateId("SV", this.listOfStudent.size() + 1);
            System.out.println("===================");
            System.out.println("Enter infomation of " + id);
            String studentName = validation.validateStudentName();
            System.out.print("Enter Semester:");
            String semester = validation.getString();
            String courseName = validation.validateCourseName();
            Student newStudent = new Student(id, studentName, semester, courseName);

            this.listOfStudent.add(newStudent);
            countNumberOfStudentEnter++;

            if (countNumberOfStudentEnter >= 1) {
                if (!validation.validateConfirm()) {
                    return;
                }
            }
        }
    }

    /**
     * function: find list of student contain name
     *
     * @param name : name of student want to search
     * @return list of student contain name
     * @throws Exception
     */
    public ArrayList<Student> findByName(String name) throws Exception {
        if (listOfStudent.isEmpty()) {
            throw new Exception("List of Student is empty");
        }
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        for (Student student : listOfStudent) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

//    function: find and sort 
//    method: find list student by name ,
//    after that sort list by studentName 
//    print list 
    /**
     * function: find and sort
     */
    public void findAndSort() {
        if (listOfStudent.isEmpty()) {
            System.out.println("List of student is empty so can't find and sort");
            return;
        }
        String nameSearch = validation.validateStudentName();
        try {
            ArrayList<Student> listOfStudentFindByName = findByName(nameSearch);
            if (listOfStudentFindByName.isEmpty()) {
                System.out.println("list of student find is empty");
                return;
            }
            Collections.sort(listOfStudent, (Student student1, Student student2) -> {
                return (int) (student1.getStudentName().compareTo(student2.getStudentName()));
            });

            for (Student student : listOfStudentFindByName) {
                System.out.format("%-20s | %-15s | %-15s\n", student.getStudentName(), student.getSemester(), student.getCourseName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printList() {
        for (Student student : listOfStudent) {
            System.out.println(student);
        }
    }

}
