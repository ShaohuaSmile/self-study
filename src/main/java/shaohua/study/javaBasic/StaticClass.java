package shaohua.study.javaBasic;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/09 15:20
 */
public class StaticClass {
    /**
     * 功能描述: 停止服务定义列表
     *
     * @author Liush
     * @date 2017/11/9
     */
    private static final List<ServiceStopDefinition> SERVICE_STOP_DEFINITIONS = new ArrayList<ServiceStopDefinition>();

    static{
        loadServiceStopDefinition();
    }

    public static void main(String... args){
        System.out.print("6666");
    }
    /**
     * 功能描述:加载 停止服务 配置信息
     *
     * @author Liush
     * @date 2017/11/9
     */
    private static void loadServiceStopDefinition(){
        //service.stop.time.definition=backRentHouseKeeper/confirmBackRent|yyyy-MM-dd 23:00:00|yyyy-MM-dd 23:59:59,
        String propStr = "backRentHouseKeeper/confirmBackRent|yyyy-MM-dd 23:00:00|yyyy-MM-dd 23:59:59";
        if(StringUtils.isNotBlank(propStr)){
            String[] props = propStr.split(",");
            for(String definitionStr:props){
                if(StringUtils.isBlank(definitionStr) || definitionStr.indexOf("|") < 1){
                    continue;
                }
                String[] strs = definitionStr.split("\\|");
                if(strs.length != 3){
                    continue;
                }
                ServiceStopDefinition serviceStopDefinition = new ServiceStopDefinition();
                serviceStopDefinition.setUrl(strs[0]);
                serviceStopDefinition.setStartRegular(strs[1]);
                serviceStopDefinition.setStopRegular(strs[2]);
                SERVICE_STOP_DEFINITIONS.add(serviceStopDefinition);
            }
        }
    }
    private static class ServiceStopDefinition{
        private String url;
        private String startRegular;
        private String stopRegular;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStartRegular() {
            return startRegular;
        }

        public void setStartRegular(String startRegular) {
            this.startRegular = startRegular;
        }

        public String getStopRegular() {
            return stopRegular;
        }

        public void setStopRegular(String stopRegular) {
            this.stopRegular = stopRegular;
        }
    }


}
