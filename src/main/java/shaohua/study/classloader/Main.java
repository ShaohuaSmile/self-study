package shaohua.study.classloader;

import sun.misc.Launcher;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/06 10:43
 */
public class Main {
    public synchronized  void a(){

    }
    public static synchronized void main(String[] args) throws IllegalAccessException, InstantiationException {
        Main m = new Main();
        m.a();
        //Main.main();
        synchronized (Main.class){

        }
        int a,b,c,i;
        i=0;
        a = i++;
        b=++i;
        c=i;
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);
        System.exit(0);
        /*
        App=sun.misc.Launcher$AppClassLoader@18b4aac2
        App-parent=sun.misc.Launcher$ExtClassLoader@76ed5528
        App-parent-parent=null
        bootstrap=null
        bootstrap=null
         */
        ClassLoader app = Main.class.getClassLoader();
        System.out.println("App=" + app);
        System.out.println("App-parent=" + app.getParent());//ExtClassLoader
        System.out.println("App-parent-parent=" + app.getParent().getParent());//null
        System.out.println("bootstrap=" + String.class.getClassLoader());//null
        System.out.println("bootstrap="+ Launcher.class.getClassLoader());//null

        ClassLoader classLoader = new FileClassLoader("D:\\tmp");
        try {
           Class clazz = classLoader.loadClass("self.shaohua.Outprinter.class");
            //Class clazz = classLoader.loadClass("java.lang.String.class");
            System.out.println("===="+clazz.newInstance().getClass().getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
