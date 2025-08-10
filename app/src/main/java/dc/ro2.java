package dc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;

/* compiled from: JsonUtil.java */
/* loaded from: classes3.dex */
public class ro2 {
    public static <T> T a(String str, Class<T> cls) {
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e) {
            String str2 = "parseObject-something Exception with:" + e.toString();
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T b(String str, Type type) {
        try {
            return (T) JSON.parseObject(str, type, Feature.AutoCloseSource);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
