package com.petplanet.backend.util;

import java.util.HashMap;
import java.util.Map;

public class WebStatusUtil {

    private static Map<String, Object> ok;
    private static Map<String, Object> error;

    public static Map<String, Object> httpOk(String msg) {

        if (null == ok) {
            synchronized (WebStatusUtil.class) {
                if (null == ok) {
                    ok = new HashMap<>();
                }
            }
        }

        ok.clear();
        ok.put("status", 200);
        ok.put("message", msg);
        return ok;
    }

    public static Map<String, Object> httpError(String msg) {

        if (null == error) {
            synchronized (WebStatusUtil.class) {
                if (null == error) {
                    error = new HashMap<>();
                }
            }
        }

        error.clear();
        error.put("status", 500);
        error.put("message", msg);
        return error;
    }

}
