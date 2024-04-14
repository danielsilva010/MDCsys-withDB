package Controllers;

import java.util.ArrayList;

import DAOs.CourseRosterDAO;
import DAOs.StudentDAO;
import Models.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import static Utils.dataUtilities.getCourseName;

public class CalculateGPAController {

    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton rbCRN;

    @FXML
    private RadioButton rbID;

    @FXML
    private Text textGPA;

    @FXML
    private Text textName;

    @FXML
    private TextField tfIDCRN;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        rbID.setSelected(true);
        rbID.setToggleGroup(toggleGroup);
        rbCRN.setToggleGroup(toggleGroup);
    }

    @FXML
    void calculate(ActionEvent event) {
        if (rbID.isSelected() && tfIDCRN.getText() != null && tfIDCRN.getText().length() == 9) {
            try {
                ArrayList<Double> grades = CourseRosterDAO.getGradesForStudent(tfIDCRN.getText());
                if (grades != null) {
                    double total = 0;
                    for (int i = 0; i < grades.size(); i++) {
                        total += grades.get(i);
                    }
                    textGPA.setText(String.format("%.2f", total / grades.size()));
                    Students student = StudentDAO.getStudentById(tfIDCRN.getText());
                    if (student != null) {
                        textName.setText(student.getFirstName() + " " + student.getLastName());
                    } else {
                        textName.setText("");
                    }
                } else {
                    textGPA.setText("");
                    textName.setText("");
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Please enter a valid student ID");
                alert.showAndWait();
            }
        } else if (rbCRN.isSelected() && tfIDCRN.getText() != null && tfIDCRN.getText().length() == 5) {
            try {
                ArrayList<Double> grades = CourseRosterDAO.getGradesForCourse(Long.parseLong(tfIDCRN.getText()));
                if (grades != null) {
                    double total = 0;
                    for (int i = 0; i < grades.size(); i++) {
                        total += grades.get(i);
                    }
                    textGPA.setText(String.format("%.2f", total / grades.size()));
                    textName.setText(getCourseName(tfIDCRN.getText()));
                } else {
                    textGPA.setText("");
                    textName.setText("");
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Please enter a valid CRN");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a valid student ID or CRN");
            alert.showAndWait();
        }
    }


}
