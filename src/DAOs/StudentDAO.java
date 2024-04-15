package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public static boolean insertStudent(Students student) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Students VALUES ('" + student.getStudentID() + "', '" + student.getFirstName()
                    + "', '" + student.getLastName() + "', '" + student.getStreet() + "', '" + student.getCity() + "', '"
                    + student.getState() + "', " + student.getZipCode() + ", '" + student.getPhone() + "', '"
                    + student.getEmail() + "', " + student.getMajorID() + ", '" + student.getExpectedGraduationDate()
                    + "')";
            stmt.executeUpdate(sql);
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

    public static boolean updateStudent(Students student) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            //prepared stmt
            String sql = "UPDATE Students SET firstName = ?, lastName = ?, street = ?, city = ?, state = ?, zipCode = ?, phone = ?, email = ?, MajorID = ?, expectedGraduationDate = ? WHERE studentID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getStreet());
            pstmt.setString(4, student.getCity());
            pstmt.setString(5, student.getState());
            pstmt.setInt(6, student.getZipCode());
            pstmt.setString(7, student.getPhone());
            pstmt.setString(8, student.getEmail());
            pstmt.setInt(9, student.getMajorID());
            pstmt.setString(10, student.getExpectedGraduationDate());
            pstmt.setString(11, student.getStudentID());

            pstmt.executeUpdate();

            return true;
        } catch(SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return false;
        }
    }
}