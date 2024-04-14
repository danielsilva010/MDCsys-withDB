package Controllers;

import DAOs.ScheduleDAO;
import Models.Schedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ViewCoursesByCRNController {

    @FXML
    private Text tCRN;

    @FXML
    private Text tCapacity;

    @FXML
    private Text tCourseID;

    @FXML
    private Text tCourseName;

    @FXML
    private Text tCreditHours;

    @FXML
    private Text tFaculty;

    @FXML
    private Text tRoom;

    @FXML
    private Text tTerm;

    @FXML
    private TextField tfCRNField;

    @FXML
    void ClearIfDefaultText(MouseEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {
        if (!tfCRNField.getText().equals("Enter CRN Here") && !tfCRNField.getText().equals("")
                && tfCRNField.getText().length() == 5) {
            Schedule schedule = ScheduleDAO.getOneSchedule(Long.parseLong(tfCRNField.getText()));
            if (schedule != null) {
                tCRN.setText(String.valueOf(schedule.getCRN()));
                tCourseID.setText(schedule.getCourseID());
                tCourseName.setText(schedule.getCourseName());
                tCapacity.setText(String.valueOf(schedule.getCapacity()));
                tCreditHours.setText(String.valueOf(schedule.getCreditHours()));
                tRoom.setText(schedule.getRoom());
                tTerm.setText(schedule.getTermFormatted());
                tFaculty.setText(schedule.getFacultyID());
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Course not found");
                alert.showAndWait();
            }
        }

    }
}