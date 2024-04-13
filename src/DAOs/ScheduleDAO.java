package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Schedule;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ScheduleDAO {

    public static ArrayList<Schedule> getAllCourses() {
        ArrayList<Schedule> courses = new ArrayList<>();

        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Schedule";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Schedule course = new Schedule();
                course.setCRN(rs.getLong("CRN"));
                course.setCapacity(rs.getInt("Capacity"));
                course.setCreditHours(rs.getInt("CreditHours"));
                course.setFacultyID(rs.getString("FacultyID"));
                course.setRoom(rs.getString("Room"));
                course.setTerm(rs.getString("Term"));
                course.setCourseName(rs.getString("CourseName")); // corrected line
                course.setCourseID(rs.getString("CourseID"));
                courses.add(course);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        return courses;
    }

    public static boolean insertCourse(Schedule schedule) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO Schedule (courseID, CRN, courseName, term, facultyID, room, capacity, creditHours) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, schedule.getCourseID());
            pstmt.setLong(2, schedule.getCRN());
            pstmt.setString(3, schedule.getCourseName());
            pstmt.setString(4, schedule.getTerm());
            pstmt.setString(5, schedule.getFacultyID());
            pstmt.setString(6, schedule.getRoom());
            pstmt.setInt(7, schedule.getCapacity());
            pstmt.setInt(8, schedule.getCreditHours());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return false;
    }

    public static ArrayList<Schedule> getStudentCourses(String studentID) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Schedule WHERE " +
                    "CRN IN (SELECT CRN FROM CourseRoster WHERE studentID = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Schedule> courses = new ArrayList<>();
            while (rs.next()) {
                Schedule course = new Schedule();
                course.setCRN(rs.getLong("CRN"));
                course.setCapacity(rs.getInt("Capacity"));
                course.setCreditHours(rs.getInt("CreditHours"));
                course.setFacultyID(rs.getString("FacultyID"));
                course.setRoom(rs.getString("Room"));
                course.setTerm(rs.getString("Term"));
                course.setGrade(getGradeForStudent(studentID, course.getCRN()));
                course.setCourseName(rs.getString("CourseName"));
                course.setCourseID(rs.getString("CourseID"));
                courses.add(course);
            }
            return courses;
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;

    }

    public static String getGradeForStudent(String studentID, long CRN) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT grade FROM CourseRoster WHERE studentID = ? AND CRN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            pstmt.setLong(2, CRN);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("grade");
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }


    public static ArrayList<Schedule> getCoursesByFaculty(String facultyID) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Schedule WHERE facultyID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, facultyID);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Schedule> courses = new ArrayList<>();
            while (rs.next()) {
                Schedule course = new Schedule();
                course.setCRN(rs.getLong("CRN"));
                course.setCapacity(rs.getInt("Capacity"));
                course.setCreditHours(rs.getInt("CreditHours"));
                course.setFacultyID(rs.getString("FacultyID"));
                course.setRoom(rs.getString("Room"));
                course.setTerm(rs.getString("Term"));
                course.setCourseName(rs.getString("CourseName"));
                course.setCourseID(rs.getString("CourseID"));
                courses.add(course);
            }
            return courses;
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }
}
