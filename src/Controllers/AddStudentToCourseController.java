package Controllers;

import DAOs.CourseRosterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddStudentToCourseController {

    @FXML
    private TextField tfCRN;

    @FXML
    private TextField tfStudentID;

    @FXML
    void add(ActionEvent event) {
        String crn = tfCRN.getText();
        String studentID = tfStudentID.getText();

        if (crn.equals("") || studentID.equals("")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("CRN or Student ID is empty");
            alert.setContentText("Please enter a CRN and Student ID.");
            alert.showAndWait();
        } else if (CourseRosterDAO.addStudentToCourse(Long.parseLong(crn), studentID)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Student Added");
            alert.setContentText("Student " + studentID + " has been added to course " + crn);
            alert.showAndWait();
        }
    }

}
