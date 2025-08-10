package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Frame.kt */
/* loaded from: classes3.dex */
public final class kh1 {

    @NotNull
    public String a;
    public int b;

    @NotNull
    public yg1 c;

    @NotNull
    public yg1 d;
    public int e;

    public kh1(int i, @NotNull JSONObject json) throws JSONException {
        Intrinsics.checkParameterIsNotNull(json, "json");
        this.a = "";
        String string = json.getString("srcId");
        Intrinsics.checkExpressionValueIsNotNull(string, "json.getString(\"srcId\")");
        this.a = string;
        this.b = json.getInt("z");
        JSONArray jSONArray = json.getJSONArray(TypedValues.AttributesType.S_FRAME);
        this.c = new yg1(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
        JSONArray jSONArray2 = json.getJSONArray("mFrame");
        this.d = new yg1(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3));
        this.e = json.getInt("mt");
    }

    @NotNull
    public final yg1 a() {
        return this.c;
    }

    @NotNull
    public final yg1 b() {
        return this.d;
    }

    public final int c() {
        return this.e;
    }

    @NotNull
    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }
}
