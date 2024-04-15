package Utils;

public enum FilePaths {
    MAIN_VIEW("/Views/MainView.fxml"),
    VIEW_FACULTY_COURSES_VIEW("/Views/ViewFacultyCoursesView.fxml"),
    ADD_STUDENT_TO_COURSE_VIEW("/Views/AddStudentToCourseView.fxml"),
    SEARCH_STUDENT_VIEW("/Views/SearchStudentView.fxml"),
    VIEW_COURSE_SCHEDULE_VIEW("/Views/ViewCourseScheduleView.fxml"),
    CREATE_NEW_STUDENT_VIEW("/Views/CreateNewStudentView.fxml"),
    CREATE_NEW_COURSE_VIEW("/Views/CreateNewCourseView.fxml"),
    COURSE_LIST_VIEW("/Views/CourseListView.fxml"),
    CREATE_FACULTY_VIEW("/Views/CreateFacultyView.fxml"),
    CALCULATE_GPA_VIEW("/Views/CalculateGPAView.fxml"),
    MODIFY_GRADES_VIEW("/Views/ModifyGradesView.fxml"),
    VIEW_COURSES_BY_CRN_VIEW("/Views/ViewCoursesByCRNView.fxml"),
    EDIT_ENTITY_VIEW("/Views/EditEntityView.fxml");

    private final String path;

    FilePaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}