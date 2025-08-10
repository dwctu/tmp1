package dc;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Frame.kt */
/* loaded from: classes3.dex */
public final class lh1 {

    @NotNull
    public final SparseArray<mh1> a;

    public lh1(@NotNull JSONObject json) throws JSONException {
        JSONObject jSONObject;
        Intrinsics.checkParameterIsNotNull(json, "json");
        this.a = new SparseArray<>();
        JSONArray jSONArray = json.getJSONArray(TypedValues.AttributesType.S_FRAME);
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i = 0; i < length; i++) {
            if (jSONArray != null && (jSONObject = jSONArray.getJSONObject(i)) != null) {
                mh1 mh1Var = new mh1(jSONObject);
                this.a.put(mh1Var.a(), mh1Var);
            }
        }
    }

    @NotNull
    public final SparseArray<mh1> a() {
        return this.a;
    }
}
