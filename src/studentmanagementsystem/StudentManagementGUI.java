package studentmanagementsystem;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashSet;

public class StudentManagementGUI extends Application {
    private StudentManagementSystem studentManagementSystem;
    private static final String STORAGE_FILE = "student_detail.txt";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        studentManagementSystem = new StudentManagementSystem();
        loadStudentsFromFile();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label rollLabel = new Label("Roll Number:");
        TextField rollField = new TextField();
        Label gradeLabel = new Label("Grade:");
        TextField gradeField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();
        Label courseLabel = new Label("Course Details:");
        TextField courseField = new TextField();
        Label homeLabel = new Label("Home Address:");
        TextField homeField = new TextField();

        Button saveButton = new Button("Save");
        Button removeButton = new Button("Remove Student");
        Button searchButton = new Button("Search Student");
        Button displayButton = new Button("Display All Students");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        saveButton.setOnAction(event -> {
            String name = nameField.getText();
            String roll = rollField.getText();
            String grade = gradeField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String course = courseField.getText();
            String home = homeField.getText();

            if (!name.isEmpty() && !roll.isEmpty() && !grade.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !course.isEmpty() && !home.isEmpty()) {
                Student student = new Student(name, roll, grade, email, phone, course, home);
                studentManagementSystem.addStudent(student);
                saveStudentsToFile();
                clearFields(nameField, rollField, gradeField, emailField, phoneField, courseField, homeField);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student added successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Please fill in all the fields.");
            }
        });

        removeButton.setOnAction(event -> {
            String name = nameField.getText();
            Student student = studentManagementSystem.searchStudent(name);
            if (student != null) {
                studentManagementSystem.removeStudent(student);
                saveStudentsToFile();
                clearFields(nameField, rollField, gradeField, emailField, phoneField, courseField, homeField);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Student removed successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Student not found.");
            }
        });

        searchButton.setOnAction(event -> {
            String name = nameField.getText();
            Student student = studentManagementSystem.searchStudent(name);
            if (student != null) {
                rollField.setText(student.getRollNumber());
                gradeField.setText(student.getGrade());
                emailField.setText(student.getEmailAdd());
                phoneField.setText(student.getPhoneNumber());
                courseField.setText(student.getCourseDetails());
                homeField.setText(student.getHomeAddress());
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Student not found.");
            }
        });

        displayButton.setOnAction(event -> {
            String allStudentsInfo = studentManagementSystem.getAllStudentsInfo();
            if (!allStudentsInfo.isEmpty()) {
                resultArea.setText(allStudentsInfo);
            } else {
                showAlert(Alert.AlertType.INFORMATION, "Information", "No students found.");
            }
        });

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(rollLabel, 0, 1);
        gridPane.add(rollField, 1, 1);
        gridPane.add(gradeLabel, 0, 2);
        gridPane.add(gradeField, 1, 2);
        gridPane.add(emailLabel, 0, 3);
        gridPane.add(emailField, 1, 3);
        gridPane.add(phoneLabel, 0, 4);
        gridPane.add(phoneField, 1, 4);
        gridPane.add(courseLabel, 0, 5);
        gridPane.add(courseField, 1, 5);
        gridPane.add(homeLabel, 0, 6);
        gridPane.add(homeField, 1, 6);
        gridPane.add(saveButton, 0, 7);
        gridPane.add(removeButton, 1, 7);
        gridPane.add(searchButton, 0, 8);
        gridPane.add(displayButton, 1, 8);
        gridPane.add(resultArea, 0, 9, 2, 1);

        Scene scene = new Scene(gridPane, 600, 400);
        primaryStage.setTitle("Student Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STORAGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String name = parts[0];
                    String roll = parts[1];
                    String grade = parts[2];
                    String email = parts[3];
                    String phone = parts[4];
                    String course = parts[5];
                    String home = parts[6];
                    Student student = new Student(name, roll, grade, email, phone, course, home);
                    studentManagementSystem.addStudent(student);
                }
            }
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load students from file.");
        }
    }

    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STORAGE_FILE))) {
            for (Student student : studentManagementSystem.getAllStudents()) {
                writer.write(student.getStudentName() + "," + student.getRollNumber() + "," + student.getGrade() + "," +
                        student.getEmailAdd() + "," + student.getPhoneNumber() + "," + student.getCourseDetails() + "," +
                        student.getHomeAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save students to file.");
        }
    }

    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
