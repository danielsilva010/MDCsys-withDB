package Controllers;

import java.util.ArrayList;

import DAOs.DepartmentDAO;
import DAOs.FacultyDAO;
import DAOs.MajorDAO;
import DAOs.StudentDAO;
import Models.Department;
import Models.Faculty;
import Models.Major;
import Models.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditEntityController {

    @FXML
    private ComboBox<String> cbDepartmentFaculty;

    @FXML
    private TextField tfCityFaculty;

    @FXML
    private TextField tfEmailFaculty;

    @FXML
    private TextField tfFacultyID;

    @FXML
    private TextField tfFirstNameFaculty;

    @FXML
    private TextField tfHireDateFaculty;

    @FXML
    private TextField tfIDFaculty;

    @FXML
    private TextField tfIDStudent;

    @FXML
    private TextField tfLastNameFaculty;

    @FXML
    private TextField tfPhoneFaculty;

    @FXML
    private TextField tfSalaryFaculty;

    @FXML
    private TextField tfStateFaculty;

    @FXML
    private TextField tfTitleFaculty;

    @FXML
    private TextField tfZipCodeFaculty;


    @FXML
    private ComboBox<String> cbMajorIDStudent;

    @FXML
    private TextField tfExpectedGraduationStudent;

    @FXML
    private TextField tfCityStudent;

    @FXML
    private TextField tfEmailStudent;

    @FXML
    private TextField tfFirstNameStudent;

    @FXML
    private TextField tfLastNameStudent;

    @FXML
    private TextField tfPhoneStudent;

    @FXML
    private TextField tfStateStudent;

    @FXML
    private TextArea taStreet;

    @FXML
    private TextField tfStreetStudent;

    @FXML
    private TextField tfStudentID;

    @FXML
    private TextField tfZipCodeStudent;

    @FXML
    void initialize() {
        ArrayList<Major> majors = MajorDAO.getAllMajors();
        ArrayList<Department> departments = DepartmentDAO.getAllDepartments();
        if (majors != null) {
            for (Major major : majors) {
                cbMajorIDStudent.getItems().add(major.getMajorID() + " - " + major.getMajorName());
            }
        }

        if (departments != null) {
            for (Department department : departments) {
                cbDepartmentFaculty.getItems()
                        .add(department.getDepartmentID() + " - " + department.getDepartmentName());
            }
        }
    }

    @FXML
    void enter(ActionEvent event) {

    }

    @FXML
    void searchStudent(ActionEvent event) {
        if (tfIDStudent.getText().length() == 9 && tfIDStudent.getText().matches("Z\\d{8}")) {
            Students student = StudentDAO.getStudentById(tfIDStudent.getText());
            if (student != null) {
                tfStudentID.setText(student.getStudentID());

                tfFirstNameStudent.setText(student.getFirstName());
                tfLastNameStudent.setText(student.getLastName());
                tfPhoneStudent.setText(student.getPhone());
                tfEmailStudent.setText(student.getEmail());
                tfStreetStudent.setText(student.getStreet());
                tfCityStudent.setText(student.getCity());
                tfStateStudent.setText(student.getState());
                tfZipCodeStudent.setText(String.valueOf(student.getZipCode()));
                cbMajorIDStudent.setValue(
                        String.valueOf(student.getMajorID() + " - " + MajorDAO.getMajorName(student.getMajorID())));
                tfExpectedGraduationStudent.setText(student.getExpectedGraduationDate());
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
    void deleteFaculty(ActionEvent event) {

    }

    @FXML
    void deleteStudent(ActionEvent event) {
        if (validateFields()) {
            if (StudentDAO.deleteStudent(tfStudentID.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Student Deleted");
                alert.setContentText("Student " + tfStudentID.getText() + " has been deleted successfully");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Student " + tfStudentID.getText() + " could not be deleted");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void modifyFaculty(ActionEvent event) {

    }

    @FXML
    void searchFaculty(ActionEvent event) {
        if (tfIDFaculty.getText().length() == 9 && tfIDFaculty.getText().matches("Z\\d{8}")) {
            Faculty faculty = FacultyDAO.getFacultyById(tfIDFaculty.getText());
            if (faculty != null) {
                tfFacultyID.setText(faculty.getFacultyID());
                tfFirstNameFaculty.setText(faculty.getFirstName());
                tfLastNameFaculty.setText(faculty.getLastName());
                tfPhoneFaculty.setText(faculty.getPhone());
                tfEmailFaculty.setText(faculty.getEmail());
                tfHireDateFaculty.setText(faculty.getHireDate());
                tfSalaryFaculty.setText( "$" + String.valueOf(faculty.getSalary()));
                tfTitleFaculty.setText(faculty.getTitle());
                cbDepartmentFaculty.setValue(String.valueOf(faculty.getDepartmentID() + " - "
                        + DepartmentDAO.getDepartmentName(faculty.getDepartmentID())));
                tfStateFaculty.setText(faculty.getState());
                tfCityFaculty.setText(faculty.getCity());
                tfZipCodeFaculty.setText(String.valueOf(faculty.getZipCode()));
                taStreet.setText(faculty.getStreet());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("No faculty with that ID exists");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void modifyStudent(ActionEvent event) {
        if (validateFields()) {
            Students student = new Students();
            student.setStudentID(tfStudentID.getText());
            student.setFirstName(tfFirstNameStudent.getText());
            student.setLastName(tfLastNameStudent.getText());
            student.setPhone(tfPhoneStudent.getText());
            student.setEmail(tfEmailStudent.getText());
            student.setStreet(tfStreetStudent.getText());
            student.setCity(tfCityStudent.getText());
            student.setState(tfStateStudent.getText());
            student.setZipCode(Integer.parseInt(tfZipCodeStudent.getText()));
            student.setMajorID(Integer.parseInt(cbMajorIDStudent.getValue().split(" - ")[0]));
            student.setExpectedGraduationDate(tfExpectedGraduationStudent.getText());

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
        if (cbMajorIDStudent.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please select a major.");
            alert.showAndWait();
            return false;
        }
        if (tfExpectedGraduationStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please select an expected graduation date.");
            alert.showAndWait();
            return false;
        }
        if (tfCityStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a city.");
            alert.showAndWait();
            return false;
        }
        if (tfEmailStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter an email.");
            alert.showAndWait();
            return false;
        }
        if (tfFirstNameStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a first name.");
            alert.showAndWait();
            return false;
        }
        if (tfLastNameStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a last name.");
            alert.showAndWait();
            return false;
        }
        if (tfPhoneStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a phone number.");
            alert.showAndWait();
            return false;
        }
        if (tfStateStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a state.");
            alert.showAndWait();
            return false;
        }
        if (tfStreetStudent.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a street.");
            alert.showAndWait();
            return false;
        }
        if (tfZipCodeStudent.getText().isEmpty()) {
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
