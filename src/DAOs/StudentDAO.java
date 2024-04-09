package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Students;
import javafx.scene.control.Alert;

public class StudentDAO {

    public static Students getStudentById(String id) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Students WHERE StudentID = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Students student = new Students();
                student.setStudentID(rs.getString("StudentID"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setStreet(rs.getString("Street"));
                student.setCity(rs.getString("City"));
                student.setState(rs.getString("State"));
                student.setZipCode(rs.getInt("ZipCode"));
                student.setPhone(rs.getString("Phone"));
                student.setEmail(rs.getString("Email"));
                student.setMajorID(rs.getInt("MajorID"));
                student.setExpectedGraduationDate(rs.getString("ExpectedGraduationDate"));
                return student;
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }
}