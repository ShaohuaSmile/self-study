package shaohua.study.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/17 16:01
 */
public class CommonListener implements ServletRequestListener {
    /**
     * The request is about to go out of scope of the web application.
     *
     * @param sre
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("----ServletRequestListener-----requestDestroyed------");
    }

    /**
     * The request is about to come into scope of the web application.
     *
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("----ServletRequestListener-----requestInitialized------");
    }
}
