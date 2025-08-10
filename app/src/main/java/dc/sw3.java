package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HandshakeData.java */
/* loaded from: classes4.dex */
public class sw3 {
    public String a;
    public String[] b;
    public long c;
    public long d;

    public sw3(String str) throws JSONException {
        this(new JSONObject(str));
    }

    public sw3(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.a = jSONObject.getString(PSOProgramService.ServiceID_Key);
        this.b = strArr;
        this.c = jSONObject.getLong("pingInterval");
        this.d = jSONObject.getLong("pingTimeout");
    }
}
