package shaohua.study.collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ArrayListStudy {
    public static void main(String... args){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(1462118400000L);
        System.out.println(format.format(date));
        List<String> list = new ArrayList<String>();

    }
}
