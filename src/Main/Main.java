package Main;

import java.io.IOException;

import Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String MAIN_VIEW = "/Views/MainView.fxml";

    private static final String SEARCH_STUDENT_VIEW = "/Views/SearchStudentView.fxml";

    private static final String VIEW_COURSE_SCHEDULE_VIEW = "/Views/ViewCourseScheduleView.fxml";

    private static final String CREATE_NEW_STUDENT_VIEW = "/Views/CreateNewStudentView.fxml";

    private static final String CREATE_NEW_COURSE_VIEW = "/Views/CreateNewCourseView.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loadMainView(primaryStage);
    }

    private void loadMainView(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_VIEW));
            Parent root = loader.load();
            MainController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("");
            primaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadCreateNewCourseView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(CREATE_NEW_COURSE_VIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Create New Course");
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadCreateNewStudentView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(CREATE_NEW_STUDENT_VIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Create New Student");
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadSearchStudentView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(SEARCH_STUDENT_VIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Search Student");
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadViewCourseScheduleView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(VIEW_COURSE_SCHEDULE_VIEW));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("View Course Schedule");
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

}
