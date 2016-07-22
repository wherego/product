package com.bjshenpu.perfectcommonbaseframework.retrofit;


/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 : Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2015/12/1 22:20
 * <p/>
 * 描 述 ：http 配置文件
 * <p/>
 * ============================================================
 **/

public class HttpConfig {

    private static final String TAG = "HttpConfig";

    public static final ServerEnvironmentEnum serverEnvironment = ServerEnvironmentEnum.ONLINE;

    public static String BASE_HOST_URL = "";

    static {
        switch (serverEnvironment) {
            case NATIVEDEBUG:
                BASE_HOST_URL = "http://10.1.81.112:8080";
                break;
            case DEVELOPMENT:
                BASE_HOST_URL = "http://192.168.0.71:8080";
                break;
            case TEST:
                BASE_HOST_URL = "http://192.168.0.72:8080/";
                break;
            case STAGING:
                BASE_HOST_URL = "http://e.kunlunhealth.com";
            break;
            case ONLINE:
                BASE_HOST_URL = "http://e.kunlunhealth.com/";
                break;
        }
    }

    public enum ServerEnvironmentEnum {
        NATIVEDEBUG, DEVELOPMENT, TEST, STAGING, ONLINE;
    }


    /**
     * 获取app 端接口
     * @param subUrl
     * @return
     */
    public static String getRequestUrl(String subUrl) {
      //  AppLog.loge(TAG,"HttpConfig.BASE_HOST_URL + subUrl :"+HttpConfig.BASE_HOST_URL + subUrl);
        return HttpConfig.BASE_HOST_URL + subUrl;
    }

    /**
     * 获取 webview 网页端接口
     */
//    public static String getRequestWebUrl(String weburl) {
//       // AppLog.loge(TAG,"agentcode :"+SpUtils.getString(ExtraName.USER_INFO_AGENTCODE,""));
//       // AppLog.loge(TAG,"webview  访问路径  :"+HttpConfig.BASE_HOST_URL + weburl+ SpUtils.getString(ExtraName.USER_INFO_AGENTCODE,""));
//        return HttpConfig.BASE_HOST_URL + weburl+ SpUtils.getString(ExtraName.USER_INFO_AGENTCODE,"");
//    }




    public static class ResponseCode {

        public static final String CODE_200 = "200";

    }

    public class SubUrl {

        /** 更新 */
        public static final String UPDATE ="/servlet/AppCheckVersionController";
        /** 登录 */
        public static final String LOGIN = "/servlet/AppLoginServletController";



    }

    /**
     * 存放html 或者下载页面
     */

    public static final class WebPage{
        /**
         * 测试页面
         */
        public static final String H5_TEST ="https://www.baidu.com/";


    }


}