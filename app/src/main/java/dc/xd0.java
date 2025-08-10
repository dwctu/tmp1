package dc;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: GsonUtils.java */
/* loaded from: classes.dex */
public final class xd0 {
    public static final Map<String, Gson> a = new ConcurrentHashMap();

    public static Gson a() {
        return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").disableHtmlEscaping().create();
    }

    public static <T> T b(@NonNull Gson gson, String str, @NonNull Class<T> cls) {
        return (T) gson.fromJson(str, (Class) cls);
    }

    public static <T> T c(@NonNull Gson gson, String str, @NonNull Type type) {
        return (T) gson.fromJson(str, type);
    }

    public static <T> T d(String str, @NonNull Class<T> cls) {
        return (T) b(f(), str, cls);
    }

    public static <T> T e(String str, @NonNull Type type) {
        return (T) c(f(), str, type);
    }

    public static Gson f() {
        Map<String, Gson> map = a;
        Gson gson = map.get("delegateGson");
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get("defaultGson");
        if (gson2 != null) {
            return gson2;
        }
        Gson gsonA = a();
        map.put("defaultGson", gsonA);
        return gsonA;
    }

    public static Gson g() {
        Map<String, Gson> map = a;
        Gson gson = map.get("logUtilsGson");
        if (gson != null) {
            return gson;
        }
        Gson gsonCreate = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put("logUtilsGson", gsonCreate);
        return gsonCreate;
    }

    public static Gson h() {
        Map<String, Gson> map = a;
        Gson gson = map.get("notNullGson");
        if (gson != null) {
            return gson;
        }
        Gson gsonCreate = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").disableHtmlEscaping().create();
        map.put("notNullGson", gsonCreate);
        return gsonCreate;
    }

    public static String i(@NonNull Gson gson, Object obj) {
        return gson.toJson(obj);
    }

    public static String j(Object obj) {
        return i(f(), obj);
    }
}
