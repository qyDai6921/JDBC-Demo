package jdbcDemo;

import jdbcDemo.utils.JdbcConfig;

import java.sql.*;

public class JdbcBatchProcessingPreparedStatTest {

    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        JdbcConfig.getUrl(),
                        JdbcConfig.getUser(),
                        JdbcConfig.getPassword()
                );
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into books values (?, ?, ?)"
                );
        ) {
            // 关闭自己主动运行
            conn.setAutoCommit(false);

            pstmt.setString(1, "Go");
            pstmt.setInt(2, 123);
            pstmt.setInt(3, 321);
            pstmt.addBatch();

            pstmt.setString(1, "Json");
            pstmt.setInt(2, 345);
            pstmt.addBatch();

            pstmt.setString(1, "C#");
            pstmt.addBatch();

            // 每次提交一批命令到数据库中运行，假设全部的命令都成功运行了，那么返回一个数组，这个数组是说明每条命令所影响的行数
            // https://www.cnblogs.com/yxwkf/p/3871789.html
            int[] returnCodes = pstmt.executeBatch();
            for (int code : returnCodes) {
                System.out.println(code + ", ");
            }
            conn.commit();

        }
    }
}
