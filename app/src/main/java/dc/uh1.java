package dc;

import dc.th1;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Src.kt */
/* loaded from: classes3.dex */
public final class uh1 {

    @NotNull
    public final HashMap<String, th1> a;

    public uh1(@NotNull JSONObject json) throws JSONException {
        JSONObject jSONObject;
        Intrinsics.checkParameterIsNotNull(json, "json");
        this.a = new HashMap<>();
        JSONArray jSONArray = json.getJSONArray("src");
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i = 0; i < length; i++) {
            if (jSONArray != null && (jSONObject = jSONArray.getJSONObject(i)) != null) {
                th1 th1Var = new th1(jSONObject);
                if (th1Var.l() != th1.c.UNKNOWN) {
                    this.a.put(th1Var.i(), th1Var);
                }
            }
        }
    }

    @NotNull
    public final HashMap<String, th1> a() {
        return this.a;
    }
}
