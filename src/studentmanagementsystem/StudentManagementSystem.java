package studentmanagementsystem;


import studentmanagementsystem.Student;

import java.util.HashSet;
public class StudentManagementSystem {
    private HashSet<studentmanagementsystem.Student> students;

    public StudentManagementSystem() {
        students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(String studentName) {
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        return null;
    }

    public String getAllStudentsInfo() {
        StringBuilder info = new StringBuilder();
        for (Student student : students) {
            info.append(student.toString()).append("\n");
        }
        return info.toString();
    }

    public HashSet<Student> getAllStudents() {
        return students;
    }
}

