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
    private final ReportController reportController = new ReportController();
    
    public StudentConTroller() {
        this.listOfStudent = new ArrayList<>();
        Student student = new Student("He18", "duong", "fa", "Java");
        listOfStudent.add(student);
        listOfStudent.add(new Student("He18", "duong", "fa", ".Net"));
        listOfStudent.add(new Student("He18", "duong", "fa1", ".Net"));
        listOfStudent.add(new Student("He17", "chien", "fa1", ".Net"));
        
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
            System.out.println("===================");
            System.out.print("enter Id: ");
            String id = validation.getString();
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
            Collections.sort(listOfStudentFindByName, (Student student1, Student student2) -> {
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
    
    public ArrayList<Student> getListStudentById(String ID) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student student : this.listOfStudent) {
            if (student.getID().equalsIgnoreCase(ID)) {
                res.add(student);
            }
        }
        return res;
    }
    
    private boolean checkCanUpdate(Student studentUpDate, int indexStudentUpdate) {
        for (int i = 0; i < listOfStudent.size(); i++) {
            Student studentCurrent = listOfStudent.get(i);
            boolean isSameIdAndCourseAndSameSesmeter
                    = studentCurrent.getID().equalsIgnoreCase(studentUpDate.getID())
                    && studentCurrent.getCourseName().equalsIgnoreCase(studentUpDate.getCourseName())
                    && studentCurrent.getSemester().equalsIgnoreCase(studentUpDate.getSemester());
            
            if (isSameIdAndCourseAndSameSesmeter) {
                System.out.println(indexStudentUpdate + " " + i);
                return (indexStudentUpdate == i);
            }
        }
        return true;
    }
    
    public void updateStudent(Student studentWantToUpdate) {
        Student studentUpdateInListOfStudent = new Student();
        int index = -1;
        for (int i = 0; i < listOfStudent.size(); i++) {
            Student student = listOfStudent.get(i);
            boolean isSameInfoStudent
                    = student.getID().equalsIgnoreCase(studentWantToUpdate.getID())
                    && student.getCourseName().equalsIgnoreCase(studentWantToUpdate.getCourseName())
                    && student.getStudentName().equalsIgnoreCase(studentWantToUpdate.getStudentName())
                    && student.getSemester().equalsIgnoreCase(studentWantToUpdate.getSemester());
            if (isSameInfoStudent) {
                studentUpdateInListOfStudent = student;
                index = i;
                break;
            }
        }
        
        System.out.println("Enter New Name : ");
        String newName = validation.validateStudentName();
        System.out.println("Enter new Semester: ");
        String newSemester = validation.getString();
        System.out.println("Enter course name:");
        String newCourse = validation.validateCourseName();
        
        Student newInfo = new Student(studentUpdateInListOfStudent.getID(), newName, newSemester, newCourse);
        if (checkCanUpdate(newInfo, index)) {
            if (!newInfo.getStudentName().equalsIgnoreCase(studentWantToUpdate.getStudentName())) {
                for (Student student : listOfStudent) {
                    if (student.getID().equalsIgnoreCase(studentWantToUpdate.getID())) {
                        student.setStudentName(newName);
                    }
                }
            }
            Student studentUpdateInLiStudent = listOfStudent.get(index);
            studentUpdateInLiStudent.setStudentName(newName);
            studentUpdateInLiStudent.setSemester(newSemester);
            studentUpdateInLiStudent.setCourseName(newCourse);
        } else {
            System.out.println("Can't update");
        }
    }
    
    public void updateOrDelete() {
        System.out.println("enter Id: ");
        String idSearch = validation.getString();
        ArrayList<Student> listOfStudentFindById = this.getListStudentById(idSearch);
        if (listOfStudentFindById.isEmpty()) {
            System.out.println("List student don't have " + idSearch);
            return;
        }
        
        for (int i = 0; i < listOfStudentFindById.size(); i++) {
            Student studentCurrent = listOfStudentFindById.get(i);
            System.out.format("%-15d%-20s%-15s%-15s%-15s\n", i + 1, studentCurrent.getID(),
                    studentCurrent.getStudentName(),
                    studentCurrent.getSemester(), studentCurrent.getCourseName());
        }
        
        System.out.print("Enter your chose: ");
        int id = validation.getIntBetween(0, listOfStudentFindById.size());
        System.out.println("Do you want to update to delete: ");
        
        Student StudentDeleleOrUpdate = listOfStudentFindById.get(id - 1);
        String inputConfirm = validation.getString();
        if (inputConfirm.equalsIgnoreCase("D")) {
            listOfStudent.remove(StudentDeleleOrUpdate);
        } else {
            updateStudent(StudentDeleleOrUpdate);
        }
        
    }
    
    public void report() {
        if (listOfStudent.isEmpty()) {
            System.out.println("List of student is empty!");
            return;
        }
//        clean data in report if exist before
        reportController.clearReport();
        for (Student student : listOfStudent) {
            int totalOfCourse = 0;
            String studentName = student.getStudentName();
            String course = student.getCourseName();
            String studentId = student.getID();
            for (Student studentCountTotal : listOfStudent) {
                boolean isEqualStudentNameAndCourse
                        = studentId.equalsIgnoreCase(studentCountTotal.getID())
                        && studentName.equalsIgnoreCase(studentCountTotal.getStudentName())
                        && course.equalsIgnoreCase(studentCountTotal.getCourseName());
                if (isEqualStudentNameAndCourse) {
                    totalOfCourse++;
                }
            }
            reportController.addIfReportNotExitReport(studentId, studentName, course, totalOfCourse);
        }
        
        reportController.printReport();
    }
    
}
