package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Major;
import javafx.scene.control.Alert;

public class MajorDAO {
    
    public static ArrayList<Major> getAllMajors() {
        ArrayList<Major> majors = new ArrayList<>();
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Major";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Major major = new Major();
                major.setMajorID(rs.getInt("MajorID"));
                major.setMajorName(rs.getString("MajorName"));
                majors.add(major);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return majors;
    }
}
