package Controllers;

import DAOs.CourseRosterDAO;
import Models.CourseRoster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ModifyGradesController {

    @FXML
    private TextField tfCRN;

    @FXML
    private TextField tfGrade;

    @FXML
    private TextField tfStudentID;

    @FXML
    void modify(ActionEvent event) {
        if (!tfStudentID.getText().equals("Enter Student ID Here") && !tfStudentID.getText().equals("")
                && !tfCRN.getText().equals("Enter CRN Here") && !tfCRN.getText().equals("")) {
            if (CourseRosterDAO.updateGradeForStudent(tfStudentID.getText(), Long.parseLong(tfCRN.getText()),
                    tfGrade.getText())) {
                tfGrade.setDisable(true);
                tfCRN.setDisable(true);
                tfStudentID.setDisable(true);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Grade Updated");
                alert.setContentText(
                        "Grade for " + tfStudentID.getText() + " has been updated to " + tfGrade.getText());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid CRN or Student ID");
            alert.setContentText("Please enter a valid CRN and Student ID.");
            alert.showAndWait();
        }
    }

    @FXML
    void search(ActionEvent event) {
        if (!tfStudentID.getText().equals("Enter Student ID Here") && !tfStudentID.getText().equals("")
                && !tfCRN.getText().equals("Enter CRN Here") && !tfCRN.getText().equals("")) {
            CourseRoster oneRoster = CourseRosterDAO.getOneRosterForStudent(tfStudentID.getText(),
                    Long.parseLong(tfCRN.getText()));
            if (oneRoster != null) {
                tfGrade.setText(oneRoster.getGrade());
                tfCRN.setDisable(true);
                tfStudentID.setDisable(true);
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid CRN or Student ID");
            alert.setContentText("Please enter a valid CRN and Student ID.");
            alert.showAndWait();
        }
    }

}
