package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.StudentCourses;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StudentCoursesDAO {
    public static ArrayList<StudentCourses> getStudentCourses(String studentID) {
        ArrayList<StudentCourses> studentCourses = new ArrayList<>();
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM CourseRoster WHERE studentID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String CRN = rs.getString("CRN");
                String grade = rs.getString("grade");
                sql = "SELECT * FROM Schedule WHERE CRN = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, CRN);
                ResultSet rs2 = pstmt.executeQuery();

                while(rs2.next()) {
                    String courseName = rs2.getString("courseName");
                    StudentCourses studentCourse = new StudentCourses();
                    studentCourse.setStudentID(studentID);
                    studentCourse.setCRN(CRN);
                    studentCourse.setGrade(grade);
                    studentCourse.setCourseName(courseName);
                    studentCourse.setCourseID(rs2.getString("courseID"));
                    studentCourse.setTerm(rs2.getString("term"));
                    studentCourse.setFacultyID(rs2.getString("facultyID"));
                    studentCourses.add(studentCourse);
                }
            }
        } catch(SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Database Error");
            alert.setContentText("Could not retrieve student courses: " + e.getMessage());
            alert.showAndWait();
        }

        return studentCourses;
    }
}
