package Controllers;

import java.util.ArrayList;
import java.util.Random;

import DAOs.DepartmentDAO;
import Models.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateFacultyController {

    @FXML
    private ComboBox<String> cbDepartmentID;

    @FXML
    private Button createButton;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFacultyID;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfHireDate;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private TextField tfSalary;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfStreet;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfZipCode;

    @FXML
    void intialize() {
        ArrayList<Department> departments = DepartmentDAO.getAllDepartments();

        if (departments != null) {
            for (Department department : departments) {
                cbDepartmentID.getItems().add(department.getDepartmentID() + " - " + department.getDepartmentName());
            }
        }
    }

    @FXML
    void create(ActionEvent event) {

    }

    @FXML
    void generate(ActionEvent event) {
        StringBuilder sb = new StringBuilder("Z");
        for (int index = 0; index < 8; index++) {
            Random rand = new Random();
            int number = rand.nextInt(10);
            sb.append(number);
        }
        tfFacultyID.setText(sb.toString());
    }

}
