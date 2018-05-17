package shaohua.study.javaBasic;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/22 11:24
 */
public enum ddd {
    /**
     * 北京
     */
    BJ("110000", "11",1),
    /**
     * 上海
     */
    SH("310000", "50",1),
    /**
     * 深圳
     */
    SZ("440300", "24",1),
    //杭州
    HZ("330100", "330100",1),
    NJ("320100", "320100",1),
    /**
     * 广州
     */
    GUAZHOU("440100","440100",1),
    /**
     * 成都
     */
    CHENGDU("510100","510100",1),
    /**
     * 武汉
     */
    WUHAN("420100","420100",1),
    /**
     * 天津
     */
    TIANJIN("120000","120000",1),
    /**
     * 北京链家
     */
    BJLJ("110000", "HL001",2),
    /**
     * 天津链家
     */
    TIANJINLJ("120000","HL002",2),
    /**
     * 成都链家
     */
    CHENGDULJ("510100","HL006",2),
    /**
     * 南京链家
     */
    NJLJ("320100", "HL005",2),
    /**
     * 杭州链家
     */
    HZLJ("330100", "HL008",2),
    /**
     * 深圳链家
     */
    SZLJ("440300", "HL024",2),
    /**
     * 武汉链家
     */
    WUHANLJ("420100","HL027",2),
    /**
     * 上海链家
     */
    SHANGHAILJ("310000","BW0001",2),
    ;
    private String name;
    private String value;
    private int company;

    /**
     * 功能描述:
     * @param name crm城市编码
     * @param value ehr城市编码
     * @param company 公司名称 1自如 2链家
     * @author Liush
     * @date 2018/1/22
     */
    private ddd(String name, String value, int company) {
        this.name = name;
        this.value = value;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public static final Map<String,String> lookup=new HashMap<String,String>();
    static {
        for(ddd s: EnumSet.allOf(ddd.class)){
            lookup.put(s.getValue(),s.getName());
        }
    }

    /** 此map仅包含自如城市编码映射 链家请使用lookuplj */
    public static final Map<String,String> lookup2=new HashMap<String,String>();
    /** 此map仅包含链家城市编码映射 自如请使用lookup2 */
    public static final Map<String,String> lookuplj=new HashMap<String,String>();
    static {
        for(ddd s: EnumSet.allOf(ddd.class)){
            if(s.getCompany() == 2){//不能将链家的城市编码覆盖了自如的城市编码
                lookuplj.put(s.getName(),s.getValue());
            }else if(s.getCompany() == 1){
                lookup2.put(s.getName(),s.getValue());
            }

        }
    }
}