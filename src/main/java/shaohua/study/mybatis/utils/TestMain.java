package shaohua.study.mybatis.utils;/**
 * Created by Administrator on 2017/7/16.
 */

import org.apache.ibatis.session.SqlSession;

import java.sql.*;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/7/16
 */
public class TestMain {
    public static void main(String... args){
        //SqlSession session = SqlSessionUtils.getSession();
        //session.getMapper()
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM t_rent_contract WHERE contract_code='SZZZCWZ81608133950'");
            ResultSet set = statement.executeQuery();
            while(set.next()){
                System.out.println(set.getString("contract_code"));
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
