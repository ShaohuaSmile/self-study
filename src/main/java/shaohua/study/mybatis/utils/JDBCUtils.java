package shaohua.study.mybatis.utils;/**
 * Created by Administrator on 2017/7/20.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/7/20
 */
public class JDBCUtils {
    private static final String URL="jdbc:mysql://10.16.16.14:3306/crm_rent";
    private static final String USER = "dev_crm";
    private static final String PWD="ziroomdb";
    private static ThreadLocal<Connection> connHolder = new ThreadLocal<Connection>();
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        if(connHolder.get() == null){
            try {
                Connection conn = DriverManager.getConnection(URL,USER,PWD);
                connHolder.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connHolder.get();
    }
    public static void closeConnection(){
        try {
            if(connHolder.get()!=null && !connHolder.get().isClosed()){
                connHolder.get().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String... args){
        JDBCUtils.getConnection();
    }
}
