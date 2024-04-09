package Controllers;

import java.util.ArrayList;

import DAOs.MajorDAO;
import DAOs.StudentDAO;
import Models.Major;
import Models.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateNewStudentController {

    @FXML
    private ComboBox<String> cbMajorID;

    @FXML
    private Button submitButton;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfExpectedGrad;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfStuID;

    @FXML
    private TextField tfZipCode;

    @FXML
    public void initialize() {
        ArrayList<Major> majors = MajorDAO.getMajors();
        for (Major major : majors) {
            cbMajorID.getItems().add(major.getMajorID() + " - " + major.getMajorName());
        }
    }

    @FXML
    void Submit(ActionEvent event) {
        Students student = new Students();
        student.setStudentID(tfStuID.getText());
        student.setFirstName(tfFirstName.getText());
        student.setLastName(tfLastName.getText());
        student.setStreet(tfAddress.getText());
        student.setCity(tfCity.getText());
        student.setState(tfState.getText());
        student.setZipCode(Integer.parseInt(tfZipCode.getText()));
        student.setPhone(tfPhone.getText());
        student.setEmail(tfEmail.getText());
        student.setMajorID(Integer.parseInt(cbMajorID.getValue().split(" - ")[0]));
        student.setExpectedGraduationDate(tfExpectedGrad.getText());

        if (StudentDAO.insertStudent(student)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Student Added");
            alert.setContentText("Student "+ student.getStudentID() + "has been added successfully");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error Adding Student");
            alert.setContentText("An error occurred while adding the student");
            alert.showAndWait();
        }

    }

    @FXML
    void generate(ActionEvent event) {
        StringBuilder sb = new StringBuilder("Z");
        for (int i = 0; i < 8; i++) {
            sb.append((int) (Math.random() * 10));
        }
        tfStuID.setText(sb.toString());
    }

}
