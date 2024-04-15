package Controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import DAOs.MajorDAO;
import DAOs.StudentDAO;
import Models.Major;
import Models.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditEntityController {

    @FXML
    private TextField tfID;

    @FXML
    private ComboBox<String> cbMajorID;

    @FXML
    private DatePicker dpExpectedGraduation;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

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
                tfEmail.setText(student.getEmail());
                tfStreet.setText(student.getStreet());
                tfCity.setText(student.getCity());
                tfState.setText(student.getState());
                tfZipCode.setText(String.valueOf(student.getZipCode()));
                cbMajorID.setValue(String.valueOf(student.getMajorID() + " - " + MajorDAO.getMajorName(student.getMajorID())));
                dpExpectedGraduation.setValue(LocalDate.parse(student.getExpectedGraduationDate()));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid 8-digit ID starting with Z.");
            alert.showAndWait();
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
        if (dpExpectedGraduation.getValue() == null) {
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


