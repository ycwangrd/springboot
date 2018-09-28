package ths.project.thstest.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: wangrd
 * @since: 2018年07月29日 10:52:55
 * @Desc:
 */
public class DBConnTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/boot-dev";
        String user = "boot-dev";
        String password = "boot-dev";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        System.out.println(connection.getCatalog());
        System.out.println(connection.getMetaData().getCatalogs());
    }
}