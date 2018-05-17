package shaohua.study.classloader;

import java.io.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/06 14:26
 */
public class FileClassLoader extends ClassLoader{

    private String filePath;

    public FileClassLoader(String filePath){
        super();
        this.filePath = filePath;
    }
    //protected Class<?> loadClass(String name, boolean resolve){}//类加载入口
    //protected final Class<?> defineClass(byte[] b, int off, int len){}//根据class加载类

    /**
     * 功能描述: 读取class文件并加载类
     *
     * @author Liush
     * @date 2018/2/6
     */
    public Class<?> findClass(String name){
        String path = name.replaceAll("\\.","/").substring(0,name.lastIndexOf("class")-1).concat(".class");
        File file = new File(filePath+"/"+path);
        if(file.exists() && file.isFile()) {
            try (FileInputStream is = new FileInputStream(file);
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int b;
                while((b = is.read()) != -1){
                    outputStream.write(b);
                }
                byte[] bytes = outputStream.toByteArray();
                return this.defineClass(bytes,0,bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
           // this.defineClass();
        }
        return null;
    }
}
