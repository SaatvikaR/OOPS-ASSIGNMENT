import java.sql.*;
import java.util.Scanner;

public class DeleteRecord {
    public static void main(String[] args) {
        // Step 1: Database connection URL for SQLite
        String url = "jdbc:sqlite:students.db"; // Database file auto-created in project folder

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Step 2: Create table if not exists
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");

            // Step 3: Insert sample records (for testing)
            stmt.execute("INSERT OR IGNORE INTO students (id, name, age) VALUES (1, 'Arun', 20), (2, 'Meena', 21), (3, 'Ravi', 22)");

            // Step 4: Prepare DELETE query
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            // Step 5: Execute update
            int rows = pstmt.executeUpdate();

            // Step 6: Display result
            if (rows > 0) {
                System.out.println("✅ Record deleted successfully!");
            } else {
                System.out.println("⚠ No record found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
