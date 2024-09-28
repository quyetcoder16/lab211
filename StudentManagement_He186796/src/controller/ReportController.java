package controller;

import java.util.ArrayList;
import model.Report;

/**
 * Controller class for handling reports (ReportController) Manages a list of
 * student reports.
 */
public class ReportController {

    // List of reports
    private final ArrayList<Report> listOfReport;

    /**
     * Constructor to initialize the ReportController with an empty report list
     */
    public ReportController() {
        this.listOfReport = new ArrayList<>();
    }

    /**
     * Constructor to initialize the ReportController with a given list of
     * reports
     *
     * @param listOfReport list of reports to initialize
     */
    public ReportController(ArrayList<Report> listOfReport) {
        this.listOfReport = listOfReport;
    }

    /**
     * Getter for the list of reports
     *
     * @return list of reports
     */
    public ArrayList<Report> getListOfReport() {
        return listOfReport;
    }

    /**
     * Clears all the reports from the list
     */
    public void clearReport() {
        this.listOfReport.clear();
    }

    /**
     * Checks if a report exists based on student ID, name, and course
     *
     * @param StudentId student ID to check
     * @param StudentName student name to check
     * @param course course name to check
     * @return true if the report exists, false otherwise
     */
    private boolean checkExitReport(String StudentId, String StudentName, String course) {
        for (Report report : listOfReport) {
            boolean isOk
                    = report.getStudentId().equalsIgnoreCase(StudentId)
                    && report.getStudentName().toLowerCase().contains(StudentName.toLowerCase())
                    && report.getCourse().toLowerCase().contains(course.toLowerCase());
            if (isOk) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a report to the list if it doesn't already exist
     *
     * @param studentId student ID of the report
     * @param StudentName student name of the report
     * @param course course name of the report
     * @param total total marks or score for the report
     */
    public void addIfReportNotExitReport(String studentId, String StudentName, String course, int total) {
        if (!checkExitReport(studentId, StudentName, course)) {
            Report newReport = new Report(studentId, StudentName, course, total);
            this.listOfReport.add(newReport);
        }
    }

    /**
     * Prints all the reports in the list to the console
     */
    public void printReport() {
        System.out.println("List of Reports");
        for (Report report : listOfReport) {
            System.out.println(report);
        }
    }
}
