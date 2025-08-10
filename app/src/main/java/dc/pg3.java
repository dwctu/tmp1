package dc;

import com.alibaba.fastjson.JSON;
import com.google.gson.internal.LinkedTreeMap;
import com.wear.bean.VideoFlagConfig;
import com.wear.bean.event.SetSyncCommonDataEvent;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SyncCommonDataUtil.java */
/* loaded from: classes4.dex */
public class pg3 {
    public static pg3 b;
    public LinkedTreeMap a;

    public static pg3 h() {
        if (b == null) {
            synchronized (pg3.class) {
                if (b == null) {
                    b = new pg3();
                }
            }
        }
        return b;
    }

    public boolean a() {
        LinkedTreeMap linkedTreeMap = this.a;
        if (linkedTreeMap == null || !linkedTreeMap.containsKey("enableDiscoverMallShow")) {
            return false;
        }
        return ((Boolean) this.a.get("enableDiscoverMallShow")).booleanValue();
    }

    public String b() {
        LinkedTreeMap linkedTreeMap = this.a;
        return (linkedTreeMap == null || !linkedTreeMap.containsKey("advertisementSource")) ? "" : (String) this.a.get("advertisementSource");
    }

    public String c() {
        LinkedTreeMap linkedTreeMap = this.a;
        return (linkedTreeMap == null || !linkedTreeMap.containsKey("discoverMallUrl")) ? "" : (String) this.a.get("discoverMallUrl");
    }

    public boolean d() {
        LinkedTreeMap linkedTreeMap = this.a;
        if (linkedTreeMap == null || !linkedTreeMap.containsKey("enableVibemateEvent")) {
            return false;
        }
        return ((Boolean) this.a.get("enableVibemateEvent")).booleanValue();
    }

    public double e() {
        LinkedTreeMap linkedTreeMap = this.a;
        if (linkedTreeMap == null || !linkedTreeMap.containsKey("enableVibemateEventGroupCount")) {
            return 500.0d;
        }
        return ((Double) this.a.get("enableVibemateEventGroupCount")).doubleValue();
    }

    public String f() {
        LinkedTreeMap linkedTreeMap = this.a;
        return (linkedTreeMap == null || !linkedTreeMap.containsKey("groupChatGuideline")) ? "" : (String) this.a.get("groupChatGuideline");
    }

    public List<String> g() {
        LinkedTreeMap linkedTreeMap = this.a;
        return (linkedTreeMap == null || !linkedTreeMap.containsKey("xRemoteApplicationDomains")) ? new ArrayList() : (List) this.a.get("xRemoteApplicationDomains");
    }

    public List<VideoFlagConfig> i() {
        LinkedTreeMap linkedTreeMap = this.a;
        if (linkedTreeMap == null || !linkedTreeMap.containsKey("videoFlagConfig")) {
            return null;
        }
        return JSON.parseArray(qx.a((String) this.a.get("videoFlagConfig")), VideoFlagConfig.class);
    }

    public boolean j() {
        LinkedTreeMap linkedTreeMap = this.a;
        if (linkedTreeMap == null || !linkedTreeMap.containsKey("showToyRouletteGames")) {
            return false;
        }
        return ((Boolean) this.a.get("showToyRouletteGames")).booleanValue();
    }

    public void k(Object obj) {
        if (obj instanceof LinkedTreeMap) {
            this.a = (LinkedTreeMap) obj;
            EventBus.getDefault().post(new SetSyncCommonDataEvent());
        }
    }
}
