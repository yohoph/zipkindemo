package org.yohoph.demo.tracking;

import java.util.Map;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/13 10:33
 * @Description Tracking
 */
public final class TrackingRuntime {

    public static final String TRACKING_ID = "tracking_id";

    public static final String TRACKING_REST_HEADER = "REST_TEMPLATE_HEADER";

    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    public static void put(String prop , Object val){
        threadLocal.get().put(prop , val);
    }

    public static Object get(String prop){
        return threadLocal.get().get(prop);
    }

}
