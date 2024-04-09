package Controllers;

import DAOs.StudentDAO;
import Models.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SearchStudentController {

    @FXML
    private Button SearchButton;

    @FXML
    private Text tAddress;

    @FXML
    private Text tEmail;

    @FXML
    private Text tExpectedGraduation;

    @FXML
    private Text tMajor;

    @FXML
    private Text tName;

    @FXML
    private Text tPhone;

    @FXML
    private TextField tfStudentID;

    @FXML
    void ClearIfDefaultText(MouseEvent event) {
        if (tfStudentID.getText().equals("Enter Student ID Here")) {
            tfStudentID.setText("");
        }
    }

    @FXML
    void enter(ActionEvent event) {
        if(!tfStudentID.getText().equals("Enter Student ID Here") && !tfStudentID.getText().equals("")) {
            search(event);
        }
    }

    @FXML
    void search(ActionEvent event) {
        Students student = StudentDAO.getStudentById(tfStudentID.getText());
        if (student != null) {
            tName.setText(student.getFirstName() + " " + student.getLastName());
            tAddress.setText(student.getStreet() + ", " + student.getCity() + ", " + student.getState() + " "
                    + student.getZipCode());
            tPhone.setText(student.getPhone());
            tEmail.setText(student.getEmail());
            tMajor.setText(student.getMajorID() + "");
            tExpectedGraduation.setText(student.getExpectedGraduationDate());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Student Not Found");
            alert.setContentText("Student with ID " + tfStudentID.getText() + " not found.");
            alert.showAndWait();
        }
    }

}
