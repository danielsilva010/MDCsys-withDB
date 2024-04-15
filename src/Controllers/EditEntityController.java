package Controllers;

import java.util.ArrayList;

import DAOs.MajorDAO;
import DAOs.StudentDAO;
import Models.Major;
import Models.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EditEntityController {

    @FXML
    private TextField tfID;

    @FXML
    private ComboBox<String> cbMajorID;

    @FXML
    private TextField tfExpectedGraduation;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfStreet;

    @FXML
    private TextField tfStudentID;

    @FXML
    private TextField tfZipCode;

    @FXML
    void initialize() {
        ArrayList<Major> majors = MajorDAO.getAllMajors();
        if (majors != null) {
            for (Major major : majors) {
                cbMajorID.getItems().add(major.getMajorID() + " - " + major.getMajorName());
            }
        }
    }

    @FXML
    void enter(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {
        if (tfID.getText().length() == 9 && tfID.getText().matches("Z\\d{8}")) {
            Students student = StudentDAO.getStudentById(tfID.getText());
            if (student != null) {
                tfStudentID.setText(student.getStudentID());

                tfFirstName.setText(student.getFirstName());
                tfLastName.setText(student.getLastName());
                tfPhone.setText(student.getPhone());
                tfEmail.setText(student.getEmail());
                tfStreet.setText(student.getStreet());
                tfCity.setText(student.getCity());
                tfState.setText(student.getState());
                tfZipCode.setText(String.valueOf(student.getZipCode()));
                cbMajorID.setValue(
                        String.valueOf(student.getMajorID() + " - " + MajorDAO.getMajorName(student.getMajorID())));
                tfExpectedGraduation.setText(student.getExpectedGraduationDate());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid 8-digit ID starting with Z.");
            alert.showAndWait();
        }

    }

    @FXML
    void modify(ActionEvent event) {
        if (validateFields()) {
            Students student = new Students();
            student.setStudentID(tfStudentID.getText());
            student.setFirstName(tfFirstName.getText());
            student.setLastName(tfLastName.getText());
            student.setPhone(tfPhone.getText());
            student.setEmail(tfEmail.getText());
            student.setStreet(tfStreet.getText());
            student.setCity(tfCity.getText());
            student.setState(tfState.getText());
            student.setZipCode(Integer.parseInt(tfZipCode.getText()));
            student.setMajorID(Integer.parseInt(cbMajorID.getValue().split(" - ")[0]));
            student.setExpectedGraduationDate(tfExpectedGraduation.getText());

            if (StudentDAO.updateStudent(student)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Student Modified");
                alert.setContentText("Student " + student.getStudentID() + "has been modified successfully");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error Modifying Student");
                alert.setContentText("An error occurred while modifying the student");
                alert.showAndWait();
            }
        }
    }

    private boolean validateFields() {
        if (tfStudentID.getText().length() != 9 || !tfStudentID.getText().matches("Z\\d{8}")) {
            return false;
        }
        if (cbMajorID.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please select a major.");
            alert.showAndWait();
            return false;
        }
        if (tfExpectedGraduation.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please select an expected graduation date.");
            alert.showAndWait();
            return false;
        }
        if (tfCity.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a city.");
            alert.showAndWait();
            return false;
        }
        if (tfEmail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter an email.");
            alert.showAndWait();
            return false;
        }
        if (tfFirstName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a first name.");
            alert.showAndWait();
            return false;
        }
        if (tfLastName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a last name.");
            alert.showAndWait();
            return false;
        }
        if (tfPhone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a phone number.");
            alert.showAndWait();
            return false;
        }
        if (tfState.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a state.");
            alert.showAndWait();
            return false;
        }
        if (tfStreet.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a street.");
            alert.showAndWait();
            return false;
        }
        if (tfZipCode.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a zip code.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

}
