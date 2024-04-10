package DAOs;

public class CourseRosterDAO {

    /*  public static ArrayList<CourseRoster> getStudentRoster(String studentID) {
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        String url = System.getenv("URL");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM CourseRoster WHERE studentID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CourseRoster> roster = new ArrayList<>();
            while (rs.next()) {
                CourseRoster course = new CourseRoster();
                course.setCRN(rs.getLong("CRN"));
                course.setGrade(rs.getString("Grade"));
                course.setGrade(rs.getString("Grade"));
                roster.add(course);
            }
            return roster;
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    } */
}
