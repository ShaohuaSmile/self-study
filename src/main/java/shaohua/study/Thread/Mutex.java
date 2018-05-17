package shaohua.study.Thread;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/02 16:58
 */
public class Mutex {
    private static Mutex mutex = new Mutex();
    public static Mutex getMutex(){
        return mutex;
    }
}
