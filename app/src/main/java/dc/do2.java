package dc;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import org.json.JSONObject;
import retrofit2.Converter;

/* compiled from: JsonResponseBodyConverter.java */
/* loaded from: classes3.dex */
public final class do2<T> implements Converter<bd4, T> {
    public final TypeAdapter<T> a;

    public do2(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    @Override // retrofit2.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(bd4 bd4Var) throws IOException {
        try {
            try {
                JSONObject jSONObject = new JSONObject(bd4Var.string());
                int iOptInt = jSONObject.optInt("status");
                ?? r3 = (T) jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "服务器开小差了~~");
                String str = "======status=====" + String.valueOf(iOptInt);
                String str2 = "====== msg =====" + ((String) r3);
                if (iOptInt != 1) {
                    throw new RuntimeException((String) r3);
                }
                if (!jSONObject.has("data")) {
                    return r3;
                }
                String string = jSONObject.get("data").toString();
                String str3 = "======data=====" + string;
                return this.a.fromJson(string);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } finally {
            bd4Var.close();
        }
    }
}
