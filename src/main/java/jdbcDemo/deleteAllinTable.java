package jdbcDemo;

import jdbcDemo.utils.JdbcConfig;

import java.sql.*;

public class deleteAllinTable {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        JdbcConfig.getUrl(),
                        JdbcConfig.getUser(),
                        JdbcConfig.getPassword()
                );

                Statement stmt = conn.createStatement();
        ) {
            conn.setAutoCommit(false);

            System.out.println("---------delete-----------");
            String sqlDelete = "delete from books";
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " records are deleted"); // output: 3 records are deleted

            conn.commit();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
