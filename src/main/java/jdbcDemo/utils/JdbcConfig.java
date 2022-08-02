package jdbcDemo.utils;

public class JdbcConfig {

    private static final String url = "jdbc:mysql://localhost:3306/jdbc-demo";
    private static final String user = "root";
    private static final String password = "qingyang2022";

//    private static final String url = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
//    private static final String user = "bmack4";
//    private static final String password = "thootcho";

    public JdbcConfig() {
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
