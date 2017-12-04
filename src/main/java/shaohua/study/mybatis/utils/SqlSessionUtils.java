package shaohua.study.mybatis.utils;/**
 * Created by Administrator on 2017/7/16.
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/7/16
 */
public class SqlSessionUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static final ReentrantLock LOCK = new ReentrantLock();
    static{
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xm");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

    public static <T> T getMapper(Class<T> clazz){
        return getSession().getMapper(clazz);
    }
}
