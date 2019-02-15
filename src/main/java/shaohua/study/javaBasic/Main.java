package shaohua.study.javaBasic;

import com.sun.mail.util.logging.MailHandler;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/04 14:33
 */
public class Main {
    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
    private static Integer parseInt(String value, boolean ignoreDot) {


        Double doubleValue;
        try{
            doubleValue = Double.parseDouble(value);
        }catch (Exception e){
            System.out.println(value + "不是数字类型，不能转换为double");
            return null;
        }
        String[] dotSplit = value.split("\\.");
        Double minInt = Double.valueOf(dotSplit[0]);
        if(ignoreDot || minInt.equals(doubleValue)){
            return Integer.valueOf(Integer.parseInt(dotSplit[0]));
        }
        System.out.println("参数不是整数类型" + value);
        return null;
    }
    private static String changePhoneNum(String str){
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher m = pattern.matcher(str);
        String mun = "";
        if(m.find()){
            mun = m.group(0);
            //todo change
            String newNum = mun.substring(0,3)+"****"+mun.substring(7);
           str = str.substring(0,str.indexOf(mun))+newNum+str.substring(str.indexOf(mun)+mun.length());
            return changePhoneNum(str);
        }
        return str;
    }
    public static void main(String[] args) throws Exception, MessagingException {
        String str = "ajkdsjfadj17171717175uuufada11112222212jd";
        System.out.print(changePhoneNum(str));

        System.exit(0);
        // sendMail("HELLO test","test");
        while(true){
            monitor();
            Thread.sleep(1000*60*3);
        }
//
//        System.exit(0);
//        ddd.lookup.get("HL001");
//
//        Map m = ddd.lookup;
//        Map n = ddd.lookup2;
//        Map p = ddd.lookuplj;
//        //System.exit(0);
//        for(int i = 0; i < 100000; i++){
//            Integer integer = parseInt(i+".00",false);
//            if(integer == null){
//                break;
//            }
//            System.out.println(integer);
//            //System.out.println(i + "-" + minRunLength(i));
//        }
//        System.exit(0);
//        BigDecimal fen = new BigDecimal(String.valueOf(327.6));
//        BigDecimal yuan = fen.divide(new BigDecimal(String.valueOf(100)), 2, BigDecimal.ROUND_DOWN);
//        System.out.print(yuan.doubleValue());
//
//        System.exit(0);
//        int a = 1 << 30; //2~30
//        int b = Integer.MAX_VALUE; //2~31 - 1
//        System.out.println(a);
//        System.out.println(b);
//
//        int c = 0x10; // 000...0 0001 0000; 16
//        System.out.println(c >>> 4);
//        System.exit(0);
//        List<String> strs = scanner();
//        //按照第一个字符排序
//        Collections.sort(strs,new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return compareTo(o2,o1);
//            }
//        });
//        //Collections.sort(strs);
//        StringBuilder sb = new StringBuilder();
//        for(String str : strs){
//            sb.append(str);
//        }
//        String strNum = sb.toString();
//        long maxNum = Long.valueOf(strNum);
//        System.out.println(maxNum);
    }

    /**
     * 字符串比较大小：eg. 7659 765 , 97 9
     * <ul>
     *     <li>按照字符逐个比较，遇到一个不相等则比较结束</li>
     *     <li>逐个比较未结束，则较长下一位与首位比较</li>
     * </ul>
     *
     * @param str1
     * @param str2
     * @return
     */
    private static int compareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1, len2);
        char v1[] = str1.toCharArray();
        char v2[] = str2.toCharArray();

        int k = 0;
        while (k < lim) { //逐个比较
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        //逐个比较未分出结果
        char first = str1.charAt(0);//第一个字符
        char next; //较长字符串多出的第一个字符
        if(len1 > len2){
            next = str1.charAt(lim);
            return next - first;
        }else{
            next = str2.charAt(lim);
            return first - next;
        }
    }
    private static List<String> scanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String consoleLine = scanner.next();
        if(consoleLine == null || "".equals(consoleLine.trim())){
            System.out.println("请按照 234,54,45 类似形式，数字用逗号隔开输入！");
            return scanner();
        }
        String[] strs = consoleLine.split(",");
        //todo 校验输入正确性
        for(String str : strs){
            if(str == null || "".equals(str.trim())){
                System.out.println("请按照 234,54,45 类似形式，数字用逗号隔开输入！");
                return scanner();
            }
            try{
                Long.valueOf(str);
            }catch (Exception e){
                System.out.println("无效数字："+str);
                System.out.println("请按照 234,54,45 类似形式，数字用逗号隔开输入！");
                return scanner();
            }

        }
        return new ArrayList<String>(Arrays.asList(strs));
    }

    private static void monitor() throws Exception {
        CloseableHttpClient client = HttpClients.custom().build();
        HttpPost post = new HttpPost("http://cx.ahzsks.cn/pugao/pglq2018_in.php");
        CloseableHttpResponse response = client.execute(post);
        InputStream is = response.getEntity().getContent();
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1024];
        while (is.read(buffer) != -1){
            sb.append(new String(buffer));
        }

        String key = "<div class=\"right\"><input type=\"text\" autocomplete=\"off\" name=\"yzm\" id=\"yzm\"  size=\"10\" maxlength=\"4\"/>";
        int index = sb.indexOf(key)+key.length();
        String code = sb.substring(index,index+4);
        System.out.println(sb.toString());
        System.out.println("code="+code);

        String url = "http://cx.ahzsks.cn/pugao/pglq2018_out.php";
        //url = url + "?ksh=18341721151824&sfzh=342921199902050018&yzm="+code;
        HttpPost post2 = new HttpPost(url);
        List<BasicNameValuePair> Listnvps = new ArrayList();
        Listnvps.add(new BasicNameValuePair("ksh", "18341721151824"));
        Listnvps.add(new BasicNameValuePair("sfzh", "342921199902050018"));
        Listnvps.add(new BasicNameValuePair("yzm", code));
        post2.setEntity(new UrlEncodedFormEntity(Listnvps, "UTF-8"));
        CloseableHttpResponse response2 = client.execute(post2);
        InputStream is2 = response2.getEntity().getContent();
        String resultStr = EntityUtils.toString(response2.getEntity(), Charset.forName("GBK"));
//        StringBuilder sb2 = new StringBuilder();
//        byte[] buffer2 = new byte[1024];
//        while (is2.read(buffer2) != -1){
//            sb2.append(new String(buffer2,"utf-8"));
//        }
        System.out.println("result="+resultStr);

        String resKey = "暂无录取信息";

        if(!resultStr.contains(resKey)){
            sendMail("录取了",resultStr);
        }else{
            sendMail2("未录取",resultStr);
        }
    }
    public static void sendMail(String title,String content) throws MessagingException {
        // 发件人电子邮箱
        String from = "shaohuasmile@163.com";

        // 收件人电子邮箱
        String to = "liushjob@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.163.com";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "25");
        properties.setProperty("mail.smtp.auth", "true");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("shaohuasmile@163.com", "xzyflzjx111??");
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        Address toAddr = new InternetAddress(to);
        Address toAddr2 = new InternetAddress("2440244805@qq.com");

        Address[] tos = new Address[2];
        tos[0] = toAddr;
        tos[1] = toAddr2;
        message.addRecipients(Message.RecipientType.TO,tos);
        message.setReplyTo(new Address[]{toAddr});
        message.setSubject(title,"UTF-8");
        message.setContent(content,"text/html;charset=gb2312");
        System.out.println("--------开始发送邮件-------");
        Transport.send(message,"shaohuasmile@163.com","xzyflzjx111??");
        System.out.println("--------完成发送邮件-------");
    }
    public static void sendMail2(String title,String content) throws MessagingException {
        // 发件人电子邮箱
        String from = "shaohuasmile@163.com";

        // 收件人电子邮箱
        String to = "liushjob@163.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.163.com";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "25");
        properties.setProperty("mail.smtp.auth", "true");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("shaohuasmile@163.com", "xzyflzjx111??");
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        Address toAddr = new InternetAddress(to);
       // Address toAddr2 = new InternetAddress("2440244805@qq.com");

        Address[] tos = new Address[1];
        tos[0] = toAddr;
        //tos[1] = toAddr2;
        message.addRecipients(Message.RecipientType.TO,tos);
        message.setReplyTo(new Address[]{toAddr});
        message.setSubject(title,"UTF-8");
        message.setContent(content,"text/html;charset=gb2312");
        System.out.println("--------开始发送邮件-------");
        Transport.send(message,"shaohuasmile@163.com","xzyflzjx111??");
        System.out.println("--------完成发送邮件-------");
    }
}
