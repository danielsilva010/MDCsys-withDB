package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Faculty;
import javafx.scene.control.Alert;

public class FacultyDAO {

    public static Faculty getFacultyById(String id) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Faculty WHERE FacultyID = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Faculty faculty = new Faculty();
                // set the properties of the Faculty object
                faculty.setFacultyID(rs.getString("FacultyID"));
                faculty.setFirstName(rs.getString("FirstName"));
                faculty.setLastName(rs.getString("LastName"));
                faculty.setHireDate(rs.getString("HireDate"));
                faculty.setTitle(rs.getString("Title"));
                faculty.setSalary(rs.getDouble("Salary"));
                faculty.setStreet(rs.getString("Street"));
                faculty.setCity(rs.getString("City"));
                faculty.setState(rs.getString("State"));
                faculty.setZipCode(rs.getInt("ZipCode"));
                faculty.setPhone(rs.getString("Phone"));
                faculty.setEmail(rs.getString("Email"));
                faculty.setDepartmentID(rs.getInt("DepartmentID"));
                return faculty;
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading Faculty");
            alert.setContentText("An error occurred while loading the Faculty: " + e.getMessage());
            alert.showAndWait();
        }
        return null;

    }

    public static ArrayList<Faculty> getAllFaculties() {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Faculty";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Faculty> faculties = new ArrayList<>();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyID(rs.getString("FacultyID"));
                faculty.setFirstName(rs.getString("FirstName"));
                faculty.setLastName(rs.getString("LastName"));
                faculty.setHireDate(rs.getString("HireDate"));
                faculty.setTitle(rs.getString("Title"));
                faculty.setSalary(rs.getDouble("Salary"));
                faculty.setStreet(rs.getString("Street"));
                faculty.setCity(rs.getString("City"));
                faculty.setState(rs.getString("State"));
                faculty.setZipCode(rs.getInt("ZipCode"));
                faculty.setPhone(rs.getString("Phone"));
                faculty.setEmail(rs.getString("Email"));
                faculty.setDepartmentID(rs.getInt("DepartmentID"));
                faculties.add(faculty);
            }
            return faculties;
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading Faculty");
            alert.setContentText("An error occurred while loading the Faculty: " + e.getMessage());
            alert.showAndWait();
        }
        return null;
    }

    public static boolean insertFaculty(Faculty faculty) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO Faculty (FacultyID, firstName, lastName, hireDate, title, salary, street, city, state, zipCode, phone, email, departmentID) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, faculty.getFacultyID());
            pstmt.setString(2, faculty.getFirstName());
            pstmt.setString(3, faculty.getLastName());
            pstmt.setString(4, faculty.getHireDate());
            pstmt.setString(5, faculty.getTitle());
            pstmt.setDouble(6, faculty.getSalary());
            pstmt.setString(7, faculty.getStreet());
            pstmt.setString(8, faculty.getCity());
            pstmt.setString(9, faculty.getState());
            pstmt.setInt(10, faculty.getZipCode());
            pstmt.setString(11, faculty.getPhone());
            pstmt.setString(12, faculty.getEmail());
            pstmt.setInt(13, faculty.getDepartmentID());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading Faculty");
            alert.setContentText("An error occurred while loading the Faculty: " + e.getMessage());
            alert.showAndWait();
            return false;
        }
    }

    public static String getFacultyName(String id) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT firstName, lastName FROM faculty WHERE facultyID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("firstName") + " " + rs.getString("lastName");
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading faculty");
            alert.setContentText("An error occurred while loading the faculty: " + e.getMessage());
            alert.showAndWait();
        }
        return null;
    }
}
