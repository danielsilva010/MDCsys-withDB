package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Department;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DepartmentDAO {

    public static ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departmentsList = new ArrayList<>();
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Department";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Department department = new Department();
                department.setDepartmentName(rs.getString("departmentName"));
                department.setDepartmentID(rs.getInt("departmentID"));
                departmentsList.add(department);
            }
            return departmentsList;
        } catch(SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }
}
