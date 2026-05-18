import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeManagement {

    // Database configurations
    private static final String URL = "jdbc:mysql://localhost:3306/company_db";
    private static final String USER = "root";
    private static final String PASSWORD = "my_pass";

    private static void insertEmployee(Connection conn, String name, String designation, double salary) {
        String insertSQL = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, designation);
            pstmt.setDouble(3, salary);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Inserted: " + name);
            }
        } catch (Exception e) {
            System.err.println("Failed to insert: " + name);
            e.printStackTrace();
        }
    }

    private static void displayEmployees(Connection conn) {
        String selectSQL = "SELECT id, name, designation, salary FROM employees";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.printf("%-5s %-20s %-20s %-10s%n", "ID", "Name", "Designation", "Salary");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String designation = rs.getString("designation");
                double salary = rs.getDouble("salary");
                System.out.printf("%-5d %-20s %-20s $%-10.2f%n", id, name, designation, salary);
            }
        } catch (Exception e) {
            System.err.println("Failed to retrieve data!");
            e.printStackTrace();
        }
    }

    private static void deleteEmployeeById(Connection conn, int id) {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Deleted employee with ID: " + id);
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Failed to delete employee with ID: " + id);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open Connection
            System.out.println("Connecting to database...");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected successfully!\n");

                // 3. Run Insert Queries
//                System.out.println("--- Inserting Employee Records ---");
//                insertEmployee(conn, "Alice Smith", "Software Engineer", 75000.00);
//                insertEmployee(conn, "Bob Jones", "Project Manager", 90000.00);
//                insertEmployee(conn, "Charlie Brown", "QA Analyst", 60000.00);
//                insertEmployee(conn, "Miguel Diaz", "HR Manager", 100000.00);
//
//                System.out.println();
//
//                // 4. Run Display Query Before Deletion
//                System.out.println("--- Displaying All Employee Records ---");
//                displayEmployees(conn);
//                System.out.println();

                // 5. Run Delete Query (Example: Deleting Employee with ID 2)
                System.out.println("--- Deleting Employee Record ---");
                deleteEmployeeById(conn, 1);
                deleteEmployeeById(conn, 2);
                deleteEmployeeById(conn, 3);
                System.out.println();

                // 6. Run Display Query After Deletion
                System.out.println("--- Displaying Records After Deletion ---");
                displayEmployees(conn);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL Connector Driver not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
