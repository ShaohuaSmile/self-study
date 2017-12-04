package shaohua.study.spring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/2
 */
@Configuration
@ComponentScan
public class TestMain {
    public static void main(String... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestMain.class);
        ///ApplicationContext applicationContext = new AnnotationConfigApplicationContext("shaohua.study.spring");
        MessageService messageService = applicationContext.getBean(MessageServiceImpl.class);
        messageService.printMessage();
//        String houseId,rentPerson,rentContractId,isResign,isDel,contractStatus,signWay,renewType,houseSourceCode,
//                createDateFrom,createDateTo,stopStart,stopEnd,customerName,mobileNum,propertyAddr,createUserCode;
//        Map<String, Object> params = new HashMap<String,Object>();
//        List<String> houses = new ArrayList<String>();
//        List<String> status = new ArrayList<String>();
//        status.add("dsh");
//        status.add("yyy");
//        params.put("contractStatusList",status);
//        houses.add("11111");
//        houses.add("115551");
//        houses.add("117777");
//        params.put("houses",houses);
//        params.put("rentPerson","2151512");
//        params.put("rentContractId","11111111");
//        params.put("isResign","0");
//        params.put("contractStatus","dsh");
//        params.put("customerName","lili");
//        System.out.print(getContractListSQL(params));
//        for(int i=0; i<1000; i++){
//            System.out.println(randomMySqlLimitBegin(100,50));
//        }
    }
    //
    private static int randomMySqlLimitBegin(int total, int length){
        if(total <= 0 || length <=0){
            return 0;
        }
        if(total <= length){
            return 0;
        }
        Random random = new Random();
        int begin = random.nextInt(total-length+1);
        if(begin >= 0 && begin <= total-1){
            return begin;
        }
        return 0;
    }
    private static String getContractListSQL(Map<String, Object> params){
        final String CONTRACT_ALIAS = "contract";
        final String RENTER_ALIAS = "renter";
        final String CUST_ALIAS = "cust";
        final String PROFILE_ALIAS = "profile";
        final String RENEW_ALIAS = "renew";
        String RETURN_COLUMN =
                CONTRACT_ALIAS+".contract_code as rentContractId,\n" +
                        CONTRACT_ALIAS+".contract_state as contractStatus,\n" +
                        CONTRACT_ALIAS+".contract_strategy as signWay,\n" +
                        CONTRACT_ALIAS+".room_id as roomId,\n" +
                        CONTRACT_ALIAS+".create_time as createDate,\n" +
                        CONTRACT_ALIAS+".house_id as houseId,\n" +
                        CONTRACT_ALIAS+".house_source_code as houseSourceCode,\n" +
                        CONTRACT_ALIAS+".contract_state as approveStatus,\n" +
                        CONTRACT_ALIAS+".sign_date as signDate,\n" +
                        CONTRACT_ALIAS+".start_date as startDate,\n" +
                        CONTRACT_ALIAS+".contract.stop_date as stopDate,\n" +
                        CONTRACT_ALIAS+".contract.renew_type as renewType,\n" +
                        CUST_ALIAS+".user_name as customerName,\n" +
                        CUST_ALIAS+".user_phone as mobileNum,\n" +
                        "    '' as roomStatus,\n" +
                        CONTRACT_ALIAS+".agent_name as rentPerson1,\n" +
                        CONTRACT_ALIAS+".keeper_name as rentPerson,\n" +
                        "    '' as approvedDate,\n" +
                        PROFILE_ALIAS+".address as propertyAddr,\n" +
                        PROFILE_ALIAS+".is_audit as isAudit,\n" +
                        PROFILE_ALIAS+".audit_result as auditResult,\n" +
                        PROFILE_ALIAS+".create_user_code as createUserCode,\n" +
                        PROFILE_ALIAS+".room_code as roomCode" ;
        // RENEW_ALIAS+  ".contract_code as beforeContractCode";
        String subBaseSql =
                "select t.contract_code,\n" +
                        "    t.contract_state,\n" +
                        "    t.contract_strategy,\n" +
                        "    t.room_id,\n" +
                        "    t.create_time,\n" +
                        "    t.house_id,\n" +
                        "    t.house_source_code,\n" +
                        "    t.sign_date,\n" +
                        "    t.start_date,\n" +
                        "    t.stop_date,\n" +
                        "    t.renew_type,\n" +
                        "    r.agent_name,\n" +
                        "    r.keeper_name\n" +
                        " from t_rent_contract t left join t_rent_contract_renter r on t.contract_code = r.contract_code " +
                        " where 1=1";
        StringBuilder innerParams = new StringBuilder();
        String houseId,rentPerson,rentContractId,isResign,isDel,contractStatus,signWay,renewType,houseSourceCode,
                createDateFrom,createDateTo,stopStart,stopEnd,customerName,mobileNum,propertyAddr,createUserCode;
        List<String> status = (List<String>) params.get("contractStatusList");
        List<String> houses = (List<String>) params.get("houses");
        if(StringUtils.isNotBlank(houseId = (String)params.get("houseId"))){
            innerParams.append(" and t.house_id='").append(houseId).append("'");
        }
        if(StringUtils.isNotBlank(rentContractId = (String)params.get("rentContractId"))){
            innerParams.append(" and t.contract_code='").append(rentContractId).append("'");
        }
        if(StringUtils.isNotBlank(isResign = (String)params.get("isResign"))){
            innerParams.append(" and t.is_resign=").append(isResign);
        }
        if(StringUtils.isNotBlank(isDel = (String)params.get("isDel"))){
            innerParams.append(" and t.is_del=").append(isDel);
        }
        if(StringUtils.isNotBlank(contractStatus = (String)params.get("contractStatus"))){
            innerParams.append(" and t.contract_state='").append(contractStatus).append("'");
        }
        if(status != null && status.size()>0){
            innerParams.append(" and t.contract_state in (");
            for(String s:status){
                innerParams.append("'").append(s).append("',");
            }
            innerParams.deleteCharAt(innerParams.length()-1).append(")");
        }
        if(StringUtils.isNotBlank(signWay = (String)params.get("signWay"))){
            innerParams.append(" and t.contract_strategy=").append(signWay);
        }
        if(StringUtils.isNotBlank(renewType = (String)params.get("renewType"))){
            innerParams.append(" and t.renew_type=").append(renewType);
        }
        if(StringUtils.isNotBlank(houseSourceCode = (String)params.get("houseSourceCode"))){
            innerParams.append(" and t.house_source_code LIKE '").append(houseSourceCode).append("%'");
        }
        if(StringUtils.isNotBlank(createDateFrom = (String)params.get("createDateFrom"))){
            innerParams.append(" and t.create_time &gt;='").append(createDateFrom).append("'");
        }
        if(StringUtils.isNotBlank(createDateTo = (String)params.get("createDateTo"))){
            innerParams.append(" and t.create_time &lt;'").append(createDateTo).append("'");
        }
        if(StringUtils.isNotBlank(stopStart = (String)params.get("stopStart"))){
            innerParams.append(" and t.stop_date &gt;='").append(stopStart).append("'");
        }
        if(StringUtils.isNotBlank(stopEnd = (String)params.get("stopEnd"))){
            innerParams.append(" and t.stop_date &lt;='").append(stopEnd).append("'");
        }
        subBaseSql = subBaseSql + innerParams.toString();
        StringBuilder subSql = new StringBuilder();
        if(StringUtils.isNotBlank(stopEnd = (String)params.get("stopEnd"))){
            innerParams.append(" and t.stop_date &lt;='").append(stopEnd).append("'");
        }
        /**
         * 处理所属房源
         */
        if(houses != null && houses.size()>0){
            StringBuilder houseIN = new StringBuilder(" and t.house_id in (");
            for(String id:houses){
                houseIN.append("'").append(id).append("',");
            }
            houseIN.deleteCharAt(houseIN.length()-1).append(")");
            subSql.append(" ").append(subBaseSql).append(houseIN);
        }
        /**
         * 处理出房
         */
        if(StringUtils.isNotBlank(rentPerson = (String)params.get("rentPerson"))){
            if(subSql.length()>0){
                subSql.append(" union ");
            }
            subSql.append(" ").append(subBaseSql).append(" and r.keeper_code='").append(rentPerson).append("'");
        }
        /**
         * 既没有所属，也不出房，则不限制
         */
        if((houses == null || houses.isEmpty()) && StringUtils.isBlank(rentPerson)){
            subSql.append(" ").append(subBaseSql);
        }

        if("1".equals(isResign)){
            RETURN_COLUMN = RETURN_COLUMN +", " + RENEW_ALIAS +  ".contract_code as beforeContractCode";
        }
        String sql = "SELECT " + RETURN_COLUMN + " FROM (" + subSql + ") AS " + CONTRACT_ALIAS
                +" LEFT JOIN t_rent_contract_profile AS " + PROFILE_ALIAS + " ON " + CONTRACT_ALIAS + ".contract_code=" + PROFILE_ALIAS + ".contract_code "
                + " LEFT JOIN t_rent_contract_customer AS " + CUST_ALIAS + " ON " + CONTRACT_ALIAS + ".contract_code=" + CUST_ALIAS + ".contract_code ";

        if("1".equals(isResign)){
            sql = sql + " LEFT JOIN t_rent_renew_link_contract AS " + RENEW_ALIAS + " ON " + CONTRACT_ALIAS + ".contract_code=" + RENEW_ALIAS + ".contract_code ";
        }
        StringBuilder outerParams = new StringBuilder();
        if(StringUtils.isNotBlank(propertyAddr = (String)params.get("propertyAddr"))){
            outerParams.append(" and ").append(PROFILE_ALIAS).append(".address LIKE '%").append(propertyAddr).append("%' ");
        }
        if(StringUtils.isNotBlank(createUserCode = (String)params.get("createUserCode"))){
            outerParams.append(" and ").append(PROFILE_ALIAS).append(".create_user_code='").append(createUserCode).append("' ");
        }
        if(StringUtils.isNotBlank(customerName=(String)params.get("customerName"))){
            outerParams.append(" and ").append(CUST_ALIAS).append(".user_name='").append(customerName).append("' ");
        }
        if(StringUtils.isNotBlank(mobileNum = (String)params.get("mobileNum"))){
            outerParams.append(" and ").append(CUST_ALIAS).append(".user_phone='").append(mobileNum).append("' ");
        }
        sql = sql + " WHERE 1=1 " + outerParams.toString();
        return sql;
    }

}
