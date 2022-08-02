package jdbcDemo;

import com.mongodb.client.MongoClient;
import jdbcDemo.utils.JdbcConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用JDBC连接MySQL数据库
 *
 * @author lloyd
 */
public class test1 {
    public static void main(String[] args) {
        try {
//            // To connect to mongodb server
//            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 1.加载数据库驱动类
//            Class.forName("mongodb.jdbc.MongoDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

            // 2.创建连接
            //格式为jdbc:mysql:
            // 127.0.0.1:3306/数据库名称?useSSL=true&characterEncoding=utf-8&user=账号名&password=密码
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/mydb?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT&user=root&password=lianlianjie");


//            Connection connection = DriverManager.getConnection
//                    ("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false");

//            String url= JdbcConfig.getUrl();
//            Connection connection = DriverManager.getConnection(url, "user", "password");
            System.out.println("创建连接成功");


        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
