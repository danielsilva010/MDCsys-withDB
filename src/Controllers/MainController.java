package Controllers;

import Main.Main;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController implements SceneManager {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void initialize() {
        main = new Main();
    }

    @FXML
    public void loadSearchStudentView(ActionEvent event) {
        main.loadSearchStudentView();
    }

    @FXML
    public void loadViewCourseScheduleView(ActionEvent event) {
        main.loadViewCourseScheduleView();
    }

    public void loadCalculateGPAView(ActionEvent event) {
        main.loadCalculateGPAView();
    }

    @FXML
    public void loadCreateNewStudentView(ActionEvent event) {
        main.loadCreateNewStudentView();
    }

    public void loadAddStudentToCourseView(ActionEvent event) {
        main.loadAddStudentToCourseView();
    }

    public void loadViewFacultyCoursesView(ActionEvent event) {
        main.loadViewFacultyCoursesView();
    }

    @FXML
    public void loadCreateNewCourseView(ActionEvent event) {
        main.loadCreateNewCourseView();
    }

    @FXML
    public void loadCourseListView(ActionEvent event) {
        main.loadCourseListView();
    }

    @FXML
    public void loadCreateFacultyView(ActionEvent event) {
        main.loadCreateFacultyView();
    }
}
