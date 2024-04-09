package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Faculty;
import javafx.scene.control.Alert;

public class FacultyDAO {

    public static Faculty getFacultyById(String id) {
        // private String FacultyID;
        // private String firstName;
        // private String lastName;
        // private String hireDate;
        // private String title;
        // private Double salary;
        // private String street;
        // private String city;
        // private String state;
        // private int zipCode;
        // private String phone;
        // private String email;
        // private int departmentID;

        // load $USER and $PASS from environment variables
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        // connect to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // create a statement object
            Statement stmt = conn.createStatement();
            // create a query string
            String sql = "SELECT * FROM Faculty WHERE FacultyID = '" + id + "'";
            // execute the query
            ResultSet rs = stmt.executeQuery(sql);
            // if the result set has a row
            if (rs.next()) {
                // create a new Faculty object
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
                // return the Faculty object
                return faculty;
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading Faculty");
            alert.setContentText("An error occurred while loading the Faculty: " + e.getMessage());
            alert.showAndWait();
        }
        // return null if the Faculty is not found
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
}
