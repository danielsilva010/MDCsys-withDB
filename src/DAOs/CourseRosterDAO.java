package DAOs;

import static Utils.dataUtilities.convertGradeToDouble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.CourseRoster;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CourseRosterDAO {

    public static boolean addStudentToCourse(long CRN, String studentID) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO CourseRoster (studentID, CRN, Grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            pstmt.setLong(2, CRN);
            pstmt.setString(3, "A");
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return false;
        }

    }

    public static CourseRoster getOneRosterForStudent(String studentID, long CRN) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM CourseRoster WHERE studentID = ? AND CRN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            pstmt.setLong(2, CRN);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CourseRoster(CRN, studentID, rs.getString("grade"));
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

    public static boolean updateGradeForStudent(String studentID, long CRN, String grade) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE CourseRoster SET grade = ? WHERE studentID = ? AND CRN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, grade);
            pstmt.setString(2, studentID);
            pstmt.setLong(3, CRN);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return false;

        }
    }

    public static ArrayList<Double> getGradesForCourse(long CRN) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");
        ArrayList<Double> grades = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT grade FROM CourseRoster WHERE CRN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, CRN);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                grades.add(convertGradeToDouble(rs.getString("grade")));
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return grades;
    }

    public static ArrayList<Double> getGradesForStudent(String studentID) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");
        ArrayList<Double> grades = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT grade FROM CourseRoster WHERE studentID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                grades.add(convertGradeToDouble(rs.getString("grade")));
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return grades;
    }
}
