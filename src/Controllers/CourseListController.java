package Controllers;

import java.util.ArrayList;

import DAOs.StudentCoursesDAO;
import DAOs.StudentDAO;
import Models.StudentCourses;
import Models.Students;
import javafx.collections.FXCollections;
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

public class CourseListController {

    @FXML
    private TableColumn<StudentCourses, Long> CRNColumn;

    @FXML
    private TableColumn<StudentCourses, String> CourseIDColumn;

    @FXML
    private TableColumn<StudentCourses, String> FacultyColumn;

    @FXML
    private TableColumn<StudentCourses, String> GradeColumn;

    @FXML
    private Button SearchButton;

    @FXML
    private TableColumn<StudentCourses, String> TermColumn;

    @FXML
    private TableColumn<StudentCourses, String> courseNameColumn;

    @FXML
    private TableView<StudentCourses> tableView;

    @FXML
    private Text textStudentName;

    @FXML
    private TextField tfStudentID;

    @FXML
    void enter(ActionEvent event) {
        if (tfStudentID.getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Student ID is empty");
            alert.setContentText("Please enter a student ID.");
            alert.showAndWait();
        } else if (tfStudentID.getText().startsWith("Z") && tfStudentID.getText().length() == 9) {
            Search(event);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Student ID");
            alert.setContentText("Please enter a valid student ID.");
            alert.showAndWait();
        }
    }

    @FXML
    void Clear(MouseEvent event) {
        if (tfStudentID.getText().equals("Enter Student ID here...")) {
            tfStudentID.clear();
        }
    }

    @FXML
    void Search(ActionEvent event) {
        if (tfStudentID.getText().startsWith("Z") && tfStudentID.getText().length() == 9) {
            ArrayList<StudentCourses> roster = StudentCoursesDAO.getStudentCourses(tfStudentID.getText());
            if (roster != null) {
                Students student = StudentDAO.getStudentById(tfStudentID.getText());
                textStudentName.setText(student.getFirstName() + " " + student.getLastName());
                CRNColumn.setCellValueFactory(new PropertyValueFactory<StudentCourses, Long>("CRN"));
                CourseIDColumn.setCellValueFactory(new PropertyValueFactory<StudentCourses, String>("courseID"));
                courseNameColumn.setCellValueFactory(new PropertyValueFactory<StudentCourses, String>("courseName"));
                TermColumn.setCellValueFactory(new PropertyValueFactory<StudentCourses, String>("term"));
                FacultyColumn.setCellValueFactory(new PropertyValueFactory<StudentCourses, String>("facultyID"));
                GradeColumn.setCellValueFactory(new PropertyValueFactory<StudentCourses, String>("grade"));
                tableView.setItems(FXCollections.observableArrayList(roster));
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Student Not Found");
                alert.setContentText(
                        "The student with ID " + tfStudentID.getText() + " was not found in the database.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Student ID");
            alert.setContentText("Please enter a valid student ID.");
            alert.showAndWait();
        }
    }

}
