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

    @FXML
    public void loadCreateNewStudentView(ActionEvent event) {
        main.loadCreateNewStudentView();
    }

    @FXML
    public void loadCreateNewCourseView(ActionEvent event) {
        main.loadCreateNewCourseView();
    }

    @FXML
    public void loadCourseListView(ActionEvent event) {
        main.loadCourseListView();
    }
}
