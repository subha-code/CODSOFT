package studentmanagementsystem;

public class Student {
    private String studentName;
    private String rollNumber;
    private String grade;
    private String emailAdd;
    private String phoneNumber;
    private String courseDetails;
    private String homeAddress;

    public Student(String studentName, String rollNumber, String grade, String emailAdd, String phoneNumber, String courseDetails, String homeAddress) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.emailAdd = emailAdd;
        this.phoneNumber = phoneNumber;
        this.courseDetails = courseDetails;
        this.homeAddress = homeAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCourseDetails() {
        return courseDetails;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    @Override
    public String toString() {
        return "Student Name: " + studentName + ", Roll Number: " + rollNumber + ", Grade: " + grade + ", Email Address: " + emailAdd + ", Phone Number: " + phoneNumber + ", Course Details: " + courseDetails + ", Home Address: " + homeAddress;
    }
}
