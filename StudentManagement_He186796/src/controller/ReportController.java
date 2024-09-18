/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Report;

/**
 *
 * @author quyet
 */
public class ReportController {

    private final ArrayList<Report> listOfReport;

    public ReportController() {
        this.listOfReport = new ArrayList<>();
    }

    public ReportController(ArrayList<Report> listOfReport) {
        this.listOfReport = listOfReport;
    }

    public ArrayList<Report> getListOfReport() {
        return listOfReport;
    }

    public void clearReport() {
        this.listOfReport.clear();
    }

    /**
     *
     * @param StudentName
     * @param course
     * @return
     */
    private boolean checkExitReport(String StudentName, String course) {
        for (Report report : listOfReport) {
            boolean isOk = report.getStudentName().toLowerCase().contains(StudentName.toLowerCase())
                    && report.getCourse().toLowerCase().contains(course.toLowerCase());
            if (isOk) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param StudentName
     * @param course
     * @param total
     */
    public void addIfReportNotExitReport(String StudentName, String course, int total) {
        if (!checkExitReport(StudentName, course)) {
            Report newReport = new Report(StudentName, course, total);
            this.listOfReport.add(newReport);
        }
    }

    public void printReport() {
        System.out.println("List of Report");
        for (Report report : listOfReport) {
            System.out.println(report);
        }
    }

}
