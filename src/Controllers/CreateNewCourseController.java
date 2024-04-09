package Controllers;

import java.util.ArrayList;

import DAOs.FacultyDAO;
import DAOs.ScheduleDAO;
import Models.Faculty;
import Models.Schedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateNewCourseController {

    @FXML
    private Button CreateButton;

    @FXML
    private ComboBox<String> cbFaculty;

    @FXML
    private TextField tfCRN;

    @FXML
    private TextField tfCapacity;

    @FXML
    private TextField tfCourseID;

    @FXML
    private TextField tfCreditHours;

    @FXML
    private TextField tfRoom;

    @FXML
    private TextField tfTerm;

    @FXML
    private TextField tfTitle;

    @FXML
    public void initialize() {
        ArrayList<Faculty> faculties = FacultyDAO.getAllFaculties();
        if(faculties != null) {
            for(Faculty faculty : faculties) {
                cbFaculty.getItems().add(faculty.getFacultyID() + " - " + faculty.getFirstName() + " " + faculty.getLastName());
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error Loading Faculties");
            alert.setContentText("An error occurred while loading the faculties.");
            alert.showAndWait();
        }
    }

    @FXML
    void CreateCourse(ActionEvent event) {
        Schedule schedule = new Schedule();
        schedule.setCRN(Long.parseLong(tfCRN.getText()));
        schedule.setCourseID(tfCourseID.getText());
        schedule.setFacultyID(cbFaculty.getValue().split(" ")[0]);
        schedule.setTerm(tfTerm.getText());
        schedule.setRoom(tfRoom.getText());
        schedule.setCapacity(Integer.parseInt(tfCapacity.getText()));
        schedule.setCreditHours(Integer.parseInt(tfCreditHours.getText()));
        schedule.setCourseName(tfTitle.getText());
        if(ScheduleDAO.insertCourse(schedule)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Course Created");
            alert.setContentText("Course " + schedule.getCourseID() + " has been created.");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error Creating Course");
            alert.setContentText("An error occurred while creating the course.");
            alert.showAndWait();
        }
    }

    @FXML
    void generate(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append((int) (Math.random() * 10));
        }
        tfCRN.setText(sb.toString());
    }

}
