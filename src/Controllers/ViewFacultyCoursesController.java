package Controllers;

import java.util.ArrayList;

import DAOs.FacultyDAO;
import DAOs.ScheduleDAO;
import Models.Schedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ViewFacultyCoursesController {

    @FXML
    private TableColumn<Schedule, Long> CRNColumn;

    @FXML
    private TableColumn<Schedule, String> CourseIDColumn;

    @FXML
    private TableColumn<Schedule, String> TermColumn;

    @FXML
    private TableColumn<Schedule, String> courseNameColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Schedule> tableView;

    @FXML
    private Text textFacultyCourses;

    @FXML
    private Text textInstructorName;

    @FXML
    private TextField tfFacultyID;

    @FXML
    void ClearIfDefaultText(MouseEvent event) {
        if (tfFacultyID.getText().equals("Enter faculty ID")) {
            tfFacultyID.setText("");
        }
    }

    @FXML
    void search(ActionEvent event) {
        if (!tfFacultyID.getText().equals("Enter faculty ID") && !tfFacultyID.getText().equals("") && tfFacultyID.getText().length() == 9) {
            ArrayList<Schedule> courses = ScheduleDAO.getCoursesByFaculty(tfFacultyID.getText());
            tableView.getItems().clear();
            tableView.getItems().addAll(courses);
            textFacultyCourses.setText("Faculty Courses for: ");
            textInstructorName.setText(FacultyDAO.getFacultyName(tfFacultyID.getText()));
            CRNColumn.setCellValueFactory(new PropertyValueFactory<Schedule, Long>("CRN"));
            CourseIDColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("courseID"));
            courseNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("courseName"));
            TermColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("term"));
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid faculty ID");
            alert.showAndWait();
        }
    }

}
