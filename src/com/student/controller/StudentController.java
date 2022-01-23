package com.student.controller;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.service.StudentServiceImplementation;
import com.student.view.StudentView;

public class StudentController {
    private StudentService service = new StudentServiceImplementation();

    public void addStudent(int rollNo, Student student) {
       service.addStudent(rollNo, student);
    }

    public void removeStudent(int rollNo) {
        StudentView.showallStudents(service.removeStudent(rollNo));
    }

    public void getStudentDetails(int rollNo) {
        service.getStudentDetails(rollNo);
    }

    public void updateStudentDetails(int rollNo, Student student) {
        StudentView.showUpdate(service.updateStudentDetails(rollNo, student));
    }

    public void showAllStudents() {
        service.showAllStudents();
    }
}
