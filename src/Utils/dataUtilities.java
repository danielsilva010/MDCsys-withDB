package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class dataUtilities {
    public static double convertGradeToDouble(String grade) {
        if (grade.startsWith("A")) {
            return 4.0;
        } else if (grade.startsWith("B")) {
            return 3.0;
        } else if (grade.startsWith("C")) {
            return 2.0;
        } else if (grade.startsWith("D")) {
            return 1.0;
        } else if (grade.startsWith("F")) {
            return 0.0;
        } else {
            return -1.0;
        }
    }

    public static String getCourseName(String crn) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT courseName FROM Schedule WHERE CRN = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, Long.parseLong(crn));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("courseName");
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
}
