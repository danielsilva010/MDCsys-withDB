public class createTables {
    public static void main(String[] args) {
        String url = System.getenv("URL");
        String dbName = "MDC";
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // String sql = "CREATE TABLE IF NOT EXISTS Students
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}