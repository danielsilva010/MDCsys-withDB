package Main;

import java.io.IOException;

import Controllers.MainController;
import Utilities.FilePaths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loadMainView(primaryStage);
    }

    private void loadMainView(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FilePaths.MAIN_VIEW.getPath()));
            Parent root = loader.load();
            MainController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadViewCoursesByCRNView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FilePaths.VIEW_COURSES_BY_CRN_VIEW.getPath()));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("View courses by CRN");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occured loading the view:" + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadViewFacultyCoursesView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FilePaths.VIEW_FACULTY_COURSES_VIEW.getPath()));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("View Faculty courses");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occured loading the view:" + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadAddStudentToCourseView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FilePaths.ADD_STUDENT_TO_COURSE_VIEW.getPath()));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Student to Course");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occured loading the view:" + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadModifyGradesView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FilePaths.MODIFY_GRADES_VIEW.getPath()));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Modify Grades");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occured loading the view:" + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadCreateFacultyView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FilePaths.CREATE_FACULTY_VIEW.getPath()));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Create Faculty");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occured loading the view:" + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadCourseListView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FilePaths.COURSE_LIST_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Course List");
            stage.setResizable(false);
            stage.show();
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
            loader.setLocation(getClass().getResource(FilePaths.CREATE_NEW_COURSE_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Create New Course");
            stage.setResizable(false);
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
            loader.setLocation(getClass().getResource(FilePaths.CREATE_NEW_STUDENT_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Create New Student");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadCalculateGPAView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FilePaths.CALCULATE_GPA_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Calculate GPA");
            stage.setResizable(false);
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
            loader.setLocation(getClass().getResource(FilePaths.SEARCH_STUDENT_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Search Student");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void loadEditEntityView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(FilePaths.EDIT_ENTITY_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Edit Entity");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
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
            loader.setLocation(getClass().getResource(FilePaths.VIEW_COURSE_SCHEDULE_VIEW.getPath()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("View Course Schedule");
            stage.setResizable(false);
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
